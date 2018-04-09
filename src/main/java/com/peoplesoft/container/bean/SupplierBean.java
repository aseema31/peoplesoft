package main.java.com.peoplesoft.container.bean;

public class SupplierBean {
	private String supplierName;
	private String shortSupplierName;
	private String supplierId;
	private String supplierLocation;
    
	public SupplierBean(String supplierName, String supplierId) {
		// TODO Auto-generated constructor stub
//		this.supplierId = supplierId;
		this.supplierName = supplierName;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getShortSupplierName() {
		return shortSupplierName;
	}

	public void setShortSupplierName(String shortSupplierName) {
		this.shortSupplierName = shortSupplierName;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierLocation() {
		return supplierLocation;
	}

	public void setSupplierLocation(String supplierLocation) {
		this.supplierLocation = supplierLocation;
	}
}
