package app.country;

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
public class CountryController {

	@Autowired	
	private CountryService countryService;
		
	@RequestMapping(method = RequestMethod.GET, path = "/countries")
	public ArrayList<Country> getAllCountries(){
		return countryService.getAllCountries();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/countries/{id}")
	public Country getCountry(@PathVariable(name = "id") String id) {
	
		return countryService.getCountry(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/countries")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addCountry(@RequestBody Country country) {
		countryService.addCountry(country);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/countries/{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void updateCountry(@RequestBody Country country, @PathVariable(name = "id") String id) {
		countryService.updateCountry(country, id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/countries/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteCountry(@PathVariable(name = "id") String id) {
		countryService.deleteCountry(id);
	}
}
