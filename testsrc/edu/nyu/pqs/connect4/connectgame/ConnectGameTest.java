package edu.nyu.pqs.connect4.connectgame;
import static org.junit.Assert.*;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.nyu.pqs.connect4.connectgui.ConnectGUI;
import edu.nyu.pqs.connect4.connectgui.IConnectGUIListener;
import edu.nyu.pqs.connect4.connectmain.ConnectMain;

/**
 * Junit Testing for ConnectGame
 * @author malathidharmalingam
 *
 */
public class ConnectGameTest {
 

	@Before
	public void testBefore() throws Exception
	{
		 
		 ConnectGame connect4Game= new ConnectGame.Builder().withrows(4).withcols(4).withConnect(4).withplayer(4).build();
	     ConnectGUI connect4GUI=new ConnectGUI(connect4Game);
	     connect4GUI.createNewGame();
	}
 
	/**
	 * This Test checks if addListener is added  successfully
 	*/
	@Test
	public void testaddListener() throws Exception
	{
		 boolean thrown  = false;
		 try
		 {
		 ConnectGame connect4Gameadd= new ConnectGame.Builder().withrows(4).withcols(4).withConnect(4).withplayer(4).build();
	     ConnectGUI connect4GUIadd=new ConnectGUI(connect4Gameadd);
	     connect4GUIadd.createNewGame();
		 }
		 catch(Exception e)
		 {
			 thrown = true;
		 }
		 assertFalse(thrown);
	}
	
	/**
	 * This Test checks if Listener is removed successfully
 	*/
	@Test
	public void testremoveListener() throws Exception
	{
		 ConnectGame connect4Gamerem= new ConnectGame.Builder().withrows(4).withcols(4).withConnect(4).withplayer(4).build();
	     ConnectGUI connect4GUIrem=new ConnectGUI(connect4Gamerem);
	     connect4GUIrem.createNewGame();
	     connect4Gamerem.removeConnectGUIListener(connect4GUIrem);
	     connect4Gamerem.fireNewGame();
	}
	
	/**
	 * This Test checks if Single Player is launched Successfully
 	*/
	@Test
	public void testSinglePlayer() throws Exception
	{
		 ConnectGame connect4Gamesingle= new ConnectGame.Builder().withrows(4).withcols(4).withConnect(4).withplayer(4).build();
	     ConnectGUI connect4GUIsingle=new ConnectGUI(connect4Gamesingle);
	     connect4GUIsingle.createNewGame();
	     connect4Gamesingle.fireNewGame();
	     connect4Gamesingle.fireSinglePlayer();
	}
	

	/**
	 * This Test checks if TwoPlayer Game is launched Successfully
 	*/
	@Test
	public void testTwoPlayer() throws Exception
	{
		 ConnectGame connect4Gametwo= new ConnectGame.Builder().withrows(4).withcols(4).withConnect(4).withplayer(4).build();
	     ConnectGUI connect4GUItwo=new ConnectGUI(connect4Gametwo);
	     connect4GUItwo.createNewGame();
	     connect4Gametwo.fireNewGame();
	     connect4Gametwo.fireTwoPlayer();
	}
	
	/**Test if the Game is Won , To Test this, Please
	 * make connectboard public
	 */
	@Test
	public void testGameWon() throws Exception
	{
		 ConnectGame connect4Game1= new ConnectGame.Builder().withrows(4).withcols(4).withConnect(4).withplayer(2).build();
	     ConnectGUI connect4GUI1=new ConnectGUI(connect4Game1);
	     connect4GUI1.createNewGame();
	     connect4Game1.resetGame();
	     connect4Game1.connectboard[0][0] =0;
	     connect4Game1.connectboard[1][0] =0;
	     connect4Game1.connectboard[2][0] =0;
	     connect4Game1.connectboard[3][0] =0;
	     System.out.println(connect4Game1.hasWon());
	     assertTrue(connect4Game1.hasWon());
	}
	
	/**Test if the Reset Method is working correctly
	 */
	@Test
	public void testReset() throws Exception
	{
		 ConnectGame connect4Gamereset= new ConnectGame.Builder().withrows(4).withcols(4).withConnect(4).withplayer(2).build();
	     ConnectGUI connect4GUIreset=new ConnectGUI(connect4Gamereset);
	     connect4GUIreset.createNewGame();
	     connect4Gamereset.resetGame();
	     System.out.println(connect4Gamereset.hasWon());
	     assertFalse(connect4Gamereset.hasWon());
	}
	
	/** Test to Check if Column is Empty to Fill the Disc
	 */
	@Test
	public void isColumnEmpty() throws Exception
	{
		 ConnectGame connect4Gamecol= new ConnectGame.Builder().withrows(4).withcols(4).withConnect(4).withplayer(2).build();
	     ConnectGUI connect4GUIcol=new ConnectGUI(connect4Gamecol);
	     connect4GUIcol.createNewGame();
	     connect4Gamecol.resetGame();
	     assertTrue(connect4Gamecol.isColumnEmpty(1));
	}
	
	
	/** Another Test Case to Check if Column is Empty to Fill the Disc
	 */
	@Test
	public void isColumnEmpty1() throws Exception
	{
		 ConnectGame connect4Gamecol1= new ConnectGame.Builder().withrows(4).withcols(4).withConnect(4).withplayer(2).build();
	     ConnectGUI connect4GUIcol1=new ConnectGUI(connect4Gamecol1);
	     connect4GUIcol1.createNewGame();
	     connect4Gamecol1.resetGame();
	     connect4Gamecol1.connectboard[0][0] =0;
	     connect4Gamecol1.connectboard[1][0] =0;
	     connect4Gamecol1.connectboard[2][0] =0;
	     connect4Gamecol1.connectboard[3][0] =0;
	     assertFalse(connect4Gamecol1.isColumnEmpty(0));
	}
	
	/**  Test Case to check for Winning
	 */
	@Test
	public void HasWon() throws Exception
	{
		 ConnectGame connect4GameSingle= new ConnectGame.Builder().withrows(4).withcols(4).withConnect(4).withplayer(2).build();
	     ConnectGUI connect4GUIcolSingle=new ConnectGUI(connect4GameSingle);
	     connect4GUIcolSingle.createNewGame();
	     connect4GameSingle.resetGame();
	     connect4GameSingle.connectboard[0][0] =0;
	     connect4GameSingle.connectboard[1][0] =0;
	     connect4GameSingle.connectboard[2][0] =0;
	     connect4GameSingle.connectboard[3][0] =0;
	     assertTrue(connect4GameSingle.hasWon());
	}
	
	/**  Test Case to check Method which Wins by Setting Move
	 */
	@Test
	public void HasWonSetMove() throws Exception
	{
		 ConnectGame connect4GamesetMove= new ConnectGame.Builder().withrows(4).withcols(4).withConnect(4).withplayer(2).build();
	     ConnectGUI connect4GUIsetMove=new ConnectGUI(connect4GamesetMove);
	     connect4GUIsetMove.createNewGame();
	     connect4GamesetMove.resetGame();
	     connect4GamesetMove.connectboard[0][0] =0;
	     connect4GamesetMove.connectboard[1][0] =0;
	     connect4GamesetMove.connectboard[2][0] =0;
	     connect4GamesetMove.setMove(3, 0);
	    // assertTrue(connect4GamesetMove.hasWon());
	}
	
	/**
	 * Test to if There is a win due to Diagonal
	 */
	public void HasWonDiag() throws Exception
	{
		 ConnectGame connect4GameDiag= new ConnectGame.Builder().withrows(4).withcols(4).withConnect(4).withplayer(2).build();
	     ConnectGUI connect4GUIDiag=new ConnectGUI(connect4GameDiag);
	     connect4GUIDiag.createNewGame();
	     connect4GameDiag.resetGame();
	     connect4GameDiag.connectboard[0][0] =0;
	     connect4GameDiag.connectboard[1][1] =0;
	     connect4GameDiag.connectboard[2][2] =0;
	     connect4GameDiag.connectboard[3][3] =0;
	     assertTrue(connect4GameDiag.hasWon());
	}
	
	/**
	 * To Test if the Board is Full
	 */
	@Test
	public void isBoardFull() throws Exception
	{
		 ConnectGame connect4GameDiag1= new ConnectGame.Builder().withrows(4).withcols(4).withConnect(4).withplayer(2).build();
	     ConnectGUI connect4GUIDiag1=new ConnectGUI(connect4GameDiag1);
	     connect4GUIDiag1.createNewGame();
	     connect4GameDiag1.resetGame();
	     connect4GameDiag1.connectboard[0][0] =0;
	     connect4GameDiag1.connectboard[0][1] =1;
	     connect4GameDiag1.connectboard[0][2] =0;
	     connect4GameDiag1.connectboard[0][3] =1;
	     connect4GameDiag1.connectboard[1][0] =0;
	     connect4GameDiag1.connectboard[1][1] =1;
	     connect4GameDiag1.connectboard[1][2] =0;
	     connect4GameDiag1.connectboard[1][3] =1;
	     connect4GameDiag1.connectboard[2][0] =0;
	     connect4GameDiag1.connectboard[2][1] =1;
	     connect4GameDiag1.connectboard[2][2] =0;
	     connect4GameDiag1.connectboard[2][3] =1;
	     connect4GameDiag1.connectboard[3][0] =0;
	     connect4GameDiag1.connectboard[3][1] =1;
	     connect4GameDiag1.connectboard[3][2] =0;
	     connect4GameDiag1.connectboard[3][3] =1;
	     assertTrue(connect4GameDiag1.isBoardFull());
	}
	
	/**
	 * To Test if the Board is not Full
	 */
	@Test
	public void isBoardFullnot() throws Exception
	{
		 ConnectGame connect4GameFull= new ConnectGame.Builder().withrows(4).withcols(4).withConnect(4).withplayer(2).build();
	     ConnectGUI connect4GUIFull=new ConnectGUI(connect4GameFull);
	     connect4GUIFull.createNewGame();
	     connect4GameFull.resetGame();
	     connect4GameFull.connectboard[0][0] =0;
	     connect4GameFull.connectboard[0][1] =1;
	     connect4GameFull.connectboard[0][2] =0;
	      
	     assertFalse(connect4GameFull.isBoardFull());
	}
	
	/**
	 * Test to set a Particular Column
	 */	
	@Test
	public void SetColumnTest() throws Exception
	{
		 ConnectGame connect4GameFull= new ConnectGame.Builder().withrows(4).withcols(4).withConnect(4).withplayer(2).build();
	     ConnectGUI connect4GUIFull=new ConnectGUI(connect4GameFull);
	     connect4GUIFull.createNewGame();
	     connect4GameFull.resetGame();
	     connect4GameFull.setMove(0,0);    
	}
	
	/**
	 * Test to set Move making BoardFull	
	 */
	@Test
	public void SetColumnFullBoardTest() throws Exception
	{
		 ConnectGame connect4GameFull1= new ConnectGame.Builder().withrows(4).withcols(4).withConnect(4).withplayer(2).build();
	     ConnectGUI connect4GUIFull1=new ConnectGUI(connect4GameFull1);
	     connect4GUIFull1.createNewGame();
	     connect4GameFull1.resetGame();
	 
	     connect4GameFull1.connectboard[0][1] =1;
	     connect4GameFull1.connectboard[0][2] =0;
	     connect4GameFull1.connectboard[0][3] =1;
	     connect4GameFull1.connectboard[1][0] =0;
	     connect4GameFull1.connectboard[1][1] =1;
	     connect4GameFull1.connectboard[1][2] =0;
	     connect4GameFull1.connectboard[1][3] =1;
	     connect4GameFull1.connectboard[2][0] =0;
	     connect4GameFull1.connectboard[2][1] =1;
	     connect4GameFull1.connectboard[2][2] =0;
	     connect4GameFull1.connectboard[2][3] =1;
	     connect4GameFull1.connectboard[3][0] =0;
	     connect4GameFull1.connectboard[3][1] =1;
	     connect4GameFull1.connectboard[3][2] =0;
	     connect4GameFull1.connectboard[3][3] =1;
	     connect4GameFull1.setCurrentPlayer(0);
	     connect4GameFull1.setMove(0,0);
	     assertFalse(connect4GameFull1.isBoardFull());
	     
	}
	
	/**
	 * Test to Start Application
	 * @throws Exception
	 */
	@Test
	public void testStart() throws Exception
	{
	  boolean thrown = false;
	  try {
		  new ConnectMain().start();
		  } catch (NullPointerException e) {
			thrown = true;
		  }
		 assertFalse(thrown);	  
	}  
}
