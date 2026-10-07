Wizard’s Maze
Wizard’s Maze is a Java-based desktop game inspired by classic maze and strategy gameplay. The project was developed using Java Swing and follows the Model-View-Controller (MVC) design pattern to separate the game logic, user interface, and interaction handling. The game is designed for multiple players and includes a maze board, turn-based movement, tile rotation, scoring, and collectible game pieces.

Project Overview
This project simulates a wizard-themed maze where players move through a dynamically generated board, collect components, and complete game objectives. The application includes:

A multi-player game model
Randomized maze generation
Player state and turn management
Image-based maze tiles and wizard pieces
Side-panel gameplay controls
Menu-driven actions such as save, reload, language switching, and network setup
Support for English and Chinese through localization files
Technologies Used
Java
Swing / AWT 
MVC architecture
ResourceBundle for localization
Java batch scripting for compile and run automation
Image assets for game tiles and player components
Features
Random maze generation using predefined tile patterns
Multiple player support with unique player identities and colors
Recipe and collectible item tracking
Tile rotation and spare-tile management
Maze shifting mechanics using border arrow actions
GUI-based interaction through a desktop application
Internationalization support with multiple language resources
Multiplayer-ready network menu options for host/connect/disconnect

Architecture
The project is structured into separate Java classes to keep responsibilities organized:

ModelMainGame: manages maze generation, player logic, turn flow, and game state
ModelPlayer: stores player attributes, score, recipe, and position
ViewWizardMazeUI: creates the main window, menus, and overall UI
ViewMazeStructure: handles displaying maze tiles and game objects
ViewSidePanel: manages the side UI for player information and controls
ControllerSingleDevice: connects user actions to the model and updates the view
This separation reflects a clean MVC architecture and makes the project easier to extend.

Multiplayer and Networking
The application includes menu actions for hosting and connecting to a game session, which shows the project’s intention to evolve into a networked multiplayer experience. Although the networking layer is not fully implemented yet, the architecture is prepared for future socket-based communication and client-server gameplay.

Build and Run
The project includes a Windows batch script for compiling the Java source, generating the JAR file, creating Javadocs, and launching the application. This simplifies project execution and demonstrates standard Java application workflow practices.

Purpose
This project was created to demonstrate:

Java application development
GUI and event-driven programming
game design and state management
object-oriented architecture
preparation for a multiplayer or network-enabled game system
Summary
Wizard’s Maze is a Java game project that showcases skills in software design, UI development, and game logic implementation. It combines a polished desktop interface with a structured model-view-controller architecture and lays the groundwork for future networking and multiplayer enhancements.
