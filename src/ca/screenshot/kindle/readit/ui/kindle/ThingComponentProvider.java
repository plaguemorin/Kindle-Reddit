package ca.screenshot.kindle.readit.ui.kindle;

import ca.screenshot.kindle.readit.reddit.thing.Link;
import com.amazon.kindle.kindlet.ui.pages.ComponentProvider;
import org.apache.log4j.Logger;

import java.awt.Component;

/**
 * @author plaguemorin
 *         Date: 2/18/13
 *         Time: 8:29 PM
 */
public class ThingComponentProvider implements ComponentProvider
{
	private static final Logger LOGGER = Logger.getLogger(ThingComponentProvider.class);

	public Component getComponent(final Object o)
	{
		LOGGER.trace("Getting component for object of type: ".concat(o.getClass().getName()));
		if (o instanceof Link)
		{
			LOGGER.trace("Returning Thing element");
			return new ThingLinkElement((Link) o);
		}


		return null;
	}
}
