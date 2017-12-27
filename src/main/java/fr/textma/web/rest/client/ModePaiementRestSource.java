package fr.textma.web.rest.client;

import fr.textma.model.TsModePaiement;
import fr.textma.service.ModePaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/textma")
@CrossOrigin(origins = "*")
public class ModePaiementRestSource {

    @Autowired
    ModePaiementService service;

    @GetMapping(value = "/modePaiements")
    public Iterable<TsModePaiement> getAllModePaiements() {
        Iterable<TsModePaiement> modePaiements = service.findAll();
        return modePaiements;
    }
}
