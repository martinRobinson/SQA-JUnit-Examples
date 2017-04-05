// So this is stub class which represents a data provider. In brief,
// once it is instantiated it allows a client to invoke the findAddress 
// method with an input parameter which is a valid and correct eircode 
// and which then returns an address object which can then be tested.
// The addressProvider may be a database or a web service but we don't
// worry about it too much because we are only concerned with the external
// superficial behaviour. 
public class addressProvider {

	public addressProvider(eircode input) {

	}

	public address getAddress() {
		return null;
	}

}
