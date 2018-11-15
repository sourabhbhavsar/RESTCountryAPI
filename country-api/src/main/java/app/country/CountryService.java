package app.country;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class CountryService {

	private ArrayList<Country> countries;
	
	public CountryService() {
		countries = new ArrayList<Country>();
		countries.add(new Country("1", "India"));
		countries.add(new Country("2", "Canada"));
		countries.add(new Country("3", "Australia"));
		countries.add(new Country("4", "England"));
		countries.add(new Country("5", "New Zealand"));
		countries.add(new Country("6", "Ireland"));
	}
	
	public ArrayList<Country> getAllCountries(){
		return countries;
	}
	
	public Country getCountry(String id) {
		return countries.stream().filter(c->c.getId().equals(id)).findFirst().get();
	}
	
	public void addCountry(Country country) {
		countries.add(country);
	}

	public void updateCountry(Country country, String id) {
		
		for (int i = 0; i < countries.size(); i++) {
			if (countries.get(i).getId().equals(id)) {
				countries.set(i, country);
			}
		}
	}

	public void deleteCountry(String id) {
		for (int i = 0; i < countries.size(); i++) {
			if (countries.get(i).getId().equals(id)) {
				countries.remove(i);
			}
		}
	}
}
