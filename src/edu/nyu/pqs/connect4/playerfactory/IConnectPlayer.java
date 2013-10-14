/**
 * 
 */
package edu.nyu.pqs.connect4.playerfactory;
 
/**
 * Interface for the ConnectPlayer , It Implements  3 methods
 * @author malathidharmalingam
 *
 */
public interface IConnectPlayer {
 
/**It sets the next move by the player
 */
public void setNextMove(int column,int type);

/**The player can be of Human or Computer
* This method returns the type of the player
*/
public int getPlayerNumber();

/**
 * It gives the type of the player
 */
public ConnectPlayer getPlayerType();
  
}
