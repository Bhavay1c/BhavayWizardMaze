
public class MainMVC {
    
	/**
	 * Default (empty) constructor.
	 */
	public MainMVC() {
		; // No commands
	}
	
	/**
	 * Main method.
	 * @param args Command line.
	 */
    public static void main(String args[]) {
    	 
    	ModelMainGame theModel = new ModelMainGame(null);
    	ViewWizardMazeUI theMainView = new ViewWizardMazeUI(theModel);
//    	ViewMazeStructure theView = new ViewMazeStructure();
        ControllerSingleDevice theController = new ControllerSingleDevice(theModel, theMainView);
        
        theController.start();
        
    }
    
}