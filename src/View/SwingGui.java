package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Ondra on 17. 4. 2017.
 */
public class SwingGui {
    private JFrame mainFrame;
    private JPanel mainPanel;
    private JTextField inputTextField;
    private GridBagConstraints constraints;
    private ArrayList<JButton> buttons = new ArrayList<JButton>();

    public SwingGui() {
        InitFrame();
        InitPanel();
        InitTextField();
        InitButtons();
        
        AddComponentsToPanel();
        
        AddPanelToFrameAndSetToVisible();
    }



    private void AddComponentsToPanel() {
        constraints.insets = new Insets(5,5,5,5);
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;

        //TextField
        constraints.gridwidth = 4;
        constraints.gridheight = 4;
        constraints.fill = GridBagConstraints.BOTH;
        mainPanel.add(inputTextField, constraints);

        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.gridx = 0;
        constraints.gridy = 1;
        mainPanel.add(new JPanel(), constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        mainPanel.add(new JPanel(), constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        mainPanel.add(new JPanel(), constraints);

        //Buttons
        int x = 0;
        int y = 4;

        for (JButton button : buttons)
        {
            constraints.gridx = x;
            constraints.gridy = y;
            constraints.fill = GridBagConstraints.BOTH;

            mainPanel.add(button, constraints);

            x++;

            if (x == 4)
            {
                y++;
                x = 0;
            }
        }

    }

    private void AddPanelToFrameAndSetToVisible() {
        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }

    private void InitButtons() {

        JButton button;

        //x^y
        button = new JButton("<html>x<sup>y</sup></html>");
        buttons.add(button);

        //sqrt[y]{x}
        button = new JButton("<html><sup>y</sup>&radic;x</html>");
        buttons.add(button);

        //x!
        button = new JButton("<html>x!</html>");
        buttons.add(button);

        //1/x
        button = new JButton("<html>1/x</html>");
        buttons.add(button);

        //log
        button = new JButton("<html>log</html>");
        buttons.add(button);

        //C
        button = new JButton("<html>C</html>");
        buttons.add(button);

        //DEL
        button = new JButton("<html>DEL</html>");
        buttons.add(button);

        //division
        button = new JButton("<html>&divide;</html>");
        buttons.add(button);

        //7
        button = new JButton("<html>7</html>");
        buttons.add(button);

        //8
        button = new JButton("<html>8</html>");
        buttons.add(button);

        //9
        button = new JButton("<html>9</html>");
        buttons.add(button);

        //multiplication
        button = new JButton("<html>&times;</html>");
        buttons.add(button);

        //4
        button = new JButton("<html>4</html>");
        buttons.add(button);

        //5
        button = new JButton("<html>5</html>");
        buttons.add(button);

        //6
        button = new JButton("<html>6</html>");
        buttons.add(button);

        //addition
        button = new JButton("<html>+</html>");
        buttons.add(button);

        //1
        button = new JButton("<html>1</html>");
        buttons.add(button);

        //2
        button = new JButton("<html>2</html>");
        buttons.add(button);

        //3
        button = new JButton("<html>3</html>");
        buttons.add(button);

        //subtraction
        button = new JButton("<html>-</html>");
        buttons.add(button);

        // * -1
        button = new JButton("<html>&plusmn;</html>");
        buttons.add(button);

        //0
        button = new JButton("<html>0</html>");
        buttons.add(button);

        //floating point
        button = new JButton("<html>,</html>");
        buttons.add(button);

        //equal
        button = new JButton("<html>=</html>");
        buttons.add(button);

        for (JButton forButton : buttons)
        {
            forButton.setPreferredSize(new Dimension(30, 30));
            forButton.setFont(new Font("SansSerif", Font.PLAIN, 20));
        }
    }

    private void InitTextField() {
        inputTextField = new JTextField();
        inputTextField.setHorizontalAlignment(JTextField.RIGHT);
        inputTextField.setFont(new Font("SansSerif", Font.BOLD, 40));
    }

    private void InitPanel() {
        mainPanel = new JPanel(new GridBagLayout());
//        mainPanel.setBackground(Color.black);
        constraints = new GridBagConstraints();
    }

    private void InitFrame() {
        mainFrame = new JFrame("IVS Calculator");
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setSize(400,600);
    }


}
