package sk.uniza.fri;

public class Delenie implements Operacia {
    @Override
    public double vykonaj(double operand1, double operand2) {
        if (operand2 == 0) {
            throw new ArithmeticException("Delenie nulou");
        }
        return operand1 / operand2;
    }
}
