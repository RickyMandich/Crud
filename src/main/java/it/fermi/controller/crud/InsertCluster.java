package it.fermi.controller.crud;

import it.fermi.utility.DBEntry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@RestController
public class InsertCluster{
    @GetMapping("/insertCluster")
    public List<String> insertCluster(
            @RequestParam String clusterCode,
            @RequestParam (required = false) String description,
            @RequestParam (required = false) String state
    ) {
        if (clusterCode.contains("'")) {
            return List.of("bad input");
        }
        if (description != null && description.contains("'")) {
            return List.of("bad input");
        }
        if (state != null && state.contains("'")) {
            return List.of("bad input");
        }
        Connection conn = DBEntry.getConnection();
        if (conn == null) {
            return List.of("impossibile stabilire una connessione");
        }
        try (java.sql.Statement stmt = conn.createStatement()) {
            String insert = "insert into spool_cluster (cluster_code, description, state, programma_creazione) values ('" + clusterCode + "', '" + description + "', '" + state + "', 'java');";
            stmt.executeUpdate(insert);
            return List.of("inserimento avvenuto con successo");
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            return List.of("impossibile inserire i dati");
        }
    }
}