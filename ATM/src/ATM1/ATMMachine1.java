package ATM1;

import java.util.Scanner;

public class ATMMachine1 {
	// �����˺�
	private static Account1[] account1 = setAccount(100);
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
//		// �����˺�
//		Account1[] account1 = setAccount(100);

		String strToInt;
		while(true){
			System.out.print("�������˺�id(00~99):");
			//�ж������Ƿ�Ϊ����
			strToInt = input.nextLine();
			if(isInt(strToInt)){
				break;
			}
			System.out.println("������󣬵�ǰ���������!\n����������:");
		}		
		int ID = Integer.valueOf(strToInt);

		// ��ʼ�˵�
		while (true) {
			System.out.println("\nMain menu");
			System.out.println("1:check balance");
			System.out.println("2:withdraw");
			System.out.println("3:deposit");
			System.out.println("4:exit");

			// �������ֽ��в���
			String strToSelect;
			while(true){
				//�ж������Ƿ�Ϊ����
				System.out.print("\n�����������:");
				strToSelect = input.nextLine();
				if(isInt(strToSelect))
					break;
				System.out.println("�������,��ǰ���������!");
			}
			int select = Integer.valueOf(strToSelect);
			switch (select) {
			case 1:
				checkBalance(account1[ID]);// �鿴�˻����
				break;
			case 2:
				// ȡ��
				String strToWithdraw;
					System.out.println("������ȡ����:");
					//�ж������Ƿ�Ϊ˫���ȸ�����
					strToWithdraw = input.nextLine();
				double amountOFWithdraw = Double.parseDouble(strToWithdraw);
				withdraw(account1[ID], amountOFWithdraw);
				break;
			case 3://���
				String strToDeposit;
					System.out.println("����������:");
					//�ж������Ƿ�Ϊ˫���ȸ�����
					strToDeposit = input.nextLine();
				double amountOfDeposit = Double.parseDouble(strToDeposit);
				Deposit(account1[ID], amountOfDeposit);
				break;
			case 4:
				System.exit(0);// �˳�
			default:
				System.out.println("�����Ŵ�����������ȷ�Ĳ�����");
			}
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}

	}

	// ���岢��ʼ��������
	public static Account1[] setAccount(int numberOfId) {
		Account1[] account1 = new Account1[numberOfId];
		for (int i = 0; i < numberOfId; i++) {
			account1[i] = new Account1(i, 1000);
		}

		return account1;
	}

	// checkBalance
	public static void checkBalance(Account1 account) {
		System.out.println("�˻����Ϊ: " + account.getBalance());
	}

	// withdraw
	public static void withdraw(Account1 account, double amount) {
		int result = account.withdraw(amount);
		if (result == 2)
			System.out.println("ȡ��������˻����,ȡ��ʧ��");
		else if (result == 3)
			System.out.println("ȡ�����С��0,ȡ��ʧ��");
		else {
			System.out.println("ȡ������ɹ�,��ȡ�� $" + amount);
			System.out.println("�˻����Ϊ: $" + account.getBalance());
		}

	}

	// deposit
	public static void Deposit(Account1 account, double amount) {
		int result = account.deposit(amount);
		if (result == 1)
			System.out.println("�������С��0,����ʧ��");
		else {
			System.out.print("�����ɹ�,�Ѵ��� $" + amount + ", ");
			System.out.println("�˻����Ϊ: $" + account.getBalance());
		}
	}
	
	//��������ʽ�ж��ַ����Ƿ�Ϊ�����ַ���
	public static boolean isInt(String str){
		if(str.matches("[\\d]+"))
			return true;
		else
			return false;		
	}
	//��������ʽ�ж��ַ����Ƿ�Ϊ˫���ȸ�����
	public static boolean isDouble(String str){
		if(str.matches("[\\d]+.[\\d]+"))
			return true;
		else
			return false;		
	}

}
