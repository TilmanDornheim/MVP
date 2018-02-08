package home;

import java.util.ArrayList;

import datamodels.Party;

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
		holder.setTitle(party.getTitle());
		holder.setPicture(party.getUrl());


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
