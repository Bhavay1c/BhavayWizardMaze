import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;

/**
 * The ControllerSingleDevice class serves as the main entry point for the Wizard's Maze game application.
 * It initializes the user interface by creating an instance of ViewWizardMazeUI and sets up action listeners
 * to handle button events for the game controls (e.g., Start, Reset, Exit).
 * 
 * This controller ensures all UI interactions are handled appropriately to facilitate user actions.
 * 
 * Note: This version does not implement a splash screen, but it can be added in the future if required.
 * 
 * @author Bhavay
 * @studentID 041102440
 * @professor Daniel Cormeir
 */
public class ControllerSingleDevice {
    private ViewWizardMazeUI view;
    private ModelMainGame model = new ModelMainGame(null);
    private int []clickTileCordinates = new int[2];
    public ControllerSingleDevice(ModelMainGame theModel, ViewWizardMazeUI theMainView) {
    	
    	this.model = theModel;
    	this.view = theMainView;
    	model.setViewMazeStructure(view.getViewMazeStructure());
		// TODO Auto-generated constructor stub
	}

	/**
     * The main method that serves as the application's entry point.
     * It initializes the Wizard's Maze UI by creating an instance of ViewWizardMazeUI and setting up event listeners.
     * 
     * @param args Command-line arguments (not used).
     */
   

    /**
     * Initializes the game UI and sets up action listeners for game controls.
     */
    public void start() {
    	   view.getViewMazeStructure().addTileButtonListener(this::handleTileClick);
    }

    private void handleTileClick(int row, int col) {
    	model.tileClicked(row,col);
        System.out.println("Tile clicked at: (" + row + ", " + col + ")");
    }
    
//    public void menuActionEvents() {
//        // File Menu
//        JMenuItem saveItem = view.getSaveItem();
//        JMenuItem reloadItem = view.getReloadItem();
//        saveItem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                handleSaveAction();
//            }
//        });
//        reloadItem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                handleReloadAction();
//            }
//        });
//        // Game Menu
//        JMenuItem newGameItem = view.getNewGameItem();
//        JMenuItem changeNameItem = view.getChangeNameItem();
//        JMenuItem invitePlayerItem = view.getInvitePlayerItem();
//        newGameItem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                handleNewGameAction();
//            }
//        });
//        changeNameItem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                handleChangeNameAction();
//            }
//        });
//        invitePlayerItem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                handleInvitePlayerAction();
//            }
//        });
//
//        // Language Menu
//        JMenuItem englishItem = view.getEnglishItem();
//        JMenuItem chineseItem = view.getChineseItem();
//        englishItem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                handleLanguageChange("English");
//            }
//        });
//        chineseItem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                handleLanguageChange("Chinese");
//            }
//        });
//
//        // Help Menu
//        JMenuItem aboutItem = view.getAboutItem();
//        JMenuItem gameRulesItem = view.getGameRulesItem();
//        aboutItem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                handleAboutAction();
//            }
//        });
//        gameRulesItem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                handleGameRulesAction();
//            }
//        });
//
//        // Network Menu
//        JMenuItem hostItem = view.getHostItem();
//        JMenuItem connectItem = view.getConnectItem();
//        JMenuItem disconnectItem = view.getDisconnectItem();
//        hostItem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                handleHostAction();
//            }
//        });
//        connectItem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                handleConnectAction();
//            }
//        });
//        disconnectItem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                handleDisconnectAction();
//            }
//        });
//    }


       
    

    /**
     * Initializes listeners for all maze tiles.
     */
//    private void initializeTileArrowListeners(ViewMazeStructure vms) {
//        for (int i = 1; i < vms.mazePattern.length; i++) {
//            for (int j = 1; j < vms.mazePattern[i].length; j++) {
//                JButton tileButton = vms.mazePattern[i][j];
//                int row = i;
//                int col = j;
//                
//                if(row==0||row==8||col==0||col==8) {
//                	 if (tileButton != null) {
//                         tileButton.addActionListener(new ActionListener() {
//                             @Override
//                             public void actionPerformed(ActionEvent e) {
//                                 model.shiftMaze(row, col);
//                              
//                             }
//                         });
//                     }
//                } else {
//                	if (tileButton != null) {
//                        tileButton.addActionListener(new ActionListener() {
//                            @Override
//                            public void actionPerformed(ActionEvent e) {
////                            	Jlabel [] = vms.getTreasureWizardLabel(tileButton);
//                                model.onTileClick(row, col);
//                                
////                                vms.getTreasureWizardLabel(tileButton).getIcon();
//                                model.interactWithWizard();
//                                model.interactWithComponent();
//                            }
//                        });
//                    }
//                } // end of else 
//                
//                
//            }
//        }
//    }

    
  

}
