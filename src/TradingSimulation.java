import company.CompanyController;
import investor.SetInvestor;
import report.ReportFacade;
import transaction.TransactionController;

import java.util.Scanner;

import static report.ReportFacade.ReportType.*;


// Author: Gamaliel Munoz Fraginals/2017092


public class TradingSimulation {

	CompanyController sc = new CompanyController();
	SetInvestor si = new SetInvestor();
	TransactionController st;
	Scanner kB = new Scanner(System.in);
	ReportFacade rs = new ReportFacade(sc, si, st);

	// The method below is going to create all the companies and investors once the program has started running!
	public void genesis() {

		System.out.println("✼✼✼✼✼ Companies and Investors are being created dynamically ✼✼✼✼✼\n");

		sc.setCompany();
		si.setInvestor();
		st = new TransactionController(sc, si);

		System.out.println(" ❃❃❃❃❃❃❃ 100 companies and investors have been created! ❃❃❃❃❃❃❃ \n");

	}

	// The option number 1 allows the user to start creating all the transactions
	public void menu() {

		System.out.println(
				"\n✵✵✵✵✵✵✵✵✵✵✵✵✵✵✵✵✵ Trading Day Menu ✵✵✵✵✵✵✵✵✵✵✵✵✵✵✵✵✵ " + "\n ➢ Please select [1] to start running the simulation day.");

		switch (kB.nextInt()) {
		case 1: {
			tradingDay();

		}
			break;
		default: {
			System.out.println("This is an incorrect choice, please try again");
			menu();
		}
		}

	}

	public void tradingDay() {

		//The following allow us to create the transactions
		st.makeTransaction();
		int number = st.transactionSold;
		System.out.println("\n✣✣✣✣✣✣✣✣✣✣✣ All the transactions have been generated successfully! ✣✣✣✣✣✣✣✣✣✣"
				+ "\n The total amount of transactions is: " + number);

		submenu();
	}

	// Displaying the menu for the user with 5 different options!
	public void submenu() {
		System.out.println("\n ⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂ Trading Day Menu ⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂ "
				+ "\n ➢ Please select [1] to show the Company with the highest capital: "
				+ "\n ➢ Please select [2] to display the Company with the lowest capital:  "
				+ "\n ➢ Please select [3] to show the investor with the highest number of shares: "
				+ "\n ➢ Please select [4] to display the investor with the lowest number of shares: "
				+ "\n ➢ Please select [5] to exit the program.");

		switch (kB.nextInt()) {
			case 1: {
				rs.generateReport(HIGHEST_CAPITAL);//Option 1
				submenu();
			}
			break;
			case 2: {
				rs.generateReport(LOWEST_CAPITAL);//Option 2
				submenu();
			}
			break;
			case 3: {
				rs.generateReport(HIGHEST_SHARES);//Option 3
				submenu();
			}
			break;
			case 4: {
				rs.generateReport(LOWEST_SHARES);//Option 4
				submenu();
			}
			break;
			case 5: {
				System.exit(5);//Option 5
			}
			break;
			default: {
				System.out.println("This is an incorrect choice, please try again");
				submenu();
			}
		}
	}
}
