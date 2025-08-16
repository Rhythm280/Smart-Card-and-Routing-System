// AuthService.java
package com.smartBusSystem.service;

import com.smartBusSystem.dao.AdminDAO;
import com.smartBusSystem.dao.PassengerDAO;
import com.smartBusSystem.model.Admin;
import com.smartBusSystem.model.Passenger;

public class AuthService {
	private final AdminDAO adminDAO;
	private final PassengerDAO passengerDAO;

	public AuthService() {
		this.adminDAO = new AdminDAO();
		this.passengerDAO = new PassengerDAO();
	}

	// Admin login
	public Admin loginAdmin(String username, String password) {
		// Directly use DAO’s login
		return adminDAO.login(username, password);
	}

	// Passenger login
	public Passenger loginPassenger(String passengerId, String password) {
		return passengerDAO.login(passengerId, password); // we’ll align PassengerDAO too
	}
}
