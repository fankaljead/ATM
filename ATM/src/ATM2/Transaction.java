package ATM2;

import java.io.Serializable;
import java.util.Date;

public class Transaction implements Serializable{
	//����
	public static final char DEPOSIT = 'D';
	//ȡ��
	public static final char WITHDRAW = 'W';
	//����ʱ��
	private Date date;
	//��������
	private char type;
	//�������
	private double amount;
	//��ǰ���
	private double balance;
	//��������
	private String description;
	
	public Transaction(char type, double amount, double balance, String description) {
		this.date = new Date();
		this.type = type;
		this.amount = amount;
		this.balance = balance;
		this.description = date.toString() + " " + 
							(getType() == DEPOSIT ? "����: " : "ȡ��: ") +
							getAmount() + " ��ǰ���: " + getBalance();
	}

	/**
	 * ��ȡ��������
	 * @return
	 */
	public char getType() {
		return type;
	}

	/**
	 * ��ȡ�������
	 * @return
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * ��ȡ��ǰ���
	 * @return
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * ��ȡ����
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * ��ȡ����ʱ��
	 * @return
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * �ж��Ƿ�Ϊͬһ��
	 * @param newDate
	 * @return
	 */
	public boolean sameDay(Date newDate){
		return getDate().getTime() /24/3600/1000 == newDate.getTime() /24/3600/1000;
	}
	
	/**
	 * ���ز�������
	 */
	@Override
	public String toString(){
		return description;
	}
}