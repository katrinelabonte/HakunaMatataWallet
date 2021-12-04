package theHakunaMatataWallet;


import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ListView;

@SuppressWarnings("restriction")
public class HakunaMatataApplication extends Application {
	// global variables
	TextField txtVendorPts, txtName, txtUsers;
	Label lblResult, lblPrompt, lblConvert, lblTo, lblAdd, lblName, lblUsers;
	BorderPane root;
	GridPane inputArea;
	ComboBox<String> options;
	ArrayList<Vendor> vendorDataBase;
	Button btnConvert, btnSwitchtoBank, btnAddAVendor, btnSwitchToUser;
	HBox hbxResult, hbxVendorPts, hbxVendor2Pts, hbxName, hbxUsers;
	VBox vbxConvert, vbxAddVendor;
	ComboBox<Vendor> comboBox, comboBox2;
	Label lblHome;
	private Button btnMyStores;
	private Button btnDeals;
	private Button btnProfile;
	private Button btnSignOut;
	private HBox hbxHome1;
	private VBox vbxHome, vbxProfile;
	private HBox hbxHome2;
	private HBox hbxHome3;
	private Label lblNameofUser;
	private Button btnPoints;
	private Button btnHome;
	private Button btnCalculator;
	private Button btnAddStore;
	private Button btnMilestones;
	private Button btnLegal;
	private Button btnContactUs;
	private Button btnSettings;
	private HBox hbxProfile1;
	private HBox hbxProfile2;
	private HBox hbxProfile3;
	private Button btnPoints2;
	private Button btnSignOut2;
	private Label lblCollectedTitle;
	private double collected;
	private double redeemed;
	private double balance;
	private Label lblBalanceTitle;
	private Label lblBalance;
	private Label lblEfficiencyTitle;
	private Label lblCollected;
	private Label lblRedeemed;
	private VBox vbxPtTrackerParts;
	private VBox vbxEfficiency;
	private HBox hbxPtTracker;
	private Node vbxBalance;
	private Node vbxCollected;
	private Node vbxRedeemed;
	private Label lblRedeemedTitle;
	private double efficiency;
	private Label lblEfficiency;
	private long efficiencyShow;
	private HBox hbxProgress;
	private Button btnImprove;
	private ListView<Transaction> transactionHistory;
	private Label transactionLabel;
	private ListView<Deals> dealsList;
	private Label lblDeals;
	private VBox vbxDeals;
	private Button btnBackToHome;
	private Transaction transaction1;
	private Transaction transaction2;
	private Transaction transaction3;
	private Deals deal1;
	private Deals deal2;
	private Deals deal3;

	@Override
	public void start(Stage myStage) throws Exception {
		// variables for start method
		final int GAP = 15;
		final int LARGEGAP = 50;
		final int EXTRALARGEGAP = 100;
		final int LARGE_FONT = 20;
		final int XL_FONT = 24;
		String backgroundColor = "-fx-background-color:POWDERBLUE";
		String buttonColor = "-fx-background-color:GHOSTWHITE";

		// setting up gridpane inputArea where all labels, input buttons and textFields
		// will be located
		inputArea = new GridPane();
		inputArea.setHgap(GAP);
		inputArea.setVgap(GAP);
		inputArea.setPadding(new Insets(GAP, GAP, GAP, GAP));
		inputArea.setStyle(backgroundColor);

		// inputArea.setGridLinesVisible(true);

		// setting up homepage
		lblHome = new Label("HOME");
		lblHome.setFont(Font.font(LARGEGAP));
		btnPoints = new Button("Point Tracking");
		btnPoints.setMinSize(100, 50);// add to all buttons
		btnPoints.setStyle(buttonColor);
		btnPoints.setOnAction(event -> homeToPointTracking());
		btnMyStores = new Button("My Stores");
		btnMyStores.setMinSize(100, 50);// add to all buttons
		btnMyStores.setStyle(buttonColor);
		btnDeals = new Button("Today's Deals");
		btnDeals.setOnAction(event -> homeToDeals());
		btnDeals.setMinSize(100, 50);// add to all buttons
		btnDeals.setStyle(buttonColor);
		btnProfile = new Button("My Profile");
		btnProfile.setMinSize(100, 50);// add to all buttons
		btnProfile.setStyle(buttonColor);
		btnProfile.setOnAction(event -> homeToProfile());
		btnSignOut = new Button("Sign Out");
		btnSignOut.setMinSize(100, 50);// add to all buttons
		btnSignOut.setStyle(buttonColor);

		hbxHome1 = new HBox(LARGEGAP, lblHome);
		hbxHome2 = new HBox(LARGEGAP, btnPoints, btnMyStores, btnDeals);
		hbxHome3 = new HBox(LARGEGAP, btnProfile, btnSignOut);
		vbxHome = new VBox(GAP, hbxHome1, hbxHome2, hbxHome3);
		inputArea.add(vbxHome, 0, 0);

		// setting up profile page
		lblNameofUser = new Label("Rebecca Oakley");
		btnHome = new Button("Home");
		btnHome.setOnAction(event -> backToHome());
		btnHome.setMinSize(100, 50);// add to all buttons
		btnHome.setStyle(buttonColor);
		btnCalculator = new Button("Conversion Calculator");
		btnCalculator.setOnAction(event -> profileToCalc());
		btnCalculator.setMinSize(100, 50);// add to all buttons
		btnCalculator.setStyle(buttonColor);
		btnAddStore = new Button("Add a Store");
		btnAddStore.setMinSize(100, 50);// add to all buttons
		btnAddStore.setStyle(buttonColor);
		btnMilestones = new Button("Milestones");
		btnMilestones.setMinSize(100, 50);// add to all buttons
		btnMilestones.setStyle(buttonColor);
		btnLegal = new Button("Legal");
		btnLegal.setMinSize(100, 50);// add to all buttons
		btnLegal.setStyle(buttonColor);
		btnContactUs = new Button("Contact Us");
		btnContactUs.setMinSize(100, 50);// add to all buttons
		btnContactUs.setStyle(buttonColor);
		btnSettings = new Button("Settings");
		btnSettings.setMinSize(100, 50);// add to all buttons
		btnSettings.setStyle(buttonColor);
		btnPoints2 = new Button("Point Tracking");
		btnPoints2.setMinSize(100, 50);// add to all buttons
		btnPoints2.setStyle(buttonColor);
		btnSignOut2 = new Button("Sign Out");
		btnSignOut2.setMinSize(100, 50);// add to all buttons
		btnSignOut2.setStyle(buttonColor);
		hbxProfile1 = new HBox(LARGEGAP, btnHome, btnCalculator, btnPoints2);
		hbxProfile2 = new HBox(LARGEGAP, btnAddStore, btnMilestones, btnSettings);
		hbxProfile3 = new HBox(LARGEGAP, btnLegal, btnContactUs, btnSignOut2);
		vbxProfile = new VBox(GAP, lblNameofUser, hbxProfile1, hbxProfile2, hbxProfile3);
		inputArea.add(vbxProfile, 0, 0);
		vbxProfile.setVisible(false);

		// setting up CONVERSION PAGE
		// setting up convert Label
		lblConvert = new Label("Convert");
		lblConvert.setFont(Font.font(LARGE_FONT));
		inputArea.add(lblConvert, 0, 0, 1, 1);
		// setting up "to" Label
		lblTo = new Label("to");
		lblTo.setFont(Font.font(LARGE_FONT));
		// setting up vendorPts TextField
		txtVendorPts = new TextField();
		// setting up dropdown menu
		Vendor vendor1 = null;
		Vendor vendor2 = null;
		// note: will implement user entering vendor data which will be stored into
		// database, just haven't gotten around to it yet
		vendor1 = new Vendor("Sephora", 100); // making vendor
		vendor2 = new Vendor("Walmart", 10000); // making vendor
		vendorDataBase = new ArrayList<Vendor>();// will be implemented in dropdowns
		vendorDataBase.add(vendor1);
		vendorDataBase.add(vendor2);
		comboBox = new ComboBox<Vendor>();
		// setting up vendorPts HBox
		hbxVendorPts = new HBox(GAP, txtVendorPts, comboBox);
		inputArea.add(hbxVendorPts, 0, 1, 1, 1);
		// setting up vendorPts Label
		lblResult = new Label();
		lblResult.setFont(Font.font(LARGE_FONT));
		// setting up dropdown menu
		comboBox2 = new ComboBox<Vendor>();
		updateComboBoxes();
		// setting up vendor2Pts HBox
		hbxVendor2Pts = new HBox(GAP, lblTo, comboBox2);
		inputArea.add(hbxVendor2Pts, 0, 2, 1, 1);
		// setting up result prompt label
		lblPrompt = new Label("This is equivalent to: ");
		lblPrompt.setFont(Font.font(LARGE_FONT));
		// setting up result HBox
		hbxResult = new HBox(GAP, lblPrompt, lblResult);
		inputArea.add(hbxResult, 0, 3, 1, 1);
		// setting up Convert VBox
		vbxConvert = new VBox(GAP, lblConvert, hbxVendorPts, lblTo, hbxVendor2Pts, hbxResult);
		inputArea.add(vbxConvert, 0, 0, 1, 1);
		vbxConvert.setVisible(false);

		// adding back to home button
		btnBackToHome = new Button("Back to Homepage");
		btnBackToHome.setOnAction(event -> backToHome());
		btnBackToHome.setMinSize(100, 50);// add to all buttons
		btnBackToHome.setStyle(buttonColor);
		inputArea.add(btnBackToHome, 0, 4);
		btnBackToHome.setVisible(false);

		// setting up New Vendor Page
		// Prompt
		lblAdd = new Label("Add a New Vendor");
		lblAdd.setFont(Font.font(LARGE_FONT));
		inputArea.add(lblAdd, 0, 0, 1, 1);
		lblAdd.setVisible(false);
		// Vendor Name
		lblName = new Label("Vendor Name: ");
		lblName.setFont(Font.font(LARGE_FONT));
		txtName = new TextField();
		txtUsers = new TextField();
		hbxName = new HBox(GAP, lblName, txtName);
		inputArea.add(hbxName, 0, 1, 1, 1);
		hbxName.setVisible(false);

		// Number of users
		lblUsers = new Label("Number of Users: ");
		lblUsers.setFont(Font.font(LARGE_FONT));
		hbxUsers = new HBox(GAP, lblUsers, txtUsers);
		inputArea.add(hbxUsers, 0, 2, 1, 1);
		hbxUsers.setVisible(false);

		// setting up add vendor Button
		btnAddAVendor = new Button("Add Vendor");
		inputArea.add(btnAddAVendor, 0, 4);
		btnAddAVendor.setOnAction(event -> addAVendor());
		btnAddAVendor.setVisible(false);

		// setting up convert Button
		btnConvert = new Button("Convert");
		btnConvert.setMinSize(100, 50);// add to all buttons
		btnConvert.setStyle(buttonColor);
		inputArea.add(btnConvert, 0, 3);
		btnConvert.setOnAction(event -> convert(comboBox, comboBox2));
		btnConvert.setVisible(false);

		// setting up switchToBank Button
		btnSwitchtoBank = new Button("Switch to Bank View");
		inputArea.add(btnSwitchtoBank, 1, 4);
		btnSwitchtoBank.setOnAction(event -> switchToBank());

		btnSwitchToUser = new Button("Switch to User View");
		inputArea.add(btnSwitchToUser, 0, 5);
		btnSwitchToUser.setOnAction(event -> switchToUser());
		btnSwitchToUser.setVisible(false);

		// setting up Points Tracker
		collected = 10000;
		redeemed = 7500;
		balance = collected - redeemed + 100;
		efficiency = calculateEffic();
		lblCollectedTitle = new Label("Points Collected");
		lblBalanceTitle = new Label("Current Point Balance");
		lblBalance = new Label("" + balance);
		lblRedeemedTitle = new Label("Points Redeemed");
		lblEfficiencyTitle = new Label("Efficiency");
		lblCollected = new Label("" + collected);
		lblRedeemed = new Label("" + redeemed);
		efficiencyShow = (Math.round(efficiency * 1000) / 1000);
		lblEfficiency = new Label("" + efficiencyShow + "%");

		lblCollectedTitle.setFont(Font.font(LARGE_FONT));
		lblBalanceTitle.setFont(Font.font(LARGE_FONT));
		lblRedeemedTitle.setFont(Font.font(LARGE_FONT));
		lblBalance.setFont(Font.font(XL_FONT));
		lblEfficiencyTitle.setFont(Font.font(LARGE_FONT));
		lblCollected.setFont(Font.font(XL_FONT));
		lblEfficiency.setFont(Font.font(16));
		lblRedeemed.setFont(Font.font(XL_FONT));


		vbxBalance = new VBox(GAP, lblBalanceTitle, lblBalance);
		vbxCollected = new VBox(GAP, lblCollectedTitle, lblCollected);
		vbxRedeemed = new VBox(GAP, lblRedeemedTitle, lblRedeemed);
		btnImprove = new Button("Improve Efficiency");
		btnImprove.setMinSize(100, 50);// add to all buttons
		btnImprove.setStyle(buttonColor);
		btnImprove.setOnAction(event -> pointsToDeals());
		ProgressBar pbEfficiency = new ProgressBar();
		pbEfficiency.setProgress(efficiency / 100);
		transactionHistory = new ListView<Transaction>();
		transactionHistory.setMinSize(200, 175);

		transaction1 = new Transaction(vendor2, 200, "November 20th, 2021", false);
		transaction2 = new Transaction(vendor1, 386, "November 16th, 2021", true);
		transaction3 = new Transaction(vendor1, 194, "November 5th, 2021", false);

		transactionHistory.getItems().add(transaction1);
		transactionHistory.getItems().add(transaction2);
		transactionHistory.getItems().add(transaction3);

		vbxPtTrackerParts = new VBox(LARGEGAP, vbxBalance, vbxCollected, vbxRedeemed);
		hbxProgress = new HBox(GAP, pbEfficiency, lblEfficiency);
		vbxEfficiency = new VBox(GAP, lblEfficiencyTitle, hbxProgress, btnImprove);
		hbxPtTracker = new HBox(EXTRALARGEGAP, vbxPtTrackerParts, vbxEfficiency);
		transactionLabel = new Label("Transaction History");
		hbxPtTracker.setVisible(false);
		transactionHistory.setVisible(false);
		transactionLabel.setVisible(false);
		inputArea.add(hbxPtTracker, 0, 0);
		inputArea.add(transactionLabel, 0, 2);
		inputArea.add(transactionHistory, 0, 3, 2, 1);

		// setting up deals page
		lblDeals = new Label("Today's Deals");
		dealsList = new ListView<Deals>();
		
		deal1 = new Deals("Sephora: 50% Off Purchases of 100$ and more!", "Nov 21, 2021 to Nov 27, 2021" );
		deal2 = new Deals("Walmart: Earn 2x points ONE DAY ONLY EVENT!", "Nov 26th, 2021" );
		deal3 = new Deals("PC Optimum: Points are worth triple their normal values THIS WEEK ONLY!", "Nov 28, 2021 to Dec 4, 2021" );

		dealsList.getItems().add(deal1);
		dealsList.getItems().add(deal2);
		dealsList.getItems().add(deal3);

		vbxDeals = new VBox(GAP, lblDeals, dealsList);
		vbxDeals.setVisible(false);
		inputArea.add(vbxDeals, 0, 0);

		// setting up screen display
		Scene scene = new Scene(inputArea);
		myStage.setMinWidth(500);// set screen width
		myStage.setHeight(750);// set screen height
		myStage.setTitle("Loyalty Program Prototype 3");
		myStage.setScene(scene);
		myStage.show();
	}

	private void backToHome() {
		// ERASE ALL
		eraseProfile();
		erasePoints();
		eraseDeals();
		eraseCalc();
		showHome();
	}

	private void eraseCalc() {
		vbxConvert.setVisible(false);
		btnConvert.setVisible(false);
		btnBackToHome.setVisible(false);
		
	}

	private void eraseDeals() {
		vbxDeals.setVisible(false);
		btnBackToHome.setVisible(false);		
	}

	private void homeToDeals() {
		eraseHome();
		showDeals();
	}

	private void profileToCalc() {
		eraseProfile();
		showCalc();
	}

	private void showCalc() {
		vbxConvert.setVisible(true);
		btnConvert.setVisible(true);
		btnBackToHome.setVisible(true);

	}

	private void eraseProfile() {
		vbxProfile.setVisible(false);
	}

	private void homeToProfile() {
		eraseHome();
		showProfile();
	}

	private void showProfile() {
		vbxProfile.setVisible(true);
	}

	private void pointsToDeals() {
		erasePoints();
		showDeals();
	}

	private void showDeals() {
		vbxDeals.setVisible(true);
		btnBackToHome.setVisible(true);

	}

	private void erasePoints() {
		hbxPtTracker.setVisible(false);
		transactionHistory.setVisible(false);
		transactionLabel.setVisible(false);

	}

	private double calculateEffic() {
		double effic = (redeemed / (collected + balance)) * 100;
		return effic;
	}

	private void homeToPointTracking() {
		eraseHome();
		showPointTracking();
	}

	private void showPointTracking() {
		hbxPtTracker.setVisible(true);
		transactionHistory.setVisible(true);
		transactionLabel.setVisible(true);
		btnBackToHome.setVisible(true);


	}

	private void eraseHome() {
		vbxHome.setVisible(false);
	}

	private void addAVendor() {
		String Name = txtName.getText();
		int Users = Integer.parseInt(txtUsers.getText());
		Vendor newVendor = new Vendor(Name, Users);
		vendorDataBase.add(newVendor);
		txtName.clear();
		txtUsers.clear();

	}

	private void switchToBank() {// switching to Bank view screen
		btnConvert.setVisible(false);
		btnSwitchtoBank.setVisible(false);
		vbxConvert.setVisible(false);
		lblAdd.setVisible(true);
		hbxName.setVisible(true);
		hbxUsers.setVisible(true);
		btnAddAVendor.setVisible(true);
		btnSwitchToUser.setVisible(true);

		// set all stuff to invisible

	}

	private void switchToUser() {// switching to Bank view screen
		lblAdd.setVisible(false);
		hbxName.setVisible(false);
		hbxUsers.setVisible(false);
		btnAddAVendor.setVisible(false);
		btnSwitchToUser.setVisible(false);
		updateComboBoxes();
		showHome();

	}

	private void showHome() {
		vbxHome.setVisible(true);

	}

	private void updateComboBoxes() {
		comboBox.getItems().clear();
		comboBox2.getItems().clear();
		for (int i = 0; i < vendorDataBase.size(); i++) {
			comboBox2.getItems().add(vendorDataBase.get(i));// will implement this to be linked to vendorDataBase
		}
		for (int i = 0; i < vendorDataBase.size(); i++) {
			comboBox.getItems().add(vendorDataBase.get(i));// will implement this to be linked to vendorDataBase
		}
	}

	@SuppressWarnings("rawtypes")
	private void convert(ComboBox comboBox, ComboBox comboBox2) {
		Vendor selection1name = (Vendor) comboBox.getValue();
		Vendor selection2name = (Vendor) comboBox2.getValue();

		Vendor source = null, destination = null;

		for (int i = 0; i < vendorDataBase.size(); i++) {
			Vendor checkAgainst = vendorDataBase.get(i);
			if (checkAgainst == selection1name) {
				source = vendorDataBase.get(i);
			}
		}

		for (int i = 0; i < vendorDataBase.size(); i++) {
			Vendor vendorName2 = vendorDataBase.get(i);

			if (vendorName2 == selection2name) {
				destination = vendorDataBase.get(i);
			}
		}

		double vendor1pts = Double.parseDouble(txtVendorPts.getText());
		double result = calculateConversion(vendor1pts, source, destination);
		updateLabel(result, destination);

	}

	private void updateLabel(double result, Vendor vendor2) {
		lblResult.setText(result + " " + vendor2.getVendorName() + " points");
	}

	private double calculateConversion(double ptsToConvert, Vendor vendor1, Vendor vendor2) {
		double convertTo = vendor1.getConversionTo();
		double convertFrom = vendor2.getConversionFrom();
		double result = ptsToConvert * convertTo * convertFrom;
		return result;
	}
}

