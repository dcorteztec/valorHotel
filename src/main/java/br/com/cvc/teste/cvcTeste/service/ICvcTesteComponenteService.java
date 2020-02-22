package br.com.cvc.teste.cvcTeste.service;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.cvc.teste.cvcTeste.domain.ServiceResponseHotelDomain;

public interface ICvcTesteComponenteService {

	public ResponseEntity<List<ServiceResponseHotelDomain>> buscaValorHotelByCidadeId(
			List<ServiceResponseHotelDomain> listHoteis,Date checkin,Date checkout,Integer qtdAdult,Integer qtdChild);
}
