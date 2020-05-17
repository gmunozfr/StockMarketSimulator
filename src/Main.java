// Author: Gamaliel Munoz Fraginals/2017092




public class Main {
	public static void main(String[] args) {
		// When the program starts running it will show a message telling the user
		// that companies and investors are being created dynamically and
		// afterwards it will display another message saying that companies and investors have been created!
		TradingSimulation td = new TradingSimulation();
		td.genesis();
		td.menu();
	}
}
