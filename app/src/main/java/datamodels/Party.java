package datamodels;

/**
 * Created by tilma on 2018-02-06.
 */

public class Party {

	private String title;
	private String url;

	public Party(String title, String url) {
		this.title = title;
		this.url = url;

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
