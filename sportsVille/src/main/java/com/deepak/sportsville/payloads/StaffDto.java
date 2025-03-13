package com.deepak.sportsville.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Data
@AllArgsConstructor()


public class StaffDto {

	private int staffId;
	
	@NotEmpty
	@Size(min=4,message = "UserName must be minimum of 4 characters")
	private String staffName;
	
	@NotEmpty
	@Size(min=4,message = "UserName must be minimum of 4 characters")
	@Pattern(regexp="^(?=.{4,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$")
	private String staffUserName;
	
	@Email(message="Given mail id is invalid")
	private String email;
	
	@NotEmpty()
	@Size(min=6,max=12,message="Password must be in 6-12 characters")
	@Pattern(regexp="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,12}$",message="Minimum eight and maximum 12 characters, at least one uppercase letter, one lowercase letter, one number and one special character")  
	private String password;
	
	@NotEmpty
	@Pattern(regexp="^(\\+\\d{1,3}[- ]?)?\\d{10}$",message="Mobile number invalid !!")
	private String mobileNumber;
}
