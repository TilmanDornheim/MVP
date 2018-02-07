package home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import lofft.mvp.R;

/**
 * Created by tilma on 2018-02-06.
 */

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerHolder> {

	private final HomeRecyclerPresenter presenter;

	public HomeRecyclerAdapter(HomeRecyclerPresenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public HomeRecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return new HomeRecyclerHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_home, parent, false));
	}

	@Override
	public void onBindViewHolder(HomeRecyclerHolder holder, int position) {

		presenter.bindRowViewAtPosition(position, holder);

	}

	@Override
	public int getItemCount() {

		return presenter.getItemCount();
		
	}
}
