package com.example.fakeflix.services;

import com.example.fakeflix.entities.Distribution;
import com.example.fakeflix.repositories.DistributionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistributionService {

    @Autowired
    private DistributionRepository distributionRepository;

    public Distribution getById(Integer id){
        return distributionRepository.getById(id);
    }

    public List<Distribution> getAll(){
        return distributionRepository.findAll();
    }

    public Distribution create(Distribution distribution){
        return distributionRepository.save(distribution);
    }

    public boolean update(Distribution distribution) {
        boolean check = checkExistence(distribution.getId());
        if(check){
            distributionRepository.save(distribution);
        }
        return check;
    }

    public boolean delete(Integer id) {
        boolean check = checkExistence(id);
        if(check){
            distributionRepository.deleteById(id);
        }
        return check;

    }

    public boolean checkExistence(Integer id) {
        return distributionRepository.existsById(id);
    }
}
