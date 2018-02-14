package home;



public interface HomeView {

	void showProgress();

	void hideProgress();

	void showIsEmpty();

	void showError();

	void setAdapter(HomeRecyclerAdapter adapter);

	void onRecyclerItemClick(int position);

}
