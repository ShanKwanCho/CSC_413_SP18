/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondgame;


import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Shan
 */
public class Secondgame {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Gameplay panel = new Gameplay (new ImageIcon("Sources/Background2.png").getImage());

        
        JFrame obj = new JFrame();
        Gameplay gamePlay = new Gameplay(); // create object

        obj.setBounds(10, 10, 700, 600); // set bound 
        obj.setTitle("Let's Break Wall");
        obj.setResizable(false);

        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(gamePlay);
          
        obj.setLocationRelativeTo(null); // make the game box display to the center of the screen

        obj.setVisible(true); // must be underneath to be visible 
        //obj.add(gamePlay);
      

        

    }

}
