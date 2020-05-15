package investor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Author: Gamaliel Munoz Fraginals/2017092

public class SetInvestor{

    private final List<Investor> investors = new ArrayList<>();

    Random rnd = new Random();

    // The following method helps to dynamically generate 100 investors having a unique Id,
    // and considering a random budget between 1000 and 10000

    public void setInvestor(){

        for (int i = 0; i < 100; i++){//100 investors
            int inv_id = i + 1;
            double budget = rnd.nextInt(9001) + 1000;//creating budget between 1000 and 10000
            int inv_share = 0;

            // Implementing the builder method to obtain every value created previously
            // Assigning the object to generate it!
            Investor inv = new Investor.InvestorBuilder(inv_id, inv_share, budget).build();
            investors.add(inv);
        }
    }
    public List<Investor> getInvestors(){
        return investors;
    }
}

