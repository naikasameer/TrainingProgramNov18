package com.mastek.training_app.hibernateapp;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="JPA_TABLE_PER_CLASS_S3_CARD_Payment")
public class CardPayment extends Payment{
	long cardNumber;
	String cardType;
	
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	@Override
	public String toString() {
		return "CardPayment [cardNumber=" + cardNumber + ", cardType=" + cardType + ", paymentId=" + paymentId
				+ ", amount=" + amount + "]";
	}
}
