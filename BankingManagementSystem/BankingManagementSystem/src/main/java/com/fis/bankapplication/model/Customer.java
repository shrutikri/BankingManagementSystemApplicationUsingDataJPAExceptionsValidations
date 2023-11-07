package com.fis.bankapplication.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Customer {

	@Id
	@Min(value = 6, message = "Account Number Cannot be less than 6")
	//@Max(value = 10, message = "Account Number cannot be greater than 10") // MANVE
	private int accNo;
	@Size(min = 3, max = 20, message = "Customer name length must be between 3-20")
	@NotBlank(message = "Customer name cannot be blank or whitespace")
	private String custName;
	private long mobileNo;
	@NotBlank(message = "Customer email id cannot be blank or whitespace")
	private String emailId;
	//@Max(value = 12, message = "Aadhar number cannot be greater than 12")
	private long aadharNo;
	//@Past(message="Customer date of birth must be in past")
	private String dob;
	private String residentialAdd;
	private String permanentAdd;
	@NotBlank(message = "Account type cannot be null or whitespace")
	private String accType;

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(long aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getResidentialAdd() {
		return residentialAdd;
	}

	public void setResidentialAdd(String residentialAdd) {
		this.residentialAdd = residentialAdd;
	}

	public String getPermanentAdd() {
		return permanentAdd;
	}

	public void setPermanentAdd(String permanentAdd) {
		this.permanentAdd = permanentAdd;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	@Override
	public String toString() {
		return "Customer [accNo=" + accNo + ", custName=" + custName + ", mobileNo=" + mobileNo + ", emailId=" + emailId
				+ ", aadharNo=" + aadharNo + ", dob=" + dob + ", residentialAdd=" + residentialAdd + ", permanentAdd="
				+ permanentAdd + ", accType=" + accType + "]";
	}

	public Customer(int accNo, String custName, long mobileNo, String emailId, long aadharNo, String dob,
			String residentialAdd, String permanentAdd, String accType) {
		super();
		this.accNo = accNo;
		this.custName = custName;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.aadharNo = aadharNo;
		this.dob = dob;
		this.residentialAdd = residentialAdd;
		this.permanentAdd = permanentAdd;
		this.accType = accType;
	}

	public Customer() {

	}

}
