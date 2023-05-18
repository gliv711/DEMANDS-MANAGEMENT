package com.ennajim.demandsmanagement.Services;

import com.ennajim.demandsmanagement.Entity.Demand;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface DemandService {
    List<Demand> getAll() ;
    void SaveDemand(Demand demand) ;
    void deleteById(Long id);
    Optional<Demand> findbyId(Long Id) ;
    long count();
}
