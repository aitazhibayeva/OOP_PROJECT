package Instruments;

import java.util.Date;
import java.util.Objects;

import Enums.*;
import Users.*;

public class Payment {
	private Student student;
	private PaymentType paymentType;
	private Date dateOfPayment;
	private double amount;
	
	public Payment(Student student, PaymentType paymentType, Date dateOfPayment, double amount) {
		this.student = student;
		this.paymentType =paymentType;
		this.dateOfPayment = dateOfPayment;
		this.amount = amount;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public Date getDateOfPayment() {
		return dateOfPayment;
	}

	public void setDateOfPayment(Date dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String toString() {
		return "Payment student = " + student + ", paymentType = " + paymentType + ", dateOfPayment = " + dateOfPayment
				+ ", amount = " + amount;
	}

	public int hashCode() {
		return Objects.hash(amount, dateOfPayment, student,paymentType);
	}

	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Payment other = (Payment) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Objects.equals(dateOfPayment, other.dateOfPayment) && Objects.equals(student, other.student)
				&& paymentType == other.paymentType;
	}
}
