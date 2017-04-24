/****************************************************************************************
 * Název projektu: IVS-project_2
 * Soubor: Main.java
 * Autor: xpospi87, xsamek06, xsalve06
 * Popis: Hlavní třída programu
 ****************************************************************************************/

/**
 * @file MathLib.java
 * @author xpospi87, xsamek06, xsalve02
 * @brief Matematická knihovna 
 */
import Controller.Controller;
import Model.MathLib;
import View.SwingGui;

/**
 * Main třída, inicializuje View a Model, které předá Controlleru
 * @brief Hlavní třída programu
 */
public class Main {
	/**
   	 * Vytvoří model, view a controller
	 */
    public static void main(String[] args)
    {
        SwingGui view = new SwingGui();
        MathLib model = new MathLib();

        new Controller(model, view);
    }
}
