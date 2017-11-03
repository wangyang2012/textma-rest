package fr.textma.web.rest;

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

			String sortCode = filter.get("sort[code]");
			String sortNom = filter.get("sort[nom]");
			Sort sort = null;
			if (!StringUtils.isEmpty(sortCode)) {
				if ("asc".equals(sortCode)) {
					sort = new Sort(Sort.Direction.ASC, "code");
				} else {
					sort = new Sort(Sort.Direction.DESC, "code");
				}
			} else if (!StringUtils.isEmpty(sortNom)) {
				if ("asc".equals(sortNom)) {
					sort = new Sort(Sort.Direction.ASC, "nom");
				} else {
					sort = new Sort(Sort.Direction.DESC, "nom");
				}
			}

			Pageable pageable = new PageRequest(page, count, sort);
			Page<TeClient> clients = teClientService.searchClients(search, pageable);
			return new WebixDatatableResponse<TeClient>(clients, start);
		}

	@GetMapping(value = "/teClients/{id}")
	public TeClient getClientById(@PathVariable Integer id) {
		TeClient client = teClientService.findById(id);
		return client;
	}

	@RequestMapping(value = "/teClients/{id}", method = RequestMethod.POST)
	public @ResponseBody String updateClient(@RequestBody TeClient client){
			teClientService.update(client);
		return "ok";
	}

	@RequestMapping(value = "/teClients", method = RequestMethod.POST)
	public @ResponseBody String updateClientWithoutId(@RequestBody TeClient client){
		teClientService.update(client);
		return "ok";
	}
}
