package com.joshbarrosweb.employee.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	private String email;
	
	private String department;
}
