package calculator.Buttons;

import calculator.Situation;

import static calculator.State.*;

public class EqualsButton extends CalculatorButton{
    public EqualsButton(String label, Situation situation){
        //
        super(label, situation);
    }
    // Override the transition method from the CalculatorButton class, now that we made it concrete method.
    @Override
    public void transition() {
        switch (situation.getState()){   //switch based on current state
            case Input1:
                // If the calculator is in the Input1 state, set the display to show the left operand
                situation.setState(Input1);
                situation.getDisplay().setText(Integer.toString(situation.getLeftOperand()));
                break;
            case OpReady:
                // If the calculator is in the OpReady state, set the display to show the left operand
                situation.setState(OpReady);
                situation.getDisplay().setText(Integer.toString(situation.getLeftOperand()));
                break;
            case Input2:
                // If the calculator is in the Input2 state, perform the appropriate math operation on the left and right operands,
                // set the result as the new left operand, and update the state of the calculator
                int result= situation.getBinaryOperatorButton().getBinaryOperator().applyAsInt(situation.getLeftOperand(), Integer.parseInt(situation.getDisplay().getText()) );
                situation.getDisplay().setText(Integer.toString(result));
                situation.setLeftOperand(result);
                situation.setState(HasResult);
                situation.getBinaryOperatorButton().resetButton();
                break;
            case HasResult:
                //set the display to show the left operand
                situation.setState(HasResult);
                situation.getDisplay().setText(Integer.toString(situation.getLeftOperand()));
                break;
        }
    }
}

