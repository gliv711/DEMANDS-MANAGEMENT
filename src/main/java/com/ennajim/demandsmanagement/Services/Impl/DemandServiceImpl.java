package com.ennajim.demandsmanagement.Services.Impl;

import com.ennajim.demandsmanagement.Entity.Demand;
import com.ennajim.demandsmanagement.Repository.DemandRepository;
import com.ennajim.demandsmanagement.Services.DemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemandServiceImpl implements DemandService {
    @Autowired
    private DemandRepository demandRepository ;



    @Override
    public List<Demand> getAll(){
        return demandRepository.findAll();
    }


    @Override
    public void SaveDemand(Demand demand) {
        demandRepository.save(demand);
    }

    @Override
    public void deleteById(Long id) {
        demandRepository.deleteById(id);
    }

    @Override
    public Optional<Demand> findbyId(Long id) {
        return demandRepository.findById(id);
    }

    @Override
    public long count(){
        return demandRepository.count();
    }

}
