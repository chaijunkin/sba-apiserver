package com.axess.smartbankapi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="ccuser")
public class CCUser {

	@Id
	@Column(name = "ccnumber")
	private long ccNumber;
	@Column(name = "ccname")
	private String ccName;
	@Column(name = "username")
	private String userName;
	@Column(name = "userid")
	private String userId;
	@Column(name = "password")
	private String password;
	@Column(name = "availableredeempoints")
	private double availableRedeemPoints;
	@Column(name = "totalrewardsgained")
	private double totalRewardsGained;
	
	public long getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(long ccNumber) {
		this.ccNumber = ccNumber;
	}

	public String getCcName() {
		return ccName;
	}

	public void setCcName(String ccName) {
		this.ccName = ccName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getAvailableRedeemPoints() {
		return availableRedeemPoints;
	}

	public void setAvailableRedeemPoints(double availableRedeemPoints) {
		this.availableRedeemPoints = availableRedeemPoints;
	}

	public double getTotalRewardsGained() {
		return totalRewardsGained;
	}

	public void setTotalRewardsGained(double totalRewardsGained) {
		this.totalRewardsGained = totalRewardsGained;
	}

}
