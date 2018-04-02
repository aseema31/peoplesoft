package main.java.com.peoplesoft.container.bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InvoiceBean {
	private String invoiceNumber;
	private String invoiceDate;
	private int invoiceAmount;
	
	public InvoiceBean(String invoiceNumber, int invoiceAmount) {
		// TODO Auto-generated constructor stub
		this.invoiceNumber = invoiceNumber;
		this.invoiceAmount = invoiceAmount;
		this.invoiceDate = getDate();
	}
	
 private String getDate()
 {
	 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate localDate = LocalDate.now();
	return dtf.format(localDate); //2016/11/16
 }

public String getInvoiceNumber() {
	return invoiceNumber;
}

public void setInvoiceNumber(String invoiceNumber) {
	this.invoiceNumber = invoiceNumber;
}

public String getInvoiceDate() {
	return invoiceDate;
}

public void setInvoiceDate(String invoiceDate) {
	this.invoiceDate = invoiceDate;
}

public int getInvoiceAmount() {
	return invoiceAmount;
}

public void setInvoiceAmount(int invoiceAmount) {
	this.invoiceAmount = invoiceAmount;
}
}
