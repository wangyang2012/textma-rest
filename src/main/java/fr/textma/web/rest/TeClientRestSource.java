package fr.textma.web.rest;

import fr.textma.model.TeClient;
import fr.textma.model.WebixDatatableResponse;
import fr.textma.model.WebixSort;
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
		public WebixDatatableResponse<TeClient> listTeClients(@RequestParam(defaultValue = "20", required = false) Integer count, @RequestParam(defaultValue = "0", required = false) Integer start, @RequestParam(required = false) Map<String, String> filter) {
			Integer page = start / count;

			String sortId = filter.get("sort[id]");
			String sortName = filter.get("sort[name]");
			Sort sort = null;
			if (!StringUtils.isEmpty(sortId)) {
				if ("asc".equals(sortId)) {
					sort = new Sort(Sort.Direction.ASC, "id");
				} else {
					sort = new Sort(Sort.Direction.DESC, "id");
				}
			} else if (!StringUtils.isEmpty(sortName)) {
				if ("asc".equals(sortName)) {
					sort = new Sort(Sort.Direction.ASC, "name");
				} else {
					sort = new Sort(Sort.Direction.DESC, "name");
				}
			}

			Pageable pageable = new PageRequest(page, count, sort);
			Page<TeClient> clients = teClientService.getClientWithFilters(filter, pageable);
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
