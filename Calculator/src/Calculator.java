public class Calculator {
    // Calculator (at least 4) operations) or a similar example,
    // using the chain of responsibility design pattern

    Processor chain;

    public Calculator(){
        buildChain();
    }

    private void buildChain(){
        chain = new Add(new Subtract(new Multiply(new Divide(null))));
    }

    public void calculate(Operation request) {
        chain.process(request);
    }
}

abstract class Processor
{
    private Processor processor;

    public Processor(Processor processor){
        this.processor = processor;
    };

    public void process(Operation request){
        if(processor != null)
            processor.process(request);
    };
}

class Operation
{
    private double a;
    private double b;
    private char operation;

    public Operation(double a, double b, char op)
    {
        this.a = a;
        this.b = b;
        this.operation = op;
    }

    public double getA()
    {
        return this.a;
    }
    public  double getB(){
        return this.b;
    }
    public  char getOperation(){
        return this.operation;
    }
}

class Add extends Processor
{
    public Add(Processor processor){
        super(processor);

    }

    public void process(Operation request)
    {
        if (request.getOperation() == '+')
        {
            double result = request.getA() + request.getB();
            System.out.println("Result of addition: " + result);
        }
        else
        {
            super.process(request);
        }
    }
}

class Subtract extends Processor
{
    public Subtract(Processor processor){
        super(processor);
    }

    public void process(Operation request)
    {
        if (request.getOperation() == '-')
        {
            double result = request.getA() - request.getB();
            System.out.println("Result of subtraction: " + result);
        }
        else
        {
            super.process(request);
        }
    }
}

class Multiply extends Processor
{

    public Multiply(Processor processor){
        super(processor);
    }

    public void process(Operation request)
    {
        if (request.getOperation() == '*')
        {
            double result = request.getA() * request.getB();
            System.out.println("Result of multiplication: " + result);
        }
        else
        {
            super.process(request);
        }
    }
}

class Divide extends Processor
{

    public Divide(Processor processor){
        super(processor);
    }

    public void process(Operation request)
    {
        if (request.getOperation() == '/')
        {
            double result = request.getA() / request.getB();
            System.out.println("Result of division: " + result);
        }
        else
        {
            super.process(request);
        }
    }
}