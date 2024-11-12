import java.awt.Color;

/**
 * The Player class represents a player in the Wizard's Maze game,
 * encapsulating player attributes and behaviors.
 * @author Bhavay Garg
 * @studentID 041102440
 * @professor Daniel Cormeir
 */

public class ModelPlayer {
    // Attributes
    private String name;          // Player's name
    private int uniqueNumber;     // Unique identifier for the player
    private int[] capturedPieces = new int[21];    // Count of pieces captured by the player 21 is maximum pieces capturable
    private int[] recipe = new int [3];
    private int totalPiece  = 0;
    private int totalScore = 0;
    private int nWands = 0;
    private int[] position = new int[2];
    
    
    private String imageAddress;
    private Color color;
    
    
    // Constructor
    public ModelPlayer(String name, int uniqueNumber, Color color, String imageAddress) {
        this.name = name;
        this.uniqueNumber = uniqueNumber;
        this.capturedPieces[0] = 0; // Initialized to 0
        
        this.color = color;
        this.imageAddress = imageAddress;
        
    }
    
    public void setPosition(int[]position) {
    	this.position = position;
    	
    } 
    
    public int[] getPosition() {
    	int[] temp = position;
    	return temp;
    }

    // method to get the wands 
    public int getNWands() {
    	return nWands;
    }
    
 // method to set the wands 
    public void setNWands(int wands) {
    	this.nWands = wands;
    }
    
    // method to dectrease the wand
    public boolean wandsUse() {
    	
    	if(nWands>0) {
    		nWands--;
    		return true;
    	}
    	else {
    		return false;
    	}
    	
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
    	
    	int [] copyArr = recipe; // temp variable to return it as not to modify the content of the original array
    	return copyArr ; 
    }
    
    public void setRecipe(int ... recipeComponents) {
    	this.recipe = recipeComponents;
    }
    
    public int[] getCapturedPieces() {
    	
    	int [] copyArr = capturedPieces; // temp variable to return it as not to modify the content of the original array

        return  copyArr;
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

    
    /**
     * Method to calculate the total score of the player
     * Each ingredient captured is worth its face value in points (ie: the 3 ingredient is
	    worth 3 points).
		Each unspent wand is worth 3 points.		 
		Each secret ingredient captured is worth 20 extra point
     * 
     * 
     * @return
     */
   public int calculateTotalScore() {
	   
	   for(int i = 0; i<=totalPiece;i++) {
		   
		   
		   totalScore += capturedPieces[i];
		   
		   for(int y = 0; y<3;y++) {
			   if(capturedPieces[i]==recipe[y]) {
				   totalScore+=20;
				   
			   }
			   
		   }
		   
		   
	   }// outer for loop
	   
	   totalScore += nWands*3;
	   
	   
	   return totalScore;
   }

  
   
}
