/**
 * The WizardMazeMain class is the entry point for the Wizard's Maze game application.
 * It initializes the user interface and displays the main game window.
 * This class also handles the splash screen functionality if implemented.
 * 
 * @author Bhavay Garg
 * @studentID 041102440
 * @professor Daniel Cormeir
 */
public class WizardMazeMain {
    /**
     * The main method that serves as the entry point of the application.
     * It creates an instance of WizardMazeUI and invokes the GUI creation on the Event Dispatch Thread.
     * 
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                WizardMazeUI wui = new WizardMazeUI();
                wui.createAndShowGUI();
            }
        });
    }
}
