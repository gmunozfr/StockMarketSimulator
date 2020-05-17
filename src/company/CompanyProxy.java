package company;

// Author: Gamaliel Munoz Fraginals/2017092

//Adding extra logic
//Proxy Pattern. Implementing the CompanyInterface


public class CompanyProxy implements CompanyInterface {

    private Company company;

    public CompanyProxy(Company company){
        this.company = company;
    }

    // Setting up getters and setters in order to be able to either access values or modify them!
    @Override
    public int getCid(){
        return company.getCid();
    }

    @Override
    public void setCid(int c_id){
        company.setCid(c_id);
    }

    @Override
    public int getShare(){
        return company.getShare();
    }

    @Override
    public void setShare(int share){
        company.setShare(share);
    }

    @Override
    public double getPrice(){
        return company.getPrice();
    }

    @Override
    public void setPrice(double price){
        company.setPrice(price);
    }

    @Override
    public int getShareSold(){
        return company.getShareSold();
    }

    @Override
    public void setShareSold(int shareSold){
        company.setShareSold(shareSold);

        //This second condition double the price of a company share
        //every 10th times they sell a share
        if (shareSold != 0 && shareSold % 10 == 0) {
            company.setPrice(company.getPrice() * 2);
        }
    }

    @Override
    public double getCapital(){
        return company.getCapital();
    }
}
