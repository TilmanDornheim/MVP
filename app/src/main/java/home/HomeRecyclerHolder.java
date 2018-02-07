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

public class HomeRecyclerHolder extends RecyclerView.ViewHolder implements HomeHolderView {

	//Fields
	TextView title;
	ImageView image;

	public HomeRecyclerHolder(View itemView) {
		super(itemView);
		title = (TextView) itemView.findViewById(R.id.TV_HomeRecycler_Title);
		image = (ImageView)itemView.findViewById(R.id.IV_HomeRecycler_Image);
	}

	@Override
	public void setTitle(String title) {

		this.title.setText(title);
	}

	@Override
	public void setPicture(String url) {

		Picasso.with(image.getContext()).load(url).into(image);

	}
}
