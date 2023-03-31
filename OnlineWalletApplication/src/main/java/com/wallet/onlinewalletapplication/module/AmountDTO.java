package com.wallet.onlinewalletapplication.module;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AmountDTO {
	@Size(min=10,max=10,message = "{mobile.invalid}")
	private String mobileNo;
	private Double amount;
}
