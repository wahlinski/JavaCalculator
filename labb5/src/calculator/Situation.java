package calculator;

import javax.swing.*;

import calculator.Buttons.BinOpButton;

public class Situation{

    private State state = State.Input1;
    private JLabel display;
    private BinOpButton binaryOperator;
    private int leftOperand;
    
    Situation(JLabel display){
        //
        // Sets the display element in the instance to the one recived as an argument and
        // sets the leftOperand variable its start value, 0.
        //
        this.display = display;
        this.leftOperand = 0;
    }
    public State getState(){
        //
        // Returns current state.
        //
        return this.state;
    }
    public void setState(State state){
        //
        // Sets current state to the one recevied as arguemnt.
        //
        this.state = state;
    }
    public void setBinaryOperatorButton(BinOpButton bo){
        //
        // Sets current binaryOperatorButton to the one recevied as arguemnt.
        //
        this.binaryOperator = bo;
    }
    public BinOpButton getBinaryOperatorButton() {
        //
        // Returns current binaryOperatorButton.
        //
        return binaryOperator;
    }
    public int getLeftOperand(){
        //
        // Returns current value of leftOperand.
        //
        return this.leftOperand;
    }
    public JLabel getDisplay(){
        //
        // Returns a reference to the display element.
        //
        return this.display;
    }
    public void setLeftOperand(int leftOperand){
        //
        // Sets value of leftOperand.
        //
        this.leftOperand = leftOperand;
    }
}