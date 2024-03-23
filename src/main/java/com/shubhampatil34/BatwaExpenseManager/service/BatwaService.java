package com.shubhampatil34.BatwaExpenseManager.service;

import com.shubhampatil34.BatwaExpenseManager.entity.Batwa;
import com.shubhampatil34.BatwaExpenseManager.exception.BatwaException;
import com.shubhampatil34.BatwaExpenseManager.repository.BatwaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BatwaService {
    @Autowired
    private BatwaRepository batwaRepository;
    public Batwa createOrUpdate(Batwa batwa){
        if(batwa.getId() == null){
            batwaRepository.save(batwa);
        }
        else{
            batwaRepository.save(batwa);
        }
        return batwa;
    }

    public boolean delete(Long id){
        Optional<Batwa> batwa = batwaRepository.findById(id);
        if(batwa.isPresent()){
            batwaRepository.delete(batwa.get());
            return true;
        }
        throw new BatwaException("Batwa doesn't exists for id: " + id);
    }
}