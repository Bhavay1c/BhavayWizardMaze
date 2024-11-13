import java.awt.*;
import java.awt.event.ActionListener;
import java.util.function.BiConsumer;


import javax.swing.*;

/**
 * The MazeStructure class is responsible for managing the maze tiles,
 * displaying them in a specified container, and handling the 
 * associated components such as arrows and wizards.
 */
public class ViewMazeStructure {

   
    public JButton[][] mazePattern = new JButton[9][9];

  
    private Dimension wizCompoDimension = new Dimension(25,25);
    private Dimension tileDimension = new Dimension(80,80);
    private Dimension arrowDimension = new Dimension(80,25);
    private GridBagConstraints c = new GridBagConstraints();
    Container pane = new Container();

    /**
     * Constructs a MazeStructure object and initializes the maze tiles.
     */
    public ViewMazeStructure() {
    	
        

    }

   

    public void setPaneInitializer(Container pane) {
    	this.pane = pane;
    	pane.setLayout(new GridBagLayout());
        this.c = new GridBagConstraints();
    }
	public void displayWizardImage(int i, int j, String wizColor) {
		System.out.println("Printing wiz"+wizColor+i+j);
		  ImageIcon wizardIcon = new ImageIcon(wizColor); 
	        Image scaledWizard = wizardIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
	        JLabel wizardLabel = new JLabel(new ImageIcon(scaledWizard));
//	        treasureIcon.setDescription(components[randomNumber]);  // Set path as description

	        // Add treasure on top of the maze tile
	        mazePattern[i][j].setLayout(new GridBagLayout()); // Use layout for placing the treasure

	        mazePattern[i][j].add(wizardLabel);
		
	}

	public void displayTreasureImage(int i, int j, String treasureImage) {
		  ImageIcon treasureIcon = new ImageIcon(treasureImage); 
	        Image scaledTreasure = treasureIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
	        JLabel treasureLabel = new JLabel(new ImageIcon(scaledTreasure));
//	        treasureIcon.setDescription(components[randomNumber]);  // Set path as description

	        // Add treasure on top of the maze tile
	        mazePattern[i][j].setLayout(new GridBagLayout()); // Use layout for placing the treasure

	        mazePattern[i][j].add(treasureLabel);
	}

	public void displayArrowTile(int i, int j, String arrowImage, int length , int width) {
		
		System.out.println("In here displayArrowTiles"+i+"  "+j);
		 JButton arrowTileButton = new JButton();
         ImageIcon icon = new ImageIcon(arrowImage);
         Image scaledImage = icon.getImage().getScaledInstance(length,width , Image.SCALE_SMOOTH);
         arrowTileButton.setIcon(new ImageIcon(scaledImage)); // Set the scaled icon to the button

         arrowTileButton.setPreferredSize(new Dimension(length,width)); // Set tile size
         arrowTileButton.setBorder(BorderFactory.createEmptyBorder()); // Remove borders

         c.gridx = i;
         c.gridy = j;
         c.fill = GridBagConstraints.BOTH;
         
         mazePattern[i][j] = arrowTileButton;

         pane.add(arrowTileButton, c);
		
		
	}

	public void displayMazeTile(int i, int j, String mazeTile) {
		
		 JButton tileButton = new JButton();
         ImageIcon icon = new ImageIcon(mazeTile);
         Image scaledImage = icon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
         tileButton.setIcon(new ImageIcon(scaledImage)); // Set the scaled icon to the button

         tileButton.setPreferredSize(tileDimension); // Set tile size
         tileButton.setBorder(BorderFactory.createEmptyBorder()); // Remove borders

         c.gridx = i;
         c.gridy = j;
         c.fill = GridBagConstraints.BOTH;
         
         mazePattern[i][j] = tileButton;

         pane.add(tileButton, c);

		
	}
    
	
	
	public void addTileButtonListener(BiConsumer<Integer, Integer> clickHandler) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (mazePattern[i][j] == null) {
                    continue;
                }
                
                final int row = i;
                final int col = j;
                
                mazePattern[i][j].addActionListener(e -> clickHandler.accept(row, col));
            }
        }
    }

}