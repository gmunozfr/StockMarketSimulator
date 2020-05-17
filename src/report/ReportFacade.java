package report;

import company.Company;
import company.CompanyController;
import investor.Investor;
import investor.SetInvestor;
import transaction.TransactionController;

import java.util.List;



// Author: Gamaliel Munoz Fraginals/2017092

//Implementing the Facade Pattern


public class ReportFacade {
    public static enum ReportType {
        HIGHEST_CAPITAL, LOWEST_CAPITAL, HIGHEST_SHARES, LOWEST_SHARES;
    }

    private CompanyController sc;
    private SetInvestor si;
    private TransactionController st; //Can be used to build reports on transactions

    //Creating the public constructor
    public ReportFacade(CompanyController sc, SetInvestor si, TransactionController st) {
        this.sc = sc;
        this.si = si;
        this.st = st;
    }
    //Generating report for an specific report type
    public void generateReport(ReportType reportType) {
        switch (reportType) {
            case HIGHEST_CAPITAL: highestCapital(); break;
            case LOWEST_CAPITAL: lowestCapital(); break;
            case HIGHEST_SHARES: highestShares(); break;
            case LOWEST_SHARES: lowestShares(); break;
        }
    }

    private void highestCapital(){

        System.out.println("The Company with the highest capital is:");

        List<Company> companies = sc.getCompanies();
        double maxCap = -1.0;
        //Using a loop to find the highest capital value
        for (Company c : companies) {
            if (c.getCapital() > maxCap) maxCap = c.getCapital();
        }
        //finding companies that have the highest capital, can be more than 1 company
        for (Company c : companies) {
            if (c.getCapital() == maxCap) {
                //Formatting numbers. Limit capital to 2 decimal points
                System.out.format("Company ID: %d, Capital: %.2f\n", c.getCid(), c.getCapital());
            }
        }
    }

    private void lowestCapital() {
        System.out.println("The Company with the lowest capital is:");
        List<Company> companies = sc.getCompanies();
        double minCap = Double.MAX_VALUE;
        //Using a loop to find the lowest capital value
        for (Company c : companies) {
            if (c.getCapital() < minCap) minCap = c.getCapital();
        }
        //finding companies that have the lowest capital, can be more than 1 company
        for (Company c : companies) {
            if (c.getCapital() == minCap) {
                //Formatting numbers. Limit capital to 2 decimal points
                System.out.format("Company ID: %d, Capital: %.2f\n", c.getCid(), c.getCapital());
            }
        }
    }

    private void highestShares() {
        System.out.println("The Investor with the highest number of shares is:");

        List<Investor> investors = si.getInvestors();
        int maxShares = -1;
        //Using a loop to find the highest amount of shares
        for (Investor i : investors) {
            if (i.getInv_share() > maxShares) maxShares = i.getInv_share();
        }
        //finding investors that have the highest amount of shares, can be more than 1 investor
        for (Investor i : investors) {
            if (i.getInv_share() == maxShares) {
                System.out.println("Investor ID: " + i.getInv_id() + ", Number of Shares: " + i.getInv_share());
            }
        }
    }

    private void lowestShares() {
        System.out.println("Investor with the lowest number of shares is:");

        List<Investor> investors = si.getInvestors();
        int minShares = Integer.MAX_VALUE;
        //Using a loop to find the lowest amount of shares
        for (Investor i : investors) {
            if (i.getInv_share() < minShares) minShares = i.getInv_share();
        }
        //finding investors that have the lowest amount of shares, can be more than 1 investor
        for (Investor i : investors) {
            if (i.getInv_share() == minShares) {
                System.out.println("Investor ID: " + i.getInv_id() + ", Number of Shares: " + i.getInv_share());
            }
        }
    }
}
