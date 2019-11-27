
public class Calculator {
	private double number1;
	private double number2;
	private String operation;
	
	
	public void setOperandOne(double number1){
		this.number1 =  number1;
	}
	public void setOperandTwo(double number2){
		this.number2 = number2;
	}
	public void setOperation(String operation){
		this.operation = operation;
	}
	public void performOperation(){
		if (this.operation == "+") {
			this.number1 += this.number2;
		} 
		else if (this.operation == "-") {
				this.number1 -= this.number2;
		}
		else {
			System.out.println("Invalid input");
		}
		
	}
	public double getResults(){
		return this.number1;
	}
	
}
