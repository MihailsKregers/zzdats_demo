package com.mk.zzdats_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class BernudarzsService {

    @Autowired
    private BernudarzsRepository bernudarzsRepository;

    public List<Bernudarzs> list() {
        return bernudarzsRepository.findAll();
    }

    public List<Berns> getQueue(Long id) {
        List<Berns> queue = bernudarzsRepository.findById(id).get().getRinda();

        Collections.sort(queue, Comparator.comparing(Berns::getDate));
        Collections.sort(queue, (i, j) -> { return (j.getBrOrSist()?1:0) - (i.getBrOrSist()?1:0); });

        return queue;
    }

    public Bernudarzs getById(Long id) {
        return bernudarzsRepository.findById(id).get();
    }

    public Berns findByPk(String persCode, Long id) {
        for (Berns berns : bernudarzsRepository.findById(id).get().getRinda()) {
            if (berns.getPersCode().contentEquals(persCode)) {
                return berns;
            }
        }
        return null;
    }
}