package com.um.sam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Customer_Table")
public class Customer {
	@Id
	@GeneratedValue(generator="gen")
	@GenericGenerator(name = "gen", strategy = "increment")
	@Column(name="txn_id")
	private long id;
	@Column(name="Cust_name")
	private String name;
	@Column(name="Cust_email")
	private String email;
	@Column(name="Cust_add")
	private String address;
	@OneToOne
	@PrimaryKeyJoinColumn
	private Txn txn;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Txn getTxn() {
		return txn;
	}
	public void setTxn(Txn txn) {
		this.txn = txn;
	}
}
