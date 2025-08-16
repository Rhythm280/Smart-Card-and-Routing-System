package com.smartBusSystem.model;

public class FarePolicy {
	private double perKm;
	private double minFare;

	public FarePolicy(double perKm, double minFare) {
		this.perKm = perKm;
		this.minFare = minFare;
	}

	public double getPerKm() {
		return perKm;
	}

	public double getMinFare() {
		return minFare;
	}
}
