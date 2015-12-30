package superheroApp.superheroApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import superheroApp.superheroApp.entities.Power;
import superheroApp.superheroApp.services.PowerService;
import superheroApp.superheroApp.validation.PowerValidation.PowerException;

@RestController
public class PowerController {

	@Autowired
	PowerService powerService;

	@RequestMapping(value = "/power", method = RequestMethod.GET)
	public List<Power> getAllPowers() {
		return powerService.getAllPowers();
	}

	@RequestMapping(value = "/getSinglePower", method = RequestMethod.GET)
	public Power getSinglePower() {
		return powerService.getSinglePower();
	}
	
	@RequestMapping(value = "/power", method = RequestMethod.POST)
	public void addPower(@RequestBody Power power) throws Exception {
		try {
			powerService.addPower(power);
		} catch (PowerException e) {
			throw new Exception(e.getMessage());
		}
	}

	@RequestMapping(value = "/power", method = RequestMethod.PUT)
	public void updatePower(/* @PathVariable Integer id, */ @RequestBody Power power) {
		// power.setPowersId(id);
		powerService.updatePower(power);
	}
}
