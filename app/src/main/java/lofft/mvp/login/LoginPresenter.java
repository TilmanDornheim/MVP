package lofft.mvp.login;

/**
 * Created by tilma on 2018-01-24.
 */

public interface LoginPresenter {

	void validateCredentials(String username, String password);

	void onDestroy();

	void onStart();

	void onStop();


}
