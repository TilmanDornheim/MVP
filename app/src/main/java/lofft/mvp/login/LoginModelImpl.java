package lofft.mvp.login;


import android.os.Handler;

import org.greenrobot.eventbus.EventBus;

import eventbusevents.LoginEvent;

/**
 * Created by tilma on 2018-01-24.
 */

public class LoginModelImpl implements LoginModel {


	@Override
	public void login(final String username, final String password) {

		final LoginEvent event = new LoginEvent();

		//Mock Login using Handler to delay the answer
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {

				if (UsernameAndPasswordFilledOut(username, password)) {

					event.setSuccess(true);


				} else {

					event.setSuccess(false);

				}

				EventBus.getDefault().post(event);

			}
		}, 2000);


	}

	private boolean UsernameAndPasswordFilledOut(String username, String password) {

		return !(username.length() == 0 || password.length() == 0);

	}
}
