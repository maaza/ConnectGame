/**
 * 
 */
package edu.nyu.pqs.connect4.connectmain;
 
import java.io.BufferedReader;
import java.io.FileReader;
import edu.nyu.pqs.connect4.connectgame.ConnectGame;
import edu.nyu.pqs.connect4.connectgui.ConnectGUI;

/**
 * This the Main Program which creates the connectgame object 
 * and starts the Game 
 * @author malathidharmalingam
 * Version 1.0
 */
public class ConnectMain {

	private int rows_default;
	private int cols_default;
	private int connects_default;
	private int players_default;
	private static String default_file = "defaults.xml";
	
	
  public void start() throws Exception  {  
  	 ConnectGame connect4Game= new ConnectGame.Builder().withrows(this.getRows_default()).withcols(this.getCols_default()).withConnect(this.getConnects_default()).withplayer(this.getPlayers_default()).build();
     ConnectGUI connect4GUI=new ConnectGUI(connect4Game);
     connect4GUI.createNewGame();
  }
 
  /* Loads the default values from the defaults.xml file
   * and its has Getters and Setters to build the Input
   */
  public String[] load(String fileName)
		    throws Exception {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String nextLine = br.readLine();
			String nextLine2 = br.readLine();
			String a[] = nextLine2.split(",");
			return a;
		}
  public static void main(String[] args) throws Exception   {
  	ConnectMain connectstart=new ConnectMain();
  	String a[] = connectstart.load(default_file);
  	int rows;
  	int cols;
  	int connects;
  	int players;
  	try
  	{
  	 rows = Integer.parseInt(a[0]);
     cols = Integer.parseInt(a[1]);
     connects = Integer.parseInt(a[2]);
     players = Integer.parseInt(a[3]);
  	}
  	catch(NumberFormatException e)
  	{
  		 rows = 6;
  	     cols = 7;
  	     connects = 4;
  	     players = 2;
  	}
  	connectstart.setCols_default(cols);
  	connectstart.setRows_default(rows);
  	connectstart.setConnects_default(connects);
  	connectstart.setPlayers_default(players);
  	connectstart.start();
  	
  }
  
  
 	public int getRows_default() {
 		return rows_default;
 	}

 	public void setRows_default(int rows_default) {
 		this.rows_default = rows_default;
 	}

 	public int getCols_default() {
 		return cols_default;
 	}

 	public void setCols_default(int cols_default) {
 		this.cols_default = cols_default;
 	}

 	public int getConnects_default() {
 		return connects_default;
 	}

 	public void setConnects_default(int connects_default) {
 		this.connects_default = connects_default;
 	}

 	public int getPlayers_default() {
 		return players_default;
 	}

 	public void setPlayers_default(int players_default) {
 		this.players_default = players_default;
 	}
 	
}
