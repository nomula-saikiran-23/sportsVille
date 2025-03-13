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
@Table(name="staff")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Data


public class Staff {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int staffId;
	
	@Column(name="staff_name",nullable=false,length=100)
	private String staffName;
	
	@Column(name="staff_user_name",nullable=false,length=100,unique=true)
	private String staffUserName;
	
	@Column(unique=true)
	private String email;
	
	private String password;
	
	@Column(unique=true)
	private String mobileNumber;

}
