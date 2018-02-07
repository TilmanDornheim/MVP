package home;

import android.os.Handler;

import org.greenrobot.eventbus.EventBus;

import datamodels.Party;
import eventbusevents.PartiesReceivedEvent;

/**
 * Created by tilma on 2018-01-25.
 */

public class HomeModelImpl implements HomeModel {


	@Override
	public void loadParties() {

		final PartiesReceivedEvent event = new PartiesReceivedEvent();

		Party Dummy1 = new Party("Test #1","http://rossmillfarm.com/rossmill3/wp-content/uploads/2017/03/Testing.jpg");
		Party Dummy2 = new Party("Test #2","http://rossmillfarm.com/rossmill3/wp-content/uploads/2017/03/Testing.jpg");
		Party Dummy3 = new Party("Test #3","http://rossmillfarm.com/rossmill3/wp-content/uploads/2017/03/Testing.jpg");

		event.addParty(Dummy1);
		event.addParty(Dummy2);
		event.addParty(Dummy3);

		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {

				EventBus.getDefault().post(event);

			}
		},2000);
	}
}
