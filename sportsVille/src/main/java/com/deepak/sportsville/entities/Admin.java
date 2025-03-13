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
@Table(name="admin")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Data


public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int AdminId;
	
	@Column(name="admin_name",nullable=false,length=100)
	private String adminName;
	
	@Column(name="admin_user_name",nullable=false,length=100,unique=true)
	private String adminUserName;
	
	@Column(unique=true)
	private String email;
	
	private String password;
	
	@Column(unique=true)
	private String mobileNumber;
}
