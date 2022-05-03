package com.lec.quiz04_customer;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CustomerMng extends JFrame implements ActionListener {

	private Container contenPane;
	private JPanel jpup, jpdown;
	private JTextField txtPhone, txtName, txtPoint;
	private JButton btnJoin, btnSearch, btnOutput, btnExit;
	private JTextArea jta;
	private JScrollPane scrollPane;

	private CustomerDao dao = CustomerDao.getInstance();

	public CustomerMng(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		contenPane = getContentPane();
		contenPane.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(3, 2));
		jpdown = new JPanel(); // FlowLayout

		txtPhone = new JTextField(15);
		txtName = new JTextField(15);
		txtPoint = new JTextField(15);

		btnJoin = new JButton("����");
		btnSearch = new JButton("����ȸ");
		btnOutput = new JButton("���");
		btnExit = new JButton("����");

		jta = new JTextArea(15, 30);
		scrollPane = new JScrollPane(jta);

		jpup.add(new JLabel("����ȣ", (int) CENTER_ALIGNMENT));
		jpup.add(txtPhone);
		jpup.add(new JLabel("�̸�", (int) CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(new JLabel("����Ʈ", (int) CENTER_ALIGNMENT));
		jpup.add(txtPoint);

		jpdown.add(btnJoin);
		jpdown.add(btnSearch);
		jpdown.add(btnOutput);
		jpdown.add(btnExit);

		contenPane.add(jpup);
		contenPane.add(jpdown);
		contenPane.add(scrollPane);

		setSize(new Dimension(450, 450));
		setLocation(200, 200);
		setVisible(true);

		// ��ư �̺�Ʈ �߰�
		btnJoin.addActionListener(this);
		btnSearch.addActionListener(this);
		btnOutput.addActionListener(this);
		btnExit.addActionListener(this);

	}

	// �̺�Ʈ���� �߰�
	// 1. ���� : public int insertCustomer(CustomerDto dto)
	// 2. ����ȸ : public ArrayList<CustomerDto> cTelgetCustomer(String ctel)
	// 3. ��ü��� : public ArrayList<CustomerDto> getCustomers()
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnJoin) { // 1. ����
			String ctel = txtPhone.getText().trim();
			String cname = txtName.getText().trim();
			int cpoint = Integer.parseInt(txtPoint.getText().trim());
			if (ctel.length() < 9 || ctel.length() > 11) {
				jta.setText("��ȭ��ȣ ������ �߸��Ǿ����ϴ�.");
			}
			int result = dao.insertCustomer(ctel, cname, cpoint);
			if (result == CustomerDao.SUCCESS) {
				jta.setText("ȸ�������� �Ϸ�Ǿ����ϴ�.");
			}

		} else if (e.getSource() == btnSearch) { // 2. ����ȸ
			String ctel = txtPhone.getText().trim();
			if (ctel.length() < 4) {
				jta.setText("��ȭ��ȣ ���ڸ� 4�ڸ� or ��ü ��ȭ��ȣ(ex. 010-1111-2222)�� �Է��ϼ���.");
				return;
			}
			ArrayList<CustomerDto> dtos = dao.cTelgetCustomer(ctel);

			if(dtos.size() ==0) {
				jta.setText("�ش��ȣ�� ȸ���� �����ϴ�.");
			} else if(dtos.size() == 1) {
				txtPhone.setText(dtos.get(0).getCtel());
				txtName.setText(dtos.get(0).getCname());
				txtPoint.setText(String.valueOf(dtos.get(0).getCpoint()));
				jta.setText("");
			} else if(dtos.size()>=1) {
				jta.append("ȸ����ȣ \t ��ȭ��ȣ \t �̸� \t ����Ʈ \n");
				for(CustomerDto d : dtos) {
					jta.append(d.toString());
				}
			}

		} else if (e.getSource() == btnOutput) { // 3. ���
			txtName.setText("");
			txtPhone.setText("");
			txtPoint.setText("");

			ArrayList<CustomerDto> customers = dao.getCustomers();

			jta.setText("��ȣ     �̸�\t��ȭ��ȣ\t����Ʈ\n\n");
			if (customers.size() != 0) {
				for (CustomerDto d : customers) {
					jta.append(d.toString() + "\n");
				}
			} else {
				jta.setText("��ϵ� ȸ���� �������� �ʽ��ϴ�.");
			}

		} else if (e.getSource() == btnExit) { // 4. ����
			setVisible(false);
			dispose();
			System.exit(0);
		}

	}

	// main
	public static void main(String[] args) {
		new CustomerMng("ȸ������");
	}
}
