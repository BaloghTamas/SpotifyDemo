package hu.bme.aut.android.spotifydemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Artists {

	@SerializedName("href")
	@Expose
	private String href;
	@SerializedName("items")
	@Expose
	private List<Item> items = new ArrayList<Item>();
	@SerializedName("limit")
	@Expose
	private Integer limit;
	@SerializedName("next")
	@Expose
	private String next;
	@SerializedName("offset")
	@Expose
	private Integer offset;
	@SerializedName("previous")
	@Expose
	private Object previous;
	@SerializedName("total")
	@Expose
	private Integer total;

	/**
	 * @return The href
	 */
	public String getHref() {
		return href;
	}

	/**
	 * @param href The href
	 */
	public void setHref(String href) {
		this.href = href;
	}

	/**
	 * @return The items
	 */
	public List<Item> getItems() {
		return items;
	}

	/**
	 * @param items The items
	 */
	public void setItems(List<Item> items) {
		this.items = items;
	}

	/**
	 * @return The limit
	 */
	public Integer getLimit() {
		return limit;
	}

	/**
	 * @param limit The limit
	 */
	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	/**
	 * @return The next
	 */
	public String getNext() {
		return next;
	}

	/**
	 * @param next The next
	 */
	public void setNext(String next) {
		this.next = next;
	}

	/**
	 * @return The offset
	 */
	public Integer getOffset() {
		return offset;
	}

	/**
	 * @param offset The offset
	 */
	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	/**
	 * @return The previous
	 */
	public Object getPrevious() {
		return previous;
	}

	/**
	 * @param previous The previous
	 */
	public void setPrevious(Object previous) {
		this.previous = previous;
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
