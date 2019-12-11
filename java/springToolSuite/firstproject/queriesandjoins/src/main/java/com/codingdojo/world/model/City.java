package com.codingdojo.world.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="cities")
public class City {
	@Id
	private Integer id;
	private String name;
	@Column(name = "country_code")
	private String countryCode;
	private String district;
	private Integer population;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="country_id")
	private Country country;
	public City() {
		
	}
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
	
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public Integer getPopulation() {
		return population;
	}
	public void setPopulation(Integer population) {
		this.population = population;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
}

