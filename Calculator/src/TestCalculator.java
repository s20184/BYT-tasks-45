class TestCalculator
{
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        //Calling chain of responsibility
        calculator.calculate(new Operation(1,3,'+'));
        calculator.calculate(new Operation(1,3,'-'));
        calculator.calculate(new Operation(1,3,'*'));
        calculator.calculate(new Operation(1,3,'/'));
    }
}
