package it.fermi.gestionehibernate.domain;

import javax.persistence.*;


/**
 * Entity class representing a spool cluster.
 * This class is mapped to the "spool_cluster" table in the database.
 * @params clusterId:Long
 * @params clusterCode:String
 * @params description:String
 * @params state:String
 * @author Riccardo Mandich
 * @version 1.0
 */
@Entity(name = "spool_cluster")
public class SpoolCluster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cluster_id", nullable = false, updatable = false)
    private long clusterId;

    @Column(name = "cluster_code", nullable = false, unique = true, length = 128)
    private String clusterCode;

    @Column(name = "description", nullable = false, length = 128)
    private String description;

    @Column(name = "state", nullable = false, length = 512)
    private String state;

    public long getClusterId() {
        return clusterId;
    }

    public void setClusterId(long clusterId) {
        this.clusterId = clusterId;
    }

    public String getClusterCode() {
        return clusterCode;
    }

    public void setClusterCode(String clusterCode) {
        this.clusterCode = clusterCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
