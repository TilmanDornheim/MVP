package home;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import datamodels.Party;
import eventbusevents.PartiesReceivedEvent;

import static org.mockito.Mockito.*;

/**
 * Created by tilma on 2018-02-07.
 */

@RunWith(MockitoJUnitRunner.class)
public class HomePresenterTest {

	HomePresenterImpl presenter;
	HomeRecyclerPresenter recyclerPresenter;
	PartiesReceivedEvent event;
	int position;

	@Mock
	HomeModel model;

	@Mock
	HomeView view;






	@Before
	public void setUp(){

		presenter = new HomePresenterImpl(view,model);
		recyclerPresenter = new HomeRecyclerPresenterImpl(new ArrayList<Party>(),view);
		event = new PartiesReceivedEvent();
		position = 0;


	}

	@Test
	public void shouldShowProgress(){

		presenter.getParties();

		verify(view).showProgress();

	}

	@Test
	public void shouldInitLoadingData(){

		presenter.getParties();

		verify(model).loadParties();

	}

	@Test
	public void shouldHideProgressOnPartiesReceived(){

		event.addParty(new Party());

		presenter.onPartiesReceived(event);

		verify(view).hideProgress();


	}

	@Test
	public void shouldHideProgressOnNoPartiesReceived(){

		event.clearEvent();

		presenter.onPartiesReceived(event);

		verify(view).hideProgress();


	}

	@Test
	public void shouldAddAdapterOnPartiesReceived(){

		event.addParty(new Party());

		presenter.onPartiesReceived(event);

		verify(view).setAdapter((HomeRecyclerAdapter) any());


	}

	@Test
	public void shouldShowMessageOnNoPartiesReceived(){

		event.clearEvent();

		presenter.onPartiesReceived(event);

		verify(view).showIsEmpty();


	}

	@Test
	public void shouldHandleOnItemClicked(){

		recyclerPresenter.onItemClick(position);

		verify(view).onRecyclerItemClick(position);


	}




}
