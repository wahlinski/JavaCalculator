package calculator;

import java.awt.event.*;
import calculator.Buttons.*;

public class buttonActionListner implements ActionListener{
    public void actionPerformed(ActionEvent e){
       ((CalculatorButton)e.getSource()).transition(); 
    }
}
