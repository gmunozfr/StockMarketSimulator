package transaction;

import company.Company;
import company.CompanyInterface;
import company.CompanyProxy;
import company.CompanyController;
import investor.Investor;
import investor.SetInvestor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


// Author: Gamaliel Munoz Fraginals/2017092

public class TransactionController{

    private final List<Transaction> transactions = new ArrayList<>();
    private final List<CompanyInterface> companies;
    private final List<Investor> investors;

    //Here I am defining the global variables
    Random rnd = new Random();
    double lowestPrice;
    double highestBudget;
    int highestShare;
    public int transactionSold = 0;

    public TransactionController(CompanyController companyController, SetInvestor setInvestor) {
        companies = new ArrayList<>();
        for (Company c : companyController.getCompanies()){
            companies.add(new CompanyProxy(c));
        }
        investors = setInvestor.getInvestors();
    }

    //The following is checking and returning the lowest share price from a company
    public double getLowestPrice() {

        lowestPrice = companies.get(0).getPrice();

        for (int i = 0; i < 100; i++) {

            if (companies.get(i).getPrice() < lowestPrice) {
                lowestPrice = companies.get(i).getPrice();
            }

        }

        return lowestPrice;// getting the lowest price
    }

    //Here is checking and returning the highest budget with regards to investors
    public double getHighestBudget() {

        highestBudget = investors.get(0).getBudget();

        for (int i = 0; i < 100; i++) {

            if (investors.get(i).getBudget() > highestBudget) {
                highestBudget = investors.get(i).getBudget();
            }

        }

        return highestBudget;// obtaining the highest budget

    }
    //Checking for any company with the biggest amount of shares!
    public double getHighestShares() {

        highestShare = companies.get(0).getShare();

        for (int i = 0; i < 100; i++) {

            if (companies.get(i).getShare() > highestShare) {
                highestShare = companies.get(i).getShare();
            }

        }

        return highestShare;//getting the biggest amount of shares

    }
    //Setting up the values in regards to each transaction while the actual Transaction is being implemented!
    public void makeTransaction() {

        try {

            //Checking conditions for the transaction to be implemented:
            //firstly it makes sure if there is any money in the budget,
            //Secondly, if there are shares to buy,
            //Thirdly, comparing if the highest budget can buy a share having the lowest price
            while (getHighestBudget() != 0 && getHighestBudget() >= getLowestPrice() && getHighestShares() != 0) {

                //Here is randomly selecting an investor and a company
                int x = rnd.nextInt(100);
                int y = rnd.nextInt(100);

                int cs = companies.get(x).getShare();//obtaining the current number of shares for a company
                double cp = companies.get(x).getPrice();//getting the current price of a share
                int ss = companies.get(x).getShareSold();//obtaining the number of shares sold by a company

                double ib = investors.get(y).getBudget();//Obtaining the amount of money an investor can afford
                int is = investors.get(y).getInv_share();//Getting the number of shares of an investor

                //Checking for all the transactions:
                //Reducing by 2% the price when no company has sold a share while 10 transactions
                //have being implemented!!
                if (transactionSold != 0 && transactionSold % 10 == 0) {
                    for (int i = 0; i < 100; i++) {
                        double c = companies.get(i).getShareSold();
                        double p = companies.get(i).getPrice();
                        if (c == 0) {
                            companies.get(i).setPrice(p * 0.98);//reduction of 2% of the price
                        }
                    }
                }

                //Making sure if the investor's budget is bigger or equal in order to buy a share from a company!
                double cp2 = companies.get(x).getPrice();
                if (cs > 0 && ib >= cp2){
                    companies.get(x).setShare(cs - 1);//Setting up company shares having a new value
                    companies.get(x).setShareSold(ss + 1);//Adding 1 to the count of the company sharesSold

                    investors.get(y).setBudget(ib - cp2);//Setting up the investor budget having a new value
                    investors.get(y).setInv_share(is + 1); //Adding 1 share regarding the investor's id

                    transactionSold++;//add 1 to the entire amount of the implemented transactions

                    //Checking for transaction already implemented!
                    Transaction tra = new Transaction.TransactionBuilder(transactionSold, investors.get(y).getInv_id(),
                            companies.get(x).getCid(), cp2).build();
                    transactions.add(tra);
                    System.out.println(tra);
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Transaction> getTransactions(){
        return transactions;
    }

    public void test(){
        System.out.println(companies.get(0));
    }
}
