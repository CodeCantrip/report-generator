package io.github.codecantrip.reportgenerator.service;


import io.github.codecantrip.reportgenerator.entity.Modality;
import io.github.codecantrip.reportgenerator.repository.ModalityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModalityService {
    private final ModalityRepository modalityRepository;

    public ModalityService(ModalityRepository modalityRepository){
        this.modalityRepository = modalityRepository;
    }
    public List<Modality> getAllModalities(){
        return modalityRepository.findAll();
    }

}
