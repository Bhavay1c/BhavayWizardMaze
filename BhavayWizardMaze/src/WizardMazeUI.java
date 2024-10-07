/*
 * Bhavay Garg
 * 041102440
 * Professor - Daniel Cormeir
 */

/*
 * This class's function is to create the UI and arrange it by calling different classes 
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

public class WizardMazeUI {
	
	private Color menuColor = new Color(50, 200, 77); // Color for menu items
	private Font menuFont = new Font("Arial", Font.BOLD, 24); // Font for menu items
	private ImageIcon backgroundImage = new ImageIcon("Images/BG1.png");

	// method for the create and show GUI 
	public void createAndShowGUI() {
		JFrame frame = createMainFrame();
		JPanel mainPanel = new JPanel(new BorderLayout());

		// Create and configure the maze panel
		JPanel mazePanel = createMazePanel();
		SidePanel sidePanel = new SidePanel(); // Create the side panel

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

	private JFrame createMainFrame() {
		JFrame frame = new JFrame("Wizard's Maze");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1350, 840); // Set the desired size for the window
		return frame;
	}

	private JPanel createMazePanel() {
		JPanel mazePanel = new JPanel();
		mazePanel.setOpaque(false);
		MazeStructure mazeStructure = new MazeStructure();
		mazeStructure.displayMazeTiles(mazePanel); // Populate mazePanel with maze tiles
		return mazePanel;
	}

	private JLabel createBackgroundLabel(JPanel mazePanel, SidePanel sidePanel) {
		JLabel backgroundLabel = new JLabel();
		backgroundLabel.setIcon(backgroundImage);
		backgroundLabel.setLayout(new BorderLayout()); // Use BorderLayout for easy overlaying
		
		
		//  creating a panel for margin for the maze 
		JPanel wrapperPanel = new JPanel(new BorderLayout());
        wrapperPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0)); // 20 pixels left margin
        wrapperPanel.setOpaque(false);
      

        wrapperPanel.add(mazePanel, BorderLayout.CENTER);
        backgroundLabel.add(wrapperPanel, BorderLayout.WEST);
		backgroundLabel.add(sidePanel, BorderLayout.EAST); // Add the side panel to the east
		return backgroundLabel;
	}

	// Method for creating menu bar
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

	// Helper method to create menu items with consistent styling
	private JMenuItem createMenuItem(String text) {
		JMenuItem menuItem = new JMenuItem(text);
		menuItem.setFont(menuFont);
		menuItem.setForeground(menuColor);
		return menuItem;
	}
}
