package theHakunaMatataWallet;

public class Deals {
	
		String deal;
		String validDate;
		
		public Deals(String d, String v) {
			deal=d;
			validDate=v;
		}
		public String toString() {// to string method to allow listview to display passenger information as
			String output;
			output = deal +  "\nValid: " + validDate;

	return output;
	}
	

}
