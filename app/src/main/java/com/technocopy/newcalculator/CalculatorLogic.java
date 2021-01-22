package com.technocopy.newcalculator;

public class CalculatorLogic {
    private StringBuilder inputString = new StringBuilder();
    private float argFirst;
    private float argSecond;
    private State state;
    private int action;

    // перечисляем аргументы действия
    private enum State {
        argFirstInput,
        argSecondInput,
        result
    }


    // конструктор для поля с первым числом
    public CalculatorLogic() {
        state = State.argFirstInput;
    }

    // нажатие на кнопки с цифрами
    public void onNumPress(int id) {
        if (state == State.result) {
            state = State.argFirstInput;  // если на экраене результат операции, то снова вводим первое число
            inputString.setLength(0);

        }
        // ограничиваем ввод чисел 15 цифрами
        if (inputString.length() < 15) {
            switch (id) {
                case R.id.button0:
                    if (inputString.length() != 0) {     // добавляем 0 только когда он не стоит в начале
                        inputString.append("0");
                    }
                    break;
                case R.id.button1:
                    inputString.append("1");
                    break;
                case R.id.button2:
                    inputString.append("2");
                    break;
                case R.id.button3:
                    inputString.append("3");
                    break;
                case R.id.button4:
                    inputString.append("4");
                    break;
                case R.id.button5:
                    inputString.append("5");
                    break;
                case R.id.button6:
                    inputString.append("6");
                    break;
                case R.id.button7:
                    inputString.append("7");
                    break;
                case R.id.button8:
                    inputString.append("8");
                    break;
                case R.id.button9:
                    inputString.append("9");
                    break;
                case R.id.buttonDot:
                    inputString.append(".");
                    break;
            }
        }
    }


    // нажатие на кнопки действий
    public void onActionPress(int actoinId) {
        if (actoinId == R.id.buttonEqual && state == State.argSecondInput) {
            argSecond = Float.parseFloat(inputString.toString());
            state = State.result;
            inputString.setLength(0);
            switch (action) {
                case R.id.buttonDivide:
                    inputString.append(argFirst / argSecond);
                    break;
                case R.id.buttonMult:
                    inputString.append(argFirst * argSecond);
                    break;
                case R.id.buttonPlus:
                    inputString.append(argFirst + argSecond);
                    break;
                case R.id.buttonMinus:
                    inputString.append(argFirst - argSecond);
                    break;
            }
        } else if (inputString.length() > 0 && state == State.argFirstInput) {
            argFirst = Float.parseFloat(inputString.toString());
            state = State.argSecondInput;
            inputString.setLength(0);
//            action = actoinId;

            switch (actoinId) {
                case R.id.buttonDivide:
                    action = R.id.buttonDivide;
                    break;
                case R.id.buttonMult:
                    action = R.id.buttonMult;
                    break;
                case R.id.buttonPlus:
                    action = R.id.buttonPlus;
                    break;
                case R.id.buttonMinus:
                    action = R.id.buttonMinus;
                    break;

            }

        }

    }

    public String getText() {
        return inputString.toString();

    }
}
