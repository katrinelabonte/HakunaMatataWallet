package theHakunaMatataWallet;

public class Vendor {

			String name;
			int userNumber;
			public Vendor(String vendorName, int totalUserNumber) {
				name=vendorName;
				userNumber=totalUserNumber;
			}

			public int getUserTotal() {
				return userNumber;}
			
			
			public String getVendorName() {
				return name;}
			
			
			public int getLevel() {
				int level=0;
				if(getUserTotal()<=100) {
					level=1;
				}else if(100<getUserTotal() && getUserTotal()<=1000) {
					level=2;
				}else if(1000<getUserTotal()) {
					level=3;
				}
				return level;
				}
			
			public double getConversionTo(){
				double conversion=0;
				if(getLevel()==1){
					conversion=0.1;
				}else if(getLevel()==2) {
					conversion=0.5;
				}else if(getLevel()==3) {
					conversion=2;
				}
				return conversion;
			}
			public double getConversionFrom(){
				double conversion=0;
				if(getLevel()==1){
					conversion=10;
				}else if(getLevel()==2) {
					conversion=2;
				}else if(getLevel()==3) {
					conversion=0.5;
				}
				return conversion;
			}
			public String toString() {// to string method to allow listview to display passenger information as
				// strings
	String output = name;

	return output;
	}
	

}
