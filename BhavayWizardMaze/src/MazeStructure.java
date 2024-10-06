/* Bhavay Garg
 * 041102440
 * Professor - Daniel Cormeir
 * 
 */

/*
 * This class is for the maze structure it will create the maze and also wizards and components on it. 
 * 
 * 
 */

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MazeStructure {
	
	
	  // Declare the mazeTiles array
    public String[][] mazeTiles;
    public JButton[][] mazePattern = new JButton[8][8];
    // Constructor to initialize the array with the maze tile types and their quantities
    public MazeStructure() {
        mazeTiles = new String[11][3];

        // Initialize the array
        mazeTiles[0] = new String[]{"EW", "Images/EW.png", "8"};          // EW
        mazeTiles[1] = new String[]{"EWS", "Images/EWS.png", "4"};        // EWS
        mazeTiles[2] = new String[]{"NE", "Images/NE.png", "4"};          // NE
        mazeTiles[3] = new String[]{"NEW", "Images/NEW.png", "4"};        // NEW
        mazeTiles[4] = new String[]{"NS", "Images/NS.png", "8"};          // NS
        mazeTiles[5] = new String[]{"NSE", "Images/NSE.png", "4"};        // NSE
        mazeTiles[6] = new String[]{"NSEW", "Images/NSEW.png", "2"};      // NSEW
        mazeTiles[7] = new String[]{"NSW", "Images/NSW.png", "4"};        // NSW
        mazeTiles[8] = new String[]{"NW", "Images/NW.png", "4"};          // NW
        mazeTiles[9] = new String[]{"SE", "Images/SE.png", "4"};          // SE
        mazeTiles[10] = new String[]{"SW", "Images/SW.png", "4"};         // SW
        String arrowNorth = "Images/An.png";
        String arrowWest = "Images/AW.png";
        String arrowSouth = "Images/AS.png";
        String arrowEast = "Images/AS.png";

        
    }

    // Method to display the maze tile information in the specified container
    public void displayMazeTiles(Container pane) {
//        pane.setLayout(new GridLayout(7, 7)); // Set layout to 7x7 grid
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
        for (int i = 1; i < 8; i++) {
            for (int y = 1; y < 8; y++) {
                int randomNumber = (int) (Math.random() * 11); // Generates a number between 0 and 10
                String stringNumber = mazeTiles[randomNumber][2]; // Get the quantity
                int tNumber = Integer.parseInt(stringNumber); // number which represents the amount of tile remaining 
                
                
                // set get action commands events also 
                
                
                if (tNumber > 0) {
                	// yet to do fix the components 
                	
                	// populte the mazePattern matrix with the tiles pattern
//                	set foregroun
                	
                    // Create a button with the image
                    JButton tileButton = new JButton();
                    
                    // Load the original image
                    ImageIcon icon = new ImageIcon(mazeTiles[randomNumber][1]);
                    
                    Image scaledImage = icon.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
                    tileButton.setIcon(new ImageIcon(scaledImage)); // Set the scaled icon to the button
                    
                    // Set the size of the button to match the image size
                    tileButton.setPreferredSize(new Dimension(90, 90)); // Set button size to 77x77
                    tileButton.setBorder(BorderFactory.createEmptyBorder());
                    tileButton.setContentAreaFilled(false); // Make the button's background transparent

                    c.gridx = i;
                    c.gridy = y;
            		c.fill = GridBagConstraints.BOTH;

//                     Remove borders to avoid extra spacing
                   
                    // Add the button to the container
                	mazePattern[i][y] = tileButton;

                    pane.add(tileButton,c);

                    // Decrease the quantity of the maze tile
                    tNumber--;
                    mazeTiles[randomNumber][2] = Integer.toString(tNumber); // Update the quantity
                } else {
                    y--; // If no tile can be placed, decrement y to try again
                }
            }
        }
    }
}



