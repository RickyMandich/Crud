package it.fermi.gestionehibernate.service;

import it.fermi.gestionehibernate.dao.SpoolClusterRepository;
import it.fermi.gestionehibernate.domain.SpoolCluster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "servizionuovo")
public class SpoolClusterService {
    @Autowired
    private SpoolClusterRepository spoolClusterRepository;

    public SpoolCluster insertSpoolCluster(
            String clusterCode,
            String description,
            String state
    ) {
        SpoolCluster spoolCluster = new SpoolCluster();
        spoolCluster.setClusterCode(clusterCode);
        spoolCluster.setDescription(description);
        spoolCluster.setState(state);

        return spoolClusterRepository.save(spoolCluster);
    }

    public List<SpoolCluster> findSpoolClusters() {
        return spoolClusterRepository.findAll();
    }

    public SpoolCluster updateSpoolClusterByClusterCode(
            Long oldId,
            String newClusterCode,
            String newDescription,
            String newState
    ) {
        SpoolCluster spoolCluster = spoolClusterRepository.getById(oldId);
        spoolCluster.setClusterCode(newClusterCode);
        spoolCluster.setDescription(newDescription);
        spoolCluster.setState(newState);
        return spoolClusterRepository.save(spoolCluster);
    }

    public SpoolCluster deleteSpoolClusterByClusterCode(Long id) {
        SpoolCluster spoolCluster = spoolClusterRepository.getById(id);
        spoolClusterRepository.delete(spoolCluster);
        return spoolCluster;
    }
}
