package it.fermi.controller.crud;

import it.fermi.utulity.DBEntry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.util.List;

@RestController
public class FindCluster{
    @GetMapping("/findCluster")
    public List<String> findCluster(@RequestParam String clusterCode) {
        List<String> ret = new java.util.ArrayList<String>();
        Connection conn = DBEntry.getConnection();
        if (conn == null) {
            ret.add("impossibile recuperare la connessione");
            return ret;
        }
        try (java.sql.Statement stmt = conn.createStatement()) {
            clusterCode = "%" + clusterCode + "%";
            String select = "select * from cluster where cluster_code like '" + clusterCode + "';";
            try (java.sql.ResultSet rs = stmt.executeQuery(select)) {
                while (rs.next()){

                }
            }
        } catch (java.sql.SQLException e) {
            ret.add("impossibile recuperare i dati");
            e.printStackTrace();
        }
        return ret;
    }
}