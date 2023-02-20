package calculator;

import javax.swing.*;

public class Situation{
    State state = State.Input1;
    JLabel display;
    //BinOpButton binaryOperator;
    int leftOperand;
    Situation(JLabel display){
        this.display = display;
        this.leftOperand = 0;
    }
    public State getState(){
        return this.state;
    }
    public int getLeftOperand(){
        return this.leftOperand;
    }
    public JLabel getDisplay(){
        return this.display;
    }
    public void setLeftOperand(int leftOperand){
        this.leftOperand = leftOperand;
    }
}