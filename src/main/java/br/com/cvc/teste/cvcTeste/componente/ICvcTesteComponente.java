package br.com.cvc.teste.cvcTeste.componente;

import java.util.List;

import br.com.cvc.teste.cvcTeste.domain.ServiceResponseHotelDomain;

public interface ICvcTesteComponente {

	public List<ServiceResponseHotelDomain> buscaHotelByCidadeId(String IdCidade);
}
