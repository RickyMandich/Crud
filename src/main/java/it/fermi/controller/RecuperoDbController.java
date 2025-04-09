package it.fermi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.List;

@RestController
public class RecuperoDbController{
    @GetMapping("/findSpoolCluster")
    public String findSpoolCluster() {
        List<String> body = new java.util.ArrayList<String>();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://10.0.9.240:3306/mandich", "mandich", "man3193jhg")) {
            try (Statement stmt = conn.createStatement()) {
                String select = "select * from spool_cluster;";
                try (ResultSet rs = stmt.executeQuery(select)) {
                    String header = "<tr>";
                    for(int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                        header = header.concat("<th>" + rs.getMetaData().getColumnName(i+1) + "</th>");
                    }
                    body.add(header.concat("</tr>"));
                    while (rs.next()) {
                        List<String> attributes = new java.util.ArrayList<String>();
                        for(int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                            attributes.add(rs.getString(i+1));
                        }
                        String result = "<tr>";
                        for (String attribute : attributes) {
                            result = result.concat("<td>" + attribute + "</td>");
                        }
                        result = result.concat("</tr>");
                        body.add(result);
                    }
                }
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String result = "<title>spool_cluster</title>";
        result = result.concat("<table border>");
        for (String row : body) {
            result = result.concat(row);
        }
        return result;
    }
}