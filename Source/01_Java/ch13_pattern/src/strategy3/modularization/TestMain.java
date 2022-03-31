package strategy3.modularization;

public class TestMain {
	public static void main(String[] args) {
		
		Student st1 = new Student("30301", "���л�", "��ȭ��");
		Student st2 = new Student("30302", "������", "Java��");
		Lecturer gs1 = new Lecturer("J01", "ȫ����", "java");
		Lecturer gs2 = new Lecturer("J02", "�����", "db");
		Staff s = new Staff("A01", "������", "�������");
		
		Person[] person = {st1, st2, gs1, gs2, s};
		System.out.println("== �����ð��̴� �� ���սô�. ==");
		for(Person p : person) {
			p.job();
		}
		System.out.println("== ������ �� ������ �� ���� ==");
		for(Person p : person) {
			p.get();
		}
		System.out.println("== �ñ��ϸ� ����Ʈ ==");
		for(Person p : person) {
			p.infoPrint();
		}
		
	}
		
}
