package lofft.mvp.Login;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by tilma on 2018-01-24.
 */

public class LoginPresenterImpl implements LoginPresenter {

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

		model.login(username, password);


	}

	@Override
	public void onDestroy() {

		view = null;

	}

	@Override
	public void onStart() {

		EventBus.getDefault().register(this);

	}

	@Override
	public void onStop() {

		EventBus.getDefault().unregister(this);

	}

	//Subscribe to login Events
	@Subscribe
	public void onLoginEvent(LoginEvent loginEvent) {

		if (loginEvent.wasSuccess()) {

			view.displaySuccess();
			view.hideProgress();

		} else {

			view.displayFailure();
			view.hideProgress();
		}

	}


}
