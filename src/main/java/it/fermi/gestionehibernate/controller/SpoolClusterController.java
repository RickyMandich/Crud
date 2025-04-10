package it.fermi.gestionehibernate.controller;

import it.fermi.gestionehibernate.domain.SpoolCluster;

import it.fermi.gestionehibernate.service.SpoolClusterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public class SpoolClusterController {

    @Autowired
    @Qualifier("servizionuovo")
    private SpoolClusterService spoolCLusterService;

    @PostMapping("/insertClusterHibernate/{clusterCode}")
    public SpoolCluster insertSpoolCluster(
            @PathVariable String clusterCode,
            @RequestParam String description,
            @RequestParam String state
    ) {
        return spoolCLusterService.insertSpoolCluster(clusterCode, description, state);
    }

    @GetMapping("/deleteClusterHibernate/{id}")
    public List<SpoolCluster> recuperoCluster(
            @PathVariable Long id
    ) {
        return spoolCLusterService.findSpoolClusters();
    }

    @DeleteMapping("/deleteClusterHibernate/{id}")
    public SpoolCluster deleteSpoolCluster(
            @PathVariable Long id
    ) {
        return spoolCLusterService.deleteSpoolClusterByClusterCode(id);
    }

    @PostMapping("/updateClusterHibernate/{oldId}")
    public SpoolCluster updateSpoolCluster(
            @PathVariable Long oldId,
            @RequestParam String newClusterCode,
            @RequestParam String newDescription,
            @RequestParam String newState
    ) {
        return spoolCLusterService.updateSpoolClusterByClusterCode(oldId, newClusterCode, newDescription, newState);
    }
}
