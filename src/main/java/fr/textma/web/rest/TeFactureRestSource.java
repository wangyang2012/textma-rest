package fr.textma.web.rest;

import fr.textma.model.TeFacture;
import fr.textma.model.WebixDatatableResponse;
import fr.textma.service.TeFactureService;
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
public class TeFactureRestSource {

	@Autowired
	TeFactureService teFactureService;

	@Autowired
	MessageSource messageSource;


	@GetMapping(value = "/teFactures/{clientId}")
	public WebixDatatableResponse<TeFacture> listTeFacturesOfClien(@PathVariable Integer clientId, @RequestParam(defaultValue = "20", required = false) Integer count, @RequestParam(defaultValue = "0", required = false) Integer start, @RequestParam(required = false) Map<String, String> filter) {
		Integer page = start / count;
		Sort sort = getSortInfo(filter);
		Pageable pageable = new PageRequest(page, count, sort);
		Page<TeFacture> factures = teFactureService.findByClientId(clientId, pageable);
		return new WebixDatatableResponse<TeFacture>(factures, start);
	}

	private Sort getSortInfo(@RequestParam(required = false) Map<String, String> filter) {

		String numeroFacture = filter.get("sort[numeroFacture]");
		String reference = filter.get("sort[reference]");
		String raisonSociale = filter.get("sort[raisonSociale]");
		String dateCreation = filter.get("sort[dateCreation]");
		String totalHt = filter.get("sort[totalHt]");
		String totalTva = filter.get("sort[totalTva]");
		String totalTtc = filter.get("sort[totalTtc]");
		String adresse = filter.get("sort[adresse]");

		Sort sort = null;
		if (!StringUtils.isEmpty(numeroFacture)) {
			if ("asc".equals(numeroFacture)) {
				sort = new Sort(Sort.Direction.ASC, "numeroFacture");
			} else {
				sort = new Sort(Sort.Direction.DESC, "numeroFacture");
			}
		} else if (!StringUtils.isEmpty(reference)) {
			if ("asc".equals(reference)) {
				sort = new Sort(Sort.Direction.ASC, "reference");
			} else {
				sort = new Sort(Sort.Direction.DESC, "reference");
			}
		} else if (!StringUtils.isEmpty(raisonSociale)) {
			if ("asc".equals(raisonSociale)) {
				sort = new Sort(Sort.Direction.ASC, "raisonSociale");
			} else {
				sort = new Sort(Sort.Direction.DESC, "raisonSociale");
			}
		} else if (!StringUtils.isEmpty(dateCreation)) {
			if ("asc".equals(dateCreation)) {
				sort = new Sort(Sort.Direction.ASC, "dateCreation");
			} else {
				sort = new Sort(Sort.Direction.DESC, "dateCreation");
			}
		} else if (!StringUtils.isEmpty(totalHt)) {
			if ("asc".equals(totalHt)) {
				sort = new Sort(Sort.Direction.ASC, "totalHt");
			} else {
				sort = new Sort(Sort.Direction.DESC, "totalHt");
			}
		} else if (!StringUtils.isEmpty(totalTva)) {
			if ("asc".equals(totalTva)) {
				sort = new Sort(Sort.Direction.ASC, "totalTva");
			} else {
				sort = new Sort(Sort.Direction.DESC, "totalTva");
			}
		} else if (!StringUtils.isEmpty(totalTtc)) {
			if ("asc".equals(totalTtc)) {
				sort = new Sort(Sort.Direction.ASC, "totalTtc");
			} else {
				sort = new Sort(Sort.Direction.DESC, "totalTtc");
			}
		} else if (!StringUtils.isEmpty(adresse)) {
			if ("asc".equals(adresse)) {
				sort = new Sort(Sort.Direction.ASC, "adresse");
			} else {
				sort = new Sort(Sort.Direction.DESC, "adresse");
			}
		} else {
			sort = new Sort(Sort.Direction.DESC, "dateCreation");
		}
		return sort;
	}
}
