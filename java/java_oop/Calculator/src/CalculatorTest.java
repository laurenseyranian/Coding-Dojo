
public class CalculatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calculator calculator = new Calculator();
		
		calculator.setOperandOne(10.5);
		calculator.setOperation("+");
		calculator.setOperandTwo(5.2);
		calculator.performOperation();
		System.out.println(calculator.getResults());
	}

}
