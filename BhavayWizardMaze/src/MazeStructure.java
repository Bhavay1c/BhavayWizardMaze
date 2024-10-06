import java.awt.*;
import java.util.HashSet;
import java.util.Set;

import javax.swing.*;

public class MazeStructure {

    // Declare the mazeTiles array
    public String[][] mazeTiles;
    public JLabel[][] mazePattern = new JLabel[8][8];

    // Arrow button images
    String arrowNorth = "Images/An.png";
    String arrowWest = "Images/AW.png";
    String arrowSouth = "Images/AS.png";
    String arrowEast = "Images/AE.png";
    String[] components = new String[21];
    Set<Integer> componentsUniqueNumbers = new HashSet<>();
    Set<Integer> wizardsUniqueNumbers = new HashSet<>();
    String yellow  = "Images/yellow.png";
    String red  = "Images/red.png";
    String blue  = "Images/blue.png";
    String green  = "Images/green.png";

    
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
        
        
        for (int i = 1; i <= 21; i++) {
            components[i - 1] = "Images/green_" + i + ".png"; // Green component images
            
        }
        components[20] = "Images/green_" + 25 + ".png"; // Green component images

    }

    // Method to display the maze tile information in the specified container
    public void displayMazeTiles(Container pane) {
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Add Arrow Labels for Shifting Maze
        addArrowLabels(pane, c);
        
        // Add maze tiles
        for (int i = 1; i < 8; i++) {
            for (int j = 1; j < 8; j++) {
                int randomNumber = (int) (Math.random() * 11); // Generates a number between 0 and 10
                String stringNumber = mazeTiles[randomNumber][2]; // Get the quantity
                int tNumber = Integer.parseInt(stringNumber); // number which represents the amount of tile remaining 

                if (tNumber > 0) {
                    JLabel tileLabel = new JLabel();
                    ImageIcon icon = new ImageIcon(mazeTiles[randomNumber][1]);
                    Image scaledImage = icon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
                    tileLabel.setIcon(new ImageIcon(scaledImage)); // Set the scaled icon to the button

                    tileLabel.setPreferredSize(new Dimension(80, 80)); // Set tile size
                    tileLabel.setBorder(BorderFactory.createEmptyBorder()); // Remove borders

                    c.gridx = i;
                    c.gridy = j;
                    c.fill = GridBagConstraints.BOTH;
                    mazePattern[i][j] = tileLabel;

                    pane.add(tileLabel, c);

                    // Decrease the quantity of the maze tile
                    tNumber--;
                    mazeTiles[randomNumber][2] = Integer.toString(tNumber); // Update the quantity

                    if( (i>1&&j>1) && (i<7&&j<7) ) { // place random component or wizard
                    	
                    	if((i==3 || i ==5) && (j==3 || j ==5)) {
                    		
                    		// place wizard
                    		addWizards(tileLabel);
                    	
                    		
                    	}
                    	else {
                    		
                    		addRandomComponent(tileLabel);
                    	}
                    	
                    }
                    
                    
                } else {
                    j--; // If no tile can be placed, decrement y to try again
                }
            }
        }
    }

    // Method to add arrow labels around the maze
    private void addArrowLabels(Container pane, GridBagConstraints c) {
        // Create one ImageIcon for each direction
        ImageIcon northIcon = new ImageIcon(arrowNorth);
        ImageIcon southIcon = new ImageIcon(arrowSouth);
        ImageIcon westIcon = new ImageIcon(arrowWest);
        ImageIcon eastIcon = new ImageIcon(arrowEast);

        // Scale the icons
        Image scaledNorth = northIcon.getImage().getScaledInstance(80, 25, Image.SCALE_SMOOTH);
        Image scaledSouth = southIcon.getImage().getScaledInstance(80, 25, Image.SCALE_SMOOTH);
        Image scaledWest = westIcon.getImage().getScaledInstance(25, 80, Image.SCALE_SMOOTH);
        Image scaledEast = eastIcon.getImage().getScaledInstance(25, 80, Image.SCALE_SMOOTH);

        // Add North labels (below the maze)
        c.gridx = 2;
        c.gridy = 0;
        pane.add(createArrowLabel(new ImageIcon(scaledSouth)), c);
        c.gridx = 4;
        pane.add(createArrowLabel(new ImageIcon(scaledSouth)), c);
        c.gridx = 6;
        pane.add(createArrowLabel(new ImageIcon(scaledSouth)), c);

        // Add South labels (above the maze)
        c.gridx = 2;
        c.gridy = 8;
        pane.add(createArrowLabel(new ImageIcon(scaledNorth)), c);
        c.gridx = 4;
        pane.add(createArrowLabel(new ImageIcon(scaledNorth)), c);
        c.gridx = 6;
        pane.add(createArrowLabel(new ImageIcon(scaledNorth)), c);

        // Add West labels (to the left of the maze)
        c.gridx = 0;
        c.gridy = 2;
        pane.add(createArrowLabel(new ImageIcon(scaledEast)), c);
        c.gridy = 4;
        pane.add(createArrowLabel(new ImageIcon(scaledEast)),c);
        c.gridy = 6;
        pane.add(createArrowLabel(new ImageIcon(scaledEast)), c);

        // Add East labels (to the right of the maze)
        c.gridx = 8;
        c.gridy = 2;
        pane.add(createArrowLabel(new ImageIcon(scaledWest)), c);
        c.gridy = 4;
        pane.add(createArrowLabel(new ImageIcon(scaledWest)), c);
        c.gridy = 6;
        pane.add(createArrowLabel(new ImageIcon(scaledWest)), c);
    }

    // Method to create arrow labels
    private JLabel createArrowLabel(ImageIcon icon) {
        JLabel aLabel = new JLabel(icon);
//        aLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Top, Left, Bottom, Right

        return aLabel;
    }

    
    // method to put wizards 
    
    private void addWizards(JLabel tile) {
    	
    	int randomNumber = 2;
    	
    	while(wizardsUniqueNumbers.size()<=4) {
        	
            
        	randomNumber = (int) (Math.random() * 4); // Generates a number between 0 and 21
	        if(wizardsUniqueNumbers.add(randomNumber)) {
	        	 break; // if unq number found break loop and add the image 
	        	
	        	
	        }
	        else {
	        	continue;  // find unique number again 
	        }

        }
    	String wizColor = yellow ;// defauolt
    	if (randomNumber ==0) { // yellow 
        	wizColor  = yellow; 
    	}
    	else if(randomNumber ==1) { // red
        	wizColor  = red; 

    	}else if(randomNumber ==2) { // blue
        	wizColor  = blue; 

    	}else { // green
        	wizColor  = green; 

    	}
    	
    	ImageIcon wizard = new ImageIcon(wizColor);// default  
        Image scaledWizard = wizard.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        JLabel wizardLabel = new JLabel(new ImageIcon(scaledWizard));

        tile.add(wizardLabel);
        tile.setLayout(new GridBagLayout()); 
    	
    }
    
    
    // Method to add random components (e.g., treasures) to maze tiles
    private void addRandomComponent(JLabel tile) {
    	
//        int randomNumber = (int) (Math.random() * 21); // Generates a number between 0 (inclusive) and 21 (exclusive)

        
        
        int randomNumber = 0 ;
        
        while(componentsUniqueNumbers.size()<=21) {
        	
        
        	randomNumber = (int) (Math.random() * 21); // Generates a number between 0 and 21
	        if(componentsUniqueNumbers.add(randomNumber)) {
	        	 break; // if unq number found break loop and add the image 
	        	
	        	
	        }
	        else {
	        	continue;  // find unique number again 
	        }

        }
    	
        ImageIcon treasureIcon = new ImageIcon(components[randomNumber]); // Example random component
        Image scaledTreasure = treasureIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        JLabel treasureLabel = new JLabel(new ImageIcon(scaledTreasure));

        // Add treasure on top of the maze tile
        tile.add(treasureLabel);
        tile.setLayout(new GridBagLayout()); // Use layout for placing the treasure
    }
}
