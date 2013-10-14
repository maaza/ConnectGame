
package edu.nyu.pqs.connect4.connectgui;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

import java.awt.Color;

import org.junit.Test;

import edu.nyu.pqs.connect4.connectgame.ConnectGame;
import edu.nyu.pqs.connect4.connectmain.ConnectMain;
import edu.nyu.pqs.connect4.playerfactory.ConnectPlayer;
import edu.nyu.pqs.connect4.playerfactory.ConnectPlayerFactory;
import edu.nyu.pqs.connect4.playerfactory.IConnectPlayer;

/**
 * Junit Test Case is ConnectGUI
 * @author malathidharmalingam
 */
public class ConnectGUITest {

	/**
	 * Test to see when the Main Application Starts fine
	 */
	@Test
	public void testStart() throws Exception
	{
		boolean thrown = false;
		try {
			ConnectGame connect4Gamestart= new ConnectGame.Builder().withrows(4).withcols(4).withConnect(4).withplayer(2).build();
			ConnectGUI connect4GUIstart=new ConnectGUI(connect4Gamestart);
			connect4GUIstart.createNewGame();
		} catch (NullPointerException e) {
			thrown = true;
		}
		assertFalse(thrown);	  
	} 

	/** 
	 * Test Start Exception when Rows or Cols is less than 4
	 */
	@Test
	public void testStartException() throws Exception
	{
		boolean thrown = false;
		try {
			ConnectGame connect4Game= new ConnectGame.Builder().withrows(2).withcols(4).withConnect(4).withplayer(2).build();
			ConnectGUI connect4GUI=new ConnectGUI(connect4Game);
			connect4GUI.createNewGame();
		} catch (IllegalStateException e) {
			thrown = true;
		}
		assertFalse(thrown);	  
	}  

	/** 
	 * Test to check Exception when row < 4
	 */
	@Test
	public void testBoardSettings() throws Exception
	{
		boolean thrown = false;
		try {
			ConnectGame connect4Game= new ConnectGame.Builder().withrows(4).withcols(4).withConnect(4).withplayer(2).build();
			ConnectGUI connect4GUI=new ConnectGUI(connect4Game);
			connect4GUI.createNewGame();
			connect4GUI.createMenuBar();
			connect4GUI.checkcustomrow();
		} catch (IllegalStateException e) {
			thrown = true;
		}
		assertFalse(thrown);	  
	} 

	/** 
	 * Test to check Exception when col when a Non Numeric Chanaracter is passed
	 * as Input
	 */	 	
	public void testBoardRows() throws Exception
	{
		boolean thrown = false;
		try {
			ConnectGame connect4Game= new ConnectGame.Builder().withrows(4).withcols(4).withConnect(4).withplayer(2).build();
			ConnectGUI connect4GUI=new ConnectGUI(connect4Game);
			connect4GUI.createNewGame();
			connect4GUI.createMenuBar();
			connect4GUI.checkcustomcol();
		} catch (NumberFormatException e) {
			thrown = true;
		}
		assertTrue(thrown);	  
	} 

	/**
	 * Test to SetNextMove on the board and create factory objects
	 * @throws Exception
	 */
	public void testBoardMove() throws Exception
	{
		boolean thrown = false;
		try {
			ConnectGame connect4Game= new ConnectGame.Builder().withrows(4).withcols(4).withConnect(4).withplayer(2).build();
			ConnectGUI connect4GUI=new ConnectGUI(connect4Game);
			connect4GUI.createNewGame();
			connect4GUI.createMenuBar();
			connect4GUI.checkcustomcol();
			IConnectPlayer player1;
			IConnectPlayer player2;

			ConnectPlayerFactory playerFactory=ConnectPlayerFactory.getConnectPlayerFactory();
			player1=playerFactory.createPlayer(ConnectPlayer.Human, connect4Game);
			player2=playerFactory.createPlayer(ConnectPlayer.Computer, connect4Game);

			player1.setNextMove(1,0);
		} catch (NumberFormatException e) {
			thrown = true;
		}
		assertFalse(thrown);	  
	} 

	/**
	 * Test the Method ResetBeginner , Method has to be made to Test
	 * @throws Exception
	 */  
	public void testResetBeginners() throws Exception
	{
		boolean thrown = false;
		try {
			ConnectGame connect4Game= new ConnectGame.Builder().withrows(4).withcols(4).withConnect(4).withplayer(2).build();
			ConnectGUI connect4GUI=new ConnectGUI(connect4Game);
			connect4GUI.createNewGame();
			connect4GUI.createMenuBar();
			connect4GUI.checkcustomcol();
			connect4GUI.resetGameBeginner();
		} catch (NumberFormatException e) {
			thrown = true;
		}
		assertFalse(thrown);	  
	}

	/**
	 * Test the Method when Playing the Board in Two Player
	 * Mode
	 * @throws Exception
	 */  
	@Test
	public void testBoardTwoPlayerMode() throws Exception
	{

		ConnectGame connect4twoPlay= new ConnectGame.Builder().withrows(4).withcols(4).withConnect(4).withplayer(2).build();
		ConnectGUI connect4GUItwoPlay=new ConnectGUI(connect4twoPlay);
		connect4GUItwoPlay.createNewGame();
		connect4GUItwoPlay.createMenuBar();
		connect4GUItwoPlay.checkcustomcol();
		connect4GUItwoPlay.TwoPlayermode();
	}

	/**
	 * checkcustomrow() method will throw IllegalStateException
	 * if rows < connects
	 * @throws Exception
	 */ 
	@Test
	public void testcheckcustomRow() throws Exception
	{

		boolean thrown = false;
		try{
			ConnectGame connect4row= new ConnectGame.Builder().withrows(4).withcols(4).withConnect(4).withplayer(2).build();
			ConnectGUI connect4GUIrow=new ConnectGUI(connect4row);
			connect4GUIrow.createNewGame();
			connect4GUIrow.createMenuBar();
			connect4GUIrow.checkcustomrow();
		}
		catch(IllegalStateException e)
		{
			thrown = true; 
		}
		assertTrue(thrown);	  
	}


	/**
	 * checkcustomcol() method will throw IllegalStateException
	 * if cols < connects
	 * @throws Exception
	 */ 
	@Test
	public void testcheckcustomCol() throws Exception
	{

		boolean thrown = false;
		try{
			ConnectGame connect4col= new ConnectGame.Builder().withrows(4).withcols(4).withConnect(4).withplayer(2).build();
			ConnectGUI connect4GUIcol=new ConnectGUI(connect4col);
			connect4GUIcol.createNewGame();
			connect4GUIcol.createMenuBar();
			connect4GUIcol.checkcustomcol();
		}
		catch(IllegalStateException e)
		{
			thrown = true; 
		}
		assertTrue(thrown);	  
	}

	/**Input While Testing this , Non Numeric Formar
	 * It Throws NumberFormat Exception
	 */
	@Test
	public void testcheckcustomrowformat() throws Exception
	{

		boolean thrown = false;
		try{
			ConnectGame connect4row1= new ConnectGame.Builder().withrows(4).withcols(4).withConnect(4).withplayer(2).build();
			ConnectGUI connect4GUIrow1=new ConnectGUI(connect4row1);
			connect4GUIrow1.createNewGame();
			connect4GUIrow1.createMenuBar();
			connect4GUIrow1.checkcustomrow();
		}
		catch(IllegalStateException e)
		{
			thrown = true; 
		}
		assertTrue(thrown);	
	}

	/**Input While Testing this , Non Numeric Formart
	 * It Throws NumberFormat Exception
	 */
	@Test
	public void testcheckcustomcolformat() throws Exception
	{

		boolean thrown = false;
		try{
			ConnectGame connect4col1= new ConnectGame.Builder().withrows(4).withcols(4).withConnect(4).withplayer(2).build();
			ConnectGUI connect4GUIcol1=new ConnectGUI(connect4col1);
			connect4GUIcol1.createNewGame();
			connect4GUIcol1.createMenuBar();
			connect4GUIcol1.checkcustomcol();
		}
		catch(IllegalStateException e)
		{
			thrown = true; 
		}
		assertTrue(thrown);	
	}
}
