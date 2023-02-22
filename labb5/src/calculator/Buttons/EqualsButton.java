package calculator.Buttons;

import calculator.Situation;
import calculator.State;

import static calculator.State.*;

public class EqualsButton extends CalculatorButton{
    private String label;
    private Situation situation;
    public EqualsButton(String label, Situation situation){
        //
        super(label, situation);
        this.label = label;
        this.situation = situation;
    }
    @Override
    public void transition() {
        switch (situation.getState()){
            case Input1:
                situation.setState(Input1);
                situation.getDisplay().setText(Integer.toString(situation.getLeftOperand()));
                break;
            case OpReady:
                situation.setState(OpReady);
                situation.getDisplay().setText(Integer.toString(situation.getLeftOperand()));
                break;
            case Input2:
                int result= situation.getBinaryOperatorButton().getBinaryOperator().applyAsInt(situation.getLeftOperand(), Integer.parseInt(situation.getDisplay().getText()) );
                situation.getDisplay().setText(Integer.toString(result));
                situation.setLeftOperand(result);
                situation.setState(HasResult);
                situation.getBinaryOperatorButton().resetButton();
                break;
            case HasResult:
                situation.setState(HasResult);
                situation.getDisplay().setText(Integer.toString(situation.getLeftOperand()));
                break;
        }
    }
}


