package edu.nyu.pqs.connect4.connectgui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import edu.nyu.pqs.connect4.connectgame.ConnectGame;
import edu.nyu.pqs.connect4.playerfactory.ConnectPlayer;
import edu.nyu.pqs.connect4.playerfactory.ConnectPlayerFactory;
import edu.nyu.pqs.connect4.playerfactory.IConnectPlayer;

/**
 * This is the Class for the GUI and it uses the Observer Pattern
 * it uses a MenuBar to access the Items, The Default is set to 
 * Single Player and 6*7 (Beginner Level). The User can also
 * change the Board Setting.
 * Implemets Interface IConnectGUIListener
 * 
 * @author malathidharmalingam
 * Version 1.0
 */
public class ConnectGUI implements IConnectGUIListener{

	private JFrame frame;  
	private JPanel Board; 
	private JPanel BoardNumbers; 
	//Slots contains the Individual Discs
	private JLabel[][] slots; 
	private JPanel ConnectBoard;  
	//Button on top of the Board, Help in Inserting Discs
	private JButton[] ButtonCols; 
	private ConnectGame connectGame; 
	private int rows; 
	private int cols; 
	private static int rows_default=6;
	private static int cols_default=7;
	private IConnectPlayer  player1;
	private IConnectPlayer  player2;
	//The Default File for rows,cols,player,connect, and the
	//Images for the Board
	private String ImageFile ="defaults.xml";
	private static String  slots_color;
	private static String player1_color;
	private static String player2_color;

	//ConnectGUI constructorm, adds Listeneer
	public ConnectGUI(ConnectGame connectGame) throws Exception{
		this.connectGame=connectGame;
		connectGame.addConnectGUIListener(this);
		rows=connectGame.getRows();
		if(rows < 4)
		{
			rows=rows_default;
		}
		cols=connectGame.getColumns();
		if(cols < 4)
		{
			cols=cols_default;
		}
		load(ImageFile);
	}

	public void BoardFull(){
		JOptionPane.showMessageDialog(null,"Board is Full. No Winners , Game Drawn.");
		resetGame();
	}

	/** JPanel to add the slots to the Panel
	 * and create the Board
	 */
	private JPanel createConnect4Board(){
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(rows,cols));
		panel.setBackground(Color.BLUE);
		slots = new JLabel[rows][cols];
		ImageIcon sloticon = new ImageIcon(slots_color);
		for (int row=0; row<rows; row++) {
			for (int column=0; column<cols; column++) {
				slots[row][column]=new JLabel(sloticon);
				slots[row][column].setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(slots[row][column]);
			}
		}
		return panel;
	}

	/** Enable the Buttons on top of Button Panel Board
	 */
	private void enableNumberButtons(){
		for(int i=0;i<ButtonCols.length;i++){
			ButtonCols[i].setEnabled(true);
		}
	}

	/** Create the Panel Buttons on top of Board
	 */
	private JPanel createPanelBoardNumbers(){
		JPanel BoardNumbers = new JPanel();
		BoardNumbers.setLayout(new GridLayout(1,cols, 4, 4));
		ButtonCols=new JButton[cols];
		for(int i=0;i<cols;i++){
			ButtonCols[i]=new JButton((i+1)+"");
			ButtonCols[i].setEnabled(false);
			BoardNumbers.add(ButtonCols[i]);
		}
		addListener();
		return BoardNumbers;
	}

	/** setNextMovePlay will add different color disc depending
	 * on player
	 */
	public void setNextMovePlay(int row,int col,int currentPlayer){
		if(currentPlayer==1){
			slots[row][col].setIcon(new ImageIcon(player2_color));
		}
		else{
			slots[row][col].setIcon(new ImageIcon(player1_color));
		}
	}

	/** Creates the Board with the Sepcifications as Below
	 * Default Fires a Single Player Method
	 */
	public void createNewGame(){
		if (frame != null) frame.dispose();
		frame = new JFrame("Connect Four");
		frame.setBounds(100, 100, 400, 300);
		Board = createConnect4Board();
		frame.setJMenuBar(createMenuBar());
		ConnectBoard=new JPanel();
		ConnectBoard.setLayout(new BorderLayout());
		frame.getContentPane().add(ConnectBoard,BorderLayout.CENTER);
		BoardNumbers=createPanelBoardNumbers();
		ConnectBoard.add(BoardNumbers,BorderLayout.NORTH);
		ConnectBoard.add(Board,BorderLayout.CENTER);
		BoardNumbers.setEnabled(false);
		Board.setEnabled(false);
		frame.setSize(700,600);
		frame.setVisible(true);
		connectGame.fireNewGame();
		connectGame.fireSinglePlayer();
	}

	/** Resets the Game 
	 */
	private void resetGame(){ 
		ConnectBoard.remove(Board);
		Board = createConnect4Board();
		ConnectBoard.add(Board,BorderLayout.CENTER);
		frame.getContentPane().add(ConnectBoard,BorderLayout.CENTER);
		frame.setVisible(true);
		connectGame.resetGame();
	}

	/** Creates the Board with default 6*7
	 * Default Fires a Single Player Method
	 */
	private void resetGameBeginner(){
		connectGame.setRows(rows_default);
		connectGame.resetGame();
		connectGame.setCols(cols_default);
		connectGame.resetGame();
		connectGame.fireBoardSettingEvent();
		connectGame.fireSinglePlayer();
	}

	/** 
	 * Message about the Winner is displayed on the Screen 
	 * if the User Wins
	 */
	public void Won(){
		if(connectGame.getCurrentPlayer()==player2.getPlayerNumber()%connectGame.getPlayers() && player2.getPlayerType()==ConnectPlayer.Computer){
			JOptionPane.showMessageDialog(null,"Computer wins.Congratulations!!!");
		}
		else{
			JOptionPane.showMessageDialog(null,"Player "+(connectGame.getCurrentPlayer()+1)+" wins.Congratulations!!!");
		}
		NewGame();
	}

	/** 
	 * add the Listener
	 */
	private void addListener(){
		ConnectFourListener listener=new ConnectFourListener();
		for(int i=0;i<cols;i++){
			ButtonCols[i].addActionListener(listener);   
		}
	}

	/** 
	 * Starts a NewGame
	 */
	public void NewGame(){
		resetGame();   
		BoardNumbers.setEnabled(true);
		Board.setEnabled(true);
		connectGame.fireSinglePlayer();
	}
	/** 
	 * SinglePlayerMode Method, Creates 2 Players one Human and the Computer
	 */
	public void SinglePlayermode(){
		ConnectPlayerFactory playerFactory=ConnectPlayerFactory.getConnectPlayerFactory();
		player1=playerFactory.createPlayer(ConnectPlayer.Human, connectGame);
		player2=playerFactory.createPlayer(ConnectPlayer.Computer, connectGame);
		enableNumberButtons();
	}

	/** 
	 * SinglePlayerMode Method, Creates 2 Players  Human versus Human
	 */
	public void TwoPlayermode(){
		ConnectPlayerFactory playerFactory=ConnectPlayerFactory.getConnectPlayerFactory();
		player1=playerFactory.createPlayer(ConnectPlayer.Human, connectGame);
		player2=playerFactory.createPlayer(ConnectPlayer.Human, connectGame);    
		enableNumberButtons();
	}

	public void BoardSetting(){
		createNewGame();
	}

	class ConnectFourListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton)e.getSource();
			int column= Integer.parseInt(button.getText())-1;
			player1.setNextMove(column,0);
		}
	}

	/**
	 * Calls the next move of Computer in single player mode  
	 */
	public void NextMove(){
		if(connectGame.getCurrentPlayer()==1 && player2.getPlayerType()==ConnectPlayer.Computer){
			int column=(int)(Math.random()*connectGame.getColumns());
			while(!connectGame.isColumnEmpty(column)){
				column=(int)(Math.random()*connectGame.getColumns()); 
			}
			player2.setNextMove(column,1); 
		}
	}

	/* Creates the MenuBar for the Application, the Choose Number 
	 * of Player and Bord Settings
	 */
	public JMenuBar createMenuBar() {
		JMenuBar menuBar;
		JMenu menu,menu1 ; 
		JMenuItem menuItem;
		JRadioButtonMenuItem rItem, rItem1,rItem2,rItem3,
		rbmenuitemabout,buttonquit;
		menuBar = new JMenuBar();
		menu = new JMenu("Game");
		menu.setMnemonic(KeyEvent.VK_A);
		menuBar.add(menu);
		menuItem = new JMenuItem("New Game", KeyEvent.VK_T);
		menu.add(menuItem);
		menuItem.addActionListener(new ActionListener(){		  
			@Override
			public void actionPerformed(ActionEvent arg0) {
				connectGame.fireNewGame();
				connectGame.fireSinglePlayer();	
			}
		});
		menu.addSeparator();
		ButtonGroup group = new ButtonGroup();
		rItem = new JRadioButtonMenuItem("Beginner (6 * 7)");   
		rItem.setMnemonic(KeyEvent.VK_R);
		group.add(rItem);
		menu.add(rItem);
		rItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				connectGame.setRows(rows_default);
				connectGame.resetGame();
				connectGame.setCols(cols_default);
				connectGame.resetGame();
				connectGame.fireBoardSettingEvent();
				connectGame.fireSinglePlayer();
			}
		});

		ButtonGroup group2 = new ButtonGroup();
		rItem1 = new JRadioButtonMenuItem("Custom");
		rItem1.setMnemonic(KeyEvent.VK_O);
		group2.add(rItem1);
		menu.add(rItem1);
		rItem1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				checkcustomrow();
				checkcustomcol() ;  
				connectGame.fireBoardSettingEvent();
				connectGame.fireSinglePlayer();
			}
		});

		menu.addSeparator();
		//a group of check box menu items
		ButtonGroup group1 = new ButtonGroup();
		rItem2 = new JRadioButtonMenuItem("Single Player");
		rItem2.setSelected(true);
		rItem2.setMnemonic(KeyEvent.VK_A);
		group1.add(rItem2);
		menu.add(rItem2);

		rItem2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				connectGame.fireNewGame();
				connectGame.fireSinglePlayer();

			}
		});

		//If TwoPlayer then it fires the Method for Human versus Human
		//Player
		rItem3 = new JRadioButtonMenuItem("Two Player");
		rItem3.setMnemonic(KeyEvent.VK_B);
		group1.add(rItem3);
		menu.add(rItem3);

		rItem3.addActionListener(new ActionListener(){
			@Override

			public void actionPerformed(ActionEvent arg0) {
				connectGame.fireNewGame();
				connectGame.fireTwoPlayer();
			}
		});
		menu.addSeparator();      
		ButtonGroup groupexit = new ButtonGroup();
		buttonquit = new JRadioButtonMenuItem("Exit");
		buttonquit.setMnemonic(KeyEvent.VK_B);
		groupexit.add(buttonquit);
		menu.add(buttonquit);

		buttonquit.addActionListener(new ActionListener(){
			@Override

			public void actionPerformed(ActionEvent arg0) {
				boolean alreadyDisposed = false;
				if (frame.isDisplayable()) {
					alreadyDisposed = true;
					frame.dispose();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			}
		});  
		menu1 = new JMenu("About");
		menu1.setMnemonic(KeyEvent.VK_S);
		menuBar.add(menu1);
		ButtonGroup groupabout = new ButtonGroup();
		rbmenuitemabout = new JRadioButtonMenuItem("Instruction");
		rbmenuitemabout.setMnemonic(KeyEvent.VK_A);
		groupabout.add(rbmenuitemabout);
		menu1.add(rbmenuitemabout);
		rbmenuitemabout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,
						"Connect Four is a Two Player Game. \n" +
								"The Player take turns dropping colored discs from the top of the Grid\n" +
								"The pieces fall straight down, occupying the next available \n"
								+"space within the column.\n" +
								"The object of the game is to connect four of\n" 
								+"one's own discs of the same color next to each other vertically,\n" +
						"horizontally, or diagonally before your opponent"); 
			}
		});
		return menuBar;
	}

	/**Check for customrow or customcol, If the User enters 
	 * a row or col value less than 4 , it will
	 * reset to default of 6*7 level
	 */
	public void checkcustomrow()
	{
		String srows=JOptionPane.showInputDialog("Enter the number of rows");
		if(!srows.equals("")){
			try
			{
				rows=Integer.parseInt(srows);
				connectGame.setRows(rows);
				connectGame.resetGame();

			}
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null,"Please enter valid row value");
				resetGameBeginner();
				throw new IllegalStateException("Rows should be larger than 4");
			}
			if(rows < 4)
			{
				JOptionPane.showMessageDialog(null,"Rows cannot be less than 4");
				resetGameBeginner();
				connectGame.resetGame();
				throw new IllegalStateException("Rows should be larger than 4");
			}

		}
	}

	public void checkcustomcol()
	{
		String scols=JOptionPane.showInputDialog("Enter the number of columns");
		if(!scols.equals("")){
			try
			{
				cols=Integer.parseInt(scols);
				connectGame.setCols(cols);
				connectGame.resetGame();
			}
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null,"Please enter valid Col value");
				resetGameBeginner();
				throw new IllegalStateException("Rows should be larger than 4");
			}
			if(cols < 4)
			{
				JOptionPane.showMessageDialog(null,"Columns cannot be less than 4");
				resetGameBeginner();
				connectGame.resetGame();
				throw new IllegalStateException("Cols should be larger than 4");
			}      	
		}
	}

	/* Loads Default Location of the Images for Slots */
	public static final void load(String fileName)
			throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String nextLine = br.readLine();
		String nextLine2 = br.readLine();
		String a[] = nextLine2.split(",");
		slots_color = a[4];
		player1_color = a[5];
		player2_color = a[6];
	}
}

