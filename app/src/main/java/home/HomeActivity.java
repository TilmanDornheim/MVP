package home;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import lofft.mvp.R;

/**
 * Created by tilma on 2018-01-24.
 */

public class HomeActivity extends AppCompatActivity implements HomeView {

	//Fields
	private ProgressDialog dialog;
	HomePresenter presenter;
	AlertDialog.Builder builder;
	AlertDialog alertDialog;

	//Butterknife
	@BindView(R.id.RV_home_recycler)
	RecyclerView recyler;


	//Lifecycle methods

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		ButterKnife.bind(this);

		presenter = new HomePresenterImpl(this,new HomeModelImpl());

		setUpEmptyAlert();

		dialog = new ProgressDialog(this);
		dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

		//Initial call to get Data
		presenter.getParties();
	}

	private void setUpEmptyAlert() {

		builder = new AlertDialog.Builder(this);
		builder.setTitle(getResources().getString(R.string.DLG_home_empty));
		builder.setPositiveButton(R.string.DLG_home_empty_ok, new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {

				dialog.dismiss();

			}
		});

		alertDialog = builder.create();


	}

	@Override
	protected void onStart() {

		super.onStart();
		presenter.onStart();

	}

	@Override
	protected void onStop(){

		super.onStop();
		presenter.onStop();

	}

	@Override
	protected void onDestroy(){

		super.onDestroy();
		presenter.onDestroy();

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
	public void showIsEmpty() {

		alertDialog.show();

	}

	@Override
	public void setAdapter(HomeRecyclerAdapter adapter) {

		recyler.setLayoutManager(new LinearLayoutManager(this));
		recyler.setAdapter(adapter);

	}

}
