package com.smartBusSystem.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.List;  // keep util.List for data from DAO

import com.smartBusSystem.dao.TripDAO;

public class TripHistoryFrame extends Frame {
    private final int passengerId;
    private final TripDAO tripDAO = new TripDAO();
    private final java.awt.List tripList = new java.awt.List(18, false); // ✅ explicitly AWT List

    public TripHistoryFrame(int passengerId) {
        this.passengerId = passengerId;
        setTitle("My Trip History");
        setSize(700, 420);
        setLayout(new BorderLayout(6,6));
        add(new Label("Most recent first:"), BorderLayout.NORTH);
        add(tripList, BorderLayout.CENTER);

        reload();

        addWindowListener(new WindowAdapter(){ 
            public void windowClosing(WindowEvent e){ dispose(); } 
        });
    }

    private void reload() {
        tripList.removeAll();
        List<String> lines = tripDAO.listPrettyByPassenger(passengerId); // ✅ from DAO
        for (String s : lines) tripList.add(s);
        if (lines.isEmpty()) tripList.add("No trips yet.");
    }
}
