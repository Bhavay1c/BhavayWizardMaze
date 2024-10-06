/* Bhavay Garg
 * 041102440
 * Professor - Daniel Cormeir
 * 
 */

/*
 * This is my main class for the wizard maze which will deal with rest of the files and also used to show the splash screen 
 * 
 * 
 */
public class WizardMazeMain {
	public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                WizardMazeUI wui = new WizardMazeUI();
                wui.createAndShowGUI();
            }
        });
    }
	

}
