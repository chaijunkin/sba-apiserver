	package com.axess.smartbankapi.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;



@Entity
@Table(name="userredeemptionhistory")
public class UserRedeemptionHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	@OneToOne
	@JoinColumn(name = "catalogue_id")
	private RewardsCatalogue catalogue;
	@Column(name = "quantity")
	private int quantity;
	@OneToOne
    @JoinColumn(name = "ccuser_id")
	private CCUser ccUser;
	@Column(name = "orderdate")
	private LocalDate orderdate;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public RewardsCatalogue getCatalogue() {
		return catalogue;
	}
	public void setCatalogue(RewardsCatalogue catalogue) {
		this.catalogue = catalogue;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public CCUser getCcUser() {
		return ccUser;
	}
	public void setCcUser(CCUser ccUser) {
		this.ccUser = ccUser;
	}
	public LocalDate getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(LocalDate orderdate) {
		this.orderdate = orderdate;
	}
	
	

}
