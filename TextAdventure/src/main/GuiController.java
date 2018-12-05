package main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import main.Fights.Fights;
import main.Game.Game;

public class GuiController {
	Game game;
	
	@FXML 
	private GridPane inventoryPane;
	
	

	@FXML
    private AnchorPane main;
	
	@FXML
    private Button buttonNorth;

    @FXML
    private Button buttonEast;

    @FXML
    private Button buttonSouth;

    @FXML
    private Button buttonWest;

    @FXML
    private ScrollPane consoleTextScrollPane;

    @FXML
    private TitledPane ConsolePane;

    @FXML
    private Text consoleText;

    @FXML
    private TextField consoleinp;

    @FXML
    private Button buttonEnter;
	
    private String inputTXT;
	
    private boolean input;
    
    private String consoleTXT;
    
    boolean scrollbarListener = false;
    
	public void initialize() {
		game = new Game(this);
		for (int i=1 ; i<=4 ; i++) {
			for (int  p=1 ; p<=10 ; p++) {
			Button button = new Button();
			inventoryPane.add(button , p , i);
			button.setOnAction(null);	
			}
		}
	}

	
	public void setDiscription(Room room) {
		consoleWrite(room.getDescprition());
	}
	
	public void goEast() {
		game.getLabyrinth().changeRoom(game.getLabyrinth().getCurrentRoom().getEastRoom());
	}
	
	public void goSouth() {
		game.getLabyrinth().changeRoom(game.getLabyrinth().getCurrentRoom().getSouthRoom());
	}
	
	public void goWest() { 
		game.getLabyrinth().changeRoom(game.getLabyrinth().getCurrentRoom().getWestRoom());

	}
	
	public void goNorth() {
		game.getLabyrinth().changeRoom(game.getLabyrinth().getCurrentRoom().getNorthRoom());

	}
	
	public void consoleWrite(String text) {
    	System.out.println(text);
    	//Falls noch nichts geschrieben wurde,
		if (consoleTXT == null) {
			//System.out.println("consoleWrite consoleTXT == null");
			//System.out.println(text);
			if (!scrollbarListener){
				scrollbarListener = true;
				ConsolePane.heightProperty().addListener(
					    (observable, oldValue, newValue) -> {
					        consoleTextScrollPane.setVvalue( 1.0d );
					    }
					);
			}
			consoleTXT = text;
			consoleText.setText(text); // lese ich nur den gegebenen Text aus, da sonst ein Nullpointer Fehler aufkommt
		}
		//sonst
		else{
			//System.out.println("consoleWrite not null");
			//System.out.println(text);
			consoleTXT = consoleTXT + "\n" + text; //den Text zu den vorherigen Text hinzufügen
			consoleText.setText(consoleTXT); //und den Text in der Konsole neu schreiben
			
		}
	}
	
	public void newInput() {
		inputTXT = consoleinp.getText();
		if (inputTXT == null||inputTXT.length()==0) {   //Nur enter drücken soll nichts machen
			input = false;
		}
		else {						  //aber sonst cleared er dieses Inputfeld
			input = true;
			inputTXT = consoleinp.getText();
			consoleinp.setText(null);
			inputHandler(inputTXT);	  //und leiten ihn zum (sehr billigen, nicht genuzten)Handler weiter.
		}
	}

	private void inputHandler(String i)
	{
		//test
		if(i.contains("test"))
		{
			if(i.contains("Fights"))
			{
				Fights f = new Fights(this, game.getLabyrinth().getCurrentRoom());
				f.Fight();
			}
		}
		//fights
		if(i.contains("fight"))
		{
			if(i.contains("attack1"))
			{
				
			}
		}
	}
	
	public Button getButtonEast() {
		return buttonEast;
	}

	public void setButtonEast(Button buttonEast) {
		this.buttonEast = buttonEast;
	}

	public Button getButtonSouth() {
		return buttonSouth;
	}

	public void setButtonSouth(Button buttonSouth) {
		this.buttonSouth = buttonSouth;
	}

	public Button getButtonWest() {
		return buttonWest;
	}

	public void setButtonWest(Button buttonWest) {
		this.buttonWest = buttonWest;
	}

	public Button getButtonNorth() {
		return buttonNorth;
	}

	public void setButtonNorth(Button buttonNorth) {
		this.buttonNorth = buttonNorth;
	}
}
