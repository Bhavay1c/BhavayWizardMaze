/**
 * The WizardMazeUI class is responsible for creating and displaying 
 * the user interface for the Wizard's Maze game. It handles the 
 * arrangement of components, including the maze and menu bar
 * 
 * @author Bhavay Garg
 * @studentID 041102440
 * @professor Daniel Cormeir
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class ViewWizardMazeUI {
	
	private Color menuColor = new Color(50, 200, 77); // Color for menu items
	private Font menuFont = new Font("Arial", Font.BOLD, 24); // Font for menu items
	private ImageIcon backgroundImage = new ImageIcon("Images/BG1.png");
	private String extraTile;
	private ViewMazeStructure mazeStructure = new ViewMazeStructure(null);
	// Declare all menu items as private variables
	private JMenuItem saveItem = createMenuItem("Save");
	private JMenuItem reloadItem = createMenuItem("Reload");
	private JMenuItem newGameItem = createMenuItem("New Game");
	private JMenuItem changeNameItem = createMenuItem("Change Name");
	private JMenuItem invitePlayerItem = createMenuItem("Invite Player");
	private JMenuItem englishItem =createMenuItem("English");
	private JMenuItem chineseItem = createMenuItem("Chinese");
	private JMenuItem aboutItem = createMenuItem("About (Information about Developers)");
	private JMenuItem gameRulesItem = createMenuItem("Game Rules");
	private JMenuItem hostItem = createMenuItem("Host");
	private JMenuItem connectItem = createMenuItem("Connect");
	private JMenuItem disconnectItem = createMenuItem("Disconnect");

	// Getter methods for each menu item
	public JMenuItem getSaveItem() {
	    return saveItem;
	}

	public JMenuItem getReloadItem() {
	    return reloadItem;
	}

	public JMenuItem getNewGameItem() {
	    return newGameItem;
	}

	public JMenuItem getChangeNameItem() {
	    return changeNameItem;
	}

	public JMenuItem getInvitePlayerItem() {
	    return invitePlayerItem;
	}

	public JMenuItem getEnglishItem() {
	    return englishItem;
	}

	public JMenuItem getChineseItem() {
	    return chineseItem;
	}

	public JMenuItem getAboutItem() {
	    return aboutItem;
	}

	public JMenuItem getGameRulesItem() {
	    return gameRulesItem;
	}

	public JMenuItem getHostItem() {
	    return hostItem;
	}

	public JMenuItem getConnectItem() {
	    return connectItem;
	}

	public JMenuItem getDisconnectItem() {
	    return disconnectItem;
	}

	/**
	 * Creates and displays the main GUI of the Wizard's Maze game.
	 */
	public void createAndShowGUI() {
		JFrame frame = createMainFrame();
		JPanel mainPanel = new JPanel(new BorderLayout());

		// Create and configure the maze panel
		JPanel mazePanel = createMazePanel();
//		mazePanel.setBorder(BorderFactory.createMatteBorder(1, 1,1 , 1, Color.green));
		
		ViewSidePanel sidePanel = new ViewSidePanel(extraTile); // Create the side panel
		
//		sidePanel.setBorder(BorderFactory.createMatteBorder(1, 1,1 , 1, Color.red));

		// Create the background label with the background image
		JLabel backgroundLabel = createBackgroundLabel(mazePanel, sidePanel);

		// Add the menu bar
		JMenuBar menuBar = createMenuBar();
		backgroundLabel.add(menuBar, BorderLayout.NORTH);

		// Add the background panel to the main panel
		mainPanel.add(backgroundLabel, BorderLayout.CENTER);
		frame.setContentPane(mainPanel);
		frame.setVisible(true);
	}

	/**
	 * Creates and configures the main frame for the application.
	 * 
	 * @return The configured JFrame object.
	 */
	private JFrame createMainFrame() {
		JFrame frame = new JFrame("Wizard's Maze");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1350, 840); // Set the desired size for the window
		return frame;
	}

	/**
	 * Creates the maze panel and populates it with maze tiles.
	 * 
	 * @return The JPanel containing the maze.
	 */
	private JPanel createMazePanel() {
		JPanel mazePanel = new JPanel();
		mazePanel.setOpaque(false);
		extraTile = mazeStructure.displayMazeTiles(mazePanel); // Populate mazePanel with maze tiles
		return mazePanel;
	}
	
//	public JButton[][] getViewMazeStructure() {
//		return mazeStructure.mazePattern;
//		
//	}
	
	public ViewMazeStructure getViewMazeStructure() {
		return mazeStructure;
		
	}

	/**
	 * Creates a background label with the specified maze and side panel.
	 * 
	 * @param mazePanel The panel containing the maze.
	 * @param sidePanel The panel containing additional controls.
	 * @return The JLabel that serves as the background for the UI.
	 */
	private JLabel createBackgroundLabel(JPanel mazePanel, ViewSidePanel sidePanel) {
		JLabel backgroundLabel = new JLabel();
		backgroundLabel.setIcon(backgroundImage);
		backgroundLabel.setLayout(new BorderLayout()); // Use BorderLayout for easy overlaying
		
		// Creating a panel for margin for the maze 
		JPanel wrapperPanel = new JPanel(new BorderLayout());
		
//		wrapperPanel.setBorder(BorderFactory.createMatteBorder(1, 20, 1, 1, Color.yellow)); // 20 pixels left margin
		wrapperPanel.setOpaque(false);
		
		wrapperPanel.add(mazePanel, BorderLayout.CENTER);
		backgroundLabel.add(wrapperPanel, BorderLayout.WEST);
		backgroundLabel.add(sidePanel, BorderLayout.CENTER); // Add the side panel to the east
		return backgroundLabel;
	}

	/**
	 * Creates the menu bar for the application.
	 * 
	 * @return The JMenuBar object containing all the menus.
	 */
	// Declare all menu items as public variables


	public JMenuBar createMenuBar() {
	    JMenuBar menuBar = new JMenuBar();
	    menuBar.setOpaque(false); // Make the menu bar non-opaque (transparent)
	    menuBar.setBorder(null);

	    // File Menu
	    JMenu fileMenu = new JMenu("File");
	    fileMenu.setForeground(menuColor);
	    fileMenu.setFont(menuFont); // Use the menuFont variable
	    fileMenu.add(saveItem);
	    fileMenu.add(reloadItem);

	    // Game Menu
	    JMenu gameMenu = new JMenu("Game");
	    gameMenu.setForeground(menuColor);
	    gameMenu.setFont(menuFont);
	    gameMenu.add(newGameItem);
	    gameMenu.add(changeNameItem);
	    gameMenu.add(invitePlayerItem);

	    // Language Menu
	    JMenu languageMenu = new JMenu("Language");
	    languageMenu.setForeground(menuColor);
	    languageMenu.setFont(menuFont);
	    languageMenu.add(englishItem);
	    languageMenu.add(chineseItem);

	    // Help Menu
	    JMenu helpMenu = new JMenu("Help");
	    helpMenu.setForeground(menuColor);
	    helpMenu.setFont(menuFont);
	    helpMenu.add(aboutItem);
	    helpMenu.add(gameRulesItem);

	    // Network Menu
	    JMenu networkMenu = new JMenu("Network");
	    networkMenu.setForeground(menuColor);
	    networkMenu.setFont(menuFont);
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

	/**
	 * Helper method to create menu items with consistent styling.
	 * 
	 * @param text The text to be displayed on the menu item.
	 * @return A JMenuItem with consistent styling.
	 */
	private JMenuItem createMenuItem(String text) {
		JMenuItem menuItem = new JMenuItem(text);
		menuItem.setFont(menuFont);
		menuItem.setForeground(menuColor);
		return menuItem;
	}
}
