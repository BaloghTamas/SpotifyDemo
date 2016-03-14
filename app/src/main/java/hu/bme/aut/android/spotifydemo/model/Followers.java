package hu.bme.aut.android.spotifydemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Followers {

	@SerializedName("href")
	@Expose
	private Object href;
	@SerializedName("total")
	@Expose
	private Integer total;

	/**
	 * @return The href
	 */
	public Object getHref() {
		return href;
	}

	/**
	 * @param href The href
	 */
	public void setHref(Object href) {
		this.href = href;
	}

	/**
	 * @return The total
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * @param total The total
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}

}