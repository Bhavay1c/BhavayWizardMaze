import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;





public class ModelMainGame {
    // Attributes
    private List<ModelPlayer> players = new ArrayList<ModelPlayer>();
    private int numPlayers= 0;
    private int currentPlayerTurn=0;
    private int currentPlayerIndex;
    private ModelMazeStructure mazeStructure;
    private String gameStatus;
    public String[][] mazeTiles;   
    private String[] components = new String[21];
    public String[][] mazePattern = new String[9][9];
    private Set<Integer> componentsUniqueNumbers = new HashSet<>();
    private String yellow = "Images/yellow.png";
    private String red = "Images/red.png";
    private String blue = "Images/blue.png";
    private String green = "Images/green.png"; 
    private int nPAdded = 0;
    private String extraMazePiece = "";
    private String arrowNorth = "Images/An.png";
    private String arrowWest = "Images/AW.png";
    private String arrowSouth = "Images/AS.png";
    private String arrowEast = "Images/AE.png";
    
    private ViewMazeStructure vms = new ViewMazeStructure();




    // Constructor
    public ModelMainGame(ViewMazeStructure vms) {
    	this.vms = vms;
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

    
    public void setViewMazeStructure(ViewMazeStructure vms ) {
    	this.vms = vms;
    }
    
    
    public void createRandomMaze() {
    	
    	 for (int i = 0; i < 9; i++) {
             for (int j = 0; j < 9; j++) {
            	 
            	// Place arrows along the edges
                 if (i == 0 || i == 8 || j == 0 || j == 8) {
                	 
                	 if (i%2==0 && j%2==0) {
                		 putArrow(i, j);
                		 System.out.println("In randomMaze "+i + " "+ j);
                		 continue;
                		 
                	 }
                	 else {
                		 continue;
                	 }
                 }
            	 
                 int randomNumber = (int) (Math.random() * 11); // Generates a number between 0 and 10
                 String stringNumber = mazeTiles[randomNumber][2]; // Get the quantity
                 int tNumber = Integer.parseInt(stringNumber); // number which represents the amount of tile remaining

                 if (tNumber > 0) {
                     
                     String mazeTile = mazeTiles[randomNumber][1];
                     
                     // call the displayMazeTile function of ViewMazeStructure which takes in string and i and j values and put the tile there 
                     vms.displayMazeTile(i,j,mazeTile);
                     
                     mazePattern[i][j] = mazeTile;

                  
      
                     // Decrease the quantity of the maze tile
                     tNumber--;
                     mazeTiles[randomNumber][2] = Integer.toString(tNumber); // Update the quantity

                     if ((i > 1 && j > 1) && (i < 7 && j < 7)) { // place random component or wizard

                         if ((i == 3 || i == 5) && (j == 3 || j == 5)) {

                             // place wizard
                         	
                        	 if(numPlayers>=nPAdded) {
                        		 addPlayer(i,j,nPAdded);
                        		 nPAdded++;
                        		 
                        	 }
                        	 
                         } else {

                             addRandomComponent(i,j);
                         }

                     }

                 } else {
                     j--; // If no tile can be placed, decrement y to try again
                 }
             }
         }
      
         
      // method which will put the extra mazePiece
     System.out.println(extraMazePiece());
     }

    	
    	
    	
    	
 // Method to place arrows along the edges
    private void putArrow(int i, int j) {

    	   System.out.println("In here"+i+"  "+j);
        // South arrows 
        if (j == 0 && (i == 2 || i == 4 || i == 6)) {
        	mazePattern[i][j] = arrowSouth;
            // call the displayArrowTile function of ViewMazeStructure which takes in string and i and j values and put the arrow tile there 
            vms.displayArrowTile(i,j,arrowSouth,80,25);

        }
        // North arrows
        if (j == 8 && (i == 2 || i == 4 || i == 6)) {
        	mazePattern[i][j] = arrowNorth;
            // call the displayArrowTile function of ViewMazeStructure which takes in string and i and j values and put the arrow tile there 
            vms.displayArrowTile(i,j,arrowNorth,80,25);

        }
        // West arrows
        if (i == 0 && (j == 2 || j == 4 || j == 6)) {
        	mazePattern[i][j] = arrowEast;
            // call the displayArrowTile function of ViewMazeStructure which takes in string and i and j values and put the arrow tile there 
            vms.displayArrowTile(i,j,arrowEast,25,80);

        }
        // East arrows 
        if (i == 8 && (j == 2 || j == 4 || j == 6)) {
        	mazePattern[i][j] = arrowWest;
            // call the displayArrowTile function of ViewMazeStructure which takes in string and i and j values and put the arrow tile there 
            vms.displayArrowTile(i,j,arrowWest,25,80);

        }
    }
    
public String extraMazePiece() {
	

      for (int i = 0; i < 11; i++) {
          String stringNumber = mazeTiles[i][2]; // Get the quantity
          int tNumber = Integer.parseInt(stringNumber); // number which represents the amount of tile remaining

          if (tNumber > 0) {
              extraMazePiece = mazeTiles[i][1]; // Get the path
          } else {
              continue;
          }
      }

      return extraMazePiece;
  }
  



	public void addRandomComponent(int i, int j) {
		int randomNumber = 0;

        while (componentsUniqueNumbers.size() <= 21) {
            randomNumber = (int) (Math.random() * 21); // Generates a number between 0 and 21
            if (componentsUniqueNumbers.add(randomNumber)) {
                break; // if unq number found break loop and add the image
            } else {
                continue; // find unique number again
            }
        }

        String treasureImage = components[randomNumber];
        
        // call the displayTreasureImage function of ViewMazeStructure which takes in string and i and j values and put the component there 
        vms.displayTreasureImage(i,j,treasureImage);

        
	}





	private void addPlayer(int i, int j,int pNumb) {

		String wizColor;

		
			
		int playerNumber = players.get(pNumb).getUniqueNumber();
		
		
        if (playerNumber == 0) { // green
            wizColor = green;
        } else if (playerNumber == 1) { // red
            wizColor = red;

        } else if (playerNumber == 2) { // blue
            wizColor = blue;

        } else if (playerNumber == 3) { // yellow
            wizColor = yellow;

        }
        else {
        	return ;
        }

        

        // call the displayWizardImage function of ViewMazeStructure which takes in string and i and j values and put the wizard there 
        players.get(pNumb).setPosition(i,j);
        vms.displayWizardImage(i,j,wizColor);

        
        
        
     
	}

    
    // method to create players it takes an varargs in whgich you pass the number of strings of how many players are playing and then it creates the players based on it  
    public void createPlayers(String ...playerNames) {
    	System.out.println("Creating plyer "+ numPlayers);
    	for (String playerName : playerNames) {
    		
    		ModelPlayer player = new ModelPlayer(playerName,numPlayers);
    		players.add(player);
    	
    		numPlayers++;
    	}
    	
    	playerRecipeGenerator();
    	
    }
    
    
    public void playerRecipeGenerator() {
    	for(ModelPlayer player: players) {
    	    Set<Integer> recipeUniqueNumber = new HashSet<>();
    	    int randomNumber;
    	    int [] recipe = new int[3];
    	    
    		for(int i = 0; i<3; i++) {
    			
    			 while (recipeUniqueNumber.size() <=3) {
    		            randomNumber = (int) (Math.random() * 21); // generate number between 0 amd 21
    		            if (recipeUniqueNumber.add(randomNumber)) {
    		            	recipe[i] = randomNumber;
    		                break; // if unq number found break loop and add the image
    		            } else {
    		                continue; // find unique number again
    		            }
    		        }

    			
    		}
    		
    		
    		player.setRecipe(recipe);
    	}
    	
    }
    
    
  
    // Methods
    public void startGame() {
        gameStatus = "In Progress";
        currentPlayerIndex = 0; // Reset to the first player
        System.out.println("Game started!");
    }

    public void nextTurn() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        System.out.println("Next turn: Player " + currentPlayerIndex);
    }

    public String checkGameStatus() {
        return gameStatus;
    }

    public boolean playerMove(int playerId, int[] newPosition) {
        if (playerId >= players.size() || playerId < 0) {
            System.out.println("Invalid player ID.");
            return false;
        }
        
        ModelPlayer player = players.get(playerId);
        if (mazeStructure.isValidMove(newPosition)) {
            player.setPosition(newPosition);
            System.out.println("Player " + playerId + " moved to " + newPosition[0] + ", " + newPosition[1]);
            return true;
        } else {
            System.out.println("Invalid move.");
            return false;
        }
    }

    public void rotateTile(int[] position, String direction) {
        System.out.println("Tile at position (" + position[0] + ", " + position[1] + ") rotated " + direction);
    }
}
