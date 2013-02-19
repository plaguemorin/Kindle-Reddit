package ca.screenshot.kindle.readit.ui.kindle;

import ca.screenshot.kindle.readit.reddit.thing.Link;
import com.amazon.kindle.kindlet.ui.KLabel;
import com.amazon.kindle.kindlet.ui.KPanel;

/**
 * @author plaguemorin
 *         Date: 2/17/13
 *         Time: 10:23 AM
 */
public class ThingLinkElement extends KPanel
{
	public ThingLinkElement(final Link thing)
	{
		final StringBuffer stringBuffer = new StringBuffer(thing.getSubreddit().length() + thing.getAuthor().length()
				+ 4);

		stringBuffer.append(thing.getSubreddit());
		stringBuffer.append(" * ");
		stringBuffer.append(thing.getAuthor());

		add(new KLabel(thing.getTitle()));
		add(new KLabel(stringBuffer.toString()));
	}
}
