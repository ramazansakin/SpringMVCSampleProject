package com.obss.ramazansakin.springpro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
 
@Entity
@Table(name="users")
public class User {
 

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @NotNull
    @Column(name = "USERNAME", nullable = false)
    private String name;
    
    @NotNull
    @Column(name = "EMAIL", nullable = false)
    private String email;
    
    @NotNull
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    
    @NotNull
    @Column(name = "SEX", nullable = false)
    private int sex;
    
    @NotNull
    @Column(name = "ENABLED", nullable = false)
    private boolean enabled;
    
    @Transient
    private String password2;
    
    @NotNull
    @DateTimeFormat(pattern="dd/MM/yyyy") 
    @Column(name = "BIRTHDAY", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate birthday;
    
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword( String password ) {
        this.password = password;
    }
    
    public String getPassword2() {
        return password2;
    }
    
    public void setPassword2( String password ) {
        this.password2 = password;
    }
    
    public int getSex(){
        return sex;
    }
    
    public void setSex( int sex ){
        this.sex = sex;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail( String email ){
        this.email = email;
    }
    
    public boolean getEnabled(){
        return enabled;
    }
    
    public void setEnabled( boolean enabled ){
        this.enabled = enabled;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public LocalDate getBirthday() {
        return birthday;
    }
 
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }   
 
    @Override
    public String toString() {
        return "User : Username=" + name + ", birthday=" + birthday + ", sex="+ sex+ "]";
    }
     
}