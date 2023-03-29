package com.wallet.onlinewalletapplication.module;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class CustomerDTO {

	@Size(min=10,max=10,message = "{moblie.invalid}")
	private String mobileNo;
	
	@Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,12}$",message = "{password.invalid}")
	private String password;
}
