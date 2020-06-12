http://hunkim.github.io/ml/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class EventProb extends JFrame{
        // 필드
	private int val;
	private JLabel laVal = new JLabel();
	private JLabel laResult = new JLabel();
        // 생성자	
	public EventProb() {
                // 필드 값과 라벨 초기화
		this.val = (int)(Math.random() * 50) + 10; 
		laVal.setText("Value: " + Integer.toString(val));
		laVal.setLocation(30, 50);
		laVal.setSize(200, 50);
		laVal.setFont(new Font("Arial", Font.BOLD, 20));

		laResult.setText("Result: ");
		laResult.setLocation(30, 100);
		laResult.setSize(200, 50);
		laResult.setFont(new Font("Arial", Font.BOLD, 20));

		setTitle("과제4: 1791292-정병현");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(null);
		c.addKeyListener(new InitKeyListener());
		c.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Component com = (Component)e.getSource();
				com.setFocusable(true);
				com.requestFocus();
			}
		});
		c.addMouseListener(new CalMouseListener());
		JButton btnTwo = new JButton("2의 배수");
		JButton btnThree = new JButton("3의 배수");
		JButton btnRnd = new JButton("랜덤 수");
		btnTwo.setLocation(30, 10);
		btnThree.setLocation(170, 10);
		btnRnd.setLocation(310, 10);
		btnTwo.setSize(100, 30);
		btnThree.setSize(100, 30);
		btnRnd.setSize(100, 30);
		btnTwo.addActionListener(new BtnActionListener());
		btnThree.addActionListener(new BtnActionListener());
		btnRnd.addActionListener(new BtnActionListener());

		c.add(laVal);
		c.add(laResult);
		c.add(btnTwo);
		c.add(btnThree);
		c.add(btnRnd);

		setSize(450,200);
		setVisible(true);
		c.setFocusable(true);
		c.requestFocus();
	}
	class BtnActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
                // 1. 버튼 액션 이벤트 (actionPerformed 메소드)
                // 버튼을 클릭하면 버튼에 적합한 이벤트를 실행
				JButton b = (JButton)e.getSource();
                // a) 2의 배수 버튼: val 값이 2의 배수인지를 확인 (true 또는 false)
				if(b.getText().equals("2의 배수")) {
					if (val % 2 == 0)
						laVal.setText("Value: " + Integer.toString(val) + " true! ");		
					else
						laVal.setText("Value: " + Integer.toString(val) + " false! ");
				}
				// b) 2의 배수 버튼: val 값이 3의 배수인지를 확인 (true 또는 false)
				if(b.getText().equals("3의 배수")) {
					if (val % 3 == 0)
						laVal.setText("Value: " + Integer.toString(val) + " true! ");
					else
						laVal.setText("Value: " + Integer.toString(val) + " false! ");
				}
                // 계산 결과를 반영하여 라벨(laVal)에 출력
				
                // c) 랜덤 수 버튼: 필드 val에 새로운 랜덤 수를 저장
				if(b.getText().equals("랜덤 수")) {
					val = (int)(Math.random() * 50) + 10;
				
                // 새로 저장된 val값을 반영하여 라벨(laVal)에 출력
				laVal.setText("Value: " + Integer.toString(val));
				}
		}
	}
	
	class InitKeyListener extends KeyAdapter {
                // 2. 키 입력 이벤트 (keyPressed 메소드)
			public void keyPressed(KeyEvent e){
                // Enter 키를 입력하면 val에 새로운 랜덤값을 넣고 라벨(laVal) 출력
					if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                // Enter 키의 키 코드는 VK_ENTER
					val = (int)(Math.random() * 50) + 10;
					laVal.setText("Value: " + Integer.toString(val));
					}
				}
	}
	
	class CalMouseListener extends MouseAdapter{
		int x,y;
                // 3. 마우스 입력 이벤트 (mouseClicked 메소드)
                // 마우스를 더블 클릭하면 현재의 좌표(x, y)를 저장
			public void mouseClicked(MouseEvent e){
				Container contentPane = (Container)e.getSource();
				if (e.getClickCount() == 2){
					x = e.getX();
					y = e.getY();
				}
				
                // 좌표 값 중 큰 값을 작은 값으로 나눈 결과를 계산
                // x > y 이면 x/y를, y > x 이면 y/x로 계산
				if ( x >= y )
					
					laResult.setText(Integer.toString(x) + " / " + Integer.toString(y) + " = " + Double.toString((double)x/(double)y));
				else
					laResult.setText(Integer.toString(y) + " / " + Integer.toString(x) + " = " + Double.toString((double)y/(double)x));
				
                // 계산 결과를 라벨(laResult)에 출력
                // 이때 배경색을 빨간색으로 변경
				contentPane.setBackground(Color.RED);
			}
	}
	
	public static void main(String[] args) {
		new EventProb();
	}
}