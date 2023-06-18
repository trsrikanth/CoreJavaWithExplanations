package glca.da.w1.d4.selfpractice;

public class EncapsulationService {

//	1. Declare and initialize all variables required
	private String country = "Germany";
	private String nationalAnthem = "Das Lied der Deutschen";
	private String touristSpot = "Brandenburg Gate";

//	2. Generate required getters and setters
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getNationalAnthem() {
		return nationalAnthem;
	}

	public void setNationalAnthem(String nationalAnthem) {
		this.nationalAnthem = nationalAnthem;
	}

	public String getTouristSpot() {
		return touristSpot;
	}

	public void setTouristSpot(String touristSpot) {
		this.touristSpot = touristSpot;
	}
}