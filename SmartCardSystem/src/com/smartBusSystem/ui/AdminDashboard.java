package com.smartBusSystem.ui;

import com.smartBusSystem.dao.*;
import com.smartBusSystem.model.*;
import com.smartBusSystem.service.*;

import java.awt.*;
import java.awt.event.*;

public class AdminDashboard extends Frame {
    private final Admin me;
    private final GraphService graphService = new GraphService();
    private final StopDAO stopDAO = new StopDAO();
    private final TextArea info = new TextArea();

    public AdminDashboard(Admin a) {
        this.me = a;
        setTitle("Admin - " + a.getUsername());
        setSize(600, 380);
        setLayout(new BorderLayout(8,8));

        Panel top = new Panel(new FlowLayout(FlowLayout.LEFT));
        Button btnReload = new Button("Reload Network");
        Button btnListStops = new Button("List Stops");
        top.add(btnReload); top.add(btnListStops);
        add(top, BorderLayout.NORTH);
        add(info, BorderLayout.CENTER);

        btnReload.addActionListener(e -> {
            graphService.reload();
            info.setText("Graph reloaded from DB.\n");
        });

        btnListStops.addActionListener(e -> {
            var stops = stopDAO.findAll();
            StringBuilder sb = new StringBuilder("Stops:\n");
            for (var s: stops) sb.append(" - ").append(s.getName()).append("\n");
            info.setText(sb.toString());
        });

        addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent e){ System.exit(0);} });
    }
}
