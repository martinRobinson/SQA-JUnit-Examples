
public class person {
	private String firstName = null;
	private String lastName = null;
	private int ageYears = 0;

	public person() {
		this("Unknown", "Unknown", 0);
	}

	public person(String firstName, String secondName, int ageYears) {
		this.firstName = firstName;
		this.lastName = secondName;
		this.ageYears = ageYears;
	}

	// validate first name
	public static boolean validateFirstName(String firstName) {
		return firstName.matches("[A-Z][a-zA-Z]*");
	}

	// validate last name
	public static boolean validateLastName(String lastName) {
		return lastName.matches("[a-zA-z]+([ '-][a-zA-Z]+)*");
	}

	public void setFirstName(String firstName) {
		if (validateFirstName(firstName) == true) {
			this.firstName = firstName;
		} else
			throw new IllegalArgumentException("First name can only be alphabetic", null);
	}

	public void setLastName(String lastName) {
		if (validateLastName(lastName) == true) {
			this.lastName = lastName;
		} else
			throw new IllegalArgumentException("Last name can only be alphabetic with a hyphen", null);
	}

	public void setAgeInYears(int ageYears) {
		if (ageYears < 0 || ageYears >= 130) {
			throw new IllegalArgumentException("Age must be reasonable");
		} else {
			this.ageYears = ageYears;
		}
	}

	public int getAgeInYears() {
		return ageYears;
	}

	public String getName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
}
