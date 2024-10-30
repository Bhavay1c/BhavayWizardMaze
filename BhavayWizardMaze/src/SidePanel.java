/**
 * * The SidePanel class represents a user interface panel that displays game-related components
 * for the Wizard's Maze game, including spare tiles, player names, captured pieces, chat area,
 * and action buttons.
 * @author Bhavay Garg
 * @studentID 041102440
 * @professor Daniel Cormeir
 */
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;


public class SidePanel extends JPanel {
    private JLabel spareTileLabel;
    private JButton doneButton, shuffleButton, wandsButton, recipeButton, piecesCapturedButton, leftArrowButton, rightArrowButton, sendButton;
    private JTextArea chatBoxArea, chatInputArea;
    private JScrollPane capturedPiecesScroll, chatScrollPane;
    private String extraMazePiece;
    private String rotatorImage = "Images/rotator.png";
    private Color buttonBackgroundColor = new Color(63, 53, 53, 255); // Button background color
    private Color buttonGTexts = new Color(183, 18, 128, 255); // Button text color
    private Color greenWTexts = new Color(63, 181, 13, 255); // Button text color
    private Color redWTexts = new Color(181, 13, 13, 255); // Button text color
    private Color blueWTexts = new Color(18, 29, 183,255); // Button text color
    private Color yellowWTexts = new Color(225, 219, 25, 255); // Button text color
    private Font textFont = new Font("Arial", Font.BOLD, 24);
//    private Map<String, Color> players;
    private ArrayList<Player> playersList = new ArrayList<Player>(4);

//    /**
//     * Constructs a SidePanel and initializes its components.
//     * The components include buttons, labels, chat area, and captured pieces display.
//     */
//    public SidePanel(String mazePiece) {
//    	// to get the image addressm of the piece missiong 
//        
//        extraMazePiece = mazePiece;
//
//        // Set GridBagLayout and panel properties
//        setLayout(new GridBagLayout());
//        setOpaque(false); // transparent 
//        GridBagConstraints gbc = new GridBagConstraints();
//        players = new HashMap<>(); // using hashmap to store the players name and their respective  color 
//
//        // Label for the current player's turn
//        JLabel currentTurnLabel = new JLabel("Current Turn: Player 1");
//        currentTurnLabel.setFont(new Font("Arial", Font.BOLD, 20)); // font
//
//        currentTurnLabel.setForeground(buttonTexts);
//        currentTurnLabel.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.BLUE));
//        
//        
//        gbc.gridx = 0;
//        gbc.gridy = 0;
////        gbc.gridwidth = 3;
////        gbc.insets = new Insets(10, 10, 10, 10);
//        //gbc.anchor = GridBagConstraints.NORTHWEST;
//        add(currentTurnLabel, gbc);
//
//        // Player Names Section
//        JPanel playerNamesPanel = new JPanel();
//        playerNamesPanel.setLayout(new BoxLayout(playerNamesPanel, BoxLayout.Y_AXIS));
//        playerNamesPanel.setOpaque(false); // transparent
//
//        gbc.gridx = 1;
//        gbc.gridy = 0;
////        gbc.gridwidth = 3;
////        gbc.weightx = 1.0;
////        gbc.insets = new Insets(10, 0, 10, 0);
////        gbc.anchor = GridBagConstraints.CENTER;
//        add(playerNamesPanel, gbc);
//
//        // Spare tile (Image)
//        spareTileLabel = new JLabel(); // Load the actual image here
//        ImageIcon extraTile = new ImageIcon(extraMazePiece);
//        Image scaledImage = extraTile.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH); // Increased size
//        spareTileLabel.setIcon(new ImageIcon(scaledImage));
//        spareTileLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        spareTileLabel.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.BLUE));
//
//        // Arrow buttons with reasonable size
//        leftArrowButton = new JButton("<<");
//        rightArrowButton = new JButton(">>");
//        styleButton(leftArrowButton);
//        styleButton(rightArrowButton);
//
//        leftArrowButton.setPreferredSize(new Dimension(60, 40)); // Set size
//        rightArrowButton.setPreferredSize(new Dimension(60, 40)); // Set size
//        leftArrowButton.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.BLUE));
//        rightArrowButton.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.BLUE));
//        // Add spare tile and arrow buttons in GridBagLayout
//        gbc.gridx = 1;
//        gbc.gridy = 2;
//        gbc.gridwidth = 2;
//        gbc.insets = new Insets(5, 5, 5, 5); // Padding around the tile
//        gbc.anchor = GridBagConstraints.CENTER;
//        add(spareTileLabel, gbc);
//
//        gbc.gridx = 0;
//        gbc.gridy = 3;
//        gbc.gridwidth = 1;
//        gbc.insets = new Insets(10, 0, 10, 10);
//        gbc.anchor = GridBagConstraints.WEST;
//        add(leftArrowButton, gbc);
//
//        gbc.gridx = 2;
//        gbc.gridy = 3;
//        gbc.insets = new Insets(10, 10, 10, 0);
//        gbc.anchor = GridBagConstraints.EAST;
//        add(rightArrowButton, gbc);
//
//        // Done Button
//        doneButton = new JButton("Done");
//        styleButton(doneButton);
//        doneButton.setPreferredSize(new Dimension(100, 50)); // Size of the Done button
//
//        gbc.gridx = 0;
//        gbc.gridy = 4;
//        gbc.gridwidth = 3;
//        gbc.insets = new Insets(10, 0, 10, 0); // More padding for better orientation
//        gbc.anchor = GridBagConstraints.CENTER;
//        add(doneButton, gbc);
//
//
//        // Shuffle and Wands Buttons
//        shuffleButton = new JButton("Shuffle");
//        wandsButton = new JButton("Wands");
//        styleButton(shuffleButton);
//        styleButton(wandsButton);
//
//        shuffleButton.setPreferredSize(new Dimension(110, 75)); // Size of Shuffle button
//        wandsButton.setPreferredSize(new Dimension(110, 75)); // Size of Wands button
//
//        JPanel shuffleWandsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5)); // Centered buttons
//        shuffleWandsPanel.setOpaque(false);
//        shuffleWandsPanel.add(shuffleButton);
//        shuffleWandsPanel.add(wandsButton);
//
//        gbc.gridx = 0;
//        gbc.gridy = 6;
//        gbc.gridwidth = 3;
//        gbc.insets = new Insets(10, 0, 10, 0);
//        gbc.anchor = GridBagConstraints.CENTER;
//        add(shuffleWandsPanel, gbc);
//
//        // Chat Box at the bottom
//        chatBoxArea = new JTextArea(20,30); // Chat box size
////        chatBoxArea.setWrapStyleWord(true);
////        chatBoxArea.setLineWrap(true);
//        chatBoxArea.setEditable(false);
////        chatBoxArea.setBackground(new Color(0, 0, 0, 0)); // Set transparent background
//        chatBoxArea.setFont(new Font("Arial", Font.PLAIN, 32)); // Larger font for chat
//
//        chatScrollPane = new JScrollPane(chatBoxArea);
//        chatScrollPane.setPreferredSize(new Dimension(200, 100)); // Chat scroll pane size
//
//        gbc.gridx = 0;
//        gbc.gridy = 7;
//        gbc.gridwidth = 3;
//        gbc.insets = new Insets(10, 0, 10, 0);
//        add(chatScrollPane, gbc);
//
//        // Input for chat and Send button
//        chatInputArea = new JTextArea(2, 20);
//        chatInputArea.setBackground(new Color(255, 255, 255, 200)); // Slightly transparent background for input
//        chatInputArea.setLineWrap(true);
//        chatInputArea.setFont(new Font("Arial", Font.PLAIN, 14));
//
//        sendButton = new JButton("Send");
//        styleButton(sendButton);
//        sendButton.setPreferredSize(new Dimension(70, 40)); // Size of the send button
//
//        JPanel chatInputPanel = new JPanel(new BorderLayout());
//        chatInputPanel.add(new JScrollPane(chatInputArea), BorderLayout.CENTER);
//        chatInputPanel.add(sendButton, BorderLayout.EAST);
//
//        gbc.gridx = 0;
//        gbc.gridy = 8;
//        gbc.gridwidth = 3;
//        gbc.insets = new Insets(10, 0, 10, 0);
//        add(chatInputPanel, gbc);
//    }
//
//    /**
//     * Reusable method to apply common button styles.
//     *
//     * @param button The button to style.
//     */
//    private void styleButton(JButton button) {
//        button.setOpaque(true); // Ensure the button is opaque to apply background color
//        button.setContentAreaFilled(true); // Fill the button with the background color
//        button.setBackground(buttonColor); // Use the color defined for all buttons
//        button.setForeground(buttonTexts); // Text color for buttons
//        button.setBorder(BorderFactory.createLineBorder(buttonColor)); // Optional: add a border with transparency
//        button.setFont(new Font("Arial", Font.BOLD, 24)); // Set font size for all buttons
//    }
//
//    
//
//   

   
    public SidePanel(String mazePiece) {
//    	 to get the image addressm of the piece missing 
      
    	 setLayout(new GridBagLayout());
         setOpaque(false); // transparent 
         GridBagConstraints gbc = new GridBagConstraints();
    	 /// test image of wizard will update in mvc what to change remove below line so that code supply which current player instaeed of green 
         
         Player player1 = new Player("Bhavay",1,greenWTexts,"Images/Green.png");
         Player player2 = new Player("Solomon",2,redWTexts,"Images/Red.png");
         Player player3 = new Player("Mohammad",3,blueWTexts,"Images/Blue.png");
         Player player4 = new Player("Himanshu",4,yellowWTexts,"Images/Yellow.png");

        playersList.add(player1);
        playersList.add(player2);
        playersList.add(player3);
        playersList.add(player4);

        
         
         
         
        gbc.gridx = 0;
        gbc.gridy = 0;
        currentPlayerMazePiecePanelAdd(mazePiece, player3 , gbc);
         
        gbc.gridx = 1;
        gbc.gridy = 0;
        playersListAdd(gbc,2);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        doneButtonAdd(gbc);  

    	
    }
    
    
    
    public void playersListAdd(GridBagConstraints gbc, int componentNumber) {
    	
    	JPanel playersListPanel = new JPanel();
    	playersListPanel.setLayout(new GridBagLayout());
    	playersListPanel.setOpaque(false);
    	GridBagConstraints gbc2 = new GridBagConstraints();
    	int y = 0  ; // used to move to new line using gbc constarints
    	for (Player player :playersList) {
    		
    		JLabel playerTextLabel = new JLabel(player.getName());
            playerTextLabel.setFont(textFont); // font

            playerTextLabel.setForeground(player.getColor());
        	gbc2.gridx = 0;
        	gbc2.gridy = y;
        	gbc2.insets = new Insets(0,5,10,0);
            playersListPanel.add(playerTextLabel,gbc2);
            
    		  ImageIcon playerWImage = new ImageIcon(player.getImageAddress()); // default
    	      Image scaledWizard = playerWImage.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
    	      JLabel wizardLabel = new JLabel(new ImageIcon(scaledWizard));
    	      
    	      gbc2.gridx = 1;
    	      gbc2.gridy = y;
              playersListPanel.add(wizardLabel,gbc2);
              y++; // increment y to move to next line 

    	      
    		
    		
    	}
    	
    	JLabel nextComponentLabel = new JLabel("Next Capture : " + componentNumber);
        nextComponentLabel.setFont(textFont); // font
        gbc2.gridx = 0;
        gbc2.gridy = y+1;

        nextComponentLabel.setForeground(buttonGTexts);
        playersListPanel.add(nextComponentLabel,gbc2);

  
        
        add(playersListPanel, gbc);

        
        
        playersListPanel.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.red));;

    	
    }
    
    public void currentPlayerMazePiecePanelAdd(String mazePiece, Player cPlayer,  GridBagConstraints gbc  ) {
    	JPanel currentPlayerMazePiecePanel = new JPanel();
    	currentPlayerMazePiecePanel.setLayout(new GridBagLayout());
    	currentPlayerMazePiecePanel.setOpaque(false);
    	GridBagConstraints gbc2 = new GridBagConstraints();
    	
    	 // Label for the current player's turn
        JLabel currentTurnLabel = new JLabel(cPlayer.getName() + "'s Turn");
        currentTurnLabel.setFont(textFont); // font

        currentTurnLabel.setForeground(cPlayer.getColor());
    	gbc2.gridx = 0;
    	gbc2.gridy = 0;
    	gbc2.insets = new Insets(0,5,10,0);
        currentPlayerMazePiecePanel.add(currentTurnLabel,gbc2);

        gbc2.gridx = 1;
    	gbc2.gridy = 0;
    	
    	 ImageIcon playerWImage = new ImageIcon(cPlayer.getImageAddress()); // default
	      Image scaledWizard = playerWImage.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
	      JLabel wizardLabel = new JLabel(new ImageIcon(scaledWizard));
        currentPlayerMazePiecePanel.add(wizardLabel,gbc2);

    	// spare tile label 
	    extraMazePiece = mazePiece;
        spareTileLabel = new JLabel(); // Load the actual image here
        ImageIcon extraTile = new ImageIcon(extraMazePiece);
        Image scaledImage = extraTile.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH); // Increased size
        spareTileLabel.setIcon(new ImageIcon(scaledImage));
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        currentPlayerMazePiecePanel.add(spareTileLabel,gbc2);

        // rotator button 
        JButton rotatorButton = new JButton();
        ImageIcon rotator = new ImageIcon(rotatorImage);
        Image scaledRotatorImage = rotator.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH); // Increased size
        rotatorButton.setIcon(new ImageIcon(scaledRotatorImage));
        rotatorButton.setOpaque(false);
        rotatorButton.setContentAreaFilled(false);
        rotatorButton.setBorderPainted(false);
        gbc2.gridx = 0;
        gbc2.gridy = 2;
        currentPlayerMazePiecePanel.add(rotatorButton,gbc2);

        currentPlayerMazePiecePanel.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.blue));;


        add(currentPlayerMazePiecePanel, gbc);
    }
    
    public void doneButtonAdd(GridBagConstraints gbc ) {
    	
    	
    	JButton doneButton = new JButton("Done");

    	styleButton(doneButton);
    	
    	
    	add(doneButton,gbc);
    	
    }
    
    private void styleButton(JButton button) {
      button.setOpaque(true); // Ensure the button is opaque to apply background color
//      button.setContentAreaFilled(true); // Fill the button with the background color
//      button.setBackground(buttonBackgroundColor); // Use the color defined for all buttons
      button.setForeground(buttonGTexts); // Text color for buttons
//      button.setBorder(BorderFactory.createLineBorder()); // Optional: add a border with transparency
      button.setFont(textFont); // Set font size for all buttons
  }
}
