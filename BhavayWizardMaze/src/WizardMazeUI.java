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
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class WizardMazeUI {
	
	
	
	// method for the create and show gui 
	 public void createAndShowGUI() {
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
	        JLabel backgroundPanel = new JLabel();
	        ImageIcon backgroundImage = new ImageIcon("Images/BG.jpg");
	        backgroundPanel.setIcon(backgroundImage);

	        backgroundPanel.setLayout(new BorderLayout()); // Use BorderLayout for easy overlaying

	        // Add the maze panel to the left side of the main panel
	        
	       
	        backgroundPanel.add(mazePanel, BorderLayout.WEST); // Place maze panel on the left

	        // Create the newPanel to cover the entire background panel
	        JPanel newPanel = new JPanel(new GridBagLayout());
	        newPanel.setOpaque(false); // Make newPanel transparent so the background is visible

	        // Add components to newPanel (which overlays the background)
//	        addComponentsToPane(newPanel);

	        // Add newPanel on top of the background panel
	        backgroundPanel.add(newPanel, BorderLayout.EAST);

	        // Add the background panel to the center of the main panel
	        mainPanel.add(backgroundPanel, BorderLayout.CENTER);

	        // Add the menu bar to the top of the main panel
	        JMenuBar menuBar = createMenuBar();
	        backgroundPanel.add(menuBar, BorderLayout.NORTH);

	        // Set the main panel as the content pane of the frame
	        frame.setContentPane(mainPanel);

	        // Make the frame visible
	        frame.setVisible(true);
	    }
	 
	 
	 
	 // method for creating menu bar 
	 public JMenuBar createMenuBar() {
	        JMenuBar menuBar = new JMenuBar();
//	        menuBar.setOpaque(false); // Make the menu bar non-opaque (transparent)
	        menuBar.setBackground(new Color(63, 53, 63, 90)); // Set the background color with transparency
	        menuBar.setBorder(null);
	        // File Menu
	        JMenu fileMenu = new JMenu("File");
	        fileMenu.setForeground(new Color(50,200,77) ); // Set the text color to red
	        fileMenu.setFont(new Font("Serif", Font.PLAIN, 24));
	        
	        JMenuItem saveItem = new JMenuItem("Save");
	        JMenuItem reloadItem = new JMenuItem("Reload");
	        fileMenu.add(saveItem);
	        fileMenu.add(reloadItem);

	        // Game Menu
	        JMenu gameMenu = new JMenu("Game");
	        gameMenu.setForeground(new Color(50,200,77) ); // Set the text color to red

	        JMenuItem newGameItem = new JMenuItem("New Game");
	        JMenuItem changeNameItem = new JMenuItem("Change Name");
	        JMenuItem invitePlayerItem = new JMenuItem("Invite Player");
	        JMenuItem historyItem = new JMenuItem("History");
	        gameMenu.add(newGameItem);
	        gameMenu.add(changeNameItem);
	        gameMenu.add(invitePlayerItem);
	        gameMenu.add(historyItem);

	        // Language Menu
	        JMenu languageMenu = new JMenu("Language");
	        languageMenu.setForeground(new Color(50,200,77) ); // Set the text color to red

	        JMenuItem englishItem = new JMenuItem("English");
	        JMenuItem chineseItem = new JMenuItem("Chinese");
	        languageMenu.add(englishItem);
	        languageMenu.add(chineseItem);

	        // Help Menu
	        JMenu helpMenu = new JMenu("Help");
	        helpMenu.setForeground(new Color(50,200,77) ); // Set the text color to red

	        JMenuItem aboutItem = new JMenuItem("About (Information about Developers)");
	        JMenuItem gameRulesItem = new JMenuItem("Game Rules");
	        helpMenu.add(aboutItem);
	        helpMenu.add(gameRulesItem);

	        // Network Menu
	        JMenu networkMenu = new JMenu("Network");
	        networkMenu.setForeground(new Color(50,200,77) ); // Set the text color to red

	        JMenuItem hostItem = new JMenuItem("Host");
	        JMenuItem connectItem = new JMenuItem("Connect");
	        JMenuItem disconnectItem = new JMenuItem("Disconnect");
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


}
