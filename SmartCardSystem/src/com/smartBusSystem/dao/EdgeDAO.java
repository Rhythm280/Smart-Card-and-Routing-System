package com.smartBusSystem.dao;

import com.smartBusSystem.db.*;
import com.smartBusSystem.model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EdgeDAO {
	public List<Edge> findAll() {
		List<Edge> list = new ArrayList<>();
		String sql = "SELECT edge_id, src_stop_id, dst_stop_id, distance_km, base_fare FROM edge";
		try (Connection con = DB.get(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
			while (rs.next()) {
				Edge e = new Edge();
				e.setEdgeId(rs.getInt(1));
				e.setSrcStopId(rs.getInt(2));
				e.setDstStopId(rs.getInt(3));
				e.setDistanceKm(rs.getDouble(4));
				e.setBaseFare(rs.getDouble(5));
				list.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
