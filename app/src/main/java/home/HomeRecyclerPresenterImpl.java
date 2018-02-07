package home;

import java.util.ArrayList;

import datamodels.Party;

/**
 * Created by tilma on 2018-02-06.
 */

public class HomeRecyclerPresenterImpl implements  HomeRecyclerPresenter {

	private ArrayList<Party> parties;

	public HomeRecyclerPresenterImpl(ArrayList<Party> parties) {

		this.parties = parties;

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
}
