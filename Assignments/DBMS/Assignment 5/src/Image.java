/**Image table POJO Class */
public class Image {
	private int productId;
	private String url;

	/**
	 * @param id
	 * @param url
	 */
	public Image(int productId, String url) {
		this.productId = productId;
		this.url = url;
	}

	@Override
	public String toString() {
		return "Image [productId=" + productId + ", url=" + url + "]";
	}

	/**
	 * @return the id
	 */
	int getProductId() {
		return productId;
	}

	/**
	 * @param id the id to set
	 */
	void setProductId(int productId) {
		this.productId = productId;
	}

	/**
	 * @return the URL
	 */
	String getUrl() {
		return url;
	}

	/**
	 * @param url the URL to set
	 */
	void setUrl(String url) {
		this.url = url;
	}

}
