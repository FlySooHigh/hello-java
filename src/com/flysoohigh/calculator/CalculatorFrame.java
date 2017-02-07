package com.flysoohigh.calculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class CalculatorFrame extends JFrame
{  
   private static final long serialVersionUID = -5160427118881571327L;
   
   private JLabel display;

   private double lastValue;
   private String lastOperator;
   private boolean startNewValue;   

   private static final int FRAME_WIDTH = 400;
   private static final int FRAME_HEIGHT = 300;

   public CalculatorFrame()
   {
      createButtonPanel();

      display = new JLabel("0");
      add(display, BorderLayout.NORTH);

      lastValue = 0;
      lastOperator = "=";
      startNewValue = true;

      setSize(FRAME_WIDTH, FRAME_HEIGHT);
   }
      
   private void createButtonPanel()
   {      
      JPanel buttonPanel = new JPanel();
      buttonPanel.setLayout(new GridLayout(4, 4));

      buttonPanel.add(makeDigitButton("7"));
      buttonPanel.add(makeDigitButton("8"));
      buttonPanel.add(makeDigitButton("9"));
      buttonPanel.add(makeOperatorButton("/"));
      
      buttonPanel.add(makeDigitButton("4"));
      buttonPanel.add(makeDigitButton("5"));
      buttonPanel.add(makeDigitButton("6"));
      buttonPanel.add(makeOperatorButton("*"));
      
      buttonPanel.add(makeDigitButton("1"));
      buttonPanel.add(makeDigitButton("2"));
      buttonPanel.add(makeDigitButton("3"));
      buttonPanel.add(makeOperatorButton("-"));
      
      buttonPanel.add(makeDigitButton("0"));
      buttonPanel.add(makeDigitButton("."));
      buttonPanel.add(makeOperatorButton("="));
      buttonPanel.add(makeOperatorButton("+"));

      add(buttonPanel, BorderLayout.CENTER);
   }

   public JButton makeDigitButton(String digit)
   {
      JButton button = new JButton(digit);      
      ActionListener listener = new DigitButtonListener(digit);
      button.addActionListener(listener);  
      return button;    
   } 
   
   class DigitButtonListener implements ActionListener
   {
      private String digit;
      
      public DigitButtonListener(String aDigit)
      {
         digit = aDigit;
      }
      
      public void actionPerformed(ActionEvent event)
      {  
         if (startNewValue) 
         {
            display.setText("");
            startNewValue = false;
         }
         display.setText(display.getText() + digit);
      }        
   }

   public JButton makeOperatorButton(String op)
   {
      JButton button = new JButton(op);      
      ActionListener listener = new OperatorButtonListener(op);
      button.addActionListener(listener);  
      return button;    
   } 
   
   class OperatorButtonListener implements ActionListener
   {
      private String operator;

      public OperatorButtonListener(String anOperator)
      {
         operator = anOperator;
      }

      public void actionPerformed(ActionEvent event)
      {  
         if (!startNewValue)
         {  
            double value = Double.parseDouble(display.getText());
            lastValue = calculate(lastValue, value, lastOperator);
            display.setText("" + lastValue);
            startNewValue = true;
         }
            
         lastOperator = operator;
      }       
   }
   
   public double calculate(double value1, double value2, String op)
   {  
      if (op.equals("+")) 
      {
         return value1 + value2;
      }
      else if (op.equals("-")) 
      {
         return value1 - value2;
      }
      else if (op.equals("*")) 
      {
         return value1 * value2;
      }
      else if (op.equals("/")) 
      {
         return value1 / value2;
      }
      else 									// "="
      {
         return value2;
      }
   }
}
