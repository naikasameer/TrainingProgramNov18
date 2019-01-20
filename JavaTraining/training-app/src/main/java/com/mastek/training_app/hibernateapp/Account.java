package com.mastek.training_app.hibernateapp;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="JPA_Account")
@EntityListeners({AccountLifeCycleListener.class})
@NamedQueries({
	@NamedQuery(name="fetchAllAccounts",query="from Account"),
	
	@NamedQuery(name="fetchAccountsByBalance",
			query="from Account where balance between :min and :max"),
	
	@NamedQuery(name="fetchAccountsByAccountType",
			query="from Account where accountType= :type"),
	
	@NamedQuery(name="fetchAccountBalanceStats",
	  query="select max(balance),min(balance),sum(balance),avg(balance) from Account")
})
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Account {

	int accountNumber; //1001
	String accountType;
	double balance;
	Set<Transaction> transactions = new HashSet<>();
	Set<Customer> owners = new HashSet<>();
	
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(name="JPA_REGISTRATIONS", //name of join table to be created by ORM
			// the foreign key for current class
			joinColumns= {@JoinColumn(name="FK_AccountId")}, 
			//the foreign key for collection type class
			inverseJoinColumns= {@JoinColumn(name="FK_CustomerId")}) 
	public Set<Customer> getOwners() {
		return owners;
	}

	public void setOwners(Set<Customer> owners) {
		this.owners = owners;
	}

	//mappedBy: denotes to fetch join column configuration from the specified 
	// propertyname eg: account of the Type of collection: eg: Transaction
	// select * from Transactions where FK_AccountId=this.accountNumber
	@OneToMany(mappedBy="account",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountType=" + accountType + ", balance=" + balance
				+ "]";
	}
	
	@Id
	@Column(name="account_number")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	@Column(name="account_type",length=25,nullable=false)
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
