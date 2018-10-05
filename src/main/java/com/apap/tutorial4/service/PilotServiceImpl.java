package com.apap.tutorial4.service;



import com.apap.tutorial4.model.PilotModel;
import com.apap.tutorial4.repository.PilotDb;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * PilotServiceImpl
 * @author Ifdhal Suharmitan
 */
@Service
@Transactional
public class PilotServiceImpl implements PilotService {
	@Autowired
	private PilotDb pilotDb;
	
	@Override
	public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) {
		return pilotDb.findByLicenseNumber(licenseNumber);
	}
	
	@Override
	public void addPilot(PilotModel pilot) {
		pilotDb.save(pilot);
	}
	
	@Override
	public void deletePilot(PilotModel pilot) {
		pilotDb.delete(pilot);
	}
	
	@Override
	public void updatePilot(PilotModel pilot, long id) {
		Optional<PilotModel> pilotOptional = pilotDb.findById(id);
		pilot.setId(id);
		pilotDb.save(pilot);
		
	}
}
