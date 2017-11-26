package fr.textma.web.rest.client;

import fr.textma.model.TeAdresse;
import fr.textma.model.TeContact;
import fr.textma.model.WebixDatatableResponse;
import fr.textma.service.TeAdresseService;
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
public class TeAdresseRestSource {

    @Autowired
    TeAdresseService service;

    @GetMapping(value = "/teAdresses/{clientId}")
    public WebixDatatableResponse<TeAdresse> listTeAdresses(@PathVariable Integer clientId, @RequestParam(defaultValue = "20", required = false) Integer count, @RequestParam(defaultValue = "0", required = false) Integer start, @RequestParam(required = false) Map<String, String> filter) {
        Integer page = start / count;
        Sort sort = getSortInfo(filter);
        Pageable pageable = new PageRequest(page, count, sort);
        Page<TeAdresse> contacts = service.findByClientId(clientId, pageable);
        return new WebixDatatableResponse<TeAdresse>(contacts, start);
    }

    private Sort getSortInfo(@RequestParam(required = false) Map<String, String> filter) {

        String nomSociete = filter.get("sort[nomSociete]");
        String adresse = filter.get("sort[adresse]");
        String codePostal = filter.get("sort[codePostal]");
        String telephone = filter.get("sort[telephone]");
        String fax = filter.get("sort[fax]");
        String email = filter.get("sort[email]");
        String ville = filter.get("sort[ville]");
        String observations = filter.get("sort[observations]");

        Sort sort = null;
        if (!StringUtils.isEmpty(nomSociete)) {
            if ("asc".equals(nomSociete)) {
                sort = new Sort(Sort.Direction.ASC, "nomSociete");
            } else {
                sort = new Sort(Sort.Direction.DESC, "nomSociete");
            }
        } else if (!StringUtils.isEmpty(adresse)) {
            if ("asc".equals(adresse)) {
                sort = new Sort(Sort.Direction.ASC, "adresse");
            } else {
                sort = new Sort(Sort.Direction.DESC, "adresse");
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
        } else if (!StringUtils.isEmpty(email)) {
            if ("asc".equals(email)) {
                sort = new Sort(Sort.Direction.ASC, "email");
            } else {
                sort = new Sort(Sort.Direction.DESC, "email");
            }
        } else if (!StringUtils.isEmpty(ville)) {
            if ("asc".equals(ville)) {
                sort = new Sort(Sort.Direction.ASC, "ville");
            } else {
                sort = new Sort(Sort.Direction.DESC, "ville");
            }
        } else if (!StringUtils.isEmpty(observations)) {
            if ("asc".equals(observations)) {
                sort = new Sort(Sort.Direction.ASC, "observations");
            } else {
                sort = new Sort(Sort.Direction.DESC, "observations");
            }
        } else {
            sort = new Sort(Sort.Direction.ASC, "nomSociete");
        }
        return sort;
    }
}
