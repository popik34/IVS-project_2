/****************************************************************************************
 * Název projektu: IVS-project_2
 * Balíček: View
 * Soubor: SwingGui.java
 * Autor: xpospi87, xsamek06, xsalve06
 * Popis: Grafické rozhraní
 ****************************************************************************************/

/**
 * @file SwingGui.java
 * @author xpospi87, xsamek06, xsalve02
 * @brief Grafické rozhraní 
 */
package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Třída představující View, všechno co uživatel vidí je zde
 * @brief Grafické rozhraní
 */
public class SwingGui {
    private JFrame mainFrame;
    private JPanel mainPanel;
    private JTextField textField;
    private JTextField statementField;
    private GridBagConstraints constraints;
    private ArrayList<JButton> buttons = new ArrayList<>();


    /**
     * Konstruktor, volá potřebné metody pro vykreslení GUI
     */
    public SwingGui() {
        InitFrame();
        InitPanel();
        InitTextField();
        InitButtons();
        
        AddComponentsToPanel();
        
        AddPanelToFrameAndSetToVisible();
    }

    /**
     * Funkce pro přístup k listu buttonů
     * @return list buttonů
     */
    public ArrayList<JButton> getButtons()
    {
        return this.buttons;
    }

    /**
     * Funkce pro přístup k textovému poli
     * @return textové pole
     */
    public JTextField getTextField()
    {
        return this.textField;
    }

    public JTextField getStatementField()
    {
        return this.statementField;
    }

    /**
     * Vloží veškeré componenty do JPanelu
     */
    private void AddComponentsToPanel() {
        this.constraints.insets = new Insets(5,5,5,5);
        this.constraints.weightx = 1.0;
        this.constraints.weighty = 1.0;

        //TextField
        this.constraints.gridwidth = 4;
        this.constraints.gridheight = 4;
        this.constraints.fill = GridBagConstraints.BOTH;
        this.mainPanel.add(this.textField, this.constraints);

        this.constraints.gridwidth = 1;
        this.constraints.gridheight = 1;
        this.constraints.gridx = 0;
        this.constraints.gridy = 1;
        this.mainPanel.add(new JPanel(), this.constraints);

        this.constraints.gridx = 0;
        this.constraints.gridy = 2;
        this.mainPanel.add(new JPanel(), this.constraints);

        this.constraints.gridx = 0;
        this.constraints.gridy = 3;
        this.mainPanel.add(new JPanel(), this.constraints);

        this.constraints.gridwidth = 4;
        this.constraints.gridx = 0;
        this.constraints.gridy = 4;
        this.constraints.fill = GridBagConstraints.BOTH;
        this.mainPanel.add(this.statementField, this.constraints);

        //Buttons
        this.constraints.gridwidth = 1;
        int x = 0;
        int y = 5;

        for (JButton button : buttons)
        {
            this.constraints.gridx = x;
            this.constraints.gridy = y;
            this.constraints.fill = GridBagConstraints.BOTH;

            this.mainPanel.add(button, constraints);

            x++;

            if (x == 4)
            {
                y++;
                x = 0;
            }
        }

    }

    /**
     * Finální vykreslení, vloží JPanel do JFrame a nastaví ho na visible
     */
    private void AddPanelToFrameAndSetToVisible() {
        this.mainFrame.add(mainPanel);
        this.mainFrame.setVisible(true);
    }

    /**
     *  Inicializuje buttony, jejich textovou reprezentaci a akci kterou mají provést
     */
    private void InitButtons() {

        JButton button;

        //x^y
        button = new JButton("<html>x<sup>y</sup></html>");
        button.setActionCommand("pow");
        this.buttons.add(button);

        //sqrt[y]{x}
        button = new JButton("<html><sup>y</sup>&radic;x</html>");
        button.setActionCommand("root");
        this.buttons.add(button);

        //x!
        button = new JButton("<html>x!</html>");
        button.setActionCommand("factorial");
        this.buttons.add(button);

        //1/x
        button = new JButton("<html>1/x</html>");
        button.setActionCommand("reciprocal");
        this.buttons.add(button);

        //log
        button = new JButton("<html>log</html>");
        button.setActionCommand("logarithm");
        this.buttons.add(button);

        //C
        button = new JButton("<html>C</html>");
        button.setActionCommand("reset");
        this.buttons.add(button);

        //DEL
        button = new JButton("<html>DEL</html>");
        button.setActionCommand("delete");
        this.buttons.add(button);

        //division
        button = new JButton("<html>&divide;</html>");
        button.setActionCommand("division");
        this.buttons.add(button);

        //7
        button = new JButton("7");
        button.setActionCommand("number");
        this.buttons.add(button);

        //8
        button = new JButton("8");
        button.setActionCommand("number");
        this.buttons.add(button);

        //9
        button = new JButton("9");
        button.setActionCommand("number");
        this.buttons.add(button);

        //multiplication
        button = new JButton("<html>&times;</html>");
        button.setActionCommand("multiplication");
        this.buttons.add(button);

        //4
        button = new JButton("4");
        button.setActionCommand("number");
        this.buttons.add(button);

        //5
        button = new JButton("5");
        button.setActionCommand("number");
        this.buttons.add(button);

        //6
        button = new JButton("6");
        button.setActionCommand("number");
        this.buttons.add(button);

        //addition
        button = new JButton("<html>+</html>");
        button.setActionCommand("addition");
        this.buttons.add(button);

        //1
        button = new JButton("1");
        button.setActionCommand("number");
        this.buttons.add(button);

        //2
        button = new JButton("2");
        button.setActionCommand("number");
        this.buttons.add(button);

        //3
        button = new JButton("3");
        button.setActionCommand("number");
        this.buttons.add(button);

        //subtraction
        button = new JButton("<html>-</html>");
        button.setActionCommand("subtraction");
        this.buttons.add(button);

        // * -1
        button = new JButton("<html>&plusmn;</html>");
        button.setActionCommand("sign");
        this.buttons.add(button);

        //0
        button = new JButton("0");
        button.setActionCommand("number");
        this.buttons.add(button);

        //floating point
        button = new JButton("<html>,</html>");
        button.setActionCommand("floating_point");
        this.buttons.add(button);

        //equal
        button = new JButton("<html>=</html>");
        button.setActionCommand("equal");
        this.buttons.add(button);

        for (JButton forButton : this.buttons)
        {
            forButton.setPreferredSize(new Dimension(30, 30));
            forButton.setFont(new Font("SansSerif", Font.PLAIN, 20));
        }
    }

    /**
     * Inicializuje textové pole JTextField a upraví jeho styl
     */
    private void InitTextField() {
        this.textField = new JTextField();
        this.textField.setHorizontalAlignment(JTextField.RIGHT);
        this.textField.setFont(new Font("SansSerif", Font.BOLD, 40));
        this.textField.setEditable(false);

        this.statementField = new JTextField();
        this.statementField.setHorizontalAlignment(JTextField.LEFT);
        this.statementField.setFont(new Font("SansSerif", Font.BOLD, 20));
        this.statementField.setEditable(false);
    }

    /**
     * Inicializace JPanelu a GridBagLayout
     */
    private void InitPanel() {
        this.mainPanel = new JPanel(new GridBagLayout());
        this.constraints = new GridBagConstraints();
    }

    /**
     * Inicializace JFrame, jeho názvu, defaultní akci na close a velikost
     */
    private void InitFrame() {
        this.mainFrame = new JFrame("IVS Calculator");
        this.mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.mainFrame.setSize(350,550);
        this.mainFrame.setMinimumSize(new Dimension(350,550));
    }


}
