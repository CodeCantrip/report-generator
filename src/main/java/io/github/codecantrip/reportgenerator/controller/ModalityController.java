package io.github.codecantrip.reportgenerator.controller;

import java.util.List;
import io.github.codecantrip.reportgenerator.entity.Modality;
import io.github.codecantrip.reportgenerator.service.ModalityService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/modality")

public class ModalityController {
    private final ModalityService modalityService;

    public ModalityController(ModalityService modalityService){
        this.modalityService = modalityService;
    }

    @GetMapping
    public List<Modality> getAllModalities(){
        return modalityService.getAllModalities();
    }

}
