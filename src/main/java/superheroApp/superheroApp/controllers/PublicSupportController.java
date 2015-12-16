package superheroApp.superheroApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import superheroApp.superheroApp.entities.PublicSupport;
import superheroApp.superheroApp.services.PublicSupportService;

@RestController
public class PublicSupportController {
	@Autowired
	PublicSupportService publicSupportService;

	@RequestMapping(value = "/publicSupport", method = RequestMethod.GET)
	public List<PublicSupport> getAllPublicSupoort() {
		return publicSupportService.getAllPublicSupport();
	}

	@RequestMapping(value = "/publicSupport", method = RequestMethod.POST)
	public void addPublicSupport(@RequestBody PublicSupport publicSupport) {
		publicSupportService.addPublicSupport(publicSupport);
	}
}
