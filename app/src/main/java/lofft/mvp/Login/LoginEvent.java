package lofft.mvp.Login;

/**
 * Created by tilma on 2018-01-25.
 */

public class LoginEvent {

	private boolean success;

	public boolean wasSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}
