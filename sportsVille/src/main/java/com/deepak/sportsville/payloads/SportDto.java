package com.deepak.sportsville.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SportDto {

	private int sportId;
	
	@NotEmpty
	@Size(min=3,max=20,message="content must be minimum of 3 and max of 20")
	private String sportName;
}