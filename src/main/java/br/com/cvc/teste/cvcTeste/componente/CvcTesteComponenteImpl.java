package br.com.cvc.teste.cvcTeste.componente;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.cvc.teste.cvcTeste.domain.ServiceResponseHotelDomain;

@Component
public class CvcTesteComponenteImpl implements ICvcTesteComponente{

	public List<ServiceResponseHotelDomain> buscaHotelByCidadeId(String IdCidade){
        RestTemplate template = new RestTemplate();
        
        ServiceResponseHotelDomain[] ret = 
        		template.getForObject("https://cvcbackendhotel.herokuapp.com/hotels/avail/{IdCidade}",ServiceResponseHotelDomain[].class, IdCidade);
        
        return Arrays.asList(ret);
    }
}
