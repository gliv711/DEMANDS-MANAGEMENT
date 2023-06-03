package com.ennajim.demandsmanagement.Services.Impl;

import com.ennajim.demandsmanagement.Entity.Demand;
import com.ennajim.demandsmanagement.Repository.DemandRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class DemandServiceImplTest {
    private DemandServiceImpl demandService;

    @Mock
    private DemandRepository demandRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        demandService = new DemandServiceImpl();
        ReflectionTestUtils.setField(demandService, "demandRepository", demandRepository);
    }

    @Test
    void getAll_ShouldReturnAllDemands() {
        List<Demand> demands = new ArrayList<>();
        when(demandRepository.findAll()).thenReturn(demands);

        List<Demand> result = demandService.getAll();

        assertEquals(demands, result);
        verify(demandRepository, times(1)).findAll();
    }

    @Test
    void saveDemand_ShouldSaveDemand() {
        Demand demand = new Demand();

        demandService.SaveDemand(demand);

        verify(demandRepository, times(1)).save(demand);
    }

    @Test
    void deleteById_ShouldDeleteDemand() {
        Long id = 1L;

        demandService.deleteById(id);

        verify(demandRepository, times(1)).deleteById(id);
    }

    @Test
    void findById_ExistingId_ShouldReturnDemand() {
        Long id = 1L;
        Demand demand = new Demand();
        when(demandRepository.findById(id)).thenReturn(Optional.of(demand));

        Optional<Demand> result = demandService.findbyId(id);

        assertEquals(Optional.of(demand), result);
        verify(demandRepository, times(1)).findById(id);
    }

    @Test
    void findById_NonExistingId_ShouldReturnEmptyOptional() {
        Long id = 1L;
        when(demandRepository.findById(id)).thenReturn(Optional.empty());

        Optional<Demand> result = demandService.findbyId(id);

        assertEquals(Optional.empty(), result);
        verify(demandRepository, times(1)).findById(id);
    }

    @Test
    void count_ShouldReturnNumberOfDemands() {
        long count = 10L;
        when(demandRepository.count()).thenReturn(count);

        long result = demandService.count();

        assertEquals(count, result);
        verify(demandRepository, times(1)).count();
    }

    @Test
    void findByEmail_ShouldReturnDemandsWithMatchingEmail() {
        String email = "example@example.com";
        List<Demand> demands = new ArrayList<>();
        when(demandRepository.findByEmail(email)).thenReturn(demands);

        List<Demand> result = demandService.findbyEmail(email);

        assertEquals(demands, result);
        verify(demandRepository, times(1)).findByEmail(email);
    }
}
