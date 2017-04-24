import Controller.Controller;
import Model.MathLib;
import View.SwingGui;

/**
 * Main třída, inicializuje View a Model, které předá Controlleru
 * @author Ondra
 */
public class Main {
    public static void main(String[] args)
    {
        SwingGui view = new SwingGui();
        MathLib model = new MathLib();

        new Controller(model, view);
    }
}
