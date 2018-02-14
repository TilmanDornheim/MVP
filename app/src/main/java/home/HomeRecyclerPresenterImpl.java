package home;

import java.util.ArrayList;

import datamodels.Party;
import util.Constants;

/**
 * Created by tilma on 2018-02-06.
 */

public class HomeRecyclerPresenterImpl implements HomeRecyclerPresenter {

	private ArrayList<Party> parties;

	private HomeView view;

	public HomeRecyclerPresenterImpl(ArrayList<Party> parties, HomeView view) {

		this.parties = parties;
		this.view = view;

	}


	@Override
	public void bindRowViewAtPosition(int position, HomeHolderView holder) {

		Party party = parties.get(position);
		holder.setTitle(Integer.toString(party.getHost_id()));
		holder.setPicture(Constants.DUMMY_PIC_URL);


	}

	@Override
	public int getItemCount() {
		return parties.size();
	}

	@Override
	public void onItemClick(int position) {

		view.onRecyclerItemClick(position);

	}
}
