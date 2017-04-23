package Controller;

import Model.MathLib;
import View.SwingGui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Třída představující Controller, propojuje Model a View
 * Reaguje na události vyvolané ve View a provede danou akci v Modelu
 * @author Ondra
 */
public class Controller implements ActionListener {
    private SwingGui view;
    private Double firstParam;
    private Double secondParam;
    private String action;
    private String textFieldString;

    /**
     * Konstruktor, uloží předáné hodnoty, zavolá nastavení ActionListeneru pro View
     * @param model - matematické knihovna
     * @param view - grafické rozhraní
     */
    public Controller(MathLib model, SwingGui view) {
        this.view = view;

        setActionListeners(this);
    }

    /**
     * Nastaví listener pro všechny buttony
     * @param actionListener - předá se každému buttonu, aby reagoval na události
     */
    private void setActionListeners(ActionListener actionListener) {
        ArrayList<JButton> buttons = view.getButtons();

        for (JButton button : buttons)
        {
            button.addActionListener(actionListener);
        }
    }

    /**
     * Pokud se stane nějaká událost, v našem případě klik na tlačítko
     * @param actionEvent - vyvolaná událost (stisk tlačítka)
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        this.textFieldString = this.view.getTextField().getText();

        switch (actionEvent.getActionCommand())
        {
            case "reset":
                cleanUp(null);
                setTextToTextField("");
                setTextToStatementField("");
                break;

            case "delete":
                if (!this.textFieldString.isEmpty())
                {
                    setTextToTextField(this.textFieldString.substring(0, textFieldString.length() - 1));
                }
                break;

            case "number":
                setTextToTextField(this.textFieldString + ((JButton) actionEvent.getSource()).getText());
                break;

            case "sign":
                if (parseStringIntoDouble() != null)
                {
                    setTextToTextField(((Double) (parseStringIntoDouble() * -1)).toString());
                }
                break;

            case "floating_point":
                if (!this.textFieldString.contains("."))
                {
                    setTextToTextField(this.textFieldString + ".");
                }
                break;

            case "reciprocal":
            case "logarithm":
            case "division":
            case "multiplication":
            case "addition":
            case "subtraction":
            case "pow":
            case "root":
            case "factorial":
                this.action = actionEvent.getActionCommand();
                loadParams("first");
                if (this.firstParam != null)
                {
                    setTextToStatementField(this.firstParam.toString() + " " + this.action);
                }
                break;

            case "equal":
                loadParams("second");

                System.out.println(this.firstParam);
                System.out.println(this.action);
                System.out.println(this.secondParam);

                if (isValidStatement())
                {
                    Double result = doMath();
                    if (result != null)
                    {
                        setTextToStatementField(result.toString());
                        if (!result.isInfinite())
                        {
                            cleanUp(result);
                        }
                        else
                        {
                            cleanUp(null);
                        }
                    }
                }
                break;
        }
    }

    /**
     * Volání matematických funkcí z modelu
     * @return - číslo typu Double
     */
    private Double doMath() {

        Double result = null;

        try{
            switch (this.action)
            {
                case "pow":
                    //test zdali je v doublu cele cislo
                    if((secondParam - secondParam.intValue()) != 0){
                        return exceptionMessageSet("Invalid entry");
                    }
                    result = MathLib.pow(this.firstParam, this.secondParam.intValue());
                    break;

                case "root":
                    result = MathLib.root(this.firstParam, this.secondParam);
                    break;

                case "factorial":
                    //test zdali je v doublu cele cislo
                    if((firstParam - firstParam.intValue()) != 0){
                        return exceptionMessageSet("Invalid entry");
                    }
                    result = MathLib.factorial(this.firstParam.intValue());
                    break;

                case "division":
                    result = MathLib.division(this.firstParam, this.secondParam);
                    break;

                case "multiplication":
                    result = MathLib.multiplication(this.firstParam, this.secondParam);
                    break;

                case "addition":
                    result = MathLib.addition(this.firstParam, this.secondParam);
                    break;

                case "subtraction":
                    result = MathLib.subtraction(this.firstParam, this.secondParam);
                    break;

                case "logarithm":
                    result = MathLib.logarithm(this.firstParam);
                    break;

                case "reciprocal":
                    result = MathLib.reciprocal(this.firstParam);
                    break;
            }
        }catch (IllegalArgumentException e){
            return exceptionMessageSet("Invalid entry");
        }catch (Exception e){
            return exceptionMessageSet("Unknown error");
        }

        return result;
    }
    
    /**
     * Vypíše chybovou hlášku
     * @param message chybová hláška
     * @return vrací null, ktere se pouziva v result pro indikaci, ze doslo k chybe
     */
    private Double exceptionMessageSet(String message){
        setTextToStatementField(message);
        cleanUp(null);
        return null;
    }

    /**
     * Načtení parametrů pro výpočet
     * @param firstOrSecond - pomocný string pro určení, jaký parametr načítám
     */
    private void loadParams(String firstOrSecond)
    {
        if (firstOrSecond.equals("first"))
        {
            if(parseStringIntoDouble() != null && this.firstParam == null)
            {
                this.firstParam = parseStringIntoDouble();
                setTextToTextField("");
            }
        }
        else if (firstOrSecond.equals("second") && this.secondParam == null && this.firstParam != null)
        {
            if(parseStringIntoDouble() != null)
            {
                this.secondParam = parseStringIntoDouble();
                setTextToTextField("");
            }
        }
    }

    /**
     * Vymazání aktuálního kontextu, ponechává výsledek výpočtu jako první parametr
     * @param number - výsledek matematické funkce
     */
    private void cleanUp (Double number)
    {
        this.firstParam = number;
        this.secondParam = null;
        this.action = null;
    }

    /**
     * Konverze Stringu na Double
     * @return číslo z textField typu Double
     */
    private Double parseStringIntoDouble() {
        /*
         * Číslo převadím na double pouze v případě, že string není prázdný
         */
        if (!this.textFieldString.isEmpty()) {
            /*
             * Je nutné testovat string na poslední znak, pokud je desetinná čárka, tak ji smažu
             */
            if (this.textFieldString.substring(this.textFieldString.length() - 1).equals("."))
            {
                if (this.textFieldString.length() > 1)
                {
                    return Double.parseDouble(this.textFieldString.substring(0, this.textFieldString.length() - 1));
                }
                else
                {
                    return null;
                }
            }
            else
            {
                return Double.parseDouble(this.textFieldString);
            }
        }
        else
        {
            return null;
        }
    }

    /**
     * Nastaví obsah textFieldu
     * @param string
     */
    private void setTextToTextField(String string)
    {
        this.view.getTextField().setText(string);
    }

    /**
     * Nastaví obsah textFieldu
     * @param string
     */
    private void setTextToStatementField(String string)
    {
        this.view.getStatementField().setText(string);
    }

    /**
     * Kontrola zda požadovaná operace je platná
     * tedy pokud je zadaný operátor a potřebné operandy
     * @return - boolean
     */
    private boolean isValidStatement() {
        if (this.action != null)
        {
            if (this.firstParam != null)
            {
                if (this.secondParam != null)
                {
                    return true;
                }
                else if (this.action.equals("factorial"))
                {
                    return true;
                }
                else if (this.action.equals("reciprocal"))
                {
                    return true;
                }
                else if (this.action.equals("logarithm"))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
}
