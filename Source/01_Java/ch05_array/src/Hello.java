// Hello.java --(������ javac Hello.java)--> Hello.class 
// --(���� java Hello �嵿�� ��ҿ�)--> ���
public class Hello {
	public static void main(String[] args) {
		// String[] args�� �ǹ�
		// String �迭�� args��� ��ü��
		System.out.print("�ȳ��ϼ���");
		for(int idx=0; idx<args.length; idx++) {
			System.out.print(", " + args[idx]);
		}
		
		// 1. bin/cmd ���� �ϴ� ��
		// Hello �����ѹ� �ϰ� ������
		// bin���� cmd â ���� .... java Hello �ۼ��ؼ� �ȳ��ϼ��� �ߴ��� Ȯ���ϰ�...
		// java Hello ���� �嵿�� ��ҿ� �Է��ϸ�... ��µǴ°� �� �� ����...
		
		// 2. �޴�
		// Run > RunConfigurations > Arguments.... ������ ���� �߰��ϰ� ������ �߰��ϱ�.
	
	}

}
