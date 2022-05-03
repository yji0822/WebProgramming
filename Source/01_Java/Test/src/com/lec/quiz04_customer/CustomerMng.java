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

		btnJoin = new JButton("가입");
		btnSearch = new JButton("폰조회");
		btnOutput = new JButton("출력");
		btnExit = new JButton("종료");

		jta = new JTextArea(15, 30);
		scrollPane = new JScrollPane(jta);

		jpup.add(new JLabel("폰번호", (int) CENTER_ALIGNMENT));
		jpup.add(txtPhone);
		jpup.add(new JLabel("이름", (int) CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(new JLabel("포인트", (int) CENTER_ALIGNMENT));
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

		// 버튼 이벤트 추가
		btnJoin.addActionListener(this);
		btnSearch.addActionListener(this);
		btnOutput.addActionListener(this);
		btnExit.addActionListener(this);

	}

	// 이벤트로직 추가
	// 1. 가입 : public int insertCustomer(CustomerDto dto)
	// 2. 폰조회 : public ArrayList<CustomerDto> cTelgetCustomer(String ctel)
	// 3. 전체출력 : public ArrayList<CustomerDto> getCustomers()
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnJoin) { // 1. 가입
			String ctel = txtPhone.getText().trim();
			String cname = txtName.getText().trim();
			int cpoint = Integer.parseInt(txtPoint.getText().trim());
			if (ctel.length() < 9 || ctel.length() > 11) {
				jta.setText("전화번호 형식이 잘못되었습니다.");
			}
			int result = dao.insertCustomer(ctel, cname, cpoint);
			if (result == CustomerDao.SUCCESS) {
				jta.setText("회원가입이 완료되었습니다.");
			}

		} else if (e.getSource() == btnSearch) { // 2. 폰조회
			String ctel = txtPhone.getText().trim();
			if (ctel.length() < 4) {
				jta.setText("전화번호 뒷자리 4자리 or 전체 전화번호(ex. 010-1111-2222)를 입력하세요.");
				return;
			}
			ArrayList<CustomerDto> dtos = dao.cTelgetCustomer(ctel);

			if(dtos.size() ==0) {
				jta.setText("해당번호의 회원이 없습니다.");
			} else if(dtos.size() == 1) {
				txtPhone.setText(dtos.get(0).getCtel());
				txtName.setText(dtos.get(0).getCname());
				txtPoint.setText(String.valueOf(dtos.get(0).getCpoint()));
				jta.setText("");
			} else if(dtos.size()>=1) {
				jta.append("회원번호 \t 전화번호 \t 이름 \t 포인트 \n");
				for(CustomerDto d : dtos) {
					jta.append(d.toString());
				}
			}

		} else if (e.getSource() == btnOutput) { // 3. 출력
			txtName.setText("");
			txtPhone.setText("");
			txtPoint.setText("");

			ArrayList<CustomerDto> customers = dao.getCustomers();

			jta.setText("번호     이름\t전화번호\t포인트\n\n");
			if (customers.size() != 0) {
				for (CustomerDto d : customers) {
					jta.append(d.toString() + "\n");
				}
			} else {
				jta.setText("등록된 회원이 존재하지 않습니다.");
			}

		} else if (e.getSource() == btnExit) { // 4. 종료
			setVisible(false);
			dispose();
			System.exit(0);
		}

	}

	// main
	public static void main(String[] args) {
		new CustomerMng("회원관리");
	}
}
