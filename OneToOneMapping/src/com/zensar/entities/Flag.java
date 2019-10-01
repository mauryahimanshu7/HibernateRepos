package com.zensar.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/*
 * @author: HImasnhu MAurya
 * @copyright: zensar.inc
 * @creation-date:27/9/2019
 * @description: primary key constraints are explained in this. using hibernate. 
 * 
 */
@Entity
public class Flag {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int flagId;
	private String flagName;
	private String flagDescription;
	@OneToOne(mappedBy = "flag")
	private Country country;
	
	public int getFlagId() {
		return flagId;
	}
	public void setFlagId(int flagId) {
		this.flagId = flagId;
	}
	public String getFlagName() {
		return flagName;
	}
	public void setFlagName(String flagName) {
		this.flagName = flagName;
	}
	public String getFlagDescription() {
		return flagDescription;
	}
	public void setFlagDescription(String flagDescription) {
		this.flagDescription = flagDescription;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
	
	

}
