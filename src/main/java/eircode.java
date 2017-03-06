
public class eircode {
	private String eircode = null;
	
	public eircode(String inputEircode) {
		super();
		this.eircode = generateCanonicalEircode(inputEircode);
	}

	
	@Override
	public String toString() {
		return "eircode [eircode=" + eircode + "]";
	}
	

	private String generateCanonicalEircode(String nonCanonicalEircode){
		String CanonicalEircode = nonCanonicalEircode.replaceAll("\\s+","");
		CanonicalEircode = CanonicalEircode.toUpperCase();
		return CanonicalEircode;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eircode == null) ? 0 : eircode.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		eircode other = (eircode) obj;
		if (eircode == null) {
			if (other.eircode != null)
				return false;
		} else if (!eircode.equals(other.eircode))
			return false;
		return true;
	}


	public String getEircode() {
		return eircode;
	}

	public void setEircode(String eircode) {
		this.eircode = eircode;
	}
}

