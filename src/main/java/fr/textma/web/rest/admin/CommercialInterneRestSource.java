package fr.textma.web.rest.admin;

import fr.textma.model.CommercialInterne;
import fr.textma.service.CommercialInterneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/textma")
@CrossOrigin(origins = "*")
public class CommercialInterneRestSource {

    @Autowired
    CommercialInterneService service;

    @GetMapping(value = "/commercial_internes")
    public Iterable<CommercialInterne> getAllCommercialInternes() {
        Iterable<CommercialInterne> CommercialInternes = service.findAll();
        return CommercialInternes;
    }
}
