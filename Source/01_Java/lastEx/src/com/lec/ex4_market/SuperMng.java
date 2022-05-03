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

	// 1. db관련 추가
	// DAO 추가
	private CustomerDao dao = CustomerDao.getInstance();

	// 2. 화면 구현
	private Container container;
	private JPanel jpup, jpbtn;
	private JTextField txtcid, txtctel, txtcname, txtcpoint, txtcamount;
	private Vector<String> levelNames;
	private JComboBox<String> comLevelName;
	private JButton btnCidSearch, btnCtelSearch, btnCnameSearch, btnBuyWithPoint;
	private JButton btnBuy, btnLevelNameOutput, btnAllOutput, btnInsert, btnCtelUpdate, btnDelete, btnExit;
	private JTextArea txtPool; // 텍스트를 입력할때마다
	private JScrollPane scrollPane; // 자동으로 스크롤이 생성되도록

	public SuperMng(String title) {

		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 컴포넌트 객체 생성
		container = getContentPane();
		container.setLayout(new FlowLayout()); // 컨테이너의 기본은 borderlayout
		jpup = new JPanel(new GridLayout(6, 3)); // 패널의 기본은 Flowlayout
		jpbtn = new JPanel();

		txtcid = new JTextField(20);
		txtctel = new JTextField(20);
		txtcname = new JTextField(20);
		txtcpoint = new JTextField(20);
		txtcamount = new JTextField(20);
		levelNames = dao.getLevelNames(); // 벡터로 데이터베이스에 있는 등급이름을 불러오는 것
		comLevelName = new JComboBox<String>(levelNames);

		btnCidSearch = new JButton("아이디 검색");
		btnCtelSearch = new JButton("폰 4자리(full) 검색");
		btnCnameSearch = new JButton("고객 이름 검색");
		btnBuyWithPoint = new JButton("포인트로만 구매");
		btnBuy = new JButton("물품 구매");
		btnLevelNameOutput = new JButton("등급별출력");
		btnAllOutput = new JButton("전체출력");
		btnInsert = new JButton("회원가입");
		btnCtelUpdate = new JButton("번호수정");
		btnDelete = new JButton("회원탈퇴");
		btnExit = new JButton("나가기");

		txtPool = new JTextArea(6, 70);
		scrollPane = new JScrollPane(txtPool);

		// 컨테이너에 컴포넌트 배치 add
		jpup.add(new JLabel("아이디", (int) CENTER_ALIGNMENT));
		jpup.add(txtcid);
		jpup.add(btnCidSearch);
		jpup.add(new JLabel("고객전화", (int) CENTER_ALIGNMENT));
		jpup.add(txtctel);
		jpup.add(btnCtelSearch);
		jpup.add(new JLabel("고객이름", (int) CENTER_ALIGNMENT));
		jpup.add(txtcname);
		jpup.add(btnCnameSearch);
		jpup.add(new JLabel("포인트", (int) CENTER_ALIGNMENT));
		jpup.add(txtcpoint);
		jpup.add(btnBuyWithPoint);
		jpup.add(new JLabel("구매금액", (int) CENTER_ALIGNMENT));
		jpup.add(txtcamount);
		jpup.add(new JLabel()); // 5행 3열에는 빈 라벨 추가
		jpup.add(new JLabel("고객등급", (int) CENTER_ALIGNMENT));
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
		txtPool.setText("\t ★★★ 고객검색 후 구매하세요 ★★★");

		// 이벤트 추가
//		1. implements ActionListener를 추가해준다.
//		2. addactionlistener 를 추가해준다
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

	// 3. 이벤트 로직 추가
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnCidSearch) {
			// 아이디검색 - 한명이 나오던지 아닌지
			// cid입력란 외에는 기본으로 비워놓고 로직 수행
			txtctel.setText("");
			txtcname.setText("");
			txtcpoint.setText("");
			txtcamount.setText("");
			comLevelName.setSelectedIndex(0);

			int cid;

			try {
				// cid를 받아서 정수로 변형한 것
				cid = Integer.parseInt(txtcid.getText().trim());
			} catch (Exception e2) {
				txtPool.setText("유효한 고객 id를 입력하신 후 아이디를 검색하세요.");
				return;
			} // try-catch
				// 숫자로 올바르게 입력한 경우
			CustomerDto customer = dao.cIdGetCustomer(cid);

			if (customer != null) {
//				txtcid.setText(String.valueOf(customer.getCid()));
				txtctel.setText(customer.getCtel());
				txtcname.setText(customer.getCname());
				txtcpoint.setText(String.valueOf(customer.getCpoint()));
//				txtcamount.setText(String.valueOf(customer.getCamount())); - 현재 구매한 금액만 넣기로 했으므로 필요X
				txtcamount.setText(""); // 물품구매액을 넣을 예정
				comLevelName.setSelectedItem(customer.getLevelName());

				txtPool.setText("ID\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을위한추가 구매할금액 \n");
				txtPool.append(
						"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- \n");
				txtPool.append(customer.toString());
			} else {
				txtPool.setText("검색되지 않은 ID입니다.");
			}

		} else if (e.getSource() == btnCtelSearch) {
			// 폰 4자리검색
			// ctel을 제외한 곳을 모두 비운다.
			txtcid.setText("");
			txtcname.setText("");
			txtcpoint.setText("");
			txtcamount.setText("");
			comLevelName.setSelectedIndex(0);

			String ctel = txtctel.getText().trim();
			// ctel이비면 안되고, 적어도 4글자 이상이 들어가야 한다.
			if (ctel.length() < 4) {
				txtPool.setText("전화번호 뒤 4자리를 입력하여 주세요.");
				return;
			}

			ArrayList<CustomerDto> customers = dao.cTelGetCustomer(ctel);

			txtPool.setText("ID\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을위한추가 구매할금액 \n");
			txtPool.append(
					"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- \n");
			if (customers.size() != 0) {
				for (CustomerDto customer : customers) {
					txtcid.setText(String.valueOf(customer.getCid()));
					txtcname.setText(customer.getCname());
					txtctel.setText(customer.getCtel());
					txtcpoint.setText(String.valueOf(customer.getCpoint()));
					txtcamount.setText(""); // 물품 구매할 금액이 넣어질 txtfield
					comLevelName.setSelectedItem(customer.getLevelName());
					txtPool.append(customer.toString() + "\n");
				}
			} else {
				txtPool.setText("해당 전화번호의 고객이 검색되지 않습니다. 회원가입 해주세요.");
			}

		} else if (e.getSource() == btnCnameSearch) {
			// 고객이름 검색
			// levelname 콤보박스를 제외한 입력란은 모두 비워놓은 후 로직 수행
			txtcid.setText("");
			txtctel.setText("");
			txtcpoint.setText("");
			txtcamount.setText("");
			comLevelName.setSelectedIndex(0);

			String cname = txtcname.getText().trim();

			// cname이비면 안되고, 적어도 4글자 이상이 들어가야 한다.
			if (cname.length() < 2) {
				txtPool.setText("이름은 2글자 이상 입력하여 주세요.");
				return;
			}

			ArrayList<CustomerDto> customers = dao.cNameGetCustomer(cname);

			txtPool.setText("ID\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을위한추가 구매할금액 \n");
			txtPool.append(
					"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- \n");
			if (customers.size() != 0) {
				for (CustomerDto customer : customers) {
					txtcid.setText(String.valueOf(customer.getCid()));
					txtcname.setText(customer.getCname());
					txtctel.setText(customer.getCtel());
					txtcpoint.setText(String.valueOf(customer.getCpoint()));
					txtcamount.setText(""); // 물품 구매할 금액이 넣어질 txtfield
					comLevelName.setSelectedItem(customer.getLevelName());
					txtPool.append(customer.toString() + "\n");
				}
			} else {
				txtPool.setText("입력하신 이름이 조회되지 않습니다. 회원가입 해주세요.");
			}
		} else if (e.getSource() == btnBuyWithPoint) {
			// 포인트로만 구매 - 아이디입력, 포인트, 구매금액 (int)
			int cid, cpoint, camount;
			try {
				cid = Integer.parseInt(txtcid.getText().trim());
				cpoint = Integer.parseInt(txtcpoint.getText().trim());
				camount = Integer.parseInt(txtcamount.getText().trim());
				
				if(cpoint < camount) {
					txtPool.setText("포인트가 부족하여 포인트 구매가 불가합니다");
					return;
				}
			} catch (Exception e2) {
				txtPool.setText("유효한 고객id point를 입력 해주세요.");
				return;
			}
			// 정수를 모두 입력한 경우
			int result = dao.buyWithPoint(cid, camount);
			if(result == CustomerDao.SUCCESS) {
				txtPool.setText("포인트 구매 성공");
				// 데이터 베이스에 반영된 것을 화면으로 출력
				txtcpoint.setText(String.valueOf(cpoint - camount));
				txtcamount.setText("");
			} else {
				txtPool.setText("고객 아이디가 유효하지 않습니다. 고객을 확인 후 구매해주세요.");
			}
			
			
		} else if (e.getSource() == btnBuy) {
			// 물품 구매
			int cid, cpoint, camount;
			try {
				cid = Integer.parseInt(txtcid.getText().trim());
				cpoint = Integer.parseInt(txtcpoint.getText().trim());
				camount = Integer.parseInt(txtcamount.getText().trim());
			} catch (NumberFormatException e2) {
				txtPool.setText("고객id나 구매금액을 올바르게 입력하셨는지 확인해주세요.");
				return;
			}
			
			int result = dao.buy(cid, camount);
			
			if(result == CustomerDao.SUCCESS) {
				txtPool.setText("물품구매완료");
				txtcpoint.setText(String.valueOf(cpoint + (camount * 0.05)));
				txtcamount.setText("");
			} else {
				txtPool.setText("고객 id가 유효하지 않습니다. 고객 검색후 구매하세요.");
			}

		} else if (e.getSource() == btnLevelNameOutput) {
			// 등급별 출력
			// levelname 콤보박스를 제외한 입력란은 모두 비워놓은 후 로직 수행
			txtcid.setText("");
			txtctel.setText("");
			txtcname.setText("");
			txtcpoint.setText("");
			txtcamount.setText("");
//			comLevelName.setSelectedIndex(0);

			String levelname = comLevelName.getSelectedItem().toString();

			if (levelname.length() == 0) {
				txtPool.setText("원하는 등급을 선택하시고 검색하세요.");
				return;
			}

			ArrayList<CustomerDto> customers = dao.levelNameGetCustomer(levelname);

			txtPool.setText("ID\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을위한추가 구매할금액 \n");
			txtPool.append(
					"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- \n");
			if (customers.size() != 0) {
				for (CustomerDto customer : customers) {
					txtPool.append(customer.toString() + "\n");
				}
				txtPool.append("총" + customers.size() + "명");
			} else {
				txtPool.setText("해당 등급에 고객이 존재하지 않습니다.");
			}

			
		} else if (e.getSource() == btnAllOutput) {
			// 전체 출력
			txtcid.setText("");
			txtctel.setText("");
			txtcname.setText("");
			txtcpoint.setText("");
			txtcamount.setText("");
			comLevelName.setSelectedItem("");
			
			ArrayList<CustomerDto> customers = dao.getCustomers();

			txtPool.setText("ID\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을위한추가 구매할금액 \n");
			txtPool.append(
					"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- \n");
			if (customers.size() != 0) {
				for (CustomerDto customer : customers) {
					txtPool.append(customer.toString() + "\n");
				}
				txtPool.append("\n  총 " + customers.size() + " 명 출력");
			} else {
				txtPool.setText("등록된 회원이 존재하지 않습니다.");
			}
			
			

		} else if (e.getSource() == btnInsert) {
			// 회원 가입 - 전화번호랑 이름만 입력하면 된다.
			// ctel, cname 입력란을 제외하고 빈 스트링 및 초기값으로 정리
			
			txtcid.setText("");
//			txtctel.setText("");
//			txtcname.setText("");
			txtcpoint.setText("1000");
			txtcamount.setText("");
			comLevelName.setSelectedItem("NORMAL");
			
			String ctel = txtctel.getText().trim();
			String cname = txtcname.getText().trim();
			
			if(ctel.length() < 9 || cname.length() < 2) {
				// 유효성 검사하는건 선택사항으로!
				txtPool.setText("조건에 맞는 이름과 번호를 입력하여 주세요.");
			}
			
			int result = dao.inertCustomer(ctel, cname);
			if(result == CustomerDao.SUCCESS) {
				txtPool.setText("회원가입 감사합니다. 포인트 1000점을 가입 선물로 드립니다.");
			}

		} else if (e.getSource() == btnCtelUpdate) {
			// 번호 수정 - 번호, id 필요
			int cid;
			String ctel;
			
			try {
				cid = Integer.parseInt(txtcid.getText().trim());
				ctel = txtctel.getText().trim();
				
				if(ctel.length() < 8) {
					txtPool.setText("변경할 전화번호를 확인해주세요");
					return;
				}
			} catch (Exception e2) {
				txtPool.setText("유효한 고객id로 검색 후 수정하세요");
				return;
			}
			
			int result = dao.updateCustomer(cid, ctel);
			if(result == CustomerDao.SUCCESS) {
				txtPool.setText("전화번호가 수정이 완료되었습니다.");
			} else {
				txtPool.setText("유효한 고객 id로 검색 후 수정을 해주세요.");
			}

		} else if (e.getSource() == btnDelete) {
			// 회원 탈퇴 - 전화번호만 입력받도록
			txtcid.setText("");
//			txtctel.setText("");
			txtcname.setText("");
			txtcpoint.setText("");
			txtcamount.setText("");
			comLevelName.setSelectedItem("");
			
			String ctel = txtctel.getText().trim();
			if(ctel.equals("")) {
				txtPool.setText("전화번호를 입력 후 회원탈퇴 진행 해주세요.");
				return;
			}
			int result = dao.deleteCustomer(ctel);
			if(result == CustomerDao.SUCCESS) {
				txtPool.setText("회원 탈퇴 완료");
				txtctel.setText("");
			} else {
				txtPool.setText("등록된 전화번호가 아여서 회원탈퇴 진행 불가합니다.");
			}
			
		} else if (e.getSource() == btnExit) {
			// 나가기 : 종료
			setVisible(false);
			dispose();
			System.exit(0);
		}

	}

	// 메인함수
	public static void main(String[] args) {
		new SuperMng("슈퍼마켓 관리");
	}

}
