import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorDemo implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numberButton = new JButton[10];
    JButton[] functionButton = new JButton[8];
    JButton addButton,subButton,multButton,divButton;
    JButton decButton,clrButton,delButton,equButton;

    JPanel jPanel;

    Font myFont = new Font("Mukta",Font.PLAIN,20);

    double num1=0,num2=0,result=0;
    char operator;


    CalculatorDemo(){
      frame = new JFrame("Calculator");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLayout(null);
      frame.setSize(420,520);

      textField = new JTextField();
      textField.setFont(myFont);
      textField.setBounds(50,25,300,50);

      addButton = new JButton("+");
      subButton = new JButton("-");
      multButton = new JButton("*");
      divButton = new JButton("/");
      decButton = new JButton(".");
      equButton = new JButton("=");
      delButton = new JButton("Delete");
      clrButton = new JButton("Clear");

      functionButton[0] = addButton;
      functionButton[1] = subButton;
      functionButton[2] = multButton;
      functionButton[3] = divButton;
      functionButton[4] = decButton;
      functionButton[5] = equButton;
      functionButton[6] = clrButton;
      functionButton[7] = delButton;

      for (int i=0;i<8;i++)
      {
          functionButton[i].addActionListener(this);
          functionButton[i].setFont(myFont);
          functionButton[i].setFocusable(false);
      }
      for (int i=0;i<10;i++)
      {
          numberButton[i] = new JButton(String.valueOf(i));
          numberButton[i].addActionListener(this);
          numberButton[i].setFont(myFont);
          numberButton[i].setFocusable(false);
      }

      delButton.setBounds(70,420,100,50);
      clrButton.setBounds(230,420,100,50);

     jPanel = new JPanel();
     jPanel.setBounds(50,100,300,300);
     jPanel.setLayout(new GridLayout(4,4,10,10));

     jPanel.add(numberButton[1]);
     jPanel.add(numberButton[2]);
     jPanel.add(numberButton[3]);
     jPanel.add(addButton);
     jPanel.add(numberButton[4]);
     jPanel.add(numberButton[5]);
     jPanel.add(numberButton[6]);
     jPanel.add(subButton);
     jPanel.add(numberButton[7]);
     jPanel.add(numberButton[8]);
     jPanel.add(numberButton[9]);
     jPanel.add(multButton);
     jPanel.add(decButton);
     jPanel.add(numberButton[0]);
     jPanel.add(equButton);
     jPanel.add(divButton);

      frame.add(jPanel);
      frame.add(delButton);
      frame.add(clrButton);
      frame.add(textField);
      frame.setVisible(true);
    }
    public static void main(String[] args) {
        CalculatorDemo cal = new CalculatorDemo();
    }
    @Override
    public void actionPerformed(ActionEvent e){
      for (int i=0;i<10;i++){
          if(e.getSource() == numberButton[i]){
            textField.setText(textField.getText().concat(String.valueOf(i)));
          }
      }
        if(e.getSource() == decButton){
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");

        }
        if(e.getSource() == subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");

        }
        if(e.getSource() == multButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");

        }
        if(e.getSource() == divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");

        }
        if(e.getSource() == equButton){
            num2 = Double.parseDouble(textField.getText());
            switch (operator){
                case '+': result = num1 + num2;
                          break;
                case '-': result = num1 - num2;
                    break;
                case '*': result = num1 * num2;
                    break;
                case '/': result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if(e.getSource() == clrButton){
         textField.setText("");
        }
        if(e.getSource() == clrButton){
         String string = textField.getText();
         textField.setText("");
         for (int i=0;i<string.length()-1;i++){
             textField.setText(textField.getText()+string.charAt(i));
         }
        }
    }
}
