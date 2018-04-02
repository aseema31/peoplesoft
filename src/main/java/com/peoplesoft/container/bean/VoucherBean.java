package main.java.com.peoplesoft.container.bean;

public class VoucherBean {

	private String businessUnitId;
	private String voucherId;
	private String voucherStyle;
	private SupplierBean supplier;
	private InvoiceBean invoiceBean;
	private String freighhtAmount;
	private String salesTaxAmount;
	private String miscChargeAmount;	
	private String poBusinessUnit;
	private String poNumber;
	private boolean isTaxExempt;
	
	public VoucherBean() {
		// TODO Auto-generated constructor stub
	}

	public String getBusinessUnitId() {
		return businessUnitId;
	}

	public void setBusinessUnitId(String businessUnitId) {
		this.businessUnitId = businessUnitId;
	}

	public String getVoucherId() {
		return voucherId;
	}

	public void setVoucherId(String voucherId) {
		this.voucherId = voucherId;
	}

	public String getVoucherStyle() {
		return voucherStyle;
	}

	public void setVoucherStyle(String voucherStyle) {
		this.voucherStyle = voucherStyle;
	}

	public SupplierBean getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierBean supplier) {
		this.supplier = supplier;
	}

	public InvoiceBean getInvoiceBean() {
		return invoiceBean;
	}

	public void setInvoiceBean(InvoiceBean invoiceBean) {
		this.invoiceBean = invoiceBean;
	}

	public String getFreighhtAmount() {
		return freighhtAmount;
	}

	public void setFreighhtAmount(String freighhtAmount) {
		this.freighhtAmount = freighhtAmount;
	}

	public String getSalesTaxAmount() {
		return salesTaxAmount;
	}

	public void setSalesTaxAmount(String salesTaxAmount) {
		this.salesTaxAmount = salesTaxAmount;
	}

	public String getMiscChargeAmount() {
		return miscChargeAmount;
	}

	public void setMiscChargeAmount(String miscChargeAmount) {
		this.miscChargeAmount = miscChargeAmount;
	}

	public String getPoBusinessUnit() {
		return poBusinessUnit;
	}

	public void setPoBusinessUnit(String poBusinessUnit) {
		this.poBusinessUnit = poBusinessUnit;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public boolean isTaxExempt() {
		return isTaxExempt;
	}

	public void setTaxExempt(boolean isTaxExempt) {
		this.isTaxExempt = isTaxExempt;
	}
	
}


