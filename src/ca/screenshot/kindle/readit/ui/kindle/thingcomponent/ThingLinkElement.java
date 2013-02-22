package ca.screenshot.kindle.readit.ui.kindle.thingcomponent;

import ca.screenshot.kindle.readit.reddit.thing.Link;
import com.amazon.kindle.kindlet.ui.KLabel;
import com.amazon.kindle.kindlet.ui.KLabelMultiline;
import com.amazon.kindle.kindlet.ui.KPanel;

import java.awt.GridLayout;

/**
 * @author plaguemorin
 *         Date: 2/17/13
 *         Time: 10:23 AM
 */
public class ThingLinkElement extends KPanel
{
	public ThingLinkElement(final Link thing)
	{
		super(new GridLayout(2, 1));

		// First "Line"
		add(new KLabelMultiline(thing.getTitle()));

		// Second Line
		final KPanel secondLine = new KPanel();
		secondLine.add(new KLabel(thing.getSubreddit()));
		secondLine.add(new KLabel(thing.getAuthor()));
		add(secondLine);
	}
}
