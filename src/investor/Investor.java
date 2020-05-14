package investor;

// Author: Gamaliel Munoz Fraginals/2017092


public class Investor{

	// Here I am declaring all the Investor's attributes as private
	private int inv_id;
	private int inv_share;
	private double budget;


	private Investor(int inv_id, int inv_share, double budget){ // The private investor constructor is being defined!
		this.inv_id = inv_id;
		this.inv_share = inv_share;
		this.budget = budget;

	}

	// Setting up getters and setters in order to be able to either access values or modify them!
	public int getInv_id(){
		return inv_id;
	}

	public void setInv_id(int inv_id){
		this.inv_id = inv_id;
	}
	public int getInv_share(){
		return inv_share;
	}

	public void setInv_share(int inv_share){
		this.inv_share = inv_share;
	}

	public double getBudget(){
		return budget;
	}

	public void setBudget(double budget){
		this.budget = budget;
	}

	// Method which will allow us to print the values regarding objects
	@Override
	public String toString(){
		return "Investor Id: " + inv_id + " Number of shares invested: " + inv_share + " Budget: " + budget;
	}
	// Builder Pattern. Generating a nested static Investor builder class!!
	public static class InvestorBuilder{

		private int inv_id;
		private int inv_share;
		private double budget;


		public InvestorBuilder(int inv_id, int inv_share, double budget){// Here the constructor is being created for the inner class
			this.inv_id = inv_id;
			this.inv_share = inv_share;
			this.budget = budget;
		}

		// This method will allow to create the object transferring the values to the outer class!
		public Investor build(){
			return new Investor(inv_id, inv_share, budget);
		}
	}
}
