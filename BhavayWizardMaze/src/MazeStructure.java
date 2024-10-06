import java.awt.*;
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
    }

    // Method to display the maze tile information in the specified container
    public void displayMazeTiles(Container pane) {
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Add Arrow Labels for Shifting Maze
        addArrowLabels(pane, c);

        // Add maze tiles
        for (int i = 1; i < 8; i++) {
            for (int y = 1; y < 8; y++) {
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
                    c.gridy = y;
                    c.fill = GridBagConstraints.BOTH;
                    mazePattern[i][y] = tileLabel;

                    pane.add(tileLabel, c);

                    // Decrease the quantity of the maze tile
                    tNumber--;
                    mazeTiles[randomNumber][2] = Integer.toString(tNumber); // Update the quantity

                    // Optionally add random components (like treasures)
                    if (Math.random() < 0.2) { // 20% chance to place a random component
                        addRandomComponent(tileLabel);
                    }
                } else {
                    y--; // If no tile can be placed, decrement y to try again
                }
            }
        }
    }

    // Method to add arrow labels around the maze
    private void addArrowLabels(Container pane, GridBagConstraints c) {
        JLabel northLabel1 = createArrowLabel(arrowNorth);
        JLabel northLabel2 = createArrowLabel(arrowNorth);
        JLabel northLabel3 = createArrowLabel(arrowNorth);

        JLabel southLabel1 = createArrowLabel(arrowSouth);
        JLabel southLabel2 = createArrowLabel(arrowSouth);
        JLabel southLabel3 = createArrowLabel(arrowSouth);

        JLabel westLabel1 = createArrowLabel(arrowWest);
        JLabel westLabel2 = createArrowLabel(arrowWest);
        JLabel westLabel3 = createArrowLabel(arrowWest);

        JLabel eastLabel1 = createArrowLabel(arrowEast);
        JLabel eastLabel2 = createArrowLabel(arrowEast);
        JLabel eastLabel3 = createArrowLabel(arrowEast);

        // Add North labels (above the maze)
        c.gridx = 2;
        c.gridy = 0;
        pane.add(southLabel1, c);
        c.gridx = 4;
        pane.add(southLabel2, c);
        c.gridx = 6;
        pane.add(southLabel3, c);

        // Add South labels (below the maze)
        c.gridx = 2;
        c.gridy = 8;
        pane.add(northLabel1, c);
        c.gridx = 4;
        pane.add(northLabel2, c);
        c.gridx = 6;
        pane.add(northLabel3, c);

        // Add West labels (to the left of the maze)
        c.gridx = 0;
        c.gridy = 2;
        pane.add(eastLabel1, c);
        c.gridy = 4;
        pane.add(eastLabel2, c);
        c.gridy = 6;
        pane.add(eastLabel3, c);

        // Add East labels (to the right of the maze)
        c.gridx = 8;
        c.gridy = 2;
        pane.add(westLabel1, c);
        c.gridy = 4;
        pane.add(westLabel2, c);
        c.gridy = 6;
        pane.add(westLabel3, c);
    }

    // Method to create arrow labels
    private JLabel createArrowLabel(String iconPath) {
        JLabel aLabel = new JLabel();

    	ImageIcon aIcon = new ImageIcon(iconPath);
    	
    	if(iconPath.equals(arrowNorth)||iconPath.equals(arrowSouth)) {
    		 Image scaledImage = aIcon.getImage().getScaledInstance(80, 25, Image.SCALE_SMOOTH);
             aLabel.setIcon(new ImageIcon(scaledImage)); // Set the scaled icon to the button

    	}else {
    		 Image scaledImage = aIcon.getImage().getScaledInstance(25, 80, Image.SCALE_SMOOTH);
             aLabel.setIcon(new ImageIcon(scaledImage)); // Set the scaled icon to the button
    	}
    	

       
        aLabel.setBorder(BorderFactory.createEmptyBorder()); // Remove borders
        return aLabel;
    }

    // Method to add random components (e.g., treasures) to maze tiles
    private void addRandomComponent(JLabel tile) {
        ImageIcon treasureIcon = new ImageIcon("Images/treasure.png"); // Example random component
        Image scaledTreasure = treasureIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        JLabel treasureLabel = new JLabel(new ImageIcon(scaledTreasure));

        // Add treasure on top of the maze tile
        tile.add(treasureLabel);
        tile.setLayout(new GridBagLayout()); // Use layout for placing the treasure
    }
}
