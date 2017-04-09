package MathLibrary;

/**
 *
 * @author Lukáš Salvet, Jan Samek
 */
public class MathLib {
    
    public static double factorial(long number) throws IllegalArgumentException{
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
    
    public static double exp(double number, double n){
        
        return number;
    }
    
	public static double pow(double number, int n){
		return number;
	}
	
    public static double sqrt(double number, double n){
        
        return number;
    }
    
    public static int abs(int number){
        
        return number;
    }
    
    public static long abs(long number){
        
        return number;
    }
    
    public static float abs(float number){
        
        return number;
    }
    
    public static double abs(double number){
        
        return number;
    }
    
}
