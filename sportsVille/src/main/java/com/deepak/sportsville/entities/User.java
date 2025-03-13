package com.deepak.sportsville.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor(staticName="build")
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="name",nullable=false,length=100)
	private String name;
	
	@Column(name="user_name",nullable=false,length=100,unique=true)
	private String userName;
	
	@Column(unique=true)
	private String email;
	
	private String password;
	
	@Column(unique=true)
	private String mobileNumber;
	 
}
