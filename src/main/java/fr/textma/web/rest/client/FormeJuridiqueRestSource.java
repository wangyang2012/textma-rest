package fr.textma.web.rest.client;

import fr.textma.model.FormeJuridique;
import fr.textma.service.FormeJuridiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/textma")
@CrossOrigin(origins = "*")
public class FormeJuridiqueRestSource {

    @Autowired
    FormeJuridiqueService service;

    @GetMapping(value = "/formeJuridiques")
    public Iterable<FormeJuridique> getAllFormeJuridiques() {
        Iterable<FormeJuridique> formeJuridiques = service.getAll();
        return formeJuridiques;
    }
}
