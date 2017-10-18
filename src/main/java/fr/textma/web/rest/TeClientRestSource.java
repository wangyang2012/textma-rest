package fr.textma.web.rest;

import fr.textma.model.TeClient;
import fr.textma.model.WebixDatatableResponse;
import fr.textma.service.TeClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
			Pageable pageable = new PageRequest(page, count);
			Page<TeClient> clients = teClientService.findByName("", filter, pageable);
			return new WebixDatatableResponse<TeClient>(clients, start);
		}

	@GetMapping(value = "/teClients/{id}")
	public TeClient getClientById(@PathVariable Integer id) {
		TeClient client = teClientService.findById(id);
		return client;
	}
}
