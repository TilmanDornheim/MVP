package datamodels;

import java.util.Date;

/**
 * Created by tilma on 2018-02-06.
 */

public class Party {

	private int id;
	private String description;
	private int host_id;
	private String date;
	private String date_created;
	private boolean isPublic;
	private int cost;
	private int free_limit;
	private double loc_lat;
	private double loc_lng;

	public Party(){}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getHost_id() {
		return host_id;
	}

	public void setHost_id(int host_id) {
		this.host_id = host_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDate_created() {
		return date_created;
	}

	public void setDate_created(String date_created) {
		this.date_created = date_created;
	}

	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean aPublic) {
		isPublic = aPublic;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getFree_limit() {
		return free_limit;
	}

	public void setFree_limit(int free_limit) {
		this.free_limit = free_limit;
	}

	public double getLoc_lat() {
		return loc_lat;
	}

	public void setLoc_lat(double loc_lat) {
		this.loc_lat = loc_lat;
	}

	public double getLoc_lng() {
		return loc_lng;
	}

	public void setLoc_lng(double loc_lng) {
		this.loc_lng = loc_lng;
	}
}
