package ca.screenshot.kindle.readit.reddit;

import ca.screenshot.kindle.readit.reddit.thing.RedditObject;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * User: plaguemorin
 * Date: 18/02/13
 * Time: 1:17 PM
 */
public interface ThingObjectListing
{
	RedditObject getObjectAt(int i) throws NoSuchElementException, RedditException;

	int getSize();

	Iterator iterator();
}
