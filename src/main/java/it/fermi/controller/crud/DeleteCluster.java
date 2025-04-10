package it.fermi.controller.crud;

import it.fermi.utility.DBEntry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeleteCluster {
    @GetMapping("/deleteCluster")
    public List<String> deleteCluster(
            @RequestParam String clusterCode
    ) {
        if (clusterCode.contains("'")) {
            return List.of("bad input");
        }
        if (DBEntry.getConnection() == null) {
            return List.of("impossibile stabilire una connessione");
        }
        try (java.sql.Statement stmt = DBEntry.getConnection().createStatement()) {
            String delete = "delete from spool_cluster where cluster_code = '" + clusterCode + "';";
            stmt.executeUpdate(delete);
            return List.of("cancellazione avvenuta con successo");
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            return List.of("impossibile cancellare i dati");
        }finally {
            try {
                DBEntry.getConnection().close();
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
