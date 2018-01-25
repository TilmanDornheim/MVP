package lofft.mvp.Login;

/**
 * Created by tilma on 2018-01-24.
 */

public interface LoginView {

	void showProgress();

	void hideProgress();

	void displayFailure();

	void displaySuccess();

}
