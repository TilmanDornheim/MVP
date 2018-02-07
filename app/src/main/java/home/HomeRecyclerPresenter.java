package home;

/**
 * Created by tilma on 2018-02-06.
 */

public interface HomeRecyclerPresenter {

	void bindRowViewAtPosition(int position, HomeHolderView holder);

	int getItemCount();

}
