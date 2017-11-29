package fr.textma.web.rest.client;

import fr.textma.model.TeClient;
import fr.textma.model.WebixDatatableResponse;
import fr.textma.service.TeClientService;
import liquibase.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/textma")
@CrossOrigin(origins = "*")
public class TeClientRestSource {

    @Autowired
    TeClientService teClientService;

    @Autowired
    MessageSource messageSource;


    @GetMapping(value = "/teClients")
    public WebixDatatableResponse<TeClient> listTeClients(@RequestParam(defaultValue = "", required = false) String search, @RequestParam(defaultValue = "20", required = false) Integer count, @RequestParam(defaultValue = "0", required = false) Integer start, @RequestParam(required = false) Map<String, String> filter) {
        Integer page = start / count;

        String nomToFind = filter.get("filter[nom]");
        if (StringUtils.isEmpty(search) && !StringUtils.isEmpty(nomToFind)) {
            search = nomToFind;
        }

        Sort sort = getSortInfo(filter);

        Pageable pageable = new PageRequest(page, count, sort);
        Page<TeClient> clients = teClientService.searchClients(search, pageable);
        return new WebixDatatableResponse<TeClient>(clients, start);
    }

    @GetMapping(value = "/teClients/{id}")
    public TeClient getClientById(@PathVariable Integer id) {
        TeClient client = teClientService.findById(id);
        return client;
    }


    @GetMapping(value = "/teClients/sous-client/{id}")
    public List<TeClient> getSousClientsById(@PathVariable Integer id) {
        return teClientService.getSousClients(id);
    }

    @RequestMapping(value = "/teClients/{id}", method = RequestMethod.POST)
    public @ResponseBody
    String updateClient(@RequestBody TeClient client) {
        teClientService.update(client);
        return "ok";
    }

    private Sort getSortInfo(@RequestParam(required = false) Map<String, String> filter) {
        String bloque = filter.get("sort[bloque]");
        String ferme = filter.get("sort[ferme]");
        String derniereModification = filter.get("sort[derniereModification]");
        String totalFacture = filter.get("sort[totalFacture]");
        String codeClient = filter.get("sort[codeClient]");
        String nom = filter.get("sort[nom]");
        String siret = filter.get("sort[siret]");
        String rcs = filter.get("sort[rcs]");
        String famille = filter.get("sort[famille]");
        String modePaiement = filter.get("sort[modePaiement]");
        String telephone = filter.get("sort[telephone]");
        String adresse = filter.get("sort[adresse]");
        String codePostal = filter.get("sort[codePostal]");
        String ville = filter.get("sort[ville]");

        Sort sort = null;
        if (!StringUtils.isEmpty(bloque)) {
            if ("asc".equals(bloque)) {
                sort = new Sort(Sort.Direction.ASC, "bloque");
            } else {
                sort = new Sort(Sort.Direction.DESC, "bloque");
            }
        } else if (!StringUtils.isEmpty(ferme)) {
            if ("asc".equals(ferme)) {
                sort = new Sort(Sort.Direction.ASC, "ferme");
            } else {
                sort = new Sort(Sort.Direction.DESC, "ferme");
            }
        } else if (!StringUtils.isEmpty(derniereModification)) {
            if ("asc".equals(derniereModification)) {
                sort = new Sort(Sort.Direction.ASC, "derniereModification");
            } else {
                sort = new Sort(Sort.Direction.DESC, "derniereModification");
            }
        } else if (!StringUtils.isEmpty(totalFacture)) {
            if ("asc".equals(codeClient)) {
                sort = new Sort(Sort.Direction.ASC, "totalFacture");
            } else {
                sort = new Sort(Sort.Direction.DESC, "totalFacture");
            }
        } else if (!StringUtils.isEmpty(codeClient)) {
            if ("asc".equals(codeClient)) {
                sort = new Sort(Sort.Direction.ASC, "codeClient");
            } else {
                sort = new Sort(Sort.Direction.DESC, "codeClient");
            }
        } else if (!StringUtils.isEmpty(nom)) {
            if ("asc".equals(nom)) {
                sort = new Sort(Sort.Direction.ASC, "nom");
            } else {
                sort = new Sort(Sort.Direction.DESC, "nom");
            }
        } else if (!StringUtils.isEmpty(siret)) {
            if ("asc".equals(siret)) {
                sort = new Sort(Sort.Direction.ASC, "siret");
            } else {
                sort = new Sort(Sort.Direction.DESC, "siret");
            }
        } else if (!StringUtils.isEmpty(rcs)) {
            if ("asc".equals(rcs)) {
                sort = new Sort(Sort.Direction.ASC, "rcs");
            } else {
                sort = new Sort(Sort.Direction.DESC, "rcs");
            }
        } else if (!StringUtils.isEmpty(famille)) {
            if ("asc".equals(famille)) {
                sort = new Sort(Sort.Direction.ASC, "famille.nom");
            } else {
                sort = new Sort(Sort.Direction.DESC, "famille.nom");
            }
        } else if (!StringUtils.isEmpty(modePaiement)) {
            if ("asc".equals(modePaiement)) {
                sort = new Sort(Sort.Direction.ASC, "modePaiement.type");
            } else {
                sort = new Sort(Sort.Direction.DESC, "modePaiement.type");
            }
        } else if (!StringUtils.isEmpty(telephone)) {
            if ("asc".equals(telephone)) {
                sort = new Sort(Sort.Direction.ASC, "telephone");
            } else {
                sort = new Sort(Sort.Direction.DESC, "telephone");
            }
        } else if (!StringUtils.isEmpty(adresse)) {
            if ("asc".equals(adresse)) {
                sort = new Sort(Sort.Direction.ASC, "adresse");
            } else {
                sort = new Sort(Sort.Direction.DESC, "adresse");
            }
        } else if (!StringUtils.isEmpty(codePostal)) {
            if ("asc".equals(codePostal)) {
                sort = new Sort(Sort.Direction.ASC, "codePostal");
            } else {
                sort = new Sort(Sort.Direction.DESC, "codePostal");
            }
        } else if (!StringUtils.isEmpty(ville)) {
            if ("asc".equals(ville)) {
                sort = new Sort(Sort.Direction.ASC, "ville");
            } else {
                sort = new Sort(Sort.Direction.DESC, "ville");
            }
//        } else {
//            sort = new Sort(Sort.Direction.DESC, "totalFacture");
        }
//        if (filter.sortByTotalFacture) {
//            sort = new Sort(Sort.Direction.DESC, "totalFacture");
//        }
        return sort;
    }
}
