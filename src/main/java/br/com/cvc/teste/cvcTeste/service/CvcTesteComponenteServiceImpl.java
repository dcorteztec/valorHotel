package br.com.cvc.teste.cvcTeste.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.cvc.teste.cvcTeste.domain.PriceDetailDomain;
import br.com.cvc.teste.cvcTeste.domain.PriceDomain;
import br.com.cvc.teste.cvcTeste.domain.RoomDomain;
import br.com.cvc.teste.cvcTeste.domain.ServiceResponseHotelDomain;

@Service
public class CvcTesteComponenteServiceImpl implements ICvcTesteComponenteService{

	@Override
	public ResponseEntity<List<ServiceResponseHotelDomain>> buscaValorHotelByCidadeId(List<ServiceResponseHotelDomain> listHoteis,
			Date checkin, Date checkout, Integer qtdAdult, Integer qtdChild) {
		
		try {
			List<ServiceResponseHotelDomain> listPreparada = preapraResponse(listHoteis,checkin,checkout,qtdAdult,qtdChild);
			
			return new ResponseEntity<>(listPreparada, HttpStatus.OK);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

	private List<ServiceResponseHotelDomain> preapraResponse(List<ServiceResponseHotelDomain> listHoteis, Date checkin,
			Date checkout, Integer qtdAdult, Integer qtdChild) {
		List<ServiceResponseHotelDomain> listreturn = new ArrayList<ServiceResponseHotelDomain>();
		for (ServiceResponseHotelDomain resp : listHoteis) {
			ServiceResponseHotelDomain respPreparada = new ServiceResponseHotelDomain();
			respPreparada.setId(resp.getId());
			respPreparada.setCityName(resp.getCityName());
			respPreparada.setRooms(preparaListRooms(resp.getRooms(),checkin,checkout,qtdAdult,qtdChild));
			listreturn.add(respPreparada);
		}
		return listreturn;
	}

	private List<RoomDomain> preparaListRooms(List<RoomDomain> rooms, Date checkin, Date checkout, Integer qtdAdult,
			Integer qtdChild) {
		List<RoomDomain> listReturn = new ArrayList<>();
		for (RoomDomain roomDomain : rooms) {
			RoomDomain resp = new RoomDomain();
			resp.setId(roomDomain.getId());
			resp.setCategoryName(roomDomain.getCategoryName());
			resp.setPriceDetail(preparaPriceDatail(roomDomain.getPrice(),checkin,checkout));
			resp.setTotalPrice(preparaTotalPriceDetail(resp.getPriceDetail(),qtdAdult,qtdChild));
			listReturn.add(resp);
		}
		return listReturn;
	}

	private BigDecimal preparaTotalPriceDetail(PriceDetailDomain priceDetail, Integer qtdAdult, Integer qtdChild) {
		BigDecimal totalPrice = new BigDecimal(0);
		BigDecimal totalChild = new BigDecimal(0);
		totalChild = BigDecimal.valueOf(qtdChild.longValue()).multiply(priceDetail.getComissaoChild()).setScale(2, BigDecimal.ROUND_CEILING);
		BigDecimal totalAdult = new BigDecimal(0);
		totalAdult = BigDecimal.valueOf(qtdAdult.longValue()).multiply(priceDetail.getPricePerDayAdult()).setScale(2, BigDecimal.ROUND_CEILING);
		totalPrice = totalPrice.add(priceDetail.getComissaoAdult()).add(totalAdult).add(priceDetail.getComissaoChild()).add(totalChild);
		return totalPrice;
	}

	private PriceDetailDomain preparaPriceDatail(PriceDomain price, Date checkin, Date checkout) {
		PriceDetailDomain priceReturn = new PriceDetailDomain();
		BigDecimal priceAdult = price.getAdult().multiply(BigDecimal.valueOf(diferencaDatas(checkin, checkout).longValue()).setScale(2, BigDecimal.ROUND_CEILING));
		BigDecimal priceChild = price.getChild().multiply(BigDecimal.valueOf(diferencaDatas(checkin, checkout).longValue()).setScale(2, BigDecimal.ROUND_CEILING));
		priceReturn.setPricePerDayAdult(priceAdult);
		priceReturn.setPricePerDayChild(priceChild);
		priceReturn.setComissaoAdult(priceAdult.divide(BigDecimal.valueOf(0.7), 2, RoundingMode.HALF_UP).setScale(2, BigDecimal.ROUND_CEILING));
		priceReturn.setComissaoChild(priceChild.divide(BigDecimal.valueOf(0.7), 2, RoundingMode.HALF_UP).setScale(2, BigDecimal.ROUND_CEILING));
		
		return priceReturn;
	}

	private Integer diferencaDatas(Date checkin, Date checkout) {
		
		Calendar checkinData = Calendar.getInstance();
		Calendar checkoutData = Calendar.getInstance();
		
		checkinData.setTime(checkin);
		checkoutData.setTime(checkout);
		
		int dias = checkoutData.get(Calendar.DAY_OF_YEAR) -
				checkinData.get(Calendar.DAY_OF_YEAR);

		return dias;
	}

}
