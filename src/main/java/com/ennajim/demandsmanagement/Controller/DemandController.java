package com.ennajim.demandsmanagement.Controller;

import com.ennajim.demandsmanagement.Entity.Demand;
import com.ennajim.demandsmanagement.Services.DemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DemandController {
@Autowired
private DemandService demandService ;


    @GetMapping("/demands/all")
    public List<Demand> getall(){
    return demandService.getAll();

    }

    @GetMapping("/demands/{Id}")
    public Optional<Demand> getbyId(@PathVariable(name="Id") Long Id){
        return demandService.findbyId(Id);
    }



    @GetMapping("/demand/email/{email}")
    public List<Demand>getByEmail(@PathVariable("email") String email){
        return demandService.findbyEmail(email);
    }

    @DeleteMapping("/demands/{Id}")
    public void deleteById(@PathVariable(name="Id") Long Id) {
        demandService.deleteById(Id);
    }

    @PostMapping("/demands")
    public void save(@RequestBody Demand demand){
        demandService.SaveDemand(demand);
    }


    @GetMapping("/demands/count")
    public long count(){
        return demandService.count();
    }







}
