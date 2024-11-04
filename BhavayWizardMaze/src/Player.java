import java.awt.Color;

/**
 * The Player class represents a player in the Wizard's Maze game,
 * encapsulating player attributes and behaviors.
 * @author Bhavay Garg
 * @studentID 041102440
 * @professor Daniel Cormeir
 */

public class Player {
    // Attributes
    private String name;          // Player's name
    private int uniqueNumber;     // Unique identifier for the player
    private int[] capturedPieces = new int[21];    // Count of pieces captured by the player 21 is maximum pieces capturable
    private int[] recipe = new int [3];
    private int totalPiece  = 0;
    
    private String imageAddress;
    private Color color;
    // Constructor
    public Player(String name, int uniqueNumber, Color color, String imageAddress) {
        this.name = name;
        this.uniqueNumber = uniqueNumber;
        this.capturedPieces[0] = 0; // Initialized to 0
        
        this.color = color;
        this.imageAddress = imageAddress;
        
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getImageAddress() {
        return imageAddress;
    }
    public int getUniqueNumber() {
        return uniqueNumber;
    }

    public int[] getRecipe() {
    	
    	return recipe ; 
    }
    
    public void setRecipe(int ... recipeComponents) {
    	this.recipe = recipeComponents;
    }
    
    public int[] getCapturedPieces() {
        return capturedPieces;
    }

    public boolean addCapturedPiece(int piece) {
    
    	if(totalPiece<=21) {
    		capturedPieces[totalPiece++] = piece;
    		return true;
    	}
    	else {
    		return false;
    	}
    	
    	
    	
    }
    public Color getColor() {
        return color;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setUniqueNumber(int uniqueNumber) {
        this.uniqueNumber = uniqueNumber;
    }

   

  
   
}
