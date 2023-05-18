package com.ennajim.demandsmanagement.Repository;

import com.ennajim.demandsmanagement.Entity.Demand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandRepository extends JpaRepository<Demand,Long> {
}
