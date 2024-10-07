import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class SidePanel extends JPanel {
    private JLabel spareTileLabel;
    private JButton doneButton;
    private JTextArea chatBoxArea;
    private JScrollPane capturedPiecesScroll;
    private JButton shuffleButton, wandsButton;

    // Map to hold player names and their colors
    private Map<String, Color> players;

    public SidePanel() {
        // Setting layout and panel properties
        setLayout(new BorderLayout());
        setBackground(new Color(50, 50, 50));
        players = new HashMap<>();

        // Panel for spare tile and buttons
        JPanel spareTilePanel = new JPanel();
        spareTilePanel.setLayout(new BorderLayout());
        spareTilePanel.setOpaque(false); // To keep the transparency

        // Spare tile (Image)
        spareTileLabel = new JLabel(new ImageIcon("path/to/spareTileImage.png")); // Load the actual image here
        spareTileLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Arrow buttons
        JPanel arrowButtonsPanel = new JPanel();
        arrowButtonsPanel.setLayout(new BoxLayout(arrowButtonsPanel, BoxLayout.X_AXIS));
        arrowButtonsPanel.setOpaque(false);

        JButton leftArrowButton = new JButton("<");
        JButton rightArrowButton = new JButton(">");

        arrowButtonsPanel.add(leftArrowButton);
        arrowButtonsPanel.add(rightArrowButton);

        spareTilePanel.add(spareTileLabel, BorderLayout.CENTER);
        spareTilePanel.add(arrowButtonsPanel, BorderLayout.SOUTH);

        // Adding spareTilePanel to top
        add(spareTilePanel, BorderLayout.NORTH);

        // Player Names Section
        JPanel playerNamesPanel = new JPanel();
        playerNamesPanel.setLayout(new BoxLayout(playerNamesPanel, BoxLayout.Y_AXIS));
        playerNamesPanel.setOpaque(false);
        add(playerNamesPanel, BorderLayout.CENTER);

        // Done Button with transparent background
        doneButton = new JButton("Done");
        doneButton.setOpaque(false);
        doneButton.setContentAreaFilled(false);
        doneButton.setForeground(Color.WHITE);
        doneButton.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 150))); // Add some RGBA for transparency
        doneButton.setFont(new Font("Arial", Font.BOLD, 14));
        doneButton.setPreferredSize(new Dimension(100, 40));
        add(doneButton, BorderLayout.SOUTH);

        // Captured Pieces with Scroll
        JLabel capturedPiecesLabel = new JLabel("Pieces Captured:");
        capturedPiecesLabel.setForeground(Color.WHITE);
        capturedPiecesLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        JPanel capturedPiecesPanel = new JPanel();
        capturedPiecesPanel.setLayout(new BoxLayout(capturedPiecesPanel, BoxLayout.Y_AXIS));
        capturedPiecesPanel.setOpaque(false);

        // Add mock captured pieces (can be replaced with actual pieces)
        for (int i = 1; i <= 10; i++) {
            capturedPiecesPanel.add(new JLabel("Captured Piece " + i));
        }

        capturedPiecesScroll = new JScrollPane(capturedPiecesPanel);
        capturedPiecesScroll.setPreferredSize(new Dimension(200, 100));
        capturedPiecesScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        capturedPiecesScroll.setOpaque(false);

        add(capturedPiecesScroll, BorderLayout.CENTER);

        // Shuffle and Wands Buttons
        JPanel shuffleWandsPanel = new JPanel();
        shuffleWandsPanel.setLayout(new BoxLayout(shuffleWandsPanel, BoxLayout.X_AXIS));
        shuffleWandsPanel.setOpaque(false);

        shuffleButton = new JButton("Shuffle");
        wandsButton = new JButton("Wands");

        shuffleWandsPanel.add(shuffleButton);
        shuffleWandsPanel.add(wandsButton);

        add(shuffleWandsPanel, BorderLayout.CENTER);

        // Chat Box at the bottom
        chatBoxArea = new JTextArea(4, 20);
        chatBoxArea.setWrapStyleWord(true);
        chatBoxArea.setLineWrap(true);
        chatBoxArea.setEditable(false);
        chatBoxArea.setFont(new Font("Arial", Font.PLAIN, 12));

        JScrollPane chatScrollPane = new JScrollPane(chatBoxArea);
        chatScrollPane.setPreferredSize(new Dimension(200, 60));

        add(chatScrollPane, BorderLayout.SOUTH);
    }

    // Method to add players
    public void addPlayer(String playerName, Color playerColor) {
        players.put(playerName, playerColor);
        updatePlayerNamesDisplay();
    }

    // Update the display of player names
    private void updatePlayerNamesDisplay() {
        // Clear the current player names
        JPanel playerNamesPanel = (JPanel) getComponent(1);
        playerNamesPanel.removeAll();

        // Add all players to the panel
        for (Map.Entry<String, Color> entry : players.entrySet()) {
            JLabel nameLabel = new JLabel(entry.getKey());
            nameLabel.setForeground(entry.getValue());
            nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
            playerNamesPanel.add(nameLabel);
        }

        playerNamesPanel.revalidate();
        playerNamesPanel.repaint();
    }

    // Method to update chat box
    public void updateChatBox(String message, Color playerColor) {
        chatBoxArea.append(message + "\n");
        chatBoxArea.setForeground(playerColor);
    }
}
