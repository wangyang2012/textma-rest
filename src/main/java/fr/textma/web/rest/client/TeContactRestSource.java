package fr.textma.web.rest.client;

import fr.textma.model.TeClient;
import fr.textma.model.TeContact;
import fr.textma.model.WebixDatatableResponse;
import fr.textma.service.TeContactService;
import liquibase.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/textma")
@CrossOrigin(origins = "*")
public class TeContactRestSource {

    @Autowired
    TeContactService service;

    @GetMapping(value = "/teContacts")
    public WebixDatatableResponse<TeContact> search(@RequestParam(defaultValue = "") String search, @RequestParam(defaultValue = "20", required = false) Integer count, @RequestParam(defaultValue = "0", required = false) Integer start, @RequestParam(required = false) Map<String, String> filter) {
        Integer page = start / count;
        Sort sort = getSortInfo(filter);
        Pageable pageable = new PageRequest(page, count, sort);
        Page<TeContact> contacts = service.findAll(pageable);
        return new WebixDatatableResponse<TeContact>(contacts, start);
    }

    @GetMapping(value = "/teContacts/{clientId}")
    public WebixDatatableResponse<TeContact> listTeContactsByClient(@PathVariable Integer clientId, @RequestParam(defaultValue = "20", required = false) Integer count, @RequestParam(defaultValue = "0", required = false) Integer start, @RequestParam(required = false) Map<String, String> filter) {
        Integer page = start / count;
        Sort sort = getSortInfo(filter);
        Pageable pageable = new PageRequest(page, count, sort);
        Page<TeContact> contacts = service.findByClientId(clientId, pageable);
        return new WebixDatatableResponse<TeContact>(contacts, start);
    }

    private Sort getSortInfo(@RequestParam(required = false) Map<String, String> filter) {

        String civilite = filter.get("sort[civilite]");
        String nom = filter.get("sort[nom]");
        String prenom = filter.get("sort[prenom]");
        String fonction = filter.get("sort[fonction]");
        String email = filter.get("sort[email]");
        String portable = filter.get("sort[portable]");
        String telephone = filter.get("sort[telephone]");
        String fax = filter.get("sort[fax]");
        String facturation = filter.get("sort[facturation]");
        String logistique = filter.get("sort[logistique]");
        String commercial = filter.get("sort[commercial]");

        Sort sort = null;
        if (!StringUtils.isEmpty(civilite)) {
            if ("asc".equals(civilite)) {
                sort = new Sort(Sort.Direction.ASC, "civilite");
            } else {
                sort = new Sort(Sort.Direction.DESC, "civilite");
            }
        } else if (!StringUtils.isEmpty(nom)) {
            if ("asc".equals(nom)) {
                sort = new Sort(Sort.Direction.ASC, "nom");
            } else {
                sort = new Sort(Sort.Direction.DESC, "nom");
            }
        } else if (!StringUtils.isEmpty(prenom)) {
            if ("asc".equals(prenom)) {
                sort = new Sort(Sort.Direction.ASC, "prenom");
            } else {
                sort = new Sort(Sort.Direction.DESC, "prenom");
            }
        } else if (!StringUtils.isEmpty(fonction)) {
            if ("asc".equals(fonction)) {
                sort = new Sort(Sort.Direction.ASC, "fonction.nom");
            } else {
                sort = new Sort(Sort.Direction.DESC, "fonction.nom");
            }
        } else if (!StringUtils.isEmpty(email)) {
            if ("asc".equals(email)) {
                sort = new Sort(Sort.Direction.ASC, "email");
            } else {
                sort = new Sort(Sort.Direction.DESC, "email");
            }
        } else if (!StringUtils.isEmpty(portable)) {
            if ("asc".equals(portable)) {
                sort = new Sort(Sort.Direction.ASC, "portable");
            } else {
                sort = new Sort(Sort.Direction.DESC, "portable");
            }
        } else if (!StringUtils.isEmpty(telephone)) {
            if ("asc".equals(telephone)) {
                sort = new Sort(Sort.Direction.ASC, "telephone");
            } else {
                sort = new Sort(Sort.Direction.DESC, "telephone");
            }
        } else if (!StringUtils.isEmpty(fax)) {
            if ("asc".equals(fax)) {
                sort = new Sort(Sort.Direction.ASC, "fax");
            } else {
                sort = new Sort(Sort.Direction.DESC, "fax");
            }
        } else if (!StringUtils.isEmpty(facturation)) {
            if ("asc".equals(facturation)) {
                sort = new Sort(Sort.Direction.ASC, "facturation");
            } else {
                sort = new Sort(Sort.Direction.DESC, "facturation");
            }
        } else if (!StringUtils.isEmpty(logistique)) {
            if ("asc".equals(logistique)) {
                sort = new Sort(Sort.Direction.ASC, "logistique");
            } else {
                sort = new Sort(Sort.Direction.DESC, "logistique");
            }
        } else {
            sort = new Sort(Sort.Direction.ASC, "nom");
        }
        return sort;
    }
}
