/* Bhavay Garg
 * 041102440
 * Professor - Daniel Cormeir
 * 
 */

/*
 * This class's function is to create the UI and arrange it by calling different classes 
 * 
 * 
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class WizardMazeUI {
	
	private Color menuColor = new Color(50, 200, 77); // Color for menu items
	private Font menuFont = new Font("Arial", Font.BOLD, 24); // Font for menu items
    private ImageIcon backgroundImage = new ImageIcon("Images/BG1.png");

	
	// method for the create and show gui 
	 public void createAndShowGUI() {
		 
		 
		 
		 
		 	// main jFrame
	        // Create the JFrame and set its properties
	        JFrame frame = new JFrame("Wizard's Maze");
	        
	        
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(1350, 840); // Set the desired size for the window

	        // Create the main panel using BorderLayout
	        JPanel mainPanel = new JPanel(new BorderLayout());

	        // Create the maze tiles panel for the left side
	        JPanel mazePanel = new JPanel();
	        
	        mazePanel.setOpaque(false);
	        MazeStructure mazeStructure = new MazeStructure();
	        mazeStructure.displayMazeTiles(mazePanel); // Populate mazePanel with maze tiles

	       
	        // Create the background panel with the background image
	        JLabel backgroundILabel = new JLabel();
	        backgroundILabel.setIcon(backgroundImage);

	        backgroundILabel.setLayout(new BorderLayout()); // Use BorderLayout for easy overlaying

	        // Add the maze panel to the left side of the main panel
	        
	       
	        backgroundILabel.add(mazePanel, BorderLayout.WEST); // Place maze panel on the left

	  
	        
	     // Add the side panel using a separate method
	        JPanel sidePanel = createSidePanel();
	        backgroundILabel.add(sidePanel, BorderLayout.EAST); // Add the side panel to the east
	        
	        
//	        // Create the newPanel to cover the entire background panel
//	        JPanel newPanel = new JPanel(new GridBagLayout());
//	        newPanel.setOpaque(false); // Make newPanel transparent so the background is visible

	       

	        // Add the background panel to the center of the main panel
	        mainPanel.add(backgroundILabel, BorderLayout.CENTER);

	        // Add the menu bar to the top of the main panel
	        JMenuBar menuBar = createMenuBar();
	        backgroundILabel.add(menuBar, BorderLayout.NORTH);

	        // Set the main panel as the content pane of the frame
	        frame.setContentPane(mainPanel);

	        // Make the frame visible
	        frame.setVisible(true);
	    }
//    public void createAndShowGUI() {
//        // Main JFrame
//        JFrame frame = new JFrame("Wizard's Maze");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(1250, 840); // Set the desired size for the window
//
//        // Create the main panel using BorderLayout
//        JPanel mainPanel = new JPanel(new BorderLayout());
//
//        // Create the background label with the background image
//        JLabel backgroundILabel = new JLabel();
//        backgroundILabel.setIcon(backgroundImage);
//        backgroundILabel.setLayout(new GridBagLayout()); // Use GridBagLayout for the background label
//
//        // Create the maze tiles panel for the left side
//        JPanel mazePanel = new JPanel();
//        mazePanel.setOpaque(false);
//        MazeStructure mazeStructure = new MazeStructure();
//        mazeStructure.displayMazeTiles(mazePanel); // Populate mazePanel with maze tiles
//
//     // Add the menu bar to the top of the main panel
//        JMenuBar menuBar = createMenuBar();
//        GridBagConstraints gbcMenuBar = new GridBagConstraints();
//        gbcMenuBar.gridx = 0; // Column 0
//        gbcMenuBar.gridy = 0; // Row 0
////        gbcMenuBar.anchor = GridBagConstraints.WEST; // Anchor to the north
//
//        gbcMenuBar.fill = GridBagConstraints.VERTICAL; // Fill vertically
//        gbcMenuBar.weightx = 0.5; // Weight for width
//        gbcMenuBar.weighty = 1.0; // Weight for height
//        backgroundILabel.add(menuBar, gbcMenuBar);
//
//        
//        // Jlabel for the Logo image 
//        JLabel logo = new JLabel();
//        
//        logo.setIcon(logoImage);
//        GridBagConstraints gbcLogo = new GridBagConstraints();
//        gbcLogo.gridx = 1; // Column 0
//        gbcLogo.gridy = 1; // Row 0
//        gbcLogo.fill = GridBagConstraints.VERTICAL; // Fill vertically
//        gbcLogo.weightx = 0.5; // Weight for width
//        gbcLogo.weighty = 1.0; // Weight for height
//        backgroundILabel.add(logo, gbcLogo);
//        
//        
//        
//        
//        
//        // Create constraints for the maze panel
//        GridBagConstraints gbcMazePanel = new GridBagConstraints();
//        gbcMazePanel.gridx = 0; // Column 0
//        gbcMazePanel.gridy = 2; // Row 0
//        gbcMazePanel.fill = GridBagConstraints.VERTICAL; // Fill vertically
//        gbcMazePanel.weightx = 0.5; // Weight for width
//        gbcMazePanel.weighty = 1.0; // Weight for height
//
//        // Add the maze panel to the background label
//        backgroundILabel.add(mazePanel, gbcMazePanel); // Place maze panel on the left
//
//        // Create the newPanel to overlay other components
//        JPanel newPanel = new JPanel(new GridBagLayout());
//        newPanel.setOpaque(false); // Make newPanel transparent so the background is visible
//
//        // Example: Add components to the newPanel (add your components here)
//        // addComponentsToOverlay(newPanel); // Call a method to add your components
//
//        // Create constraints for the overlay panel
//        
//        mainPanel.add(backgroundILabel, BorderLayout.NORTH);
//
//       
//        frame.getContentPane().add(mainPanel,BorderLayout.NORTH);
//        // Add the background label to the center of the main panel
//
//        
//        // Set the main panel as the content pane of the frame
////        frame.setContentPane(mainPanel);
//
//        // Make the frame visible
//        frame.setVisible(true);
//    }

	 
    
//     menuBar.setBackground(new Color(63, 53, 63, 90)); // Set the background color with transparency

	 
	 
	 
	 
	 
	 
	 // method for creating menu bar go
	 public JMenuBar createMenuBar() {
	        JMenuBar menuBar = new JMenuBar();
	        menuBar.setOpaque(false); // Make the menu bar non-opaque (transparent)
	        menuBar.setBorder(null);

	        // File Menu
	        JMenu fileMenu = new JMenu("File");
	        fileMenu.setForeground(menuColor);
	        fileMenu.setFont(menuFont); // Use the menuFont variable
	        
	        JMenuItem saveItem = new JMenuItem("Save");
	        saveItem.setFont(menuFont); // Set font for save item
	        saveItem.setForeground(menuColor); // Set color for save item
	        JMenuItem reloadItem = new JMenuItem("Reload");
	        reloadItem.setFont(menuFont); // Set font for reload item
	        reloadItem.setForeground(menuColor); // Set color for reload item
	        fileMenu.add(saveItem);
	        fileMenu.add(reloadItem);

	        // Game Menu
	        JMenu gameMenu = new JMenu("Game");
	        gameMenu.setForeground(menuColor); // Use the same color variable
	        gameMenu.setFont(menuFont); // Use the menuFont variable

	        JMenuItem newGameItem = new JMenuItem("New Game");
	        newGameItem.setFont(menuFont); // Set font for new game item
	        newGameItem.setForeground(menuColor); // Set color for new game item
	        JMenuItem changeNameItem = new JMenuItem("Change Name");
	        changeNameItem.setFont(menuFont); // Set font for change name item
	        changeNameItem.setForeground(menuColor); // Set color for change name item
	        JMenuItem invitePlayerItem = new JMenuItem("Invite Player");
	        invitePlayerItem.setFont(menuFont); // Set font for invite player item
	        invitePlayerItem.setForeground(menuColor); // Set color for invite player item
	        JMenuItem historyItem = new JMenuItem("History");
	        historyItem.setFont(menuFont); // Set font for history item
	        historyItem.setForeground(menuColor); // Set color for history item
	        gameMenu.add(newGameItem);
	        gameMenu.add(changeNameItem);
	        gameMenu.add(invitePlayerItem);
	        gameMenu.add(historyItem);

	        // Language Menu
	        JMenu languageMenu = new JMenu("Language");
	        languageMenu.setForeground(menuColor); // Use the same color variable
	        languageMenu.setFont(menuFont); // Use the menuFont variable

	        JMenuItem englishItem = new JMenuItem("English");
	        englishItem.setFont(menuFont); // Set font for English item
	        englishItem.setForeground(menuColor); // Set color for English item
	        JMenuItem chineseItem = new JMenuItem("Chinese");
	        chineseItem.setFont(menuFont); // Set font for Chinese item
	        chineseItem.setForeground(menuColor); // Set color for Chinese item
	        languageMenu.add(englishItem);
	        languageMenu.add(chineseItem);

	        // Help Menu
	        JMenu helpMenu = new JMenu("Help");
	        helpMenu.setForeground(menuColor); // Use the same color variable
	        helpMenu.setFont(menuFont); // Use the menuFont variable

	        JMenuItem aboutItem = new JMenuItem("About (Information about Developers)");
	        aboutItem.setFont(menuFont); // Set font for about item
	        aboutItem.setForeground(menuColor); // Set color for about item
	        JMenuItem gameRulesItem = new JMenuItem("Game Rules");
	        gameRulesItem.setFont(menuFont); // Set font for game rules item
	        gameRulesItem.setForeground(menuColor); // Set color for game rules item
	        helpMenu.add(aboutItem);
	        helpMenu.add(gameRulesItem);

	        // Network Menu
	        JMenu networkMenu = new JMenu("Network");
	        networkMenu.setForeground(menuColor); // Use the same color variable
	        networkMenu.setFont(menuFont); // Use the menuFont variable

	        JMenuItem hostItem = new JMenuItem("Host");
	        hostItem.setFont(menuFont); // Set font for host item
	        hostItem.setForeground(menuColor); // Set color for host item
	        JMenuItem connectItem = new JMenuItem("Connect");
	        connectItem.setFont(menuFont); // Set font for connect item
	        connectItem.setForeground(menuColor); // Set color for connect item
	        JMenuItem disconnectItem = new JMenuItem("Disconnect");
	        disconnectItem.setFont(menuFont); // Set font for disconnect item
	        disconnectItem.setForeground(menuColor); // Set color for disconnect item
	        networkMenu.add(hostItem);
	        networkMenu.add(connectItem);
	        networkMenu.add(disconnectItem);

	        // Add all menus to the menu bar
	        menuBar.add(fileMenu);
	        menuBar.add(gameMenu);
	        menuBar.add(languageMenu);
	        menuBar.add(helpMenu);
	        menuBar.add(networkMenu);

	        return menuBar;
	    }
	 
	 private JPanel createSidePanel() {
	        // Create the side panel using GridBagLayout
	        JPanel sidePanel = new JPanel(new GridBagLayout());
	        sidePanel.setOpaque(false); // Make the side panel transparent

	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.insets = new Insets(5, 5, 5, 5); // Add some margin between components

	        // Add logo to the side panel
	       

	        // Create buttons for the side panel
	        gbc.anchor = GridBagConstraints.NORTHWEST;
	        
	        JButton done = new JButton();
	        
	        String[] buttonLabels = {"Done", "Shuffle", "Wands", "Recipe", "Piece Captured"};
            gbc.gridy =  1; // Update row for each button
            gbc.gridx =  1; // Update row for each button

	        for (int i = 0; i < buttonLabels.length; i++) {
	            JButton button = new JButton(buttonLabels[i]);
	            
	            sidePanel.add(button, gbc);
	        }

	        // Add a chat box at the bottom
	        JTextArea chatBox = new JTextArea(5, 20); // Example chat box with 5 rows and 20 columns
	        chatBox.setLineWrap(true);
	        chatBox.setWrapStyleWord(true);
	        JScrollPane scrollPane = new JScrollPane(chatBox); // Add scroll pane for scrolling

	        gbc.gridy = buttonLabels.length + 1; // Update row for chat box
	        gbc.fill = GridBagConstraints.BOTH; // Fill the remaining space
	        gbc.weighty = 1.0; // Let the chat box take extra vertical space
	        sidePanel.add(scrollPane, gbc);

	        return sidePanel;
	    }

	 
	 
	 
	}

