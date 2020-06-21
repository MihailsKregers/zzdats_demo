package com.mk.zzdats_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BernsService {

    @Autowired
    private BernsRepository bernsRepository;

    public void save(Berns berns) {
        bernsRepository.save(berns);
    }

    public void delete(Berns berns) {
        bernsRepository.delete(berns);
    }
}
