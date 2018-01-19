package fr.textma.web.rest.client;

import fr.textma.model.TeContact;
import fr.textma.model.TeFamilleClient;
import fr.textma.model.WebixDatatableResponse;
import fr.textma.service.TeContactService;
import fr.textma.service.TeFamilleClientService;
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
public class TeFamilleClientRestSource {

    @Autowired
    TeFamilleClientService service;

    @GetMapping(value = "/teFamilleClients")
    public WebixDatatableResponse<TeFamilleClient> listTeFamilleClients(@RequestParam(defaultValue = "", required = false) String search, @RequestParam(defaultValue = "20", required = false) Integer count, @RequestParam(defaultValue = "0", required = false) Integer start, @RequestParam(required = false) Map<String, String> filter) {
        Integer page = start / count;
        Sort sort = getSortInfo(filter);
        Pageable pageable = new PageRequest(page, count, sort);
        Page<TeFamilleClient> familleClients = service.findByNomLike(search, pageable);
        return new WebixDatatableResponse<TeFamilleClient>(familleClients, start);
    }


    @GetMapping(value = "/teFamilleClients/{id}")
    public TeFamilleClient getById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PutMapping(value = "/teFamilleClients")
    public String save(@RequestBody TeFamilleClient familleClient) {
        service.save(familleClient);
        return "ok";
    }


    @DeleteMapping(value = "/teFamilleClients/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "ok";
    }

    private Sort getSortInfo(@RequestParam(required = false) Map<String, String> filter) {

        String id = filter.get("sort[id]");
        String nom = filter.get("sort[nom]");

        Sort sort = null;
        if (!StringUtils.isEmpty(id)) {
            if ("asc".equals(id)) {
                sort = new Sort(Sort.Direction.ASC, "id");
            } else {
                sort = new Sort(Sort.Direction.DESC, "id");
            }
        } else if (!StringUtils.isEmpty(nom)) {
            if ("asc".equals(nom)) {
                sort = new Sort(Sort.Direction.ASC, "nom");
            } else {
                sort = new Sort(Sort.Direction.DESC, "nom");
            }
        } else {
            sort = new Sort(Sort.Direction.ASC, "id");
        }
        return sort;
    }
}
