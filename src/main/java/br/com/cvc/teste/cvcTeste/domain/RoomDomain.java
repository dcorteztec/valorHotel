package br.com.cvc.teste.cvcTeste.domain;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomDomain {

	private Integer id;
	private String categoryName;
	private BigDecimal totalPrice;
	private PriceDomain price;
	private PriceDetailDomain priceDetail;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public PriceDomain getPrice() {
		return price;
	}
	public void setPrice(PriceDomain price) {
		this.price = price;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public PriceDetailDomain getPriceDetail() {
		return priceDetail;
	}
	public void setPriceDetail(PriceDetailDomain priceDetail) {
		this.priceDetail = priceDetail;
	}
}
