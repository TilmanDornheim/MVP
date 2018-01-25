package Home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import lofft.mvp.R;

/**
 * Created by tilma on 2018-01-24.
 */

public class HomeActivity extends AppCompatActivity {

	//Fields


	//Butterknife


	//Lifecycle methods

	@Override
	protected void onCreate(Bundle savedInstanceState){

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		ButterKnife.bind(this);

	}

	//Implementation of View-Interface methods


}
