package company;

// Author: Gamaliel Munoz Fraginals/2017092

//Implementing the CompanyInterface

public class Company implements CompanyInterface {

	// Here I'm declaring all the attributes that the company is going to have
	private int c_id;
	private int share;
	private double price;
	private int shareSold;

	// Defining a private company constructor
	private Company(int c_id, int share, double price, int shareSold) {
		this.c_id = c_id;
		this.share = share;
		this.price = price;
		this.shareSold = shareSold;
	}

	// Setting up getters and setters in order to be able to either access values or modify them!
	public int getCid(){
		return c_id;
	}

	public void setCid(int c_id){
		this.c_id = c_id;
	}

	public int getShare(){
		return share;
	}

	public void setShare(int share){
		this.share = share;
	}

	public double getPrice(){
		return price;
	}

	public void setPrice(double price){
		this.price = price;
	}

	//Here I am dynamically calculating the capital: number of shares * latest price
	public double getCapital(){
		return share * price;
	}

	public int getShareSold(){
		return shareSold;
	}

	public void setShareSold(int shareSold){
		this.shareSold = shareSold;
	}



	// Method which will allow us to print the values regarding objects
	@Override
	public String toString() {
		return "Company Id: " + c_id + " Number of Share: " + share + " Price of Shares: " + price +
				" Capital: " + getCapital() + " Number of Shares Sold: " + shareSold;
	}

	// Builder Pattern. Generating a nested static Company builder class!
	public static class CompanyBuilder{

		private int c_id;
		private int share;
		private double price;
		private int shareSold;

		// Here I am creating the constructor for the inner class
		public CompanyBuilder(int c_id, int share, double price, int shareSold){
			this.c_id = c_id;
			this.share = share;
			this.price = price;
			this.shareSold = shareSold;
		}

		// This method will allow to create the object transferring the values to the outer class
		public Company build(){
			return new Company(c_id, share, price, shareSold);
		}

	}

}
