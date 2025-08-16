package com.smartBusSystem.dao;

import com.smartBusSystem.db.DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TripDAO {

	// List trips for a passenger (pretty format)
	public List<String> listPrettyByPassenger(int passengerId) {
		List<String> trips = new ArrayList<>();
		String sql = "SELECT trip_id, created_at, fare_charged, src_stop_id, dst_stop_id FROM trip WHERE passenger_id = ? ORDER BY created_at DESC";

		try (Connection con = DB.get(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, passengerId);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					String record = "Trip #" + rs.getInt("trip_id") + " | " + rs.getTimestamp("created_at")
							+ " | Source Stop ID: " + rs.getInt("src_stop_id") + " → Dest Stop ID: "
							+ rs.getInt("dst_stop_id") + " | Fare: ₹" + rs.getDouble("fare_charged");
					trips.add(record);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trips;
	}

	// Record a trip and return success/failure
	public boolean recordTrip(int passengerId, int srcStopId, int dstStopId, double routeDistanceKm,
			double fareCharged) {
		String sql = "INSERT INTO trip (passenger_id, src_stop_id, dst_stop_id, route_distance_km, fare_charged, created_at) "
				+ "VALUES (?, ?, ?, ?, ?, NOW())";
		try (Connection con = DB.get(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, passengerId);
			ps.setInt(2, srcStopId);
			ps.setInt(3, dstStopId);
			ps.setDouble(4, routeDistanceKm);
			ps.setDouble(5, fareCharged);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
