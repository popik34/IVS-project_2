package Model;

/**
 *
 * @author Lukáš Salvet, Jan Samek
 */
public class MathLib {
    
	/**
	 * Sečte dvě čísla
	 * @param a
	 * @param b
	 * @return a + b
	 */
	public static double addition (double a, double b){
		return a + b;
	}
	
	/**
	 * Odečte dvě čísla
	 * @param a
	 * @param b
	 * @return a - b
	 */
	public static double subtraction (double a, double b){
		return a - b;
	} 
	
	/**
	 * Vynásobí dvě čísla
	 * @param a
	 * @param b
	 * @return a * b
	 */
	public static double multiplication (double a, double b){
		return a * b;
	}
	
	/**
	 * Vydělí dvě čísla
	 * @param a
	 * @param b
	 * @return a / b
	 * @throws IllegalArgumentException při dělení nulou
	 */
	public static double division (double a, double b){
		if (b == 0){
			throw new IllegalArgumentException(); 
		}
		
		return a / b;
	}
	
	/**
	 * Vypočítá faktoriál zadaného čísla
	 * @param number
	 * @return faktoriál
	 * @throws IllegalArgumentException pokud je číslo menší než 0
	 */
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
    
	/**
	 * Vypočítá n-tou mocninu čísla number
	 * @param number
	 * @param n přirozený exponent
	 * @return n-tá odmocnina čísla number
	 * @throws IllegalArgumentException pokud n není přirozené číslo
	 */
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
	
	/**
	 * Provede n-tou odmocninu
	 * @param number
	 * @param n
	 * @return n-tá odmocnina čísla number
	 * @throws IllegalArgumentException pokud je odmocněnec záporný
	 */
    public static double root(double number, double n){
        if (number < 0){
			throw new IllegalArgumentException();
		}
		else if (number == 0){
			return 0;
		}
		
		return Math.pow(number, 1/n);
    }
    
	/**
	 * Absolutní hodnota
	 * @param number
	 * @return absolutní hodnota čísla number
	 */
    public static int abs(int number){
        if (number > 0){
			return number;
		}
		else{
			return number * -1;
		}
    }
 	
	/**
	 * Absolutní hodnota
	 * @param number
	 * @return absolutní hodnota čísla number
	 */   
    public static long abs(long number){
        if (number > 0){
			return number;
		}
		else{
			return number * -1;
		}
    }
    
	/**
	 * Absolutní hodnota
	 * @param number
	 * @return absolutní hodnota čísla number
	 */
    public static float abs(float number){
		if (number > 0) {
			return number;
		} 
		else {
			return number * -1;
		}        
    }
    
	/**
	 * Absolutní hodnota
	 * @param number
	 * @return absolutní hodnota čísla number
	 */
    public static double abs(double number){
		if (number > 0) {
			return number;
		} 
		else {
			return number * -1;
		}        
    }

	public static double reciprocal(double number){
		return division(1, number);
	}

	public static double logarithm(double number) {
		return Math.log(number);
	}
}
