package eventbusevents;

import java.util.ArrayList;

import datamodels.Party;

/**
 * Created by tilma on 2018-02-06.
 */

public class PartiesReceivedEvent {

	private ArrayList<Party> parties = new ArrayList<>();

	public ArrayList<Party> getParties() {
		return parties;
	}

	public void addParty(Party party) {

		parties.add(party);

	}

	public int getSize() {

		return parties.size();

	}

	public boolean isEmpty() {

		return parties.isEmpty();

	}
}
