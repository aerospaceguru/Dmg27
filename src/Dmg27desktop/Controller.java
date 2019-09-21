package Dmg27desktop;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.*;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;

public class Controller {

	public ComboBox<String> pavType;
	public ObservableList<String> pavList = FXCollections.observableArrayList("Flexible", "Rigid");

	public ComboBox<String> cbrDrop;
	public ObservableList<String> cbrList = FXCollections.observableArrayList("3","4","5","6","7","8","9","10","11","12","13","14","15");

	public ComboBox<String> kDrop;
	public ObservableList<String> kList = FXCollections.observableArrayList("20", "30", "40", "50","60","70","80");

	public ComboBox<String> materialDrop;
	public ObservableList<String> materialList = FXCollections.observableArrayList("BBM", "HSBBM");

	public ComboBox<String> concreteDrop;
	public ObservableList<String> concreteList = FXCollections.observableArrayList("F5", "F6");

	public ComboBox<String> gearDrop;
	public ObservableList<String> gearList = FXCollections.observableArrayList("Single", "Dual", "Dual-tandem", "Tridem");

	public ComboBox<String> coveragesDrop;
	public ObservableList<String> coveragesList = FXCollections.observableArrayList("Low", "Medium");

	public TextField acnDesign;
	public TextArea surfacesoln;
	public TextArea bindersoln;
	public TextArea gsbflexsoln;

	public TextArea pqsoln;
	public TextArea dlcsoln;
	public TextArea gsbrigidsoln;

	@FXML
	private Button calculate;
	@FXML
	private Button reset;


	public void initialize() {

		pavType.setItems(pavList);
		cbrDrop.setItems(cbrList);
		kDrop.setItems(kList);
		materialDrop.setItems(materialList);
		concreteDrop.setItems(concreteList);
		gearDrop.setItems(gearList);
		coveragesDrop.setItems(coveragesList);

		pavType.getSelectionModel().selectedItemProperty().addListener( 
				(observable, oldvalue, newvalue) -> {

					if (pavType.getValue().equals("Rigid")) {

						cbrDrop.setDisable(true);
						cbrDrop.setStyle("-fx-opacity: 1;");
						materialDrop.setDisable(true);
						materialDrop.setStyle("-fx-opacity: 1;");

						kDrop.setDisable(false);
						concreteDrop.setDisable(false);

					}
					else if (pavType.getValue().equals("Flexible")) {

						kDrop.setDisable(true);
						kDrop.setStyle("-fx-opacity: 1;");
						concreteDrop.setDisable(true);
						concreteDrop.setStyle("-fx-opacity: 1;");

						cbrDrop.setDisable(false);
						materialDrop.setDisable(false);

					}
				});

	}

	public void calculate(ActionEvent event) {

		// THIS SECTION BEGINS THE RIGID CODE EVALUATION 

		if (pavType.getValue().equals("Rigid")) {


			String gearR = gearDrop.getValue();
			String coveragesR = coveragesDrop.getValue();
			double acnR = Double.parseDouble(acnDesign.getText());
			double polyR = 0;	
			int k = Integer.parseInt(kDrop.getValue());
			String concrete = concreteDrop.getValue();


			double f5low[][]  = 
				{
						{-0.017857143*Math.pow(acnR,2) + 4.221428571*acnR  + 121.0, -0.012797619*Math.pow(acnR,2) + 3.782738095*acnR  + 124.6428571, -0.009440559*Math.pow(acnR,2) + 3.351398601*acnR  + 123.2954545, -0.008591409*Math.pow(acnR,2) + 3.171078921*acnR  + 122.5000000},
						{-0.017857143*Math.pow(acnR,2) + 4.157142857*acnR  + 119.5, -0.015476190*Math.pow(acnR,2) + 3.934523810*acnR  + 118.9285714, -0.009453047*Math.pow(acnR,2) + 3.421203796*acnR  + 117.1590909, -0.008429071*Math.pow(acnR,2) + 3.198926074*acnR  + 117.7272727},
						{-0.015178571*Math.pow(acnR,2) + 3.912500000*acnR  + 119.0, -0.015476190*Math.pow(acnR,2) + 3.863095238*acnR  + 118.9285714, -0.009502997*Math.pow(acnR,2) + 3.488886114*acnR  + 112.6136364, -0.007923327*Math.pow(acnR,2) + 3.203983516*acnR  + 114.0340909},
						{-0.016964286*Math.pow(acnR,2) + 3.980357143*acnR  + 116.0, -0.013392857*Math.pow(acnR,2) + 3.687500000*acnR  + 118.5714286, -0.009902597*Math.pow(acnR,2) + 3.600274725*acnR  + 107.9545455, -0.007817183*Math.pow(acnR,2) + 3.247002997*acnR  + 110.4545455},
						{-0.015178571*Math.pow(acnR,2) + 3.798214286*acnR  + 118.0, -0.014285714*Math.pow(acnR,2) + 3.767857143*acnR  + 115.7142857, -0.009833916*Math.pow(acnR,2) + 3.623688811*acnR  + 107.1022727, -0.008035714*Math.pow(acnR,2) + 3.306006494*acnR  + 109.2613636},
						{-0.015178571*Math.pow(acnR,2) + 3.798214286*acnR  + 115.5, -0.014285714*Math.pow(acnR,2) + 3.767857143*acnR  + 115.0000000, -0.010439560*Math.pow(acnR,2) + 3.736513487*acnR  + 105.3409091, -0.008054446*Math.pow(acnR,2) + 3.349525475*acnR  + 108.4090909},
						{-0.015178571*Math.pow(acnR,2) + 3.798214286*acnR  + 115.5, -0.013392857*Math.pow(acnR,2) + 3.705357143*acnR  + 117.5000000, -0.010089910*Math.pow(acnR,2) + 3.722527473*acnR  + 107.2727273, -0.008216783*Math.pow(acnR,2) + 3.377622378*acnR  + 109.5454545}
				};

			double f5med[][]  = 
				{
						{-0.019642857*Math.pow(acnR,2) + 4.717857143*acnR + 125.5,	-0.015476190*Math.pow(acnR,2) +	4.363095238*acnR + 126.7857143,	-0.010083666*Math.pow(acnR,2) +	3.675387113*acnR + 129.2613636,	-0.009459291*Math.pow(acnR,2) +	3.519043457*acnR + 129.3750000},
						{-0.021875000*Math.pow(acnR,2) + 4.774107143*acnR + 122.75,	-0.014583333*Math.pow(acnR,2) +	4.211309524*acnR + 125.3571429,	-0.010683067*Math.pow(acnR,2) +	3.798763736*acnR + 123.2386364,	-0.009496753*Math.pow(acnR,2) +	3.558878621*acnR + 125.7386364},
						{-0.019642857*Math.pow(acnR,2) + 4.582142857*acnR + 121.5,	-0.013095238*Math.pow(acnR,2) +	4.065476190*acnR + 123.5714286,	-0.011195055*Math.pow(acnR,2) +	3.924762737*acnR + 118.2386364,	-0.010277223*Math.pow(acnR,2) +	3.732892108*acnR + 118.8636364},
						{-0.021428571*Math.pow(acnR,2) + 4.650000000*acnR + 118.5,	-0.014583333*Math.pow(acnR,2) +	4.139880952*acnR + 120.3571429,	-0.011700799*Math.pow(acnR,2) +	4.045579421*acnR + 113.7500000,	-0.010439560*Math.pow(acnR,2) +	3.799450549*acnR + 116.2500000},
						{-0.019642857*Math.pow(acnR,2) + 4.517857143*acnR + 117.5,	-0.013095238*Math.pow(acnR,2) +	3.994047619*acnR + 121.0714286,	-0.011781968*Math.pow(acnR,2) +	4.104208292*acnR + 112.6704545,	-0.010339660*Math.pow(acnR,2) +	3.831918082*acnR + 115.6818182},
						{-0.017410714*Math.pow(acnR,2) + 4.325892857*acnR + 118.75,	-0.014583333*Math.pow(acnR,2) +	4.068452381*acnR + 120.3571429,	-0.011825674*Math.pow(acnR,2) +	4.154470529*acnR + 111.9318182,	-0.010452048*Math.pow(acnR,2) +	3.897227772*acnR + 114.5454545},
						{-0.017410714*Math.pow(acnR,2) + 4.325892857*acnR + 118.75,	-0.014583333*Math.pow(acnR,2) +	4.068452381*acnR + 122.8571429,	-0.011725774*Math.pow(acnR,2) +	4.162462537*acnR + 114.2045455,	-0.010295954*Math.pow(acnR,2) +	3.904033467*acnR + 115.9659091},
				};

			double f6low[][]  = 
				{
						{-0.013392857*Math.pow(acnR,2) + 3.537500000*acnR + 104.00, -0.011607143*Math.pow(acnR,2) + 3.455357143*acnR + 107.1428571, -0.008610140*Math.pow(acnR,2) + 3.013548951*acnR + 112.2159091, -0.007636114*Math.pow(acnR,2) + 2.8921703300*acnR + 104.8295455},
						{-0.015625000*Math.pow(acnR,2) + 3.658035714*acnR + 100.25, -0.012500000*Math.pow(acnR,2) + 3.446428571*acnR + 105.0000000, -0.007423826*Math.pow(acnR,2) + 2.908279221*acnR + 109.7159091, -0.006630869*Math.pow(acnR,2) + 2.7990759240*acnR + 102.7272727},
						{-0.013839286*Math.pow(acnR,2) + 3.475892857*acnR + 99.75,  -0.011904762*Math.pow(acnR,2) + 3.345238095*acnR + 103.9285714, -0.006499750*Math.pow(acnR,2) + 2.835352148*acnR + 109.0340909, -0.005407093*Math.pow(acnR,2) + 2.6784465530*acnR + 103.5227273},
						{-0.016071429*Math.pow(acnR,2) + 3.596428571*acnR + 96.00,  -0.010416667*Math.pow(acnR,2) + 3.181547619*acnR + 105.7142857, -0.006106394*Math.pow(acnR,2) + 2.837537463*acnR + 106.1363636, -0.004408092*Math.pow(acnR,2) + 2.5800449550*acnR + 104.0909091},
						{-0.014285714*Math.pow(acnR,2) + 3.414285714*acnR + 98.00,  -0.010416667*Math.pow(acnR,2) + 3.181547619*acnR + 103.2142857, -0.006000250*Math.pow(acnR,2) + 2.850836663*acnR + 105.7386364, -0.003902348*Math.pow(acnR,2) + 2.5378996000*acnR + 104.7159091},
						{-0.016071429*Math.pow(acnR,2) + 3.532142857*acnR + 94.50,  -0.010416667*Math.pow(acnR,2) + 3.181547619*acnR + 103.2142857, -0.005282218*Math.pow(acnR,2) + 2.805569431*acnR + 106.2500000, -0.003558941*Math.pow(acnR,2) + 2.5343406590*acnR + 104.5454545},
						{-0.016071429*Math.pow(acnR,2) + 3.532142857*acnR + 94.50,  -0.009523810*Math.pow(acnR,2) + 3.119047619*acnR + 106.0714286, -0.005126124*Math.pow(acnR,2) + 2.812375125*acnR + 107.6704545, -0.003902348*Math.pow(acnR,2) + 2.6043331670*acnR + 104.1477273},
				};

			double f6med[][]  = 
				{
						{-0.020089286*Math.pow(acnR,2) + 4.091964286*acnR + 112.25, -0.010416667*Math.pow(acnR,2) + 3.395833333*acnR + 119.6428571, -0.008877373*Math.pow(acnR,2) + 3.126960539*acnR + 117.6250000, -0.008098152*Math.pow(acnR,2) + 2.983703796*acnR +  113.4659091},
						{-0.021875000*Math.pow(acnR,2) + 4.159821429*acnR + 109.25, -0.010416667*Math.pow(acnR,2) + 3.324404762*acnR + 117.8571429, -0.008229271*Math.pow(acnR,2) + 3.092532468*acnR + 113.9772727, -0.006699550*Math.pow(acnR,2) + 2.826361139*acnR +  114.0340909},
						{-0.019642857*Math.pow(acnR,2) + 3.967857143*acnR + 108.00, -0.010119048*Math.pow(acnR,2) + 3.255952381*acnR + 116.0714286, -0.007086663*Math.pow(acnR,2) + 2.995566933*acnR + 113.4659091, -0.005294705*Math.pow(acnR,2) + 2.693556444*acnR +  114.4318182},
						{-0.021875000*Math.pow(acnR,2) + 4.088392857*acnR + 104.25, -0.008630952*Math.pow(acnR,2) + 3.110119048*acnR + 116.7857143, -0.006637113*Math.pow(acnR,2) + 2.984328172*acnR + 111.7613636, -0.004795205*Math.pow(acnR,2) + 2.677572428*acnR +  111.9318182},
						{-0.019642857*Math.pow(acnR,2) + 3.853571429*acnR + 107.00, -0.008630952*Math.pow(acnR,2) + 3.092261905*acnR + 115.3571429, -0.006824426*Math.pow(acnR,2) + 3.057629870*acnR + 109.2613636, -0.004395604*Math.pow(acnR,2) + 2.653596404*acnR +  112.1590909},
						{-0.019642857*Math.pow(acnR,2) + 3.853571429*acnR + 104.50, -0.008630952*Math.pow(acnR,2) + 3.110119048*acnR + 114.2857143, -0.006880619*Math.pow(acnR,2) + 3.081543457*acnR + 109.8863636, -0.003896104*Math.pow(acnR,2) + 2.637612388*acnR +  112.1590909},
						{-0.019642857*Math.pow(acnR,2) + 3.853571429*acnR + 104.50, -0.010119048*Math.pow(acnR,2) + 3.273809524*acnR + 112.5000000, -0.007067932*Math.pow(acnR,2) + 3.123376623*acnR + 110.6818182, -0.004395604*Math.pow(acnR,2) + 2.720029970*acnR +  111.5909091},
				};

			if (concrete.equals("F5")){

				if (coveragesR.equals("Low") && gearR.equals("Single")){
					polyR = f5low[(k-20)/10][0]; 
				}
				else if (coveragesR.equals("Low") && gearR.equals("Dual")){
					polyR = f5low[(k-20)/10][1]; 
				}
				else if (coveragesR.equals("Low") && gearR.equals("Dual-tandem")){
					polyR = f5low[(k-20)/10][2]; 
				}
				else if (coveragesR.equals("Low") && gearR.equals("Tridem")){
					polyR = f5low[(k-20)/10][3]; 
				}
				else if (coveragesR.equals("Medium") && gearR.equals("Single")){
					polyR = f5med[(k-20)/10][0]; 
				}
				else if (coveragesR.equals("Medium") && gearR.equals("Dual")){
					polyR = f5med[(k-20)/10][1]; 
				}
				else if (coveragesR.equals("Medium") && gearR.equals("Dual-tandem")){
					polyR = f5med[(k-20)/10][2]; 
				}
				else if (coveragesR.equals("Medium") && gearR.equals("Tridem")){
					polyR = f5med[(k-20)/10][3]; 
				}

				double answer = polyR;
				answer = (Math.round(answer/5.0))*5.0;
				int answer1 = (int) answer;
				String answer2 = String.valueOf(answer1);


				pqsoln.setText(answer2);
				gsbrigidsoln.setText("100");

			}

			else if (concrete.equals("F6")){

				if (coveragesR.equals("Low") && gearR.equals("Single")){
					polyR = f6low[(k-20)/10][0]; 
				}
				else if (coveragesR.equals("Low") && gearR.equals("Dual")){
					polyR = f6low[(k-20)/10][1]; 
				}
				else if (coveragesR.equals("Low") && gearR.equals("Dual-tandem")){
					polyR = f6low[(k-20)/10][2]; 
				}
				else if (coveragesR.equals("Low") && gearR.equals("Tridem")){
					polyR = f6low[(k-20)/10][3]; 
				}
				else if (coveragesR.equals("Medium") && gearR.equals("Single")){
					polyR = f6med[(k-20)/10][0]; 
				}
				else if (coveragesR.equals("Medium") && gearR.equals("Dual")){
					polyR = f6med[(k-20)/10][1]; 
				}
				else if (coveragesR.equals("Medium") && gearR.equals("Dual-tandem")){
					polyR = f6med[(k-20)/10][2]; 
				}
				else if (coveragesR.equals("Medium") && gearR.equals("Tridem")){
					polyR = f6med[(k-20)/10][3]; 
				}

				double answer = polyR;
				answer = (Math.round(answer/5.0))*5.0;
				int answer1 = (int) answer;
				String answer2 = String.valueOf(answer1);


				pqsoln.setText(answer2);
				gsbrigidsoln.setText("100");

			}

			// LEAN EVALUATION BEGINS HERE


			String dlc = "error!"; 								// This initialises the 'dlc' string to a value
			int answer = Integer.parseInt(pqsoln.getText()); 	// This retries the calculated PQ depth from the text box


			// These are the lean mix boundary conditions

			double boundarySing59 = 1.858974359*k + 147.8205128;
			double boundarySing79 = 1.779661017*k + 84.40677966;	
			double boundaryDual59 = 1.602564103*k +	160.4487179;
			double boundaryDual79 = 1.602564103*k +	95.44871795;
			double boundaryDtan39 = 2.105263158*k +	257.8947368;
			double boundaryDtan56 = 2.083333333*k +	198.3333333;
			double boundaryDtan69 = 2.193877551*k +	131.122449;
			double boundaryDtan79 = 2.033898305*k +	79.3220339;


			// The following if statement addresses the boundaries of the lean mix for single gear


			if( gearR.equals("Single") ){

				if( k < 60 )
				{
					if(answer >= boundarySing59){
						dlc = "150";
					}

					else if( (answer < boundarySing59) && (answer >= boundarySing79) ){
						dlc = "125";
					}

					else{ dlc = "100"; 
					}

				}

				else if( k >= 60 && k <= 79){

					if(answer >= boundarySing79){
						dlc = "125";
					}

					else{ dlc = "100";
					}
				}

				else { dlc = "100";}

			}

			// The following if statement addresses the boundaries of the lean mix for dual gear

			else if( gearR.equals("Dual") ){

				if( k < 60 )
				{
					if(answer >= boundaryDual59){
						dlc = "150";
					}

					else if( (answer < boundaryDual59) && (answer >= boundaryDual79) ){
						dlc = "125";
					}

					else{ dlc = "100"; 
					}

				}

				else if( k >= 60 && k <= 79){

					if(answer >= boundaryDual79){
						dlc = "125";
					}

					else{ dlc = "100";
					}
				}

				else { dlc = "100";}

			}

			// The following if statement addresses the boundaries of the lean mix for dual-tandem & tridem gear

			else if( gearR.equals("Dual-tandem") || gearR.equals("Tridem") ){

				if( k < 40 )
				{
					if(answer >= boundaryDtan39){
						dlc = "200";
					}

					else if( (answer < boundaryDtan39 ) && (answer >= boundaryDtan56 ) ){
						dlc = "175";
					}

					else if( (answer < boundaryDtan56 ) && (answer >= boundaryDtan69 ) ){
						dlc = "150";
					}

					else if( (answer < boundaryDtan69 ) && (answer >= boundaryDtan79 ) ){
						dlc = "125";
					}

					else{ dlc = "100"; 
					}

				}

				else if( k >= 40 && k <= 56){

					if(answer >= boundaryDtan56){
						dlc = "175";
					}

					else if( (answer < boundaryDtan56 ) && (answer >= boundaryDtan69 ) ){
						dlc = "150";
					}

					else if( (answer < boundaryDtan69 ) && (answer >= boundaryDtan79 ) ){
						dlc = "125";
					}

					else{ dlc = "100";
					}
				}

				else if( k >= 56 && k <= 69){

					if(answer >= boundaryDtan69){
						dlc = "150";
					}

					else if( (answer < boundaryDtan69 ) && (answer >= boundaryDtan79 ) ){
						dlc = "125";
					}

					else{ dlc = "100";
					}
				}

				else if( k >= 69 && k <= 79){

					if(answer >= boundaryDtan79){
						dlc = "125";
					}

					else{ dlc = "100";
					}
				}

				else { dlc = "100";}

			}



			dlcsoln.setText(dlc); 		// This statement sets the value of the lean mix in the text box


		}

		// FLEXIBLE CODE

		else if (pavType.getValue().equals("Flexible")) {

			String gearF = gearDrop.getValue();
			String coveragesF = coveragesDrop.getValue();
			double acnF = Double.parseDouble(acnDesign.getText());
			double polyF = 0;	
			int cbr = Integer.parseInt(cbrDrop.getValue());
			String material = materialDrop.getValue();

			double matrix5[][] = 
				{
						{-0.0128*Math.pow(acnF,2) + 6.4842*acnF + 127.4725, -0.0127*Math.pow(acnF,2) + 6.5005*acnF + 145.1648, -0.0246*Math.pow(acnF,2) + 8.9962*acnF + 137.5000, - 0.0186*Math.pow(acnF,2) + 8.1131*acnF + 137.7622},
						{-0.0148*Math.pow(acnF,2) + 6.1930*acnF + 118.2967, -0.0134*Math.pow(acnF,2) + 6.0868*acnF + 130.7692, -0.0246*Math.pow(acnF,2) + 8.0871*acnF + 137.5000, - 0.0204*Math.pow(acnF,2) + 7.5612*acnF + 133.5664},
						{-0.0140*Math.pow(acnF,2) + 5.8323*acnF + 107.6374, -0.0153*Math.pow(acnF,2) + 5.1634*acnF + 109.6703, -0.0313*Math.pow(acnF,2) + 8.4981*acnF + 107.9167, - 0.0205*Math.pow(acnF,2) + 7.2902*acnF + 120.6294},
						{-0.0129*Math.pow(acnF,2) + 5.4435*acnF + 114.7253, -0.0129*Math.pow(acnF,2) + 5.6521*acnF + 111.5385, -0.0265*Math.pow(acnF,2) + 7.9167*acnF + 101.6667, - 0.0197*Math.pow(acnF,2) + 6.9930*acnF + 119.4056},
						{-0.0125*Math.pow(acnF,2) + 5.3610*acnF + 101.3187, -0.0129*Math.pow(acnF,2) + 5.4435*acnF + 114.7253, -0.0246*Math.pow(acnF,2) + 7.4811*acnF + 110.8333, - 0.0174*Math.pow(acnF,2) + 6.5097*acnF + 119.0559},
						{-0.0111*Math.pow(acnF,2) + 5.0869*acnF + 104.7253, -0.0115*Math.pow(acnF,2) + 5.2465*acnF + 103.4615, -0.0180*Math.pow(acnF,2) + 6.6610*acnF + 115.4167, - 0.0194*Math.pow(acnF,2) + 6.8444*acnF + 98.6014},
						{-0.0105*Math.pow(acnF,2) + 4.7464*acnF + 113.9560, -0.0111*Math.pow(acnF,2) + 5.0869*acnF + 104.7253, -0.0284*Math.pow(acnF,2) + 7.6553*acnF + 90.8333,  - 0.0190*Math.pow(acnF,2) + 6.6134*acnF + 102.7972},
						{-0.0105*Math.pow(acnF,2) + 4.8535*acnF + 100.3846, -0.0101*Math.pow(acnF,2) + 4.9573*acnF + 107.0879, -0.0256*Math.pow(acnF,2) + 7.3580*acnF + 88.7500, - 0.0150*Math.pow(acnF,2) + 6.1364*acnF + 101.3986},
						{-0.011675824*Math.pow(acnF,2) + 5.028846154*acnF + 90.87912088, -0.009473982*Math.pow(acnF,2) + 4.631908533*acnF + 111.0989011, -0.0199*Math.pow(acnF,2) + 6.7633*acnF + 89.5833, -0.017732268*Math.pow(acnF,2) + 6.301198801*acnF + 99.47552448},
						{-0.008686167*Math.pow(acnF,2) + 4.389786684*acnF + 103.956044, -0.009837589*Math.pow(acnF,2) + 4.797228507*acnF + 95.87912088, -0.0227*Math.pow(acnF,2) + 6.8939*acnF + 88.3333, -0.01486014*Math.pow(acnF,2) + 	5.885364635*acnF	 + 106.6433566},
						{-0.00779735*Math.pow(acnF,2) +	4.265433096*acnF + 104.8901099, -0.010322398*Math.pow(acnF,2) + 4.731940853*acnF + 95.10989011, -0.0180*Math.pow(acnF,2)	+ 6.2822*acnF + 98.7500, -0.016983017*Math.pow(acnF,2) + 	6.031468531*acnF	 + 96.32867133},
						{-0.009837589*Math.pow(acnF,2) + 4.475799935*acnF + 96.59340659, -0.008686167*Math.pow(acnF,2) + 4.389786684*acnF + 103.956044, -0.023674242*Math.pow(acnF,2) + 6.785984848*acnF + 82.91666667, -0.014985015*Math.pow(acnF,2) + 	5.834165834*acnF	 + 91.78321678},
						{-0.005999515*Math.pow(acnF,2) + 3.772422431*acnF + 112.8021978, -0.009473982*Math.pow(acnF,2) + 4.506908533*acnF + 96.0989011, -0.017045455*Math.pow(acnF,2) + 6.132575758*acnF + 85.83333333, -0.011738262*Math.pow(acnF,2) + 	5.26973027*acnF	 + 103.1468531}
				};

			double matrix7[][] = 
				{
						{-0.019089367*Math.pow(acnF,2) + 8.438227214*acnF + 182.7472527, -0.018261151*Math.pow(acnF,2) + 8.49321267*acnF + 189.8351648, -0.036931818*Math.pow(acnF,2) + 	11.7594697*acnF + 185.4166667, -0.026973027*Math.pow(acnF,2) + 10.50699301*acnF	+ 192.1328671},
						{-0.015534098*Math.pow(acnF,2) + 7.405098578*acnF + 159.3406593, -0.018988365*Math.pow(acnF,2) + 8.055995475*acnF + 155.8241758, -0.028409091*Math.pow(acnF,2) + 10.15530303*acnF + 165.8333333, -0.026973027*Math.pow(acnF,2) + 10.50699301*acnF	+ 192.1328671},
						{-0.016968326*Math.pow(acnF,2) + 7.214932127*acnF + 143.0769231, -0.017877343*Math.pow(acnF,2) + 7.547874919*acnF + 138.956044, -0.03125*Math.pow(acnF,2) + 	9.785984848*acnF	+ 149.5833333, -0.02047952*Math.pow(acnF,2) + 8.553946054*acnF	+ 157.1678322},
						{-0.016604719*Math.pow(acnF,2) + 7.03175501*acnF + 114.7252747, -0.017493536*Math.pow(acnF,2) + 7.191822883*acnF + 130.9340659, -0.03219697*Math.pow(acnF,2) + 	9.678030303*acnF + 124.1666667, -0.022977023*Math.pow(acnF,2) + 8.546453546*acnF	+ 138.8111888},
						{-0.014766484*Math.pow(acnF,2) + 6.514423077*acnF + 117.5824176, -0.015251293*Math.pow(acnF,2) + 6.699135423*acnF + 116.8131868, -0.015251293*Math.pow(acnF,2) + 6.699135423*acnF + 116.8131868, -0.020104895*Math.pow(acnF,2) + 7.828421578*acnF	+ 142.1328671},
						{-0.013675663*Math.pow(acnF,2) + 6.17917744*acnF + 110.3846154, -0.015433096*Math.pow(acnF,2) + 6.505009696*acnF + 113.8461538, -0.024621212*Math.pow(acnF,2) + 8.359848485*acnF + 122.5, -0.020104895*Math.pow(acnF,2) + 7.828421578*acnF	+ 117.1328671},
						{-0.012342437*Math.pow(acnF,2) + 5.769432773*acnF + 117.1428571, -0.013796865*Math.pow(acnF,2) + 6.162855527*acnF + 107.6923077, -0.022727273*Math.pow(acnF,2) + 8.03030303*acnF + 113.3333333, -0.019230769*Math.pow(acnF,2) + 7.445054945*acnF	+ 125},
						{-0.010746606*Math.pow(acnF,2) + 5.469457014*acnF + 114.6153846, -0.012726244*Math.pow(acnF,2) + 5.875484809*acnF + 110.1648352, -0.026515152*Math.pow(acnF,2) + 8.189393939*acnF + 111.6666667, -0.019230769*Math.pow(acnF,2) + 7.445054945*acnF	+ 100},
						{-0.012039431*Math.pow(acnF,2) + 5.551308985*acnF + 107.0879121, -0.010746606*Math.pow(acnF,2) + 5.469457014*acnF + 114.6153846, -0.018939394*Math.pow(acnF,2) + 7.325757576*acnF + 110, -0.021103896*Math.pow(acnF,2) + 7.501248751*acnF +	100.1748252},
						{-0.011797027*Math.pow(acnF,2) + 5.369667098*acnF + 104.6153846, -0.012039431*Math.pow(acnF,2) + 5.551308985*acnF + 107.0879121, -0.03125*Math.pow(acnF,2) + 8.498106061*acnF + 82.91666667, -0.017107892*Math.pow(acnF,2) +  6.886863137*acnF  + 104.5454545},
						{-0.009150776*Math.pow(acnF,2) + 4.973052683*acnF + 107.8021978, -0.012180834*Math.pow(acnF,2) + 5.475719134*acnF + 97.63736264, -0.025568182*Math.pow(acnF,2) + 7.78219697*acnF + 90.41666667, -0.017232767*Math.pow(acnF,2) + 	6.753246753*acnF  + 105.0699301},
						{-0.010544602*Math.pow(acnF,2) + 4.972850679*acnF + 109.3406593, -0.011110213*Math.pow(acnF,2) + 5.295491273*acnF + 101.5384615, -0.026515152*Math.pow(acnF,2) +  7.689393939*acnF + 91.66666667, -0.018106893*Math.pow(acnF,2) + 	6.779470529*acnF  +  97.2027972}, 
						{-0.009776988*Math.pow(acnF,2) + 4.957175178*acnF + 97.58241758, -0.011675824*Math.pow(acnF,2) + 5.153846154*acnF + 105.8791209, -0.024621212*Math.pow(acnF,2) +  7.481060606*acnF + 85.83333333, -0.01510989*Math.pow(acnF,2) + 	6.332417582*acnF  + 100}
				};

			if (material.equals("HSBBM")){

				if (coveragesF.equals ("Low") && ( gearF.equals("Single") || gearF.equals("Dual") || gearF.equals("Dual-tandem") ) ){
					polyF = matrix5[cbr-3][0]; 
				}

				else if (coveragesF.equals("Low") && gearF.equals("Tridem") ) {
					polyF = matrix5[cbr-3][1]; 
				}

				else if (coveragesF.equals("Medium") && ( gearF.equals("Single") || gearF.equals("Dual") ) ) {
					polyF = matrix5[cbr-3][2]; 
				}

				else if (coveragesF.equals("Medium") && gearF.equals("Dual-tandem") || gearF.equals("Tridem"))  {
					polyF = matrix5[cbr-3][3]; 
				}

				else {
					polyF=888;	
				}

				double answer = polyF;
				answer = (Math.round(answer/25.0))*25.0;
				int answer1 = (int) answer;
				String answer2 = String.valueOf(answer1);

				surfacesoln.setText("100");
				bindersoln.setText(answer2);
				gsbflexsoln.setText("100");
			}

			else if (material.equals("BBM")){

				if (coveragesF.equals ("Low") && ( gearF.equals("Single") || gearF.equals("Dual") || gearF.equals("Dual-tandem") ) ){
					polyF = matrix7[cbr-3][0]; 
				}

				else if (coveragesF.equals("Low") && gearF.equals("Tridem") ) {
					polyF = matrix7[cbr-3][1]; 
				}

				else if (coveragesF.equals("Medium") && ( gearF.equals("Single") || gearF.equals("Dual") ) ) {
					polyF = matrix7[cbr-3][2]; 
				}

				else if (coveragesF.equals("Medium") && gearF.equals("Dual-tandem") || gearF.equals("Tridem"))  {
					polyF = matrix7[cbr-3][3]; 
				}

				else {
					polyF=888;	
				}

				double answer = polyF;
				answer = (Math.round(answer/25.0))*25.0;
				int answer1 = (int) answer;
				String answer2 = String.valueOf(answer1);

				surfacesoln.setText("100");
				bindersoln.setText(answer2);
				gsbflexsoln.setText("100");
			}

		}



	}

	public void reset(ActionEvent event1) {

		acnDesign.clear();
		surfacesoln.clear();
		bindersoln.clear();
		gsbflexsoln.clear();
		pqsoln.clear();
		dlcsoln.clear();
		gsbrigidsoln.clear();

		pavType.valueProperty().set(null);
		cbrDrop.valueProperty().set(null);
		cbrDrop.setDisable(false);
		kDrop.valueProperty().set(null);
		kDrop.setDisable(false);
		materialDrop.valueProperty().set(null);
		materialDrop.setDisable(false);
		concreteDrop.valueProperty().set(null);
		concreteDrop.setDisable(false);
		gearDrop.valueProperty().set(null);
		coveragesDrop.valueProperty().set(null);

	}

}


