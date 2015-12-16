package superheroApp.superheroApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import superheroApp.superheroApp.entities.PowerType;
import superheroApp.superheroApp.services.PowerTypeService;

@RestController
public class PowerTypeController {
	@Autowired
	PowerTypeService powerTypeService;

	@RequestMapping(value = "/powerType", method = RequestMethod.GET)
	public List<PowerType> getAllPowerType() {
		return powerTypeService.getAllPowerType();
	}

	@RequestMapping(value = "/powerType", method = RequestMethod.POST)
	public void addPowerType(@RequestBody PowerType powerType) {
		powerTypeService.addPowerType(powerType);
	}
}
