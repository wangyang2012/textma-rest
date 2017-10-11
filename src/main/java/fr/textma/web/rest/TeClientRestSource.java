package fr.textma.web.rest;

import fr.textma.model.TeClient;
import fr.textma.service.TeClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping("/teClientRest")
public class TeClientRestSource {

	@Autowired
    TeClientService teClientService;

	@Autowired
	MessageSource messageSource;


	@GetMapping()
	public List<TeClient> listTeClients(HttpServletResponse res) {
		List<TeClient> clients = teClientService.findByName("");
		return clients;
	}
}
