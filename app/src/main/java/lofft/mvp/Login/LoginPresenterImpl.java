package lofft.mvp.Login;

/**
 * Created by tilma on 2018-01-24.
 */

public class LoginPresenterImpl implements LoginPresenter, LoginModel.OnLoginFinishedListener {

	private LoginView view;
	private LoginModel model;

	public LoginPresenterImpl(LoginView view, LoginModel model) {

		this.view = view;
		this.model = model;
	}

	@Override
	public void validateCredentials(String username, String password) {

		if (view != null) {

			view.showProgress();

		}

		model.login(username, password, this);


	}

	@Override
	public void onDestroy() {

		view = null;

	}


	@Override
	public void onLoginSuccess() {

		view.displaySuccess();
		view.hideProgress();

	}

	@Override
	public void onLoginFailure() {

		view.displayFailure();
		view.hideProgress();
	}
}
