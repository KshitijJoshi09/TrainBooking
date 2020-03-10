package com.booking.app.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Train implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "TRAIN_NO" , nullable=false)
	private int trainNo;

	@Length(min = 3 , max = 30 , message = "Name should contain chars btw 3 and 30")
	@Column(name = "TRAIN_NAME")
	@NotEmpty(message = "field cant be empty")
	private String trainName;

	@Column(name = "TRAIN_TYPE")
	private String trainType;

	@Max(value = 10000 , message = "price so")
	@Min(value = 0 , message ="price should be greater thn 0")
	@Column(name = "TRAIN_FARE")
	private double trainFare;

	@Column(name = "STARTING_POINT")
	private String startingPoint;

	@Column(name = "DESTINATION_POINT")
	private String destinationPoint;

	@Transient
	private String dummyValues;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getTrainType() {
		return trainType;
	}

	public void setTrainType(String trainType) {
		this.trainType = trainType;
	}

	public double getTrainFare() {
		return trainFare;
	}

	public void setTrainFare(double trainFare) {
		this.trainFare = trainFare;
	}

	public String getStartingPoint() {
		return startingPoint;
	}

	public void setStartingPoint(String startingPoint) {
		this.startingPoint = startingPoint;
	}

	public String getDestinationPoint() {
		return destinationPoint;
	}

	public void setDestinationPoint(String destinationPoint) {
		this.destinationPoint = destinationPoint;
	}

	public Train() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Train [id=" + id + ", trainNo=" + trainNo + ", trainName=" + trainName + ", trainType=" + trainType
				+ ", trainFare=" + trainFare + ", startingPoint=" + startingPoint + ", destinationPoint="
				+ destinationPoint + "]";
	}

}
