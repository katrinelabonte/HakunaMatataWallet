package theHakunaMatataWallet;

import theHakunaMatataWallet.Vendor;

public class Transaction {
		Vendor vendor;
		int points;
		String date;
		boolean collected; //if false, they were spent
		
		public Transaction(Vendor v, int p, String d, boolean c) {
			vendor=v;
			points=p;
			date = d;
			collected = c;
			
		}
		public String toString() {// to string method to allow listview to display passenger information as
			String output;
			if (collected ==true)// strings
			{
			output = points +  " points \nCollected at " + vendor.name +" \nDate Collected: " + date;
			}
			else
			{
			output = points +  " points \nRedeemed at " + vendor.name +" \nDate Redeemed: " + date;
			}

	return output;
	}
	

}
