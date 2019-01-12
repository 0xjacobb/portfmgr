package portfmgr.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Entity class for persistence of transaction information in an embedded database
 *
 * @author: Pascal Rohner
 */

@Entity
public class Transaction {
	
	/*
	 * Id serves as unique key, it is unique and is automatically generated when
	 * adding a transaction to the database.
	 */
	@Id
	@Column(unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String cryptoCurrency;
	private String fiatCurrency;
	private Double numberOfCoins;
	private Double price;
	private LocalDate transactionDate;
	private String type;
	private Double fees;
	private Double total;
	
	@ManyToOne
	private Portfolio portfolio;
 
	/*
	 * Empty constructor
	 * 
	 */
	public Transaction() {};
	
	/*
	 * Overloaded constructor with some initial data
	 * 
	 */
	
	public Transaction(String cryptoCurrency, String fiatCurrency, Double numberOfCoins, Double price, LocalDate transactionDate, String type,
			Double fees, Double total) {
		super();
		this.cryptoCurrency = cryptoCurrency;
		this.fiatCurrency = fiatCurrency;
		this.numberOfCoins = numberOfCoins;
		this.price = price;
		this.transactionDate = transactionDate;
		this.type = type;
		this.fees = fees;
		this.total = total;
	}
	
	
	/*
	 * Method to query the primary key
	 * 
	 * @return Auto-generated primary key as a String
	 */
	public Long getId() {
		return id;
	}


	/*
	 * Method to query the currency
	 * 
	 * @return currency as a String
	 */
	public String getCurrency() {
		return cryptoCurrency;
	}

	/*
	 * Method to set the currency
	 * 
	 * @param currency as a String
	 */
	public void setCurrency(String currency) {
		this.cryptoCurrency = currency;
	}
	
	/*
	 * Method to query the moneytary (= W�hrung)
	 * 
	 * @return moneytary as a String
	 */
	public String getMoneytary() {
		return fiatCurrency;
	}
	
	/*
	 * Method to set the moneytary
	 * 
	 * @param moneytary as a String
	 */
	public void setMoneytary(String moneytary) {
		this.fiatCurrency = moneytary;
	}

	/*
	 * Method to query the number of coins
	 * 
	 * @return number of Coins as Double
	 */
	public Double getNumberOfCoins() {
		return numberOfCoins;
	}
	
	/*
	 * Method to set the number of coins
	 * 
	 * @param number of Coins as Double
	 */
	public void setNumberOfCoins(Double numberOfCoins) {
		this.numberOfCoins = numberOfCoins;
	}

	/*
	 * Method to query the price
	 * 
	 * @return price as Double
	 */
	public Double getPrice() {
		return price;
	}
	
	/*
	 * Method to set the price 
	 * 
	 * @param price as Double
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/*
	 * Method to query the transaction date
	 * 
	 * @return date of the transaction as Date
	 */
	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	/*
	 * Method to set the transaction date
	 * 
	 * @param date of the transaction as Date
	 */
	public void setTransactionDate(LocalDate localDate) {
		this.transactionDate = localDate;
	}

	/*
	 * Method to query the type of transaction (Buy or Sell)
	 * 
	 * @return type of transaction as String
	 */
	public String getType() {
		return type;
	}

	/*
	 * Method to set the type of transaction (Buy or Sell)
	 * 
	 * @param type of transaction as String
	 */
	public void setType(String type) {
		this.type = type;
	}

	/*
	 * Method to query the fees
	 * 
	 * @return fees as Double
	 */
	public Double getFees() {
		return fees;
	}

	/*
	 * Method to set the fees 
	 * 
	 * @param fees as Double
	 */
	public void setFees(Double fees) {
		this.fees = fees;
	}

	/*
	 * Method to query the Portfolio
	 * 
	 * @return portfolio as Portfolio
	 */
	public Portfolio getPortfolio() {
		return portfolio;
	}

	/*
	 * Method to set the fees in CHF
	 * 
	 * @param portfolio as Portfolio
	 */
	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}
	
	/*
	 * Method to set the total
	 * 
	 * @param total as Double
	 */
	public void setTotal(Double total) {
		this.total = total;
	}
	
	/*
	 * Method overrides the toString-Method
	 * 
	 * @return id, currency and portfolio
	 */
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", currency=" + cryptoCurrency + ", portfolio=" + portfolio + "]";
	}
	
	

	
	
	
	
	
	
	
	
	
	
}
