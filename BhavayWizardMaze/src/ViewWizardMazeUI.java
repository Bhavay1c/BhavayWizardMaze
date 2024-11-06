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
		ViewMazeStructure mazeStructure = new ViewMazeStructure();
		extraTile = mazeStructure.displayMazeTiles(mazePanel); // Populate mazePanel with maze tiles
		return mazePanel;
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
	public JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.setOpaque(false); // Make the menu bar non-opaque (transparent)
		menuBar.setBorder(null);

		// File Menu
		JMenu fileMenu = new JMenu("File");
		fileMenu.setForeground(menuColor);
		fileMenu.setFont(menuFont); // Use the menuFont variable
		
		JMenuItem saveItem = createMenuItem("Save");
		JMenuItem reloadItem = createMenuItem("Reload");
		fileMenu.add(saveItem);
		fileMenu.add(reloadItem);

		// Game Menu
		JMenu gameMenu = new JMenu("Game");
		gameMenu.setForeground(menuColor);
		gameMenu.setFont(menuFont);

		JMenuItem newGameItem = createMenuItem("New Game");
		JMenuItem changeNameItem = createMenuItem("Change Name");
		JMenuItem invitePlayerItem = createMenuItem("Invite Player");
		JMenuItem historyItem = createMenuItem("History");
		gameMenu.add(newGameItem);
		gameMenu.add(changeNameItem);
		gameMenu.add(invitePlayerItem);
		gameMenu.add(historyItem);

		// Language Menu
		JMenu languageMenu = new JMenu("Language");
		languageMenu.setForeground(menuColor);
		languageMenu.setFont(menuFont);

		JMenuItem englishItem = createMenuItem("English");
		JMenuItem chineseItem = createMenuItem("Chinese");
		languageMenu.add(englishItem);
		languageMenu.add(chineseItem);

		// Help Menu
		JMenu helpMenu = new JMenu("Help");
		helpMenu.setForeground(menuColor);
		helpMenu.setFont(menuFont);

		JMenuItem aboutItem = createMenuItem("About (Information about Developers)");
		JMenuItem gameRulesItem = createMenuItem("Game Rules");
		helpMenu.add(aboutItem);
		helpMenu.add(gameRulesItem);

		// Network Menu
		JMenu networkMenu = new JMenu("Network");
		networkMenu.setForeground(menuColor);
		networkMenu.setFont(menuFont);

		JMenuItem hostItem = createMenuItem("Host");
		JMenuItem connectItem = createMenuItem("Connect");
		JMenuItem disconnectItem = createMenuItem("Disconnect");
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
