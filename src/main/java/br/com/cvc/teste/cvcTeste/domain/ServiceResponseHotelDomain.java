package br.com.cvc.teste.cvcTeste.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) 	
public class ServiceResponseHotelDomain {

	private Integer id;
	private String name;
	private Integer cityCode;
	private String cityName;
	private List<RoomDomain> rooms;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCityCode() {
		return cityCode;
	}
	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public List<RoomDomain> getRooms() {
		return rooms;
	}
	public void setRooms(List<RoomDomain> rooms) {
		this.rooms = rooms;
	}
	
	
}
