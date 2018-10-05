package com.apap.tutorial4.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * FlightModel
 * @author Ifdhal Suharmitan
 */
@Entity
@Table(name = "flight")
public class FlightModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "flight_number", nullable = false)
	private String flight_number;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "origin", nullable = false)
	private String origin;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "destination", nullable = false)
	private String destination;
	
	@NotNull
	@Column(name = "time")
	private Date time;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pilot_licenseNumber", referencedColumnName = "license_number", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnore
	private PilotModel pilot;
	
	public FlightModel() {
		id = 0;
		flight_number = "";
		origin = "";
		destination = "";
		time = new Date(11111111);
		pilot = new PilotModel();
	}
	public FlightModel(long id, String flight_number, String origin, String destination, Date time, PilotModel pilot) {
		this.id = id;
		this.flight_number = flight_number;
		this.origin = origin;
		this.destination = destination;
		this.time = time;
		this.pilot = pilot;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getFlightNumber() {
		return flight_number;
	}
	
	public void setFlightNumber(String flight_number) {
		this.flight_number = flight_number;
	}
	
	public String getOrigin() {
		return origin;
	}
	
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public Date getTime() {
		return time;
	}
	
	public void setTime(Date time) {
		this.time = time;
	}
	
	public String getPilotLicenseNumber() {
		String pilot_licenseNumber = pilot.getLicenseNumber();
		return pilot_licenseNumber;
	}
	
	public void setLicenseNumber(String pilot_licenseNumber) {
		pilot.setLicenseNumber(pilot_licenseNumber);
	}
	
	public PilotModel getPilot() {
		return pilot;
	}
	
	public void setPilot(PilotModel pilot) {
		this.pilot = pilot;
	}
	
	
}
