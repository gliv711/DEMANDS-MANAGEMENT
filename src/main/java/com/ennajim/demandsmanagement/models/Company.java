package com.ennajim.demandsmanagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company{
    private Long id ;
    private String NameofCompany ;
    private String DomaineofActivity ;
}
