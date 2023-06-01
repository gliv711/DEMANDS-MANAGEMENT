package com.ennajim.demandsmanagement.Repository;

import com.ennajim.demandsmanagement.Entity.Demand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemandRepository extends JpaRepository<Demand,Long> {
    List<Demand> findByEmail(String email) ;
}
