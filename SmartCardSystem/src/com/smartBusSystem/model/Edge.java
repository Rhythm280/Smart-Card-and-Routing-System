package com.smartBusSystem.model;

public class Edge {
	private int edgeId;
	private int srcStopId;
	private int dstStopId;
	private double distanceKm;
	private double baseFare;

	public int getEdgeId() {
		return edgeId;
	}

	public void setEdgeId(int edgeId) {
		this.edgeId = edgeId;
	}

	public int getSrcStopId() {
		return srcStopId;
	}

	public void setSrcStopId(int srcStopId) {
		this.srcStopId = srcStopId;
	}

	public int getDstStopId() {
		return dstStopId;
	}

	public void setDstStopId(int dstStopId) {
		this.dstStopId = dstStopId;
	}

	public double getDistanceKm() {
		return distanceKm;
	}

	public void setDistanceKm(double distanceKm) {
		this.distanceKm = distanceKm;
	}

	public double getBaseFare() {
		return baseFare;
	}

	public void setBaseFare(double baseFare) {
		this.baseFare = baseFare;
	}
}
