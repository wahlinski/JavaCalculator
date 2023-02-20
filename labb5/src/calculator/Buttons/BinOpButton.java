package calculator.Buttons;

import calculator.Situation;

public class BinOpButton extends CalculatorButton{
    private String label;
    private Situation situation;
    public BinOpButton(String label, Situation situation){
        super(label, situation);
        this.label = label;
        this.situation = situation;
    }
    @Override
    public void transition() {
        switch (situation.getState()){
            case Input1:
                situation.setLeftOperand(0);
                situation.getDisplay().setText("0");
                break;
            case OpReady:
                situation.setLeftOperand(0);
                situation.getDisplay().setText("0");
                break;
            case Input2:
                situation.setLeftOperand(0);
                situation.getDisplay().setText("0");
                break;
            case HasResult:
                situation.setLeftOperand(0);
                situation.getDisplay().setText("0");
                break;
        }
    }
}
