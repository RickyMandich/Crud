package it.fermi.controller.crud;

import it.fermi.utulity.DBEntry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FindCluster{
    @GetMapping("/findCluster")
    public List<List<String>> findCluster(@RequestParam (required = false) String clusterCode) {
        List<List<String>> ret = new java.util.ArrayList<List<String>>();
        Connection conn = DBEntry.getConnection();
        if (conn == null) {
            ret.add(new ArrayList<String>(List.of("impossibile stabilire una connessione")));
            return ret;
        }
        try (java.sql.Statement stmt = conn.createStatement()) {
            clusterCode = (clusterCode == null) ? "" : clusterCode;
            clusterCode = "%" + clusterCode + "%";
            String select = "select * from spool_cluster where cluster_code like '" + clusterCode + "';";
            ret.add(new ArrayList<String>(List.of(select)));
            try (java.sql.ResultSet rs = stmt.executeQuery(select)) {
                while (rs.next()){
                    List<String> res = new ArrayList<String>();
                    for(int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                        res.add(rs.getString(i+1));
                    }
                    ret.add(res);
                }
            }
        } catch (java.sql.SQLException e) {
            ret.add(new ArrayList<>(List.of("impossibile recuperare i dati")));
            e.printStackTrace();
        }
        return ret;
    }
}