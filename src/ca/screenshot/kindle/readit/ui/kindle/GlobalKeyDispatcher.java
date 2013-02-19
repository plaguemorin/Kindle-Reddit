package ca.screenshot.kindle.readit.ui.kindle;

import com.amazon.kindle.kindlet.event.KindleKeyCodes;
import org.apache.log4j.Logger;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;

/**
 * User: plaguemorin
 * Date: 15/02/13
 * Time: 12:17 PM
 */
public class GlobalKeyDispatcher implements KeyEventDispatcher
{
	private static final Logger LOGGER = Logger.getLogger(GlobalKeyDispatcher.class);

	private KindleUserInterface userInteface;

	public boolean dispatchKeyEvent(final KeyEvent event)
	{
		LOGGER.info("Key Event = " + event.getKeyCode());
		if (event.isConsumed() || event.getID() == KeyEvent.KEY_RELEASED)
		{
			return false;
		}

		switch (event.getKeyCode())
		{
			case KindleKeyCodes.VK_FIVE_WAY_SELECT:
				break;
			case KindleKeyCodes.VK_RIGHT_HAND_SIDE_TURN_PAGE:
				userInteface.nextPage();
				break;
		}

		return false;
	}

	public void setUserInteface(final KindleUserInterface userInteface)
	{
		this.userInteface = userInteface;
	}
}
