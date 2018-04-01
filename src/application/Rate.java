package application;

public class Rate {
	private String rater;
	private String rated;
	private int rate;

	/**
	 * Default constructor
	 * @param rater
	 * @param rated
	 * @param rate
	 */
	public Rate(String rater, String rated, int rate) {
		this.rater=rater;
		this.rated=rated;
		this.rate=rate;
	}
	
	// GETTERS AND SETTERS
	
	public String getRater() {
		return rater;
	}
	public void setRater(String rater) {
		this.rater = rater;
	}
	public String getRated() {
		return rated;
	}
	public void setRated(String rated) {
		this.rated = rated;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	
}
