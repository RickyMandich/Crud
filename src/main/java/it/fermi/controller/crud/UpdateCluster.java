package it.fermi.controller.crud;

import it.fermi.utility.DBEntry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UpdateCluster {
    @GetMapping("/updateCluster")
    public List<String> updateCluster(
            @RequestParam (required = false) String clusterCode,
            @RequestParam (required = false) String description,
            @RequestParam (required = false) String state,
            @RequestParam String codeToEdit
    ) {
        if(clusterCode != null && clusterCode.contains("'")){
            return List.of("bad input");
        }
        if(description != null && description.contains("'")){
            return List.of("bad input");
        }
        if(state != null && state.contains("'")){
            return List.of("bad input");
        }
        if(DBEntry.getConnection() == null) {
            return List.of("impossibile stabilire una connessione");
        }
        if(clusterCode == null && description == null && state == null) {
            return List.of("nulla da aggiornare");
        }
        try (Statement stmt = DBEntry.getConnection().createStatement()) {
            String update = "update spool_cluster set "+
                    (clusterCode != null?"CLUSTER_CODE = '" + clusterCode + "'":"")+
                    ((description != null && clusterCode != null )? ", " : "" )+
                    (description != null ? "DESCRIPTION = '" + description + "'":"")+
                    ((description != null && state != null )? ", " : "" )+
                    ((clusterCode != null && description != null && state != null )? ", " : "" )+
                    (state != null?", STATE = '" + state + "'":"")+
                    "where CLUSTER_CODE = '" + codeToEdit + "';";
            stmt.executeUpdate(update);
            return List.of("aggiornamento avvenuto con successo");
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            return List.of("impossibile aggiornare i dati");
        }
    }
}
