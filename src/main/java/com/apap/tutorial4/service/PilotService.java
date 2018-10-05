package com.apap.tutorial4.service;

import java.util.List;

import com.apap.tutorial4.model.PilotModel;

/**
 * PilotService
 * @author Ifdhal Suharmitan
 */

public interface PilotService {
	PilotModel getPilotDetailByLicenseNumber(String licenseNumber);
	void addPilot(PilotModel pilot);
	void deletePilot(PilotModel pilot);
	void updatePilot(PilotModel pilot, long id);
}
