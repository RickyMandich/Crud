package it.fermi.gestionehibernate.dao;

import it.fermi.gestionehibernate.domain.SpoolCluster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpoolClusterRepository extends JpaRepository<SpoolCluster, Long> {
}