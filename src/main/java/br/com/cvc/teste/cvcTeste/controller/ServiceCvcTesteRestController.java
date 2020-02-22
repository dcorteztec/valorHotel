package br.com.cvc.teste.cvcTeste.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cvc.teste.cvcTeste.componente.ICvcTesteComponente;
import br.com.cvc.teste.cvcTeste.domain.ServiceResponseHotelDomain;
import br.com.cvc.teste.cvcTeste.service.ICvcTesteComponenteService;


@RestController
public class ServiceCvcTesteRestController {

	@Autowired
	private ICvcTesteComponente componente;
	
	@Autowired
	private ICvcTesteComponenteService service;

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "serviceByCityId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<ServiceResponseHotelDomain>> serviceByCityId(
			  @RequestParam(required = true) Integer cityCode
            , @RequestParam(required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date checkin
            , @RequestParam(required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date checkout
            , @RequestParam(required = true) Integer qtdAdult
            , @RequestParam(required = true) Integer qtdChild,
			HttpServletRequest req, HttpServletResponse res){
		try {
			List<ServiceResponseHotelDomain> listHoteis = componente.buscaHotelByCidadeId(Integer.toString(cityCode));
			return service.buscaValorHotelByCidadeId(listHoteis, checkin, checkout, qtdAdult, qtdChild);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON).build();
		}
		
	}
}
