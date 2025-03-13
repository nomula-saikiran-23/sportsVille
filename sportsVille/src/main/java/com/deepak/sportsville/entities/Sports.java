package com.deepak.sportsville.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="sports")
@NoArgsConstructor
@Getter
@Setter

public class Sports {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sportId;
	
	@Column(name="sportName",nullable=false,length=100)
	private String sportName;
	
}
