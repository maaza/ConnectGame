package edu.nyu.pqs.connect4.connectgame;
import java.util.ArrayList;
import java.util.List;
import edu.nyu.pqs.connect4.connectgui.IConnectGUIListener;
/**
 * This is the Connect Game for Two Players. Single Player Game is played
 * against Human versus Computer . Two Playered game is Human versus Human
 * The player who makes a four in the row or column or diagonal first wins
 * Programmer uses the Builder Pattern for Inputs
 * 
 * @author malathidharmalingam
 * Version 1.0
 */
public class ConnectGame {

	private int rows;   
	private int cols;
	private int players;
	private int connect;

	//Change visibilty of connectboard for testing
	/**
	 *ConnectBoard contains the values for slots
	 *empty slots are identified by -1.
	 */
	private int connectboard[][]; 
	private int current=0;
	private List<IConnectGUIListener> listeners = new ArrayList<IConnectGUIListener>();  


	//Change Visibilty for ConnectGame constructor to default For Testing

	/** ConnectGame constructor, takes in the four Input Values
	 * and Initializes them.
	 * @param rows
	 * @param cols
	 * @param players
	 * @param connect
	 */
	private ConnectGame(int rows,int cols,int players,int connect){
		this.rows=rows;
		this.cols=cols;
		this.players=players;
		this.connect=connect;
		resetGame();  
	}

	/** Builder Pattern used to send the 4 Inputs Variables
	 * Rows,Cols,Connects and Player
	 */
	public static class Builder{
		private int rows;
		private int cols;
		private int players;
		private int connect;

		public Builder(){}

		public Builder withrows(int rows){
			this.rows=rows;
			return this;
		}
		public Builder withcols(int cols){
			this.cols=cols;
			return this;
		}
		public Builder withplayer(int players){
			this.players=players;
			return this;
		}
		public Builder withConnect(int connect){
			this.connect=connect;
			return this;
		}
		public ConnectGame build(){
			return new ConnectGame(rows,cols,players,connect);
		}
	}

	/**
	 * Sets the no of players in the game
	 * @param n number of players in te game
	 */
	public void setNoOfPlayers(int n){
		players=n;
	}

	/**
	 * @return the no of players
	 */ 
	public int getPlayers(){
		return players;
	}

	/**
	 * @param Sets the rows
	 */
	public void setRows(int rows){
		this.rows=rows; 
	}
	
	/**
	 * @return the no of rows
	 */
	public int getRows(){
		return rows;
	}

	/**
	 * @param Sets the Cols
	 */
	public void setCols(int cols){  
		this.cols=cols;
	}
	
	/**
	 * @return the no of columns 
	 */
	public int getColumns(){
		return cols;
	}

	/**
	 * @param Sets the connects
	 */
	public void setConnect(int connect){
		this.connect=connect;
	}
	
	/**
	 * @return the no of connects 
	 */
	public int getConnect(){
		return connect;
	}

	/**
	 * @param Sets the CurrentPlayer
	 */
	public void setCurrentPlayer(int player){
		this.current=player;
	}
	
	/**
	 * @return the no of players
	 */
	public int getCurrentPlayer(){
		return current;
	}

 
	/** Adds the Listener for the GUI
	 * @param connectFourGUIListener  
	 */
	public void addConnectGUIListener(IConnectGUIListener connectFourGUIListener){
		listeners.add(connectFourGUIListener);
	}

	/** Removes the Listener for the GUI
	 * @param connectFourGUIListener  
	 */
	public void removeConnectGUIListener(IConnectGUIListener connectFourGUIListener){
		listeners.remove(connectFourGUIListener);
	}

	/**
	 * Fires a new game event to all the listeners  
	 */
	public void fireNewGame(){
		for(IConnectGUIListener listener:listeners){
			listener.NewGame();
		}
	}

	/**
	 * Fires a Single Player game event 
	 */
	public void fireSinglePlayer(){
		for(IConnectGUIListener listener:listeners){
			listener.SinglePlayermode();
		}
	}

	/**
	 * Fires a Two Player game event 
	 */
	public void fireTwoPlayer(){
		for(IConnectGUIListener listener:listeners){
			listener.TwoPlayermode();
		}
	}

	/**
	 * Fires a Next Move Event
	 */
	public void fireSetNextMove(int row,int column){
		for(IConnectGUIListener listener:listeners){
			listener.setNextMovePlay(row,column,current);
		}
	}

	/**
	 * Check if the Board is Full, return Boolean value true 
	 * if it is full
	 */
	public boolean isBoardFull(){
		boolean isFull=true;
		for(int row=0;row<rows;row++){
			for(int column=0;column<cols;column++){
				if(connectboard[row][column]==-1){
					isFull=false;
				}
			}
		}
		return isFull;
	}


	/**
	 * Gets the Board values for a particular row and column
	 */
	public int getBoardSlot(int row,int column){
		return connectboard[row][column];
	}

	/**
	 * All the board Elements are set to -1 and
	 * the Game starts from the Beginning
	 */
	public void resetGame(){
		current=0;
		connectboard=new int[rows][cols];
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				connectboard[i][j]=-1;
			}
		}
	}

	/**
	 * Checks if the Column is empty to 
	 * insert the disc
	 */
	public boolean isColumnEmpty(int column){
		for(int row=0;row<rows;row++){
			if(connectboard[row][column]==-1){
				return true;
			}
		}
		return false;
	}

	/**
	 * Setting the Disc to the particular Column
	 */
	public void setMove(int column,int type,int a ){
		if(isColumnEmpty(column)){
			for(int i=rows-1;i>=0;i--){
				if(connectboard[i][column]==-1){   
					setMove(i,column);
					return;
				}
			}
		}

	}

	/**
	 * Temporary Move to check if a HasWon condition 
	 * is fulfilled
	 */
	public void MoveTemp(int row,int column){
		connectboard[row][column]=current;
	}

	/**
	 * setMove is to add the disc to the particular Column
	 */
	public void setMove(int row,int column){
		connectboard[row][column]=current;
		fireSetNextMove(row,column);
		if(hasWon()){
			fireWinEvent();
			return;
		}
		if(isBoardFull()){
			fireBoardFullEvent();
			resetGame();
			fireSinglePlayer();
			return;
		}
		current=(current+1)%getPlayers();
		fireNextPlayerEvent();
	}

	/**
	 * Fires BoardFull Event
	 */
	private void fireBoardFullEvent() {
		for(IConnectGUIListener listener:listeners){
			listener.BoardFull();
		}
	}

	/**
	 * Fires Next Player Event
	 */
	private void fireNextPlayerEvent() {
		for(IConnectGUIListener listener:listeners){
			listener.NextMove();
		}

	}

	/**
	 * Checks if the Player has Won , It Checks Rows,
	 * Columns and Diagonals
	 */
	public boolean hasWon(){
		return (CheckRow() || CheckCol() || CheckDiagN() || CheckDiagS());
	}

	/**
	 * Checks Row for Winning
	 */
	boolean CheckRow(){
		int count=0;
		for(int row=0;row<rows;row++){
			count=0;
			for(int column=0;column<cols;column++){
				if(connectboard[row][column]!=current){
					count=0;
				}
				else{
					count++;
				}
				if(count==getConnect()){

					return true;
				}
			}
		}
		return false;  
	}

	/**
	 * Checks Col for Winning
	 */
	boolean CheckCol(){
		int count=0;
		for(int column=0;column<cols;column++){
			count=0;
			for(int row=0;row<rows;row++){
				if(connectboard[row][column]!=current){
					count=0;
				}
				else{

					count++;
				}
				if(count==getConnect()){
					return true;
				}
			}

		}
		return false;
	}

	/**
	 * Checks Diagonals for Winning
	 */
	boolean CheckDiagN(){
		int count=0;
		for(int row=0;row<(rows-getConnect()+1);row++){
			int rowtemp=row;
			count=0;
			for(int column=cols-1;column>=0 && rowtemp<=rows-1;column--){
				if(connectboard[rowtemp++][column]!=current){
					count=0;
				}
				else{
					count++;
				}
				if(count==getConnect()){
					return true;
				}
			}
		}
		for(int row=getConnect()-1;row<rows;row++){
			int rowtemp=row;
			count=0;
			for(int column=0;column<cols&& rowtemp>=0;column++){
				if(connectboard[rowtemp--][column]!=current){
					count=0;
				}
				else{
					count++;
				}
				if(count==getConnect()){
					return true;
				}  
			} 
		}
		return false;
	}
	/**
	 * Checks Diagonals for Winning
	 */
	boolean CheckDiagS(){
		int count=0;
		for(int column=0;column<(cols-getConnect()+1);column++){
			int coltemp=column;
			count=0;
			for(int row=0;row<rows && coltemp<=cols-1;row++){
				if(connectboard[row][coltemp++]!=current){
					count=0;
				}
				else{
					count++;
				}
				if(count==getConnect()){
					return true;
				}
			}
		}

		for(int column=getConnect()-1;column<cols;column++){
			int coltemp=column;
			count=0;
			for(int row=rows-1;row>=0 && coltemp>=0;row--){
				if(connectboard[row][coltemp--]!=current){
					count=0;
				}
				else{

					count++;
				}
				if(count==getConnect()){
					return true;
				}
			}

		}
		return false;
	}

	/**
	 * Fires BoardSetting Event
	 */
	public void fireBoardSettingEvent() {
		for(IConnectGUIListener listener:listeners){
			listener.BoardSetting();
		}  
	}

	/**
	 * Fires Win Event
	 */
	public void fireWinEvent() {
		for(IConnectGUIListener listener:listeners){
			listener.Won();
		}  
	}
	/**
	 * toString Method
	 */
	public String toString(){
		String returnString="";
		for(int row=0;row<rows;row++){
			for(int column=0;column<cols;column++){
				returnString=returnString+connectboard[row][column];
			}
			returnString=returnString+"\n";
		}
		return returnString;
	}

	/**
	 * @param i
	 * @param j
	 */
	public void resetMove(int i, int j) {
		// TODO Auto-generated method stub
		connectboard[i][j] =-1;
	}
}

