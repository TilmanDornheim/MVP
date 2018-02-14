package eventbusevents;

import java.util.ArrayList;
import java.util.List;

import datamodels.Party;

/**
 * Created by tilma on 2018-02-06.
 */

public class PartiesReceivedEvent {

	private boolean error = false;

	private ArrayList<Party> parties = new ArrayList<>();

	public ArrayList<Party> getParties() {
		return parties;
	}

	public void addParty(Party party) {

		parties.add(party);

	}

	public void setListOfParties(List<Party> partyList){

		parties = (ArrayList<Party>) partyList;

	}

	public int getSize() {

		return parties.size();

	}

	public boolean isEmpty() {

		return parties.isEmpty();

	}

	public void clearEvent(){

		parties.clear();

	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}
}
