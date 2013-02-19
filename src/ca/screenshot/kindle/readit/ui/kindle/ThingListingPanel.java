package ca.screenshot.kindle.readit.ui.kindle;

import ca.screenshot.kindle.readit.reddit.ThingObjectListing;
import com.amazon.kindle.kindlet.ui.KPanel;
import com.amazon.kindle.kindlet.ui.pages.ComponentProvider;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.Iterator;

/**
 * User: plaguemorin
 * Date: 19/02/13
 * Time: 4:16 PM
 */
public class ThingListingPanel extends KPanel
{
	private final ComponentProvider componentProvider = new ThingComponentProvider();

	public ThingListingPanel(final ThingObjectListing thingObjectListing)
	{
		super(new GridLayout(0, 1));
		final Iterator iterator = thingObjectListing.iterator();
		while (iterator.hasNext())
		{
			final Component component = componentProvider.getComponent(iterator.next());
			add(component);
			component.repaint();
		}

		invalidate();
		repaint();
	}
}
