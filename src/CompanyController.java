import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Author: Gamaliel Munoz Fraginals/2017092


public class CompanyController{

    private final List<Company> companies = new ArrayList<>();

	Random rnd = new Random();

	// The following method is implemented to dynamically generate 100 companies having a unique Id,
	// and using random values regarding the number of shares and price.

	public void setCompany(){

		for (int i = 0; i < 100; i++) {//100 companies

			int c_id = i + 1;
			int share = rnd.nextInt(501) + 500;//Random number of shares
			double price = rnd.nextInt(91) + 10;//Random share price
			int shareSold = 0;


            // Implementing the builder method to obtain every value created previously
            // Assigning the object to generate it!

			Company cia = new Company.CompanyBuilder(c_id, share, price, shareSold).build();
			companies.add(cia);

		}

	}

	public List<Company> getCompanies(){
		return companies;
	}
}
