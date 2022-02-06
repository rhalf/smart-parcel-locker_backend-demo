package com.spl.splapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transactions")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@OneToOne
    @JoinColumn(name = "courier_id")
	private Courier courier;
	
	@OneToOne
    @JoinColumn(name = "parcel_id")
	private Parcel parcel;
	
	@OneToOne
    @JoinColumn(name = "locker_id")
	private Locker locker;
	
	@Column(name = "datetime_withdraw")
	private String withdraw;
	
	@Column(name = "datetime_deposit")
	private String deposit;
	
	@Column(name = "datetime_created")
	private String created;
	
	
	
}
