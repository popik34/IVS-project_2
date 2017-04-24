/****************************************************************************************
 * Název projektu: IVS-project_2
 * Balíček: MathTests
 * Soubor: MathematicOperationTests.java
 * Autor: xpospi87, xsamek06, xsalve06
 * Popis: Třída pro testování matematické knihovny
 ****************************************************************************************/
package MathTests;

import Model.MathLib;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class MathematicOperationTests {
    
    @Test
    public void _6_plus_minus20_isMinus14() {
         assertEquals("Spatne pocita.", -14, MathLib.addition(6, -20), 0.001);
    }
    
    @Test
    public void _minus6_minus_minus20_14() {
         assertEquals("Spatne pocita.", 14, MathLib.subtraction(-6, -20), 0.001);
    }
    
    @Test
    public void _minus6_multiplication_minus5_isMinus30() {
         assertEquals("Spatne pocita.", 30, MathLib.multiplication(-6, -5), 0.001);
    }
    
    @Test
    public void _17_multiplication_0_is0() {
         assertEquals("Spatne pocita.", 0, MathLib.multiplication(17, 0), 0.001);
    }
    
    @Test
    public void _60_div_minus30_isMinus2() {
         assertEquals("Spatne pocita.", -2, MathLib.division(60, -30), 0.001);
    }
    
    @Test
    public void _60_div_2dot2_is27() {
         assertEquals("Spatne pocita.", 27.27272727, MathLib.division(60, 2.2), 0.001);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void _100_div_0_ExceptionExpected() {
         MathLib.division(100, 0);
    }
    
    @Test
    public void factorial_5_is120() {
         assertEquals("Spatne pocita.", 120, MathLib.factorial(5), 1);
    }
    
    @Test
    public void factorial_0_is1() {
         assertEquals("Spatne pocita.", 1, MathLib.factorial(0), 1);
    }
    
    @Test
    public void factorial_1_is1() {
         assertEquals("Spatne pocita.", 1, MathLib.factorial(1), 1);
    }
    
    @Test
    public void factorial_100_isRealyBigNumber() {
         assertEquals("Spatne pocita.", 9.332621544394418E157, MathLib.factorial(100), 1);
    }
    
    @Test
    public void factorial_1000_expectedInfinite() {
         assertTrue("hodnota by mela byt tak velka,ze se nevleze do double.", Double.isInfinite(MathLib.factorial(1000)));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void factorialMinus5_ExceptionExpected() {
        MathLib.factorial(-5);
    }
    
    @Test
    public void _0_pow_2_is0() {
         assertEquals("Spatne pocita.", 0, MathLib.pow(0, 2), 0.01);
    }
    
    @Test
    public void _1234_pow_0_is1() {
         assertEquals("Spatne pocita.", 1, MathLib.pow(1234, 0), 0.01);
    }
    
    @Test
    public void _42_pow_2_is1764() {
         assertEquals("Spatne pocita.", 1764, MathLib.pow(42, 2), 0.01);
    }
    
    @Test
    public void _2dot2_pow_3_is10dot648() {
         assertEquals("Spatne pocita.", 10.648, MathLib.pow(2.2, 3), 0.01);
    }
    
    @Test
    public void _165_pow_1_is165() {
         assertEquals("Spatne pocita.", 165, MathLib.pow(165, 1), 0.01);
    }
    
    @Test
    public void _minus9_pow_2_is81() {
         assertEquals("Spatne pocita.", 81, MathLib.pow(9, 2), 0.01);
    }
    
    @Test
    public void _minus9_pow_3_isMinus729() {
         assertEquals("Spatne pocita.", -729, MathLib.pow(-9, 3), 0.01);
    }
        
    @Test
    public void _99_pow_9999_expectedInf() {
         assertTrue("hodnota by mela byt tak velka,ze se nevleze do double.", Double.isInfinite(MathLib.pow(99, 9999)));
    }
    
    @Test
    public void _5_rootOf_59049_is9() {
         assertEquals("Spatne pocita.", 9, MathLib.root(59049, 5), 0.01);
    }
    
    @Test
    public void _2_rootOf_50_is7dot07() {
         assertEquals("Spatne pocita.", 7.071, MathLib.root(50, 2), 0.01);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void _2_rootOf_minus50_ExceptionExpected() {
        MathLib.root(-50, 2);
    }
    
    @Test
    public void _2_rootOf_25dot1_is5dot0099() {
         assertEquals("Spatne pocita.", 5.0099, MathLib.root(25.1, 2), 0.01);
    }
    
    @Test
    public void _3_rootOf_216_is6() {
         assertEquals("Spatne pocita.", 6, MathLib.root(216, 3), 0.01);
    }
    
    @Test
    public void _5_abs_is5() {
         assertEquals("Spatne pocita.", 5, MathLib.abs(5));
    }
    
    @Test
    public void _minus5_abs_is5() {
         assertEquals("Spatne pocita.", 5, MathLib.abs(-5));
    }
    
    @Test
    public void _minus6_abs_is6() {
         assertEquals("Spatne pocita.", 6, MathLib.abs((long)-6));
    }
    
    @Test
    public void _minus7dot5_abs_is7dot5() {
         assertEquals("Spatne pocita.", 7.5, MathLib.abs(-7.5), 1);
    }
    
    @Test
    public void _8dot5_abs_is8dot5() {
         assertEquals("Spatne pocita.", 8.5, MathLib.abs(8.5), 1);
    }
    
    @Test
    public void _minus0dot5_abs_is0dot5() {
         assertEquals("Spatne pocita.", 0.5, MathLib.abs(0.5f), 1);
    }
}
