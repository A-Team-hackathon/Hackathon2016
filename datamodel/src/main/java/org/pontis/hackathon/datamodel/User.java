package ateam.data;

public class User {
	String internaluserId;
	double latitude;
	double longitude;
	String country;
	String state;
	public String getInternaluserId() {
		return internaluserId;
	}
	public void setInternaluserId(String internaluserId) {
		this.internaluserId = internaluserId;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
