/**
 * 
 */
package edu.nyu.pqs.connect4.playerfactory;

import edu.nyu.pqs.connect4.connectgame.ConnectGame;
import edu.nyu.pqs.connect4.connectgui.ConnectGUI;

/**
 * @author malathidharmalingam
 * This is the Junit Test Case for Factory Class
 */
public class ConnectPlayerFactoryTest {

	/**
	 * Test to Check if the Factory Class, could create 
	 * multiple Players successfully
	 */
	public void testConnectPlayer() throws Exception
	{
		ConnectPlayerFactory playerFactory=ConnectPlayerFactory.getConnectPlayerFactory();
		ConnectGame connect4Gamefactory= new ConnectGame.Builder().withrows(4).withcols(4).withConnect(4).withplayer(2).build();
	     ConnectGUI connect4GUIsetfactory=new ConnectGUI(connect4Gamefactory);
		IConnectPlayer player1=playerFactory.createPlayer(ConnectPlayer.Human,connect4Gamefactory);
		IConnectPlayer player2=playerFactory.createPlayer(ConnectPlayer.Computer, connect4Gamefactory);
 
	}
	

}
