package home;

import android.os.Handler;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import datamodels.Party;
import eventbusevents.PartiesReceivedEvent;
import retrofit.MockarooApiService;
import retrofit.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import util.Constants;

/**
 * Created by tilma on 2018-01-25.
 */

public class HomeModelImpl implements HomeModel {


	@Override
	public void loadParties() {

		final PartiesReceivedEvent event = new PartiesReceivedEvent();

		// Create Service
		MockarooApiService service = ServiceGenerator.createService(MockarooApiService.class);

		// Create Call

		Call<List<Party>> call = service.getUsers(Constants.MOCKAROO_API_KEY);

		// Queue call

		call.enqueue(new Callback<List<Party>>() {
			@Override
			public void onResponse(Call<List<Party>> call, Response<List<Party>> response) {

				List<Party> parties = response.body();

				event.setListOfParties(parties);

				EventBus.getDefault().post(event);

				// Logging

				Log.d("Network Req","Recevied response: " + response.message());

			}

			@Override
			public void onFailure(Call<List<Party>> call, Throwable t) {

				event.clearEvent();

				event.setError(true);

				EventBus.getDefault().post(event);

				//Logging

				Log.d("Network Req", "Received Error: " + t);
			}
		});


	}
}
