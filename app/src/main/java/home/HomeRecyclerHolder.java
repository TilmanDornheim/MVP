package home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import lofft.mvp.R;

/**
 * Created by tilma on 2018-02-06.
 */

public class HomeRecyclerHolder extends RecyclerView.ViewHolder implements HomeHolderView,View.OnClickListener {

	//Fields
	TextView title;
	ImageView image;
	View itemView;
	HomeRecyclerPresenter presenter;

	public HomeRecyclerHolder(View itemView, HomeRecyclerPresenter presenter) {
		super(itemView);
		this.itemView = itemView;
		this.presenter = presenter;

		title = (TextView) itemView.findViewById(R.id.TV_HomeRecycler_Title);
		image = (ImageView)itemView.findViewById(R.id.IV_HomeRecycler_Image);

		itemView.setOnClickListener(this);
	}

	@Override
	public void setTitle(String title) {

		this.title.setText(title);
	}

	@Override
	public void setPicture(String url) {

		Picasso.with(itemView.getContext()).load(url).into(image);

	}

	@Override
	public void onClick(View v) {

		presenter.onItemClick(getAdapterPosition());

	}
}
