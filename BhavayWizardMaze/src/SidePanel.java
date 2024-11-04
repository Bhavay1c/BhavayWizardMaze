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
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;


public class SidePanel extends JPanel {
    private JLabel spareTileLabel;
    private String extraMazePiece;
    private String rotatorImage = "Images/rotator.png";
    private Color buttonBackgroundColor = new Color(63, 53, 53, 1); // Button background color
    private Color buttonGTexts = new Color(183, 18, 128, 255); // Button text color
    private Color buttonBorderC = new Color(54, 8, 204, 255); // Button text color
    private Color greenWTexts = new Color(63, 181, 13, 255); // Button text color
    private Color redWTexts = new Color(181, 13, 13, 255); // Button text color
    private Color blueWTexts = new Color(18, 29, 183,255); // Button text color
    private Color yellowWTexts = new Color(225, 219, 25, 255); // Button text color
    private Font textFont = new Font("Arial", Font.BOLD, 24);
    private Dimension buttonDimension = new Dimension(120,70);
//    private Map<String, Color> players;
    private ArrayList<Player> playersList = new ArrayList<Player>(4);
    private String wandImage = "Images/Wands1.png";
    private JPanel topSidePanel = new JPanel();
   
    public SidePanel(String mazePiece) {
//    	 to get the image addressm of the piece missing 
      topSidePanel.setLayout(new GridBagLayout());
      topSidePanel.setOpaque(false);
//		topSidePanel.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.blue));

    	 setLayout(new BorderLayout());
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

        
        gbc.insets = new Insets(80, -10, 0, 30); // 20px top margin, no padding on other sides
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;

        playersListAdd(gbc,2);
        
         
         
        gbc.insets = new Insets(80,20, 0, 0); // 20px top margin, no padding on other sides
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        currentPlayerMazePiecePanelAdd(mazePiece, player3 , gbc);
         
        
        gbc.insets = new Insets(0, -10, 0, 0); // 20px top margin, no padding on other sides
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        doneButtonAdd(gbc);  
        
        gbc.insets = new Insets(0, -50, 0, 0); // 20px top margin, no padding on other sides
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        wandsButtonAdd(gbc,3);  

        gbc.gridx = 1;
        gbc.gridy = 2;
        player1.setRecipe(2,5,7);
        player1.addCapturedPiece(1);
        player1.addCapturedPiece(13);
        player1.addCapturedPiece(1);
        player1.addCapturedPiece(13);player1.addCapturedPiece(1);
        player1.addCapturedPiece(13);player1.addCapturedPiece(1);
        player1.addCapturedPiece(13);player1.addCapturedPiece(1);
        player1.addCapturedPiece(13);player1.addCapturedPiece(1);
        player1.addCapturedPiece(13);player1.addCapturedPiece(1);
        player1.addCapturedPiece(13);player1.addCapturedPiece(1);
        player1.addCapturedPiece(13);player1.addCapturedPiece(1);
        player1.addCapturedPiece(13);

        recipePiecesCapturedPanelAdd(gbc,player1);  
        

        gbc.gridx = 1;
        gbc.gridy = 3;
        chatPanelAdd(gbc, player1);
        
        
        add(topSidePanel,BorderLayout.CENTER);

        
    }
    
    
    public void recipePiecesCapturedPanelAdd(GridBagConstraints gbc,Player currentPlayer) {
    	
    	JPanel recipePiecesCapturedPanel = new JPanel();
    	recipePiecesCapturedPanel.setLayout(new GridBagLayout());
    	recipePiecesCapturedPanel.setOpaque(false);
    	
    	GridBagConstraints gbc2 = new GridBagConstraints();
    	
    	JButton recipeButton = new JButton();
    	
    	recipeButton.setPreferredSize(buttonDimension);
    	
    	
    	for (int i =0 ; i < currentPlayer.getRecipe().length; i++) {
    		 ImageIcon recipe1 = new ImageIcon("Images/green_" + currentPlayer.getRecipe()[i] + ".png"); // default
             Image scaledRecipe1 = recipe1.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
             JLabel recipe1Label = new JLabel(new ImageIcon(scaledRecipe1));
    	
             recipeButton.add(recipe1Label);
    	
    	}
    	
    	
    	 
        styleButton(recipeButton);

    	recipeButton.setLayout(new GridBagLayout());
    	gbc2.gridx = 0;
    	gbc2.gridy = 0;
    	recipePiecesCapturedPanel.add(recipeButton,gbc2);
    	
    	
    	// below for peicecapturedLabel
    	
    	JPanel piecesCapturedPanel = new JPanel();
    	
    	
    	
    	
    	for (int i =0 ; i < currentPlayer.getCapturedPieces().length; i++) {
    		 ImageIcon piece1 = new ImageIcon("Images/green_" + currentPlayer.getCapturedPieces()[i] + ".png"); // default
             Image scaledPiece1 = piece1.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
             JLabel piece1Label = new JLabel(new ImageIcon(scaledPiece1));

             piecesCapturedPanel.add(piece1Label);
    	
    	}
    	
//    	piecesCapturedPanel.setPreferredSize(new Dimension(550, 70)); // Set a larger preferred width for scrolling
    
    	piecesCapturedPanel.setLayout(new GridBagLayout());
    	piecesCapturedPanel.setOpaque(false);

    	
    	gbc2.gridx = 1;
    	gbc2.gridy = 0;
    	
//    	recipePiecesCapturedPanel.add(piecesCapturedPanel,gbc2);
//    	 // Create a JScrollPane for horizontal scrolling
        JScrollPane scrollPane = new JScrollPane(piecesCapturedPanel);
        scrollPane.setOpaque(false);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(150,70));
////    	gbc2.gridx = 1;
//    	gbc2.gridy = 1;
//        gbc2.insets= new Insets(5,5,5,5);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        recipePiecesCapturedPanel.add(scrollPane,gbc2);
    	
        
        
        
        
        JLabel recipePieceTextLabel = new JLabel("Recipe/Pieces Captured");
        
      
        recipePieceTextLabel.setForeground(buttonGTexts);
        recipePieceTextLabel.setFont(textFont);
        gbc2.gridx = 0;
    	gbc2.gridy = 1;
    	gbc2.gridwidth = 2;
        
    	recipePiecesCapturedPanel.add(recipePieceTextLabel,gbc2);

    	
        topSidePanel.add(recipePiecesCapturedPanel,gbc);
        
        
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

  
        
        topSidePanel.add(playersListPanel, gbc);

        
        
//        playersListPanel.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.red));;

    	
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
        Image scaledRotatorImage = rotator.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Increased size
        rotatorButton.setIcon(new ImageIcon(scaledRotatorImage));
        rotatorButton.setOpaque(false);
        rotatorButton.setContentAreaFilled(false);
        rotatorButton.setBorderPainted(false);
        gbc2.gridx = 2;
        gbc2.gridy = 1;
        currentPlayerMazePiecePanel.add(rotatorButton,gbc2);

//        currentPlayerMazePiecePanel.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.blue));;


        topSidePanel.add(currentPlayerMazePiecePanel, gbc);
    }
    
    
    public void wandsButtonAdd(GridBagConstraints gbc, int wands) {
    	JPanel wandsButtonPanel = new JPanel();
    	wandsButtonPanel.setLayout(new GridBagLayout());
    	wandsButtonPanel.setOpaque(false);
    	
    	GridBagConstraints gbc2 = new GridBagConstraints();
    	
    	gbc2.gridx = 0;
    	gbc2.gridy = 0;
    	
    	JButton wandsButton = new JButton();
    	wandsButton.setPreferredSize(buttonDimension);
    	
    	
    	for (int i =0 ; i < wands; i++) {
    		 ImageIcon wand = new ImageIcon(wandImage); // default
             Image scaledWand = wand.getImage().getScaledInstance(46, 43, Image.SCALE_SMOOTH);
             JLabel wandLabel = new JLabel(new ImageIcon(scaledWand));
      	
             wandsButton.add(wandLabel);
    	}
    	  
           styleButton(wandsButton);
           wandsButton.setLayout(new GridBagLayout());
           wandsButtonPanel.add(wandsButton,gbc2);
           
           JLabel wandsLabel = new JLabel("Wands");
           wandsLabel.setForeground(buttonGTexts);
           wandsLabel.setFont(textFont);
           gbc2.gridx = 0;
       	   gbc2.gridy = 1;
           
           wandsButtonPanel.add(wandsLabel,gbc2);

           topSidePanel.add(wandsButtonPanel,gbc);
    }
    
    public void doneButtonAdd(GridBagConstraints gbc ) {
    	
    	
    	JButton doneButton = new JButton("Done");
    	doneButton.setPreferredSize(buttonDimension);
    	styleButton(doneButton);
    	
    	
    	topSidePanel.add(doneButton,gbc);
    	
    }
    
    private void styleButton(JButton button) {
      button.setOpaque(false); // Ensure the button is opaque to apply background color
      button.setContentAreaFilled(true); // Fill the button with the background color
      button.setBackground(buttonBackgroundColor); // Use the color defined for all buttons
      button.setForeground(buttonGTexts); // Text color for buttons
      button.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, buttonBorderC)); // bronze-like color with transparency
      button.setFont(textFont); // Set font size for all buttons
      // Center text in the button
//      button.setHorizontalAlignment(SwingConstants.CENTER);
//      button.setVerticalAlignment(SwingConstants.CENTER);

      // Add padding between the text and the border
//      button.setMargin(new Insets(20, 20, 20, 20)); // Adjust padding as needed (top, left, bottom, right)
  }


    public void chatPanelAdd(GridBagConstraints gbc, Player currentPlayer) {

        JPanel chatPanel = new JPanel();
        chatPanel.setOpaque(false);
        chatPanel.setLayout(new BorderLayout());
        chatPanel.setBorder(BorderFactory.createMatteBorder(3,2,0,2, Color.black));

        JTextArea chatArea = new JTextArea(8, 15); // 15 rows, 15 columns
        chatArea.setOpaque(false);
        chatArea.setEditable(false); // Users can't edit the chat area directly
        chatArea.setFont(textFont);

        JScrollPane chatScroll = new JScrollPane(chatArea); // Add scrolling for the chat area
        chatScroll.setOpaque(false);
        chatScroll.getViewport().setOpaque(false);
        chatPanel.add(chatScroll, BorderLayout.CENTER); // Place the chat area in the center of the panel
        

        JTextField chatInput = new JTextField();
        chatInput.setForeground(currentPlayer.getColor());
        chatInput.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.red));

        chatInput.setFont(textFont);
        chatInput.setOpaque(false);

        JButton sendButton = new JButton("Send");
        styleButton(sendButton);

        JPanel chatInputPanel = new JPanel(new BorderLayout());
        chatInputPanel.setOpaque(false);
        chatInputPanel.add(chatInput, BorderLayout.CENTER); // Input field takes most of the space
        chatInputPanel.add(sendButton, BorderLayout.EAST); // Send button is aligned to the right

        chatPanel.add(chatInputPanel, BorderLayout.SOUTH);
        add(chatPanel, BorderLayout.SOUTH);

        // ActionListener for sending the message
        ActionListener sendMessage = e -> {
            String message = chatInput.getText().trim();
            if (!message.isEmpty()) {
                chatArea.append(currentPlayer.getName() + ": " + message + "\n"); // Display the message with player's name
                chatArea.setForeground(currentPlayer.getColor());
                chatInput.setText(""); // Clear the input field after sending
                chatArea.setCaretPosition(chatArea.getDocument().getLength()); // Scroll to the bottom of the chat area
            }
        };

        // Add action listener to both send button and chat input field (Enter key)
        sendButton.addActionListener(sendMessage);
        chatInput.addActionListener(sendMessage); // Pressing Enter will also send the message
    }
}
