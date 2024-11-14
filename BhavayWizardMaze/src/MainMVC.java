import java.util.Locale;

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
		Locale locale = new Locale.Builder().setLanguage("zh").setRegion("CN").build();
System.out.println(locale);
    	ViewWizardMazeUI theMainView = new ViewWizardMazeUI(theModel,locale);
//    	ViewMazeStructure theView = new ViewMazeStructure();
        ControllerSingleDevice theController = new ControllerSingleDevice(theModel, theMainView);
        
        theController.start();
        
    }
    
}