package home;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import eventbusevents.PartiesReceivedEvent;

/**
 * Created by tilma on 2018-01-25.
 */

public class HomePresenterImpl implements HomePresenter {

	private HomeView view;
	private HomeModel model;
	private HomeRecyclerPresenterImpl presenter;

	public HomePresenterImpl(HomeView view, HomeModel model) {
		this.view = view;
		this.model = model;
	}

	@Override
	public void onStart() {

		EventBus.getDefault().register(this);

	}

	@Override
	public void onStop() {

		EventBus.getDefault().unregister(this);

	}

	@Override
	public void onDestroy() {

		view = null;

	}

	@Override
	public void getParties() {

		if (view != null) {

			view.showProgress();

		}

		model.loadParties();

	}

	@Subscribe
	void onPartiesRecevied(PartiesReceivedEvent event) {

		if (view != null) {

			view.hideProgress();

		}

		if (event.isEmpty()) {

			view.showIsEmpty();

		} else {

			presenter = new HomeRecyclerPresenterImpl(event.getParties());

			HomeRecyclerAdapter adapter = new HomeRecyclerAdapter(presenter);

			view.setAdapter(adapter);

		}


	}
}
