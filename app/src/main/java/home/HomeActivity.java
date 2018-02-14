package home;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

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
	AlertDialog emptyDialog, errorDialog;


	//Butterknife
	@BindView(R.id.RV_home_recycler)
	RecyclerView recyler;


	//Lifecycle methods

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_activity);

		ButterKnife.bind(this);

		presenter = new HomePresenterImpl(this, new HomeModelImpl());

		setUpEmptyAlert();
		setUpErrorAlert();

		dialog = new ProgressDialog(this);
		dialog.setTitle(getString(R.string.DLG_home_loading));
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

		emptyDialog = builder.create();


	}

	private void setUpErrorAlert() {

		builder = new AlertDialog.Builder(this);
		builder.setTitle(R.string.DLG_home_error);
		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {

				dialog.dismiss();

			}
		});

		builder.setNegativeButton("Try again", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {

				presenter.getParties();
				dialog.dismiss();

			}
		});

		errorDialog = builder.create();

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

	@Override
	protected void onDestroy() {

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

		emptyDialog.show();

	}

	@Override
	public void showError() {

		errorDialog.show();

	}

	@Override
	public void setAdapter(HomeRecyclerAdapter adapter) {

		recyler.setLayoutManager(new LinearLayoutManager(this));
		recyler.setAdapter(adapter);

	}

	@Override
	public void onRecyclerItemClick(int position) {

		Toast.makeText(this, "Item #" + position + " clicked", Toast.LENGTH_SHORT).show();

	}

}
