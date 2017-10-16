package fr.textma.web.rest;

import fr.textma.model.TeFacture;
import fr.textma.model.WebixDatatableResponse;
import fr.textma.service.TeFactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/textma")
@CrossOrigin(origins = "*")
public class TeFactureRestSource {

	@Autowired
	TeFactureService teFactureService;

	@Autowired
	MessageSource messageSource;


	@GetMapping(value = "/teFactures/{clientId}")
	public WebixDatatableResponse<TeFacture> listTeFacturesOfClients(@PathVariable Integer clientId, @RequestParam(defaultValue = "20", required = false) Integer count, @RequestParam(defaultValue = "0", required = false) Integer start) {
		Integer page = start / count;
		Pageable pageable = new PageRequest(page, count);
		Page<TeFacture> factures = teFactureService.findByClientId(clientId, pageable);
		return new WebixDatatableResponse<TeFacture>(factures, start);
	}

//	@GetMapping(value = "/teClients/{id}")
//	public TeClient getClientById(@PathVariable Integer id) {
//		TeClient client = teClientService.findById(id);
//		return client;
//	}
}
