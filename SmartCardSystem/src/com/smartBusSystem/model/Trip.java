package com.smartBusSystem.model;

import java.sql.Timestamp;

public class Trip {
	private int tripId;
	private int passengerId;
	private int srcStopId;
	private int dstStopId;
	private double routeDistanceKm;
	private double fareCharged;
	private Timestamp createdAt;

	public Trip(int tripId, int passengerId, int srcStopId, int dstStopId, double routeDistanceKm, double fareCharged,
			Timestamp createdAt) {
		this.tripId = tripId;
		this.passengerId = passengerId;
		this.srcStopId = srcStopId;
		this.dstStopId = dstStopId;
		this.routeDistanceKm = routeDistanceKm;
		this.fareCharged = fareCharged;
		this.createdAt = createdAt;
	}

	// Getters and Setters
	public int getTripId() {
		return tripId;
	}

	public int getPassengerId() {
		return passengerId;
	}

	public int getSrcStopId() {
		return srcStopId;
	}

	public int getDstStopId() {
		return dstStopId;
	}

	public double getRouteDistanceKm() {
		return routeDistanceKm;
	}

	public double getFareCharged() {
		return fareCharged;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}
}
