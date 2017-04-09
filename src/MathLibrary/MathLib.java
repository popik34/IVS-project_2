package MathLibrary;

/**
 *
 * @author Lukáš Salvet, Jan Samek
 */
public class MathLib {
    
    public static double plus(double operand1, double operand2){
        return 0;
    }
    
    public static double minus(double operand1, double operand2){
        return 0;
    }
    
    public static double multiplication(double operand1, double operand2){
        return 0;
    }
    
    public static double divident(double operand1, double operand2) throws ArithmeticException{
        if (operand2 == 0) {
            throw new ArithmeticException("Divide by zero error");
        }
        return 0;
    }
    
            
    public static double factorial(long number) throws IllegalArgumentException {
		if (number < 0){
			throw new IllegalArgumentException();
		}
		else if (number == 0){
			return 1;
		}
		
		double result = number;
		
		while(number != 1){
			result *= --number; 
		}
		
        return result;
    }
        
	public static double pow(double number, int n) {
		if (n < 0) {
			throw new IllegalArgumentException();
		}
		else if (n == 0) {
			return 1;
		}
		
		double result = 1;
		for (int i = 0; i < n; i++){
			result *= number;
		}		
		return result;
	}
	
    public static double root(double number, double n){
        
        return number;
    }
    
    public static int abs(int number){
        if (number > 0){
			return number;
		}
		else{
			return number * -1;
		}
    }
    
    public static long abs(long number){
        if (number > 0){
			return number;
		}
		else{
			return number * -1;
		}
    }
    
    public static float abs(float number){
		if (number > 0) {
			return number;
		} else {
			return number * -1;
		}        
    }
    
    public static double abs(double number){
		if (number > 0) {
			return number;
		} else {
			return number * -1;
		}        
    }
    
}
