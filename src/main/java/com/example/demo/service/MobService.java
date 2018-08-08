package com.example.demo.service;

import com.example.demo.domain.Mob;
import com.example.demo.repository.MobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MobService {

    @Autowired
    private MobRepository mobRepository;

    public List<Mob> findAll(){
        return mobRepository.findAll();
    }

    public Mob findOne(Long id){
        return mobRepository.findById(id).get();
    }
    public Mob save(Mob mob){
        return mobRepository.save(mob);
    }
    public void delete(Long id){
        mobRepository.deleteById(id);
    }
}
