package com.te.springboot.Beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@Entity
@JsonRootName("employee-info")
@JsonPropertyOrder({"id" ,"name"} )
@XmlRootElement(name = "employee-info")
@Table(name = "EmployeeInfo")
public class EmployeeBean implements Serializable {

	@Id
	@JsonProperty("emp_id")
	@Column(name = "User_Id")
	private int id;

	
	@Column(name = "Username")
	private String name;
	
	@Column
	private String Password;
	
	@JsonIgnore
	@XmlTransient
	@Column(name = "dob")
	private Date dateofbirth;

}