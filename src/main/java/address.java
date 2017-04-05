
public class address {
	private final eircode eircode;
	private final String houseName;
	private final String streetName;
	private final String townLand;
	private final String postalTown;
	private final String county;
	private final String country;

	public address(eircode eircode, String houseName, String streetName, String townland, String postalTown,
			String county, String country) {
		this.eircode = eircode;
		this.houseName = houseName;
		this.streetName = streetName;
		this.townLand = townland;
		this.postalTown = postalTown;
		this.county = county;
		this.country = country;
	}

	public eircode getEircode() {
		return eircode;
	}

	public String getHouseName() {
		return houseName;
	}

	public String getStreetName() {
		return streetName;
	}

	public String getTownLand() {
		return townLand;
	}

	public String getPostalTown() {
		return postalTown;
	}

	public String getCounty() {
		return county;
	}

	public String getCountry() {
		return country;
	}
}
