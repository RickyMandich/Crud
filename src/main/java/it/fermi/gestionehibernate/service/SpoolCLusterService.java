package it.fermi.gestionehibernate.service;

import it.fermi.gestionehibernate.dao.SpoolClusterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "servizionuovo")
public class SpoolCLusterService {
    @Autowired
    private SpoolClusterRepository spoolClusterRepository;

}
