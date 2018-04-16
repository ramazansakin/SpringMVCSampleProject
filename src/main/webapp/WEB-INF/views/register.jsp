<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
<style>
.error {
	color: #ff0000;
}
</style>
</head>
<body>
	<form:form method="POST" modelAttribute="user">
		<form:input type="hidden" path="id" id="id" />
		<center>
			<table border="1" style="width: 50%" cellpadding="5">
				<thead>
					<tr>
						<th colspan="2">Registration Page</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><label for="name">Username: </label></td>
						<td><form:input path="name" id="name" /></td>
						<td><form:errors path="name" cssClass="error"/></td>
					</tr>
					<tr>
						<td><label for="email">Email: </label></td>
						<td><form:input path="email" id="email" /></td>
						<td><form:errors path="email" cssClass="error"/></td>

					</tr>
					<tr>
						<td><label for="sex">Sex: </label></td>
						<td><form>
								<input type="radio" name="sex" path="sex" id="sex" value="1"
									checked="checked">Male
								</radio>
								<input type="radio" name="sex" path="sex" id="sex"
									value="2">Female
								</radio>
							</form></td>
							<td><form:errors path="sex" cssClass="error"/></td>
					</tr>
					<tr>
						<td><label for="sex">Birthday: </label></td>
						<td><select name="DOBYear">
								<option>Year</option>
								<option value="1993">2000</option>
								<option value="1993">1999</option>
								<option value="1993">1998</option>
								<option value="1993">1997</option>
								<option value="1993">1996</option>
								<option value="1993">1995</option>
								<option value="1993">1994</option>
								<option value="1993">1993</option>
								<option value="1992">1992</option>
								<option value="1991">1991</option>
								<option value="1990">1990</option>
								<option value="1989">1989</option>
								<option value="1988">1988</option>
								<option value="1987">1987</option>
								<option value="1986">1986</option>
								<option value="1985">1985</option>
								<option value="1984">1984</option>
								<option value="1983">1983</option>
								<option value="1982">1982</option>
								<option value="1981">1981</option>
								<option value="1980">1980</option>
								<option value="1979">1979</option>
								<option value="1978">1978</option>
								<option value="1977">1977</option>
								<option value="1976">1976</option>
								<option value="1975">1975</option>
								<option value="1974">1974</option>
								<option value="1973">1973</option>
								<option value="1972">1972</option>
								<option value="1971">1971</option>
								<option value="1970">1970</option>
								<option value="1969">1969</option>
								<option value="1968">1968</option>
								<option value="1967">1967</option>
						</select> <select name="DOBMonth">
								<option>Month</option>
								<option value="January">January</option>
								<option value="Febuary">February</option>
								<option value="March">March</option>
								<option value="April">April</option>
								<option value="May">May</option>
								<option value="June">June</option>
								<option value="July">July</option>
								<option value="August">August</option>
								<option value="September">September</option>
								<option value="October">October</option>
								<option value="November">November</option>
								<option value="December">December</option>
						</select> <select name="DOBDay">
								<option>Day</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>
								<option value="11">11</option>
								<option value="12">12</option>
								<option value="13">13</option>
								<option value="14">14</option>
								<option value="15">15</option>
								<option value="16">16</option>
								<option value="17">17</option>
								<option value="18">18</option>
								<option value="19">19</option>
								<option value="20">20</option>
								<option value="21">21</option>
								<option value="22">22</option>
								<option value="23">23</option>
								<option value="24">24</option>
								<option value="25">25</option>
								<option value="26">26</option>
								<option value="27">27</option>
								<option value="28">28</option>
								<option value="29">29</option>
								<option value="30">30</option>
								<option value="31">31</option>
						</select></td>
						<td><form:errors path="birthday" cssClass="error"/></td>
					</tr>
					<tr>
						<td><label for="password">Password: </label></td>
						<td><form:input path="password" id="password" /></td>
						<td><form:errors path="password" cssClass="error"/></td>
					</tr>
					
					<tr>
						<td><label for="password2">Password Confirmation: </label></td>
						<td><form:input path="password2" id="password2"/></td>
						<td><form:errors path="password2" cssClass="error"/></td>
					</tr>
					
					<tr>
						<td><input type="submit" value="Register" /></td>
						<td><input type="reset" value="Reset" /></td>
					</tr>
					<tr>
						<td colspan="2">Already registered? <a href="/third2/">Login
								Here</a></td>
					</tr>
				</tbody>
			</table>
		</center>
	</form:form>
</body>
</html>