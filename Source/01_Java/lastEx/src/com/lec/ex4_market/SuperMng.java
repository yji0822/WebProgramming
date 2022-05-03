package com.lec.ex4_market;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SuperMng extends JFrame implements ActionListener {

	// 1. db���� �߰�
	// DAO �߰�
	private CustomerDao dao = CustomerDao.getInstance();

	// 2. ȭ�� ����
	private Container container;
	private JPanel jpup, jpbtn;
	private JTextField txtcid, txtctel, txtcname, txtcpoint, txtcamount;
	private Vector<String> levelNames;
	private JComboBox<String> comLevelName;
	private JButton btnCidSearch, btnCtelSearch, btnCnameSearch, btnBuyWithPoint;
	private JButton btnBuy, btnLevelNameOutput, btnAllOutput, btnInsert, btnCtelUpdate, btnDelete, btnExit;
	private JTextArea txtPool; // �ؽ�Ʈ�� �Է��Ҷ�����
	private JScrollPane scrollPane; // �ڵ����� ��ũ���� �����ǵ���

	public SuperMng(String title) {

		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// ������Ʈ ��ü ����
		container = getContentPane();
		container.setLayout(new FlowLayout()); // �����̳��� �⺻�� borderlayout
		jpup = new JPanel(new GridLayout(6, 3)); // �г��� �⺻�� Flowlayout
		jpbtn = new JPanel();

		txtcid = new JTextField(20);
		txtctel = new JTextField(20);
		txtcname = new JTextField(20);
		txtcpoint = new JTextField(20);
		txtcamount = new JTextField(20);
		levelNames = dao.getLevelNames(); // ���ͷ� �����ͺ��̽��� �ִ� ����̸��� �ҷ����� ��
		comLevelName = new JComboBox<String>(levelNames);

		btnCidSearch = new JButton("���̵� �˻�");
		btnCtelSearch = new JButton("�� 4�ڸ�(full) �˻�");
		btnCnameSearch = new JButton("�� �̸� �˻�");
		btnBuyWithPoint = new JButton("����Ʈ�θ� ����");
		btnBuy = new JButton("��ǰ ����");
		btnLevelNameOutput = new JButton("��޺����");
		btnAllOutput = new JButton("��ü���");
		btnInsert = new JButton("ȸ������");
		btnCtelUpdate = new JButton("��ȣ����");
		btnDelete = new JButton("ȸ��Ż��");
		btnExit = new JButton("������");

		txtPool = new JTextArea(6, 70);
		scrollPane = new JScrollPane(txtPool);

		// �����̳ʿ� ������Ʈ ��ġ add
		jpup.add(new JLabel("���̵�", (int) CENTER_ALIGNMENT));
		jpup.add(txtcid);
		jpup.add(btnCidSearch);
		jpup.add(new JLabel("����ȭ", (int) CENTER_ALIGNMENT));
		jpup.add(txtctel);
		jpup.add(btnCtelSearch);
		jpup.add(new JLabel("���̸�", (int) CENTER_ALIGNMENT));
		jpup.add(txtcname);
		jpup.add(btnCnameSearch);
		jpup.add(new JLabel("����Ʈ", (int) CENTER_ALIGNMENT));
		jpup.add(txtcpoint);
		jpup.add(btnBuyWithPoint);
		jpup.add(new JLabel("���űݾ�", (int) CENTER_ALIGNMENT));
		jpup.add(txtcamount);
		jpup.add(new JLabel()); // 5�� 3������ �� �� �߰�
		jpup.add(new JLabel("�����", (int) CENTER_ALIGNMENT));
		jpup.add(comLevelName);

		jpbtn.add(btnBuy);
		jpbtn.add(btnLevelNameOutput);
		jpbtn.add(btnAllOutput);
		jpbtn.add(btnInsert);
		jpbtn.add(btnCtelUpdate);
		jpbtn.add(btnDelete);
		jpbtn.add(btnExit);

		container.add(jpup);
		container.add(jpbtn);
		container.add(scrollPane);

		setVisible(true);
		setSize(new Dimension(800, 400));
		setLocation(200, 200);
		txtPool.setText("\t �ڡڡ� ���˻� �� �����ϼ��� �ڡڡ�");

		// �̺�Ʈ �߰�
//		1. implements ActionListener�� �߰����ش�.
//		2. addactionlistener �� �߰����ش�
		btnCidSearch.addActionListener(this);
		btnCtelSearch.addActionListener(this);
		btnCnameSearch.addActionListener(this);
		btnBuyWithPoint.addActionListener(this);
		btnBuy.addActionListener(this);
		btnLevelNameOutput.addActionListener(this);
		btnAllOutput.addActionListener(this);
		btnInsert.addActionListener(this);
		btnCtelUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnExit.addActionListener(this);

	}

	// 3. �̺�Ʈ ���� �߰�
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnCidSearch) {
			// ���̵�˻� - �Ѹ��� �������� �ƴ���
			// cid�Է¶� �ܿ��� �⺻���� ������� ���� ����
			txtctel.setText("");
			txtcname.setText("");
			txtcpoint.setText("");
			txtcamount.setText("");
			comLevelName.setSelectedIndex(0);

			int cid;

			try {
				// cid�� �޾Ƽ� ������ ������ ��
				cid = Integer.parseInt(txtcid.getText().trim());
			} catch (Exception e2) {
				txtPool.setText("��ȿ�� �� id�� �Է��Ͻ� �� ���̵� �˻��ϼ���.");
				return;
			} // try-catch
				// ���ڷ� �ùٸ��� �Է��� ���
			CustomerDto customer = dao.cIdGetCustomer(cid);

			if (customer != null) {
//				txtcid.setText(String.valueOf(customer.getCid()));
				txtctel.setText(customer.getCtel());
				txtcname.setText(customer.getCname());
				txtcpoint.setText(String.valueOf(customer.getCpoint()));
//				txtcamount.setText(String.valueOf(customer.getCamount())); - ���� ������ �ݾ׸� �ֱ�� �����Ƿ� �ʿ�X
				txtcamount.setText(""); // ��ǰ���ž��� ���� ����
				comLevelName.setSelectedItem(customer.getLevelName());

				txtPool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������������߰� �����ұݾ� \n");
				txtPool.append(
						"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- \n");
				txtPool.append(customer.toString());
			} else {
				txtPool.setText("�˻����� ���� ID�Դϴ�.");
			}

		} else if (e.getSource() == btnCtelSearch) {
			// �� 4�ڸ��˻�
			// ctel�� ������ ���� ��� ����.
			txtcid.setText("");
			txtcname.setText("");
			txtcpoint.setText("");
			txtcamount.setText("");
			comLevelName.setSelectedIndex(0);

			String ctel = txtctel.getText().trim();
			// ctel�̺�� �ȵǰ�, ��� 4���� �̻��� ���� �Ѵ�.
			if (ctel.length() < 4) {
				txtPool.setText("��ȭ��ȣ �� 4�ڸ��� �Է��Ͽ� �ּ���.");
				return;
			}

			ArrayList<CustomerDto> customers = dao.cTelGetCustomer(ctel);

			txtPool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������������߰� �����ұݾ� \n");
			txtPool.append(
					"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- \n");
			if (customers.size() != 0) {
				for (CustomerDto customer : customers) {
					txtcid.setText(String.valueOf(customer.getCid()));
					txtcname.setText(customer.getCname());
					txtctel.setText(customer.getCtel());
					txtcpoint.setText(String.valueOf(customer.getCpoint()));
					txtcamount.setText(""); // ��ǰ ������ �ݾ��� �־��� txtfield
					comLevelName.setSelectedItem(customer.getLevelName());
					txtPool.append(customer.toString() + "\n");
				}
			} else {
				txtPool.setText("�ش� ��ȭ��ȣ�� ���� �˻����� �ʽ��ϴ�. ȸ������ ���ּ���.");
			}

		} else if (e.getSource() == btnCnameSearch) {
			// ���̸� �˻�
			// levelname �޺��ڽ��� ������ �Է¶��� ��� ������� �� ���� ����
			txtcid.setText("");
			txtctel.setText("");
			txtcpoint.setText("");
			txtcamount.setText("");
			comLevelName.setSelectedIndex(0);

			String cname = txtcname.getText().trim();

			// cname�̺�� �ȵǰ�, ��� 4���� �̻��� ���� �Ѵ�.
			if (cname.length() < 2) {
				txtPool.setText("�̸��� 2���� �̻� �Է��Ͽ� �ּ���.");
				return;
			}

			ArrayList<CustomerDto> customers = dao.cNameGetCustomer(cname);

			txtPool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������������߰� �����ұݾ� \n");
			txtPool.append(
					"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- \n");
			if (customers.size() != 0) {
				for (CustomerDto customer : customers) {
					txtcid.setText(String.valueOf(customer.getCid()));
					txtcname.setText(customer.getCname());
					txtctel.setText(customer.getCtel());
					txtcpoint.setText(String.valueOf(customer.getCpoint()));
					txtcamount.setText(""); // ��ǰ ������ �ݾ��� �־��� txtfield
					comLevelName.setSelectedItem(customer.getLevelName());
					txtPool.append(customer.toString() + "\n");
				}
			} else {
				txtPool.setText("�Է��Ͻ� �̸��� ��ȸ���� �ʽ��ϴ�. ȸ������ ���ּ���.");
			}
		} else if (e.getSource() == btnBuyWithPoint) {
			// ����Ʈ�θ� ���� - ���̵��Է�, ����Ʈ, ���űݾ� (int)
			int cid, cpoint, camount;
			try {
				cid = Integer.parseInt(txtcid.getText().trim());
				cpoint = Integer.parseInt(txtcpoint.getText().trim());
				camount = Integer.parseInt(txtcamount.getText().trim());
				
				if(cpoint < camount) {
					txtPool.setText("����Ʈ�� �����Ͽ� ����Ʈ ���Ű� �Ұ��մϴ�");
					return;
				}
			} catch (Exception e2) {
				txtPool.setText("��ȿ�� ��id point�� �Է� ���ּ���.");
				return;
			}
			// ������ ��� �Է��� ���
			int result = dao.buyWithPoint(cid, camount);
			if(result == CustomerDao.SUCCESS) {
				txtPool.setText("����Ʈ ���� ����");
				// ������ ���̽��� �ݿ��� ���� ȭ������ ���
				txtcpoint.setText(String.valueOf(cpoint - camount));
				txtcamount.setText("");
			} else {
				txtPool.setText("�� ���̵� ��ȿ���� �ʽ��ϴ�. ���� Ȯ�� �� �������ּ���.");
			}
			
			
		} else if (e.getSource() == btnBuy) {
			// ��ǰ ����
			int cid, cpoint, camount;
			try {
				cid = Integer.parseInt(txtcid.getText().trim());
				cpoint = Integer.parseInt(txtcpoint.getText().trim());
				camount = Integer.parseInt(txtcamount.getText().trim());
			} catch (NumberFormatException e2) {
				txtPool.setText("��id�� ���űݾ��� �ùٸ��� �Է��ϼ̴��� Ȯ�����ּ���.");
				return;
			}
			
			int result = dao.buy(cid, camount);
			
			if(result == CustomerDao.SUCCESS) {
				txtPool.setText("��ǰ���ſϷ�");
				txtcpoint.setText(String.valueOf(cpoint + (camount * 0.05)));
				txtcamount.setText("");
			} else {
				txtPool.setText("�� id�� ��ȿ���� �ʽ��ϴ�. �� �˻��� �����ϼ���.");
			}

		} else if (e.getSource() == btnLevelNameOutput) {
			// ��޺� ���
			// levelname �޺��ڽ��� ������ �Է¶��� ��� ������� �� ���� ����
			txtcid.setText("");
			txtctel.setText("");
			txtcname.setText("");
			txtcpoint.setText("");
			txtcamount.setText("");
//			comLevelName.setSelectedIndex(0);

			String levelname = comLevelName.getSelectedItem().toString();

			if (levelname.length() == 0) {
				txtPool.setText("���ϴ� ����� �����Ͻð� �˻��ϼ���.");
				return;
			}

			ArrayList<CustomerDto> customers = dao.levelNameGetCustomer(levelname);

			txtPool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������������߰� �����ұݾ� \n");
			txtPool.append(
					"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- \n");
			if (customers.size() != 0) {
				for (CustomerDto customer : customers) {
					txtPool.append(customer.toString() + "\n");
				}
				txtPool.append("��" + customers.size() + "��");
			} else {
				txtPool.setText("�ش� ��޿� ���� �������� �ʽ��ϴ�.");
			}

			
		} else if (e.getSource() == btnAllOutput) {
			// ��ü ���
			txtcid.setText("");
			txtctel.setText("");
			txtcname.setText("");
			txtcpoint.setText("");
			txtcamount.setText("");
			comLevelName.setSelectedItem("");
			
			ArrayList<CustomerDto> customers = dao.getCustomers();

			txtPool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������������߰� �����ұݾ� \n");
			txtPool.append(
					"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- \n");
			if (customers.size() != 0) {
				for (CustomerDto customer : customers) {
					txtPool.append(customer.toString() + "\n");
				}
				txtPool.append("\n  �� " + customers.size() + " �� ���");
			} else {
				txtPool.setText("��ϵ� ȸ���� �������� �ʽ��ϴ�.");
			}
			
			

		} else if (e.getSource() == btnInsert) {
			// ȸ�� ���� - ��ȭ��ȣ�� �̸��� �Է��ϸ� �ȴ�.
			// ctel, cname �Է¶��� �����ϰ� �� ��Ʈ�� �� �ʱⰪ���� ����
			
			txtcid.setText("");
//			txtctel.setText("");
//			txtcname.setText("");
			txtcpoint.setText("1000");
			txtcamount.setText("");
			comLevelName.setSelectedItem("NORMAL");
			
			String ctel = txtctel.getText().trim();
			String cname = txtcname.getText().trim();
			
			if(ctel.length() < 9 || cname.length() < 2) {
				// ��ȿ�� �˻��ϴ°� ���û�������!
				txtPool.setText("���ǿ� �´� �̸��� ��ȣ�� �Է��Ͽ� �ּ���.");
			}
			
			int result = dao.inertCustomer(ctel, cname);
			if(result == CustomerDao.SUCCESS) {
				txtPool.setText("ȸ������ �����մϴ�. ����Ʈ 1000���� ���� ������ �帳�ϴ�.");
			}

		} else if (e.getSource() == btnCtelUpdate) {
			// ��ȣ ���� - ��ȣ, id �ʿ�
			int cid;
			String ctel;
			
			try {
				cid = Integer.parseInt(txtcid.getText().trim());
				ctel = txtctel.getText().trim();
				
				if(ctel.length() < 8) {
					txtPool.setText("������ ��ȭ��ȣ�� Ȯ�����ּ���");
					return;
				}
			} catch (Exception e2) {
				txtPool.setText("��ȿ�� ��id�� �˻� �� �����ϼ���");
				return;
			}
			
			int result = dao.updateCustomer(cid, ctel);
			if(result == CustomerDao.SUCCESS) {
				txtPool.setText("��ȭ��ȣ�� ������ �Ϸ�Ǿ����ϴ�.");
			} else {
				txtPool.setText("��ȿ�� �� id�� �˻� �� ������ ���ּ���.");
			}

		} else if (e.getSource() == btnDelete) {
			// ȸ�� Ż�� - ��ȭ��ȣ�� �Է¹޵���
			txtcid.setText("");
//			txtctel.setText("");
			txtcname.setText("");
			txtcpoint.setText("");
			txtcamount.setText("");
			comLevelName.setSelectedItem("");
			
			String ctel = txtctel.getText().trim();
			if(ctel.equals("")) {
				txtPool.setText("��ȭ��ȣ�� �Է� �� ȸ��Ż�� ���� ���ּ���.");
				return;
			}
			int result = dao.deleteCustomer(ctel);
			if(result == CustomerDao.SUCCESS) {
				txtPool.setText("ȸ�� Ż�� �Ϸ�");
				txtctel.setText("");
			} else {
				txtPool.setText("��ϵ� ��ȭ��ȣ�� �ƿ��� ȸ��Ż�� ���� �Ұ��մϴ�.");
			}
			
		} else if (e.getSource() == btnExit) {
			// ������ : ����
			setVisible(false);
			dispose();
			System.exit(0);
		}

	}

	// �����Լ�
	public static void main(String[] args) {
		new SuperMng("���۸��� ����");
	}

}
