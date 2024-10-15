import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class Calculator implements ActionListener{
	
	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton addButton,subButton,mulButton,divButton;
	JButton decButton, equButton, delButton, clrButton, negButton;
	JPanel panel;
	
	Font myFont = new Font("Ink Free",Font.BOLD,30);
	
	double num1=0,num2=0,result=0;
	char operator;
	
	Calculator(){
		
		this.frame = new JFrame("Calculator");
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setSize(420, 550);
		this.frame.setLayout(null);

		this.textfield = new JTextField();
		this.textfield.setBounds(50, 25, 300, 50);
		this.textfield.setFont(this.myFont);
		this.textfield.setEditable(false);

		this.addButton = new JButton("+");
		this.subButton = new JButton("-");
		this.mulButton = new JButton("*");
		this.divButton = new JButton("/");
		this.decButton = new JButton(".");
		this.equButton = new JButton("=");
		this.delButton = new JButton("Delete");
		this.clrButton = new JButton("Clear");
        this.negButton = new JButton("(-)");

		this.functionButtons[0] = this.addButton;
		this.functionButtons[1] = this.subButton;
		this.functionButtons[2] = this.mulButton;
		this.functionButtons[3] = this.divButton;
		this.functionButtons[4] = this.decButton;
		this.functionButtons[5] = this.equButton;
		this.functionButtons[6] = this.delButton;
		this.functionButtons[7] = this.clrButton;
		this.functionButtons[8] = this.negButton;

		for(int i =0;i<9;i++) {
			this.functionButtons[i].addActionListener(this);
			this.functionButtons[i].setFont(this.myFont);
			this.functionButtons[i].setFocusable(false);
		}

		for(int i =0;i<10;i++) {
			this.numberButtons[i] = new JButton(String.valueOf(i));
            this.numberButtons[i].addActionListener(this);
            this.numberButtons[i].setFont(this.myFont);
            this.numberButtons[i].setFocusable(false);
		}
		this.negButton.setBounds(50,430,100,50);
		this.delButton.setBounds(150,430,100,50);
		this.clrButton.setBounds(250,430,100,50);
		
		this.panel = new JPanel();
		this.panel.setBounds(50, 100, 300, 300);
		this.panel.setLayout(new GridLayout(4,4,10,10));
		this.panel.setBackground(Color.GRAY);

        this.panel.add(this.numberButtons[1]);
		this.panel.add(this.numberButtons[2]);
		this.panel.add(this.numberButtons[3]);
		this.panel.add(this.numberButtons[4]);
		this.panel.add(this.numberButtons[5]);
		this.panel.add(this.numberButtons[6]);
		this.panel.add(this.numberButtons[7]);
		this.panel.add(this.numberButtons[8]);
		this.panel.add(this.numberButtons[9]);
		this.panel.add(this.numberButtons[0]);
		this.panel.add(this.addButton);
		this.panel.add(this.subButton);
		this.panel.add(this.mulButton);
		this.panel.add(this.decButton);
		this.panel.add(this.divButton);
		this.panel.add(this.equButton);

		this.frame.add(this.delButton);
		this.frame.add(this.negButton);
		this.frame.add(this.panel);
		this.frame.add(this.clrButton);
		this.frame.add(this.textfield);
		this.frame.setVisible(true);
	}

	public static void main(String[] args) {
		
		Calculator Calc = new Calculator();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<10;i++) {
			if(e.getSource() == this.numberButtons[i]) {
				this.textfield.setText(this.textfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()==this.decButton) {
			this.textfield.setText(this.textfield.getText().concat( "."));
		}
		if(e.getSource()==this.addButton) {
            this.num1 = Double.parseDouble(this.textfield.getText());
            this.operator = '+';
            this.textfield.setText("");
        }
		if(e.getSource()==this.subButton) {
            this.num1 = Double.parseDouble(this.textfield.getText());
            this.operator = '-';
            this.textfield.setText("");
        }
		if(e.getSource()==this.mulButton) {
            this.num1 = Double.parseDouble(this.textfield.getText());
            this.operator = '*';
            this.textfield.setText("");
        }
		if(e.getSource()==this.divButton) {
            this.num1 = Double.parseDouble(this.textfield.getText());
            this.operator = '/';
            this.textfield.setText("");
        }
		if(e.getSource()==this.equButton) {
			this.num2 = Double.parseDouble(this.textfield.getText());

			switch(this.operator) {
				case'+':
				this.result=this.num1+this.num2;
				break;
				case'-':
				this.result=this.num1-this.num2;
				break;
				case'*':
				this.result=this.num1*this.num2;
				break;
				case'/':
				this.result=this.num1/this.num2;
				break;
			}
			this.textfield.setText(String.valueOf(this.result));
			this.num1=this.result;
		}
		if(e.getSource()==this.clrButton) {
			this.textfield.setText("");
		}
		if(e.getSource()==this.delButton) {
			String string = this.textfield.getText();
			this.textfield.setText("");
			for(int i=0;i<string.length()-1;i++) {
				this.textfield.setText(this.textfield.getText()+string.charAt(i));
			}      
		}
		if(e.getSource()==this.negButton) {
			double temp = Double.parseDouble(this.textfield.getText());
			temp*=-1;
			this.textfield.setText(String.valueOf(temp));
		}
		
    }
}