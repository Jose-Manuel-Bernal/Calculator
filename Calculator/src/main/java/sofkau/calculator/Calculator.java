package sofkau.calculator;

public class Calculator {
    private static Operator plus = (x, y) -> x+y;;

    private static Operator minus = ((x, y) -> x-y);

    private static Double multiply (Double x, Double y) {
        if (y > 0){
            return plus.operation(x, multiply(x, minus.operation(y, 1.0)));
        }else if (y < 0){
            return plus.operation(-x, multiply(x, plus.operation(y, 1.0)));
        }
        return 0.0;
    }

    private static Double divide (Double x, Double y){
        if (y == 0) {
            throw new ArithmeticException("Math error");
        } else if (x.equals(y)) {
            return 1.0;
        }  else if (x < 0 && y > 0 || x > 0 && y < 0){
            return plus.operation(-1.0, divide(plus.operation(x,y), y));
        }
        else if (x < y) {
            return 0.0;
        }
        else {
            return plus.operation(1.0, divide(minus.operation(x, y), y));
        }
    }

    public static void main(String[] args) {
        Double a = -10.0;
        Double b = 2.0;

        System.out.println(plus.operation(a,b));
        System.out.println(minus.operation(a,b));
        System.out.println(multiply(a,b));
        System.out.println(divide(a,b));

    }
}
