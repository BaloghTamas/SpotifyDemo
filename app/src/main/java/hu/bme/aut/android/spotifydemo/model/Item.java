package hu.bme.aut.android.spotifydemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Item {

	@SerializedName("external_urls")
	@Expose
	private ExternalUrls externalUrls;
	@SerializedName("followers")
	@Expose
	private Followers followers;
	@SerializedName("genres")
	@Expose
	private List<String> genres = new ArrayList<String>();
	@SerializedName("href")
	@Expose
	private String href;
	@SerializedName("id")
	@Expose
	private String id;
	@SerializedName("images")
	@Expose
	private List<Image> images = new ArrayList<Image>();
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("popularity")
	@Expose
	private Integer popularity;
	@SerializedName("type")
	@Expose
	private String type;
	@SerializedName("uri")
	@Expose
	private String uri;

	/**
	 * @return The externalUrls
	 */
	public ExternalUrls getExternalUrls() {
		return externalUrls;
	}

	/**
	 * @param externalUrls The external_urls
	 */
	public void setExternalUrls(ExternalUrls externalUrls) {
		this.externalUrls = externalUrls;
	}

	/**
	 * @return The followers
	 */
	public Followers getFollowers() {
		return followers;
	}

	/**
	 * @param followers The followers
	 */
	public void setFollowers(Followers followers) {
		this.followers = followers;
	}

	/**
	 * @return The genres
	 */
	public List<String> getGenres() {
		return genres;
	}

	/**
	 * @param genres The genres
	 */
	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

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
	 * @return The id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id The id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return The images
	 */
	public List<Image> getImages() {
		return images;
	}

	/**
	 * @param images The images
	 */
	public void setImages(List<Image> images) {
		this.images = images;
	}

	/**
	 * @return The name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name The name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return The popularity
	 */
	public Integer getPopularity() {
		return popularity;
	}

	/**
	 * @param popularity The popularity
	 */
	public void setPopularity(Integer popularity) {
		this.popularity = popularity;
	}

	/**
	 * @return The type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type The type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return The uri
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * @param uri The uri
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}

}
