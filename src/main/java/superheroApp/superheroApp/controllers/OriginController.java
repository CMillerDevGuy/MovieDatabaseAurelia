package superheroApp.superheroApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import superheroApp.superheroApp.entities.Origin;
import superheroApp.superheroApp.services.OriginService;

@RestController
public class OriginController{
	@Autowired
	OriginService originService;
	
	@RequestMapping(value = "/origin", method=RequestMethod.GET)
	public List<Origin> getAllOrigin(){
		return originService.getAllOrigin();
	}
	
	@RequestMapping(value = "/origin", method=RequestMethod.POST)
	public void addOrigin(@RequestBody Origin origin){
		originService.addOrigin(origin);
	}
}
