package fr.textma.web.rest.client;

import fr.textma.model.TeFonctionContact;
import fr.textma.service.TeFonctionContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/textma")
@CrossOrigin(origins = "*")
public class TeFonctionContactRestSource {

    @Autowired
    private TeFonctionContactService service;

    @GetMapping(value = "/teFonctionContacts")
    public Iterable<TeFonctionContact> getAll() {
        return service.findAll();
    }

}
