package ca.screenshot.kindle.readit.reddit.helpers;

import ca.screenshot.kindle.readit.reddit.RedditException;
import ca.screenshot.kindle.readit.reddit.ThingObjectListing;

import java.util.Iterator;

/**
 * User: plaguemorin
 * Date: 18/02/13
 * Time: 1:42 PM
 */
class CachedRedditFetcherIterator implements Iterator
{
	private int position;
	private ThingObjectListing objectListing;

	CachedRedditFetcherIterator(final ThingObjectListing listing)
	{
		position = 0;
		objectListing = listing;
	}

	public boolean hasNext()
	{
		return position + 1 < objectListing.getSize();
	}

	public Object next()
	{
		try
		{
			return objectListing.getObjectAt(++position);
		}
		catch (RedditException e)
		{
			throw new RuntimeException("An error has occured", e);
		}
	}

	public void remove()
	{
		throw new UnsupportedOperationException("Remove is not supported");
	}
}
