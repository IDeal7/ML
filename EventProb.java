http://hunkim.github.io/ml/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class EventProb extends JFrame{
        // �ʵ�
	private int val;
	private JLabel laVal = new JLabel();
	private JLabel laResult = new JLabel();
        // ������	
	public EventProb() {
                // �ʵ� ���� �� �ʱ�ȭ
		this.val = (int)(Math.random() * 50) + 10; 
		laVal.setText("Value: " + Integer.toString(val));
		laVal.setLocation(30, 50);
		laVal.setSize(200, 50);
		laVal.setFont(new Font("Arial", Font.BOLD, 20));

		laResult.setText("Result: ");
		laResult.setLocation(30, 100);
		laResult.setSize(200, 50);
		laResult.setFont(new Font("Arial", Font.BOLD, 20));

		setTitle("����4: 1791292-������");
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
		JButton btnTwo = new JButton("2�� ���");
		JButton btnThree = new JButton("3�� ���");
		JButton btnRnd = new JButton("���� ��");
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
			
                // 1. ��ư �׼� �̺�Ʈ (actionPerformed �޼ҵ�)
                // ��ư�� Ŭ���ϸ� ��ư�� ������ �̺�Ʈ�� ����
				JButton b = (JButton)e.getSource();
                // a) 2�� ��� ��ư: val ���� 2�� ��������� Ȯ�� (true �Ǵ� false)
				if(b.getText().equals("2�� ���")) {
					if (val % 2 == 0)
						laVal.setText("Value: " + Integer.toString(val) + " true! ");		
					else
						laVal.setText("Value: " + Integer.toString(val) + " false! ");
				}
				// b) 2�� ��� ��ư: val ���� 3�� ��������� Ȯ�� (true �Ǵ� false)
				if(b.getText().equals("3�� ���")) {
					if (val % 3 == 0)
						laVal.setText("Value: " + Integer.toString(val) + " true! ");
					else
						laVal.setText("Value: " + Integer.toString(val) + " false! ");
				}
                // ��� ����� �ݿ��Ͽ� ��(laVal)�� ���
				
                // c) ���� �� ��ư: �ʵ� val�� ���ο� ���� ���� ����
				if(b.getText().equals("���� ��")) {
					val = (int)(Math.random() * 50) + 10;
				
                // ���� ����� val���� �ݿ��Ͽ� ��(laVal)�� ���
				laVal.setText("Value: " + Integer.toString(val));
				}
		}
	}
	
	class InitKeyListener extends KeyAdapter {
                // 2. Ű �Է� �̺�Ʈ (keyPressed �޼ҵ�)
			public void keyPressed(KeyEvent e){
                // Enter Ű�� �Է��ϸ� val�� ���ο� �������� �ְ� ��(laVal) ���
					if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                // Enter Ű�� Ű �ڵ�� VK_ENTER
					val = (int)(Math.random() * 50) + 10;
					laVal.setText("Value: " + Integer.toString(val));
					}
				}
	}
	
	class CalMouseListener extends MouseAdapter{
		int x,y;
                // 3. ���콺 �Է� �̺�Ʈ (mouseClicked �޼ҵ�)
                // ���콺�� ���� Ŭ���ϸ� ������ ��ǥ(x, y)�� ����
			public void mouseClicked(MouseEvent e){
				Container contentPane = (Container)e.getSource();
				if (e.getClickCount() == 2){
					x = e.getX();
					y = e.getY();
				}
				
                // ��ǥ �� �� ū ���� ���� ������ ���� ����� ���
                // x > y �̸� x/y��, y > x �̸� y/x�� ���
				if ( x >= y )
					
					laResult.setText(Integer.toString(x) + " / " + Integer.toString(y) + " = " + Double.toString((double)x/(double)y));
				else
					laResult.setText(Integer.toString(y) + " / " + Integer.toString(x) + " = " + Double.toString((double)y/(double)x));
				
                // ��� ����� ��(laResult)�� ���
                // �̶� ������ ���������� ����
				contentPane.setBackground(Color.RED);
			}
	}
	
	public static void main(String[] args) {
		new EventProb();
	}
}