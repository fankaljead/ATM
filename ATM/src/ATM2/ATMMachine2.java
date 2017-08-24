package ATM2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ATMMachine2{
	public Scanner input = new Scanner(System.in);
	private ArrayList<Integer> unusedID = null;
	private HashMap<Integer, Account2> accounts = null;
	private Account2 account = null;
	
	/**
	 * ��ȡ�ļ������ļ��е��˻���Ϣ������accounts��
	 * @param fileName
	 */
	public void readFile(String fileName){
		try{
			ObjectInputStream ois = new ObjectInputStream(
					new FileInputStream(fileName));
			accounts = (HashMap<Integer, Account2>)ois.readObject();
			if(accounts == null){
				System.out.println("read null");
			}
			ois.close();
		}catch(Exception e){
			accounts = null;
		}
	}
	
	/**
	 * ���ļ���д���˺���Ϣ
	 * @param fileName
	 */
	public void writeFile(String fileName){
		try{
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream(fileName));
			if(accounts == null)
				System.out.println("write null");
			oos.writeObject(accounts);
			oos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * ���췽��
	 */
	public ATMMachine2() {
		readFile("accounts.dat");
		
		//�˻������ڣ������µ��˻�
		if(accounts == null){
			accounts = new HashMap<Integer, Account2>();
		}

		if(unusedID == null){
			unusedID = new ArrayList<Integer>();
			for(int i = 100000; i <= 999999; i++){
				if(!accounts.keySet().contains(i))
					unusedID.add(i);
			}
		}
	}
	
	/**
	 * ��½
	 */
	public int login(){
		System.out.println("�������˺�: ");
		String ID = input.nextLine();
		
		//�˺�ID����6Ϊ����
		if(!ID.matches("\\d{6}")){
			System.out.println("�˺Ŵ���,ӦΪ6λ����!");
			return 0;
		}
		Account2 account = accounts.get(Integer.valueOf(ID));
		
		if(account == null){
			System.out.println("�˺Ų�����");
			return 0;
		}
		
		System.out.println("����������: ");
		String password = input.nextLine();
		
		//���벻��ȷ
		if(!account.getPassword().equals(password)){
			System.out.println("�������");
			return 0;
		}

		this.account = account;
		return 1;
	}
	
	/**
	 * ��ȡ�˺�
	 * @return
	 */
	public Account2 getAccount(){
		return this.account;
	}
	
	/**
	 * �����˺�
	 */
	public void CreatAccount(){
		System.out.println("����������: ");
		String name = input.nextLine();
		System.out.println("����������: ");
		String password = input.nextLine();
		System.out.println("�������ʼ���: ");
		int balance = input.nextInt();
		System.out.println("������������: ");
		double annualInterestRate = input.nextDouble();
		
		try{
			Account2 account = new Account2(name, password, 
					balance, annualInterestRate, unusedID);
			
			accounts.put(account.getId(), account);
			System.out.println("�����˺�Ϊ: " + account.getId());
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	/**
	 * �鿴�˻����
	 */
	public void checkBalance(){
		Account2 account = getAccount();
		
		if(account != null){
			System.out.println("�����˻����Ϊ: " + account.getBalance());
		}else{
			System.out.println("++++++");
		}
	}
	
	/**
	 * ȡ��
	 */
	public void withdraw(){
		Account2 account = getAccount();
		
		if(account != null){
			System.out.println("������ȡ����: ");
			double amount = input.nextDouble();
			
			int op = account.withdraw(amount);
			if(op == 0){
				System.out.println("ȡ��ɹ�!");
			}else if(op == 2){
				System.out.println("�˻�����,ȡ��ʧ��!");
			}else if(op == 3){
				System.out.println("ȡ��������Ƿ�,ȡ��ʧ��!");
			}else if(op == 4){
				System.out.println("ȡ����ӦΪ100�ı���,ȡ��ʧ��!");
			}else if(op == 5){
				System.out.println("����ȡ�����Ѿ���5000����,ȡ��ʧ��!");
			}
		}		
	}
	
	/**
	 * ���
	 */
	public void deposit(){
		Account2 account = getAccount();
		
		if(account != null){
			System.out.println("����������: ");
			double amount = input.nextDouble();
			
			int op = account.deposit(amount);
			if(op == 0){
				System.out.println("���ɹ�!");
			}else if(op == 1){
				System.out.println("���������Ƿ������ʧ��!");
			}
		}
	}
	
	/**
	 * ��ӡ���׼�¼
	 */
	public void detailOfTransaction(){
		Account2 account = getAccount();
		
		if(account != null){
			for(Transaction t: account.getTransactions()){
				System.out.println(t.getDescription());
			}
		}
	}
	
	/**
	 * �޸�����
	 */
	public void changePassword(){
		Account2 account = getAccount();
		
		if(account != null){
			System.out.println("�����������: ");
			String oldPassword = input.nextLine();
			System.out.println("������������: ");
			String newPassword1 = input.nextLine();
			System.out.println("���ٴ�����������: ");
			String newPassword2 = input.nextLine();
			
			int op = account.changePassword(oldPassword, newPassword1, newPassword2);
			if(op == 0){
				System.out.println("�޸ĳɹ�!");
			}else if(op == 6){
				System.out.println("�����벻��ȷ,�޸�ʧ��!");
			}else if(op == 7){
				System.out.println("�������벻��ͬ,�޸�ʧ��!");
			}else if(op == 8){
				System.out.println("���벻�淶,�޸�ʧ��!");
			}
		}
	}
	
	/**
	 * �˵�
	 */
	public void menu(){
		System.out.println("Main menu");
//		System.out.println("0��create a account");
		System.out.println("1: check balance");
		System.out.println("2: withdraw");
		System.out.println("3: deposit");
		System.out.println("4��details of the transaction");
		System.out.println("5: change password");
		System.out.println("6��exit");
		System.out.println("��������: ");
	}
	
	/**
	 * ��ʼ
	 */
	public void start(){
		while(true){
			System.out.println("1: ��½");
			System.out.println("2: ע��");
			System.out.println("0: �˳�");
			System.out.println("��������:");
			String select = input.nextLine();
			while(true){
				if(select.matches("[0-2]")){
					break;
				}
				select = input.nextLine();
			}
			
			if(Integer.valueOf(select) == 1){
				if(login() == 1){
					while(true){
						menu();
						String option = input.nextLine();
						while (!isNumber(option)){
							option = input.nextLine();
						}
						int op = Integer.valueOf(option);
//						input.nextLine();
						
						switch(op){
						case 1: checkBalance();break;
						case 2: withdraw();break;
						case 3: deposit();break;
						case 4: detailOfTransaction();break;
						case 5: changePassword();break;
						case 6: writeFile("accounts.dat");System.exit(0);break;
						default: System.out.println("��������!");
						}
					}
				}
			}else if(Integer.valueOf(select) == 2){
				CreatAccount();
			}else if(Integer.valueOf(select) == 0){
				System.exit(1);
			}
			
			
		}
	}
	
	public boolean isNumber(String num){
		return num.matches("\\d+");
	}
	
	public static void main(String[] args) throws InterruptedException{
		ATMMachine2 atm = new ATMMachine2();
		atm.start();
	}
}