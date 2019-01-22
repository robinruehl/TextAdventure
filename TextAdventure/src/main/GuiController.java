package main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
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
    
    @FXML
    private Button ability1;
    
    @FXML
    private Button ability2;
    
    @FXML
    private Label YHP;
    
    @FXML
    private ProgressBar YHPP;
    
    @FXML
    private Label EHP;
    
    @FXML
    private ProgressBar EHPP;
    
    
    
    @FXML
    private TextField maxHealthPoints;
    
    @FXML
    private TextField maxHealthValue;
    
    @FXML
    private Button increaseMaxHealth;
    
    @FXML
    private TextField attackPoints;
    
    @FXML
    private TextField attackValue;
    
    @FXML
    private Button increaseAttack;
    
  
    @FXML
    private TextField intelligencePoints;
    
    @FXML
    private TextField intelligenceValue;
    
    @FXML
    private Button increaseIntelligence;
    
    @FXML
    private TextField luckPoints;
    
    @FXML
    private TextField luckValue;
    
    @FXML
    private Button increaseLuck;
    
    @FXML 
    private TextField skillPoints;
    
    @FXML
    private TextField level;
    
    public boolean inHand = false;
	public void initialize() {
		game = new Game(this);
		for (int i=1 ; i<=4 ; i++) {
			for (int  p=1 ; p<=10 ; p++) {
			InventarButton button = new InventarButton();
			button.setPrefHeight(40);
			button.setPrefWidth(40);
			button.setButtonID((i-1)*10+p-1);
			inventoryPane.add(button , p , i);
			button.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					if (inHand) {
						System.out.println("Ich bin Button " + ((InventarButton)event.getSource()).getButtonID());
						inHand = false;
				}else {
					System.out.println("hund");
					inHand = true;
				}
				
				}});	
			button.setOnTouchMoved(null);
			}
		}
		skillPoints.setText(game.getPlayer().getPerkpoints()+"");
		maxHealthPoints.setText(game.getPlayer().getMaxHealth()+"");
		attackPoints.setText(game.getPlayer().getAttackDamage()+"");
		intelligencePoints.setText(game.getPlayer().getIntelligence()+"");
		luckPoints.setText(game.getPlayer().getLuck()+"");
		ability1.setText(game.getFights().getAbillity1().getName()+"");
		ability2.setText(game.getFights().getAbillity2().getName()+"");
		YHP.setText(game.getPlayer().getHealth()+"");
		YHPP.setProgress(game.getPlayer().getHealth()/game.getPlayer().getMaxHealth());


	}
		

	
	public void setDiscription(Room room) {
		consoleWrite(room.getDescprition());
	}
	
	public void goEast() {
		game.getLabyrinth().changeRoom(game.getLabyrinth().getCurrentRoom().getEastRoom());
		game.getFights().Fight();
	}
	
	public void goSouth() {
		game.getLabyrinth().changeRoom(game.getLabyrinth().getCurrentRoom().getSouthRoom());
		game.getFights().Fight();
	}
	
	public void goWest() { 
		game.getLabyrinth().changeRoom(game.getLabyrinth().getCurrentRoom().getWestRoom());
		game.getFights().Fight();

	}
	
	public void goNorth() {
		game.getLabyrinth().changeRoom(game.getLabyrinth().getCurrentRoom().getNorthRoom());
		game.getFights().Fight();

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
			game.inputHandler(inputTXT);	  //und leiten ihn zum (sehr billigen, nicht genuzten)Handler weiter.
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
	
	
	public void increaseMaxHealth() {
		game.getPlayer().getSkills().skillincr(1, game.getPlayer());
		maxHealthPoints.setText(game.getPlayer().getMaxHealth()+"");
		skillPoints.setText(game.getPlayer().getPerkpoints()+"");
		
	}
	
	public void increaseAttack() {
		game.getPlayer().getSkills().skillincr(2, game.getPlayer());
		attackPoints.setText(game.getPlayer().getAttackDamage()+"");
		skillPoints.setText(game.getPlayer().getPerkpoints()+"");
	}
	

	public void increaseIntelligence() {
		game.getPlayer().getSkills().skillincr(4, game.getPlayer());
		intelligencePoints.setText(game.getPlayer().getIntelligence()+"");
		skillPoints.setText(game.getPlayer().getPerkpoints()+"");
	}
	
	public void increaseLuck() {
		game.getPlayer().getSkills().skillincr(3 , game.getPlayer());
		luckPoints.setText(game.getPlayer().getLuck()+"");
		skillPoints.setText(game.getPlayer().getPerkpoints()+"");
	}
	
	public void Abillity1() {
		if(game.getFights().isYourTurn()) {
		game.getFights().attack1();
		YHP.setText(game.getPlayer().getHealth()+"");
		YHPP.setProgress(game.getPlayer().getHealth()/game.getPlayer().getMaxHealth());
		//EHP.setText(game.getFights().getE);
		}
		
	}
	public void Abillity2() {
		game.getFights().attack2();
		YHP.setText(game.getPlayer().getHealth()+"");
		YHPP.setProgress(game.getPlayer().getHealth()/game.getPlayer().getMaxHealth());
		
	}
}

