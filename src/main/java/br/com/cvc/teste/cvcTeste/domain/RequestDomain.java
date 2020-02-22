package br.com.cvc.teste.cvcTeste.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class RequestDomain {

	private Integer cityCode;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date checkin;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date checkout;
}
