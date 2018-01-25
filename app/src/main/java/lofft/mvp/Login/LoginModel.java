package lofft.mvp.Login;

/**
 * Created by tilma on 2018-01-24.
 */

public interface LoginModel {

	interface OnLoginFinishedListener{


		void onLoginSuccess();

		void onLoginFailure();

	}


	void login(String username, String password, OnLoginFinishedListener listener);



}
