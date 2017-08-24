package ATM1;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Account1 implements Serializable{
	// �����ɹ�
	public static final int SUCCESS = 0;
	// �����Ϊ����
	public static final int NEGATIVE_DEPOSITE = 1;
	// ȡ�����������
	public static final int BEYOND_BALANCE = 2;
	// ȡ����Ϊ����
	public static final int NEGATIVE_WITHDRAW = 3;

	private int id;// �û�id
	private double balance;// �û����
	private double annualInterestRate;// ������
	private Date dateCreated;// ��������

	// ���췽��
	public Account1() {

	}

	public Account1(int newId, double newBalance) {
		setId(newId);
		setBalance(newBalance);
	}

	// id���������޸���
	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (id >= 0)
			this.id = id;
	}

	// balance���������޸���
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		if (balance >= 0)
			this.balance = new Double(String.format("%.2f", balance));
	}

	// annualInterestRate���������޸���
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	// dateCreated������
	public Date getDateCreated() {
		return dateCreated;
	}

	// ��ȡ������
	public double getMonthlyInterestRate() {
		return getAnnualInterestRate() / 12;
	}

	/**
	 * ȡ�� ���ݲ�ͬ���������ز�ͬ��ֵ
	 * 
	 * @param amount
	 * @return
	 */
	public int withdraw(double amount) {
		if (amount < 0)// ȡ����С��0
			return NEGATIVE_WITHDRAW;
		if (amount > this.balance)// ȡ�����������
			return BEYOND_BALANCE;

		this.balance -= amount;// �����ɹ�
		return SUCCESS;
	}

	/**
	 * ��� ���ݲ�ͬ���������ز�ͬ��ֵ
	 * 
	 * @param amount
	 * @return
	 */
	public int deposit(double amount) {
		if (amount < 0)// �����С��0
			return NEGATIVE_DEPOSITE;

		this.balance += amount;// �����ɹ�
		return SUCCESS;
	}

}
