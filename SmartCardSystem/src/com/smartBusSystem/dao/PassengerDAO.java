package com.smartBusSystem.dao;

import com.smartBusSystem.db.*;
import com.smartBusSystem.model.*;
import java.sql.*;

public class PassengerDAO {
	public Passenger login(String cardId, String password) {
		String sql = "SELECT * FROM passenger WHERE card_id=? AND password=?";
		try (Connection con = DB.get(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, cardId);
			ps.setString(2, password);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					Passenger p = new Passenger();
					p.setPassengerId(rs.getInt("passenger_id"));
					p.setName(rs.getString("name"));
					p.setCardId(rs.getString("card_id"));
					p.setPassword(rs.getString("password"));
					p.setBalance(rs.getDouble("balance"));
					return p;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean updateBalance(int passengerId, double delta) {
		String sql = "UPDATE passenger SET balance = balance + ? WHERE passenger_id=?";
		try (Connection con = DB.get(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setDouble(1, delta);
			ps.setInt(2, passengerId);
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// transaction-friendly methods
	public double fetchBalance(Connection con, int passengerId) throws SQLException {
		String sql = "SELECT balance FROM passenger WHERE passenger_id=?";
		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, passengerId);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next())
					return rs.getDouble(1);
				return -1;
			}
		}
	}

	public boolean updateBalance(Connection con, int passengerId, double delta) throws SQLException {
		String sql = "UPDATE passenger SET balance = balance + ? WHERE passenger_id=?";
		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setDouble(1, delta);
			ps.setInt(2, passengerId);
			return ps.executeUpdate() == 1;
		}
	}

	public Passenger findById(int id) {
		String sql = "SELECT * FROM passenger WHERE passenger_id=?";
		try (Connection con = DB.get(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					Passenger p = new Passenger();
					p.setPassengerId(rs.getInt("passenger_id"));
					p.setName(rs.getString("name"));
					p.setCardId(rs.getString("card_id"));
					p.setPassword(rs.getString("password"));
					p.setBalance(rs.getDouble("balance"));
					return p;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
