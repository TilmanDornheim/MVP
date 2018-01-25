package lofft.mvp.Login;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lofft.mvp.R;

public class LoginActivity extends AppCompatActivity implements LoginView {


	//Fields

	private LoginPresenter presenter;
	private ProgressDialog dialog;

	// Butterknife

	@BindView(R.id.ET_login_username)
	EditText ETusername;
	@BindView(R.id.ET_login_password)
	EditText ETpassword;
	@BindView(R.id.BTN_login_login)
	Button BTNlogin;


	@OnClick(R.id.BTN_login_login)
	public void loginPressed() {

		String username = ETusername.getText().toString();
		String password = ETpassword.getText().toString();

		presenter.validateCredentials(username, password);

	}


	//Lifecycle Methods

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);

		// Presenter setup
		presenter = new LoginPresenterImpl(this, new LoginModelImpl());

		//Dialog styling
		dialog = new ProgressDialog(this);
		dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);


	}

	@Override
	protected void onDestroy() {

		super.onDestroy();
		presenter.onDestroy();

	}

	@Override
	protected void onStart() {

		super.onStart();
		presenter.onStart();

	}

	@Override
	protected void onStop() {

		super.onStop();
		presenter.onStop();

	}

	//Implementation of View-Interface methods


	@Override
	public void showProgress() {

		dialog.show();

	}

	@Override
	public void hideProgress() {

		dialog.hide();

	}

	@Override
	public void displayFailure() {

		Toast.makeText(this, "Failure", Toast.LENGTH_SHORT).show();

	}

	@Override
	public void displaySuccess() {

		Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();

	}


}
