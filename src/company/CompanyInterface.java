package company;

// Author: Gamaliel Munoz Fraginals/2017092

//abstract methods

public interface CompanyInterface {

    int getCid();
    void setCid(int c_id);

    int getShare();
    void setShare(int share);

    double getPrice();
    void setPrice(double price);

    int getShareSold();
    void setShareSold(int shareSold);

    double getCapital();
}
