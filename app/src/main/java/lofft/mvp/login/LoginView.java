package lofft.mvp.login;

/**
 * Created by tilma on 2018-01-24.
 */

public interface LoginView {

	void showProgress();

	void hideProgress();

	void displayFailure();

	void displaySuccess();

}
