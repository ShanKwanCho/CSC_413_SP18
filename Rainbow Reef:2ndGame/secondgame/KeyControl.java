import java.awt.event.*;

public class KeyControl extends KeyAdapter {
	private final GameEvents gameEvents;
	
	public KeyControl(GameEvents gameEvents) {
		this.gameEvents = gameEvents;
	}
	
        @Override
	public void keyPressed(KeyEvent e) {
		gameEvents.setValue(e);
	}
		
	/*public void keyReleased(KeyEvent e) {
	}*/
}
