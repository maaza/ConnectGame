/**
 * 
 */
package edu.nyu.pqs.connect4.connectmain;
import static org.junit.Assert.*;
 
import org.junit.Test;

import edu.nyu.pqs.connect4.connectgame.ConnectGame;
import edu.nyu.pqs.connect4.connectgui.ConnectGUI;
 

/**
 * @author malathidharmalingam
 * Junit Test Case for Main Program
 */
public class ConnectMainTest {
 
	/**
	 *  Test to check if start Method to start Application is working 
	 *  correctly
	 */
	@Test
	public void testConnectMain() throws Exception
	{
	  boolean thrown = false;
	  try {
		  new ConnectMain().start();
		  } catch (NullPointerException e) {
			thrown = true;
		  }
		 assertFalse(thrown);	  
	}  
	
	/**
	 *  While Firing TwoPlayer Method, It starts Successfully
	 *  No, Null Pointer Method
	 */
	@Test
	public void testStartTwoPlayer() throws Exception
	{
	  boolean thrown = false;
	  try {
		  ConnectGame connect4Game= new ConnectGame.Builder().withrows(4).withcols(4).withConnect(4).withplayer(2).build();
		     ConnectGUI connect4GUI=new ConnectGUI(connect4Game);
		     connect4GUI.createNewGame();
		     connect4Game.fireNewGame();
		     connect4Game.fireTwoPlayer();
		  } catch (NullPointerException e) {
			thrown = true;
		  }
		 assertFalse(thrown);	  
	} 
	
	/**
	 *  While removing Listeners , the method id successful
	 *  No, Null Pointer Method
	 */
	@Test
	public void testStart() throws Exception
	{
	  boolean thrown = false;
	  try {
		  ConnectGame connect4Game= new ConnectGame.Builder().withrows(4).withcols(4).withConnect(4).withplayer(2).build();
		     ConnectGUI connect4GUI=new ConnectGUI(connect4Game);
		     connect4GUI.createNewGame();
		     connect4Game.removeConnectGUIListener(connect4GUI);
		  } catch (NullPointerException e) {
			thrown = true;
		  }
		 assertFalse(thrown);	  
	} 
	
	/** The LoadFile Method, reads the File corectly
	 * and gives Number FormatException if the file
	 * contains invalid values for rows , cols
	 */
	@Test
	public void ReadFile()
	{
		boolean thrown = false;
 
			  ConnectMain connectstart=new ConnectMain();
 
			  	try
			  	{
			  	 Integer.parseInt("/");
			  	}
			  	catch(NumberFormatException e)
			  	{
			  		thrown = true;
			  	}
			  	assertTrue(thrown);	
			  	connectstart.setCols_default(7);
			  	connectstart.setRows_default(6);
			  	connectstart.setConnects_default(4);
			  	connectstart.setPlayers_default(2);
		  }
		
 
	 
	 
}
