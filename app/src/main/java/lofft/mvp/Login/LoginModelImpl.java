package lofft.mvp.Login;


import android.os.Handler;

/**
 * Created by tilma on 2018-01-24.
 */

public class LoginModelImpl implements LoginModel {


	@Override
	public void login(final String username, final String password, final OnLoginFinishedListener listener) {


		//Mock Login using Handler to delay the answer
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {

				if (UsernameAndPasswordFilledOut(username, password)) {

					listener.onLoginSuccess();

				} else {

					listener.onLoginFailure();

				}

			}
		}, 2000);




	}

	private boolean UsernameAndPasswordFilledOut(String username, String password) {

		return !(username.length() == 0 || password.length() == 0);

	}
}
