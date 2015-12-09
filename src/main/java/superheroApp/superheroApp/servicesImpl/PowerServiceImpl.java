package superheroApp.superheroApp.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import superheroApp.superheroApp.daos.PowerDao;
import superheroApp.superheroApp.daos.PowerTypeDao;
import superheroApp.superheroApp.entities.Power;
import superheroApp.superheroApp.entities.PowerType;
import superheroApp.superheroApp.services.PowerService;

@Service
public class PowerServiceImpl implements PowerService {
	@Autowired
	PowerDao powerDao;
	
	@Autowired
	PowerTypeDao powerTypeDao;

	public class PowerException extends Exception{

		private static final long serialVersionUID = -5172459068095913338L;

		public PowerException(String message) {
			super(message);
		}
		
	}
	
	public List<Power> getAllPowers() {
		return powerDao.getAllPowers();
	}

	
	public boolean addPower(Power power) throws PowerException {
			boolean result = false;
			if(validatePower(power) == true){
				result = true;
				powerDao.addPower(power);	
			}
			return result;
	}

	public void updatePower(Power power) {
		powerDao.updatePower(power);
		
	}
	
	public boolean validatePower(Power power) throws PowerException{
			boolean result = false;
			if(validatePowerName(power) && validatePowerDescription(power) && validatePowerType(power)){
				result = true;
			}
			return result;
	}
	
	public boolean validatePowerName(Power power) throws PowerException {
		boolean result = true;
		try{
			String powerName = power.getPowerName();
			if(powerName.equals("")){
				result = false;
				throw new PowerException("Power name is empty");
			}
		}catch(NullPointerException e){
			throw new PowerException("Power name is null");
		}
		return result;
	}
	
	public boolean validatePowerDescription(Power power) throws PowerException{
		boolean result = true;
		try{
			String description = power.getPowerDescription();
			if(description.equals("")){
				result = false;
				throw new PowerException("Power description is empty");
			}
		}catch(NullPointerException e){
			throw new PowerException("Power description is null");
		}
		return result;
	}
	
	public boolean validatePowerType(Power power) throws PowerException{
		boolean result = true;
		try{
			PowerType type = power.getPowerType();
			String typeName = type.getPowerType();
			if(typeName.equals("")){
				result = false;
				throw new PowerException("Power type is empty");
			}
			List<PowerType> powerType = powerTypeDao.getAllPowerType();
			for(PowerType p : powerType){
				String existingType = p.getPowerType();
				if(typeName.equals(existingType)){
					power.setPowerType(p);
				}
			}
		}catch(NullPointerException e){
			throw new PowerException("Null power");
		}
		return result;
	}
}
