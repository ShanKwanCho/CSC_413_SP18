
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.WindowConstants;

public class EvaluatorUI extends JFrame implements ActionListener {
    
    private TextField txField = new TextField();
    private Panel buttonPanel = new Panel();
    
    // total of 20 buttons on the calculator,
    // numbered from left to right, top to bottom
    // bText[] array contains the text for corresponding buttons
    private static final String[] bText = {
    "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3",
    "*", "0", "^", "=", "/", "(", ")", "C", "CE"
    };
    private Button[] buttons = new Button[bText.length];
    
    Evaluator eva = new Evaluator();
    
    public static void main(String argv[]) {
        EvaluatorUI calc = new EvaluatorUI();
    }
    
    public EvaluatorUI() {
        setLayout(new BorderLayout());
        
        add(txField, BorderLayout.NORTH);
        txField.setEditable(false);
        
        add(buttonPanel, BorderLayout.CENTER);
        buttonPanel.setLayout(new GridLayout(5, 4));
        
        //create 20 buttons with corresponding text in bText[] array
        for (int i = 0; i < 20; i++) {
            buttons[i] = new Button(bText[i]);
        }
        
        //add buttons to button panel
        for (int i = 0; i < 20; i++) {
            buttonPanel.add(buttons[i]);
        }
        
        //set buttons to listen mouse input
        for (int i = 0; i < 20; i++) {
            buttons[i].addActionListener(this);
        }
        
        setTitle("Calculator");
        setSize(400, 400);
        setLocationByPlatform(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent arg0) {
        Object[] button = null;
        
        //Checking condition
        if (arg0.getSource() != buttons[14] && arg0.getSource() != buttons[18] && arg0.getSource() != buttons[19]) {
            for (int i = 0; i < 20; i++) {
                //Check condition
                if (arg0.getSource() == buttons[i]) {
                    
                    txField.setText(txField.getText() + bText[i]);
                    System.out.println(txField.getText().toString());
                }
            }
        } //Checking condition
        else if (arg0.getSource() == buttons[18]) {
            //Declare and initialize
            String temp = txField.getText();
            
            //Checking condition
            if (!temp.equals("")) //Set
            {
                txField.setText(temp.substring(0, temp.length() - 1));
            }
        } //Checking condition
        else if (arg0.getSource() == buttons[14]) {
            //Declare and initialize
            String result = eva.eval(txField.getText().toString());
            
            txField.setText(result);//Result
        } //Checking condition
        else if (arg0.getSource() == buttons[19]) {
            txField.setText("");//Clear text field
        }
    }
}

