package com.obss.ramazansakin.springpro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="authorities")
public class UserRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
	@NotNull
    @Column(name = "USERID", nullable = false)
	private int userid;
    
    @NotNull
    @Column(name = "AUTHORITY", nullable = false)
    private String authority;
    
    public void setAuthority( String authority ){
    	this.authority = authority;
    }
    
    public String getAuthority(){
    	return authority;
    }
    
    public void setIUserID( int id){
    	this.userid = id;
    }
    
    public int getUserId(){
    	return userid;
    }
    
    public void setID( int id){
    	this.id = id;
    }
    
    public int getId(){
    	return id;
    }
    
    @Override
    public String toString() {
    	return "User : id => " + userid+" / role => "+authority;
    }

}
