package br.com.cvc.teste.cvcTeste.domain;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PriceDetailDomain {

	private BigDecimal pricePerDayAdult;
	private BigDecimal pricePerDayChild;
	@JsonIgnore
	private BigDecimal comissaoAdult;
	@JsonIgnore
	private BigDecimal comissaoChild;
	
	public BigDecimal getPricePerDayAdult() {
		return pricePerDayAdult;
	}
	public void setPricePerDayAdult(BigDecimal pricePerDayAdult) {
		this.pricePerDayAdult = pricePerDayAdult;
	}
	public BigDecimal getPricePerDayChild() {
		return pricePerDayChild;
	}
	public void setPricePerDayChild(BigDecimal pricePerDayChild) {
		this.pricePerDayChild = pricePerDayChild;
	}
	public BigDecimal getComissaoAdult() {
		return comissaoAdult;
	}
	public void setComissaoAdult(BigDecimal comissaoAdult) {
		this.comissaoAdult = comissaoAdult;
	}
	public BigDecimal getComissaoChild() {
		return comissaoChild;
	}
	public void setComissaoChild(BigDecimal comissaoChild) {
		this.comissaoChild = comissaoChild;
	}
}
