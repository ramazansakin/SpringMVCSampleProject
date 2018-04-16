package com.obss.ramazansakin.springpro.controller;

import java.util.List;

import javax.validation.Valid;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.obss.ramazansakin.springpro.configuration.HibernateConf;
import com.obss.ramazansakin.springpro.model.User;
import com.obss.ramazansakin.springpro.model.UserRole;
import com.obss.ramazansakin.springpro.service.UserRoleService;
import com.obss.ramazansakin.springpro.service.UserService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	UserService service;
	
	@Autowired
	UserRoleService roleService ;
	
	@Autowired
	MessageSource messageSource;

	/*
	 * This method will list all existing employees.
	 */
	@RequestMapping(value = { "/listuser" }, method = RequestMethod.GET)
	public String listUSers(ModelMap model) {

		System.out.println("HERE : AppController-ListUsers!");
		List<User> users = service.findAllUsers();
		model.addAttribute("users", users);

		System.out.println("User Size : " + users.size());
		return "allusers";
	}

	/*
	 * This method will show login page.
	 */
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String Login(ModelMap model) {
		model.addAttribute("user", new User());

		System.out.println("HERE : AppController-LOGIN PAGE!");
		return "login";
	}

	@RequestMapping(value = { "/" }, method = RequestMethod.POST)
	public String LoginConfirmation(@Valid User user, BindingResult result, ModelMap model) {
		System.out.println("HERE : AppController-LOGIN Confirmation Page!");

		
		if (user.getName().isEmpty()) {
			FieldError passError = new FieldError("user", "name", "You must enter a username!");
			result.addError(passError);
			return "login";
		}

		if (user.getPassword().isEmpty()) {
			FieldError passError = new FieldError("user", "password", "You must enter a password!" );
			result.addError(passError);
			return "login";
		}
		
		List<UserRole> roles = roleService.findAllUserRoles();
		List<User> users = service.findAllUsers();
		for (User u : users) {
			if (u.getName().equals(user.getName()) && u.getPassword().equals(user.getPassword())) {
				roles = roleService.findAllUserRoles();
				model.addAttribute("user",u.getName());
				for( UserRole role : roles){
					if( u.getId() == role.getUserId() ){
						if( role.getAuthority().equals("ADMIN")){
							model.addAttribute("role",true);
						}
					}
				}
				
				return "home";
			}
		}

		FieldError passError = new FieldError("user", "name", "There is no such User : " + user.getName());
		result.addError(passError);
		return "login";
	}

	/*
	 * This method will provide the medium to add a new employee.
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		return "register";
	}
	
	

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving employee in database. It also validates the user input
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveUSer(@Valid User user, BindingResult result, ModelMap model) {

		// TODO : DEFAULT Birthday
		user.setBirthday(LocalDate.now());
		if ( result.hasErrors() ) {

			System.out.println("Error : " + result.getAllErrors());
			System.out.println("USer name : " + user.getName());
			System.out.println("USer email : " + user.getEmail());
			System.out.println("USer sex : " + user.getSex());
			System.out.println("USer birthday : " + user.getBirthday());
			System.out.println("USer pass : " + user.getPassword());
			System.out.println("USer pass2 : " + user.getPassword2());

			return "register";
		}
	
		// Check all inputs to be completed!
		if (user.getName().isEmpty()) {
			FieldError passError = new FieldError("user", "name", "You must enter a username!");
			result.addError(passError);
			return "login";
		}

		List<User> users = service.findAllUsers();
		for (User u : users) {
			if (u.getName().equals(user.getName())) {
				FieldError nameError = new FieldError("user", "name", "Username Exist!");
				result.addError(nameError);
				FieldError emailError = new FieldError("user", "email", "Email Exist!");
				result.addError(emailError);
				
				return "register";
			}
		}

		if (user.getPassword() != user.getPassword2()) {
			FieldError passError = new FieldError("user", "password", "Passwords not match!");
			result.addError(passError);
			return "register";
		}

		service.saveUser(user);

		model.addAttribute("success", user.getName() );
		return "success";
	}

	
	@RequestMapping(value = "/printTable", method = RequestMethod.GET)
    public String generateReport(HttpServletRequest request, HttpServletResponse response) throws JRException {
        
		System.out.println("generateReport()");
        HashMap<String, Object> hmParams = new HashMap<String, Object>();
        hmParams.put("Title", "Test");

        String reportFileName = "JRUser1";
        String contextPath = request.getServletContext().getRealPath("jasper/JRUser1.jrxml");
        System.out.println("TTTT -:" + contextPath);

        try {
            generatePdfReport(request);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("There is an exception about SQL!!");
        }

        return "saveaspdf";
    }
   

    public void generatePdfReport(HttpServletRequest request) throws SQLException {

        String contextPath = request.getServletContext().getRealPath("jasper/JRUser1.jrxml");

        HibernateConf jc = new HibernateConf();
        Connection conn = jc.getConn();
        try {

            InputStream input = new FileInputStream(new File(contextPath));

            System.out.println("Context Path is  : =" + contextPath);
            JasperDesign jasperDesign = JRXmlLoader.load(input);

            System.out.println("Compiling Report Designs");
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

            System.out.println("Creating JasperPrint Object");
            Map<String, String> parameters = new HashMap<String, String>();
            parameters.put("ReportTitle", "PDF JasperReport");

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, conn);

            
            File f = new File("/home/rmzn/Desktop/OBSS/Report.pdf");
            f.createNewFile();

            //Exporting the report
            OutputStream output = new FileOutputStream(f);

            JasperExportManager.exportReportToPdfStream(jasperPrint, output);

            System.out.println("Report Generation Complete");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
