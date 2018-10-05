package com.apap.tutorial4.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * PilotModel
 * @author Ifdhal Suharmitan
 */
@Entity
@Table(name = "pilot")
public class PilotModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "license_number", nullable = false, unique = true)
	private String license_number;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "name", nullable = false)
	private String name;
	
	@NotNull
	@Column(name = "fly_hour", nullable = false)
	private int flyHour;
	
	@OneToMany(mappedBy = "pilot", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<FlightModel> pilotFlight;
	
	public PilotModel() {
		id = 0;
		license_number = "";
		name = "";
		flyHour = 0;
	}
	
	public PilotModel(long id, String license_number, String name, int flyHour) {
		this.id = id;
		this.license_number = license_number;
		this.name = name;
		this.flyHour = flyHour;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getLicenseNumber() {
		return license_number;
	}
	
	public void setLicenseNumber(String license_number) {
		this.license_number = license_number;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getFlyHour() {
		return flyHour;
	}
	
	public void setFlyHour(int flyHour) {
		this.flyHour = flyHour;
	}
	
	public List<FlightModel> getListFlightModel() {
		return pilotFlight;
	}
	
	public void setListFlightModel(List<FlightModel> pilotFlight) {
		this.pilotFlight = pilotFlight;
	}
	
}
