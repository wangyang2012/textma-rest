package fr.textma.web.rest;

import fr.textma.model.TeClient;
import fr.textma.service.TeClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/textma")
@CrossOrigin(origins = "*")
public class TeClientRestSource {

	@Autowired
    TeClientService teClientService;

	@Autowired
	MessageSource messageSource;


	@GetMapping(value = "/teClients")
	public List<TeClient> listTeClients(@RequestParam(defaultValue = "20", required = false) Integer count, @RequestParam(defaultValue = "0", required = false) Integer start) {
		Integer page = start / count;
		Pageable pageable = new PageRequest(page, count);
		Page<TeClient> clients = teClientService.findByName("", pageable);
		return clients.getContent();
	}
}
