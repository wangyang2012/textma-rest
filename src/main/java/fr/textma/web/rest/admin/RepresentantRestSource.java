package fr.textma.web.rest.admin;

import fr.textma.model.Representant;
import fr.textma.model.TsModePaiement;
import fr.textma.service.ModePaiementService;
import fr.textma.service.RepresentantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/textma")
@CrossOrigin(origins = "*")
public class RepresentantRestSource {

    @Autowired
    RepresentantService service;

    @GetMapping(value = "/representants")
    public Iterable<Representant> getAllRepresentants() {
        Iterable<Representant> representants = service.findAll();
        return representants;
    }
}
