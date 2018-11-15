package app.state;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateService {

	private ArrayList<State> states;
	
	@Autowired
	private StateRepository countryRepo;
	
	public StateService() {
		states = new ArrayList<State>();
		states.add(new State("1", "Madhya Prades"));
		states.add(new State("2", "Gujarat"));
		states.add(new State("3", "Rajasthan"));
		states.add(new State("4", "Maharashtra"));
		states.add(new State("5", "Delhi"));
		states.add(new State("6", "Himachal Pradesh"));
		
		
	}
	
	
	
	public ArrayList<State> getAllStates(){

		ArrayList<State> list = new ArrayList<State>();

		//countryRepo.findAll().forEach(list::add);
		return states;
	}
	
	public State getState(String id) {
		return states.stream().filter(c->c.getId().equals(id)).findFirst().get();
	}
	
	public void addState(State s) {
		states.add(s);
		//countryRepo.save(country);
	}

	public void updateState(State s, String id) {
		
		for (int i = 0; i < states.size(); i++) {
			if (states.get(i).getId().equals(id)) {
				states.set(i, s);
			}
		}
	}

	public void deleteState(String id) {
		for (int i = 0; i < states.size(); i++) {
			if (states.get(i).getId().equals(id)) {
				states.remove(i);
			}
		}
	}
}
