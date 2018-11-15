package app.state;

import java.util.ArrayList;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StateController {

	@Autowired	
	private StateService stateService;
		
	@RequestMapping(method = RequestMethod.GET, path = "/countries/{id}/states")
	public ArrayList<State> getAllStates(@PathVariable(name = "id") String id){
		return stateService.getAllStates();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/countries/{id}/states/{stateId}")
	public State getCountry(@PathVariable(name = "stateId") String id) {
	
		return stateService.getState(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/countries")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addCountry(@RequestBody State country) {
		stateService.addState(country);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/countries/{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void updateCountry(@RequestBody State country, @PathVariable(name = "id") String id) {
		stateService.updateState(country, id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/countries/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteCountry(@PathVariable(name = "id") String id) {
		stateService.deleteState(id);
	}
}
