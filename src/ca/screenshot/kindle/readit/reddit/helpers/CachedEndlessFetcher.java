package ca.screenshot.kindle.readit.reddit.helpers;

import ca.screenshot.kindle.readit.reddit.RedditException;
import ca.screenshot.kindle.readit.reddit.ThingObjectListing;
import ca.screenshot.kindle.readit.reddit.thing.Listing;
import ca.screenshot.kindle.readit.reddit.thing.RedditObject;
import org.apache.log4j.Logger;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * User: plaguemorin
 * Date: 18/02/13
 * Time: 12:00 PM
 */
public class CachedEndlessFetcher implements ThingObjectListing
{
	private static final Logger LOGGER = Logger.getLogger(CachedEndlessFetcher.class);
	private final String url;
	private Listing currentFetch = null;
	private int fetchCount = 25;
	private int currentLastId = 0;


	public CachedEndlessFetcher(final String url)
	{
		this.url = url;
	}

	private void fetchNext() throws RedditException
	{
		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace("Fetching next " + fetchCount + " items from " + url + " current last id is " + currentLastId);
		}
		else
		{
			LOGGER.info("Fetching next " + fetchCount + " items from source");
		}

		try
		{
			currentFetch = RedditFetcher.fetchRedditListingObject(url,
					null,
					currentFetch != null ? currentFetch.getBefore() : null,
					fetchCount);

			currentLastId += fetchCount;
			LOGGER.info("Fetching done");
		}
		catch (RedditException e)
		{
			LOGGER.error("Error while fetching items", e);
			throw e;
		}
	}

	public RedditObject getObjectAt(final int i) throws NoSuchElementException, RedditException
	{
		if (i > currentLastId)
		{
			fetchNext();
		}

		if (i < currentLastId - fetchCount)
		{
			//fetchPrev();
		}
		return (RedditObject) currentFetch.get(i);
	}

	public int getSize()
	{
		return fetchCount;
	}

	public Iterator iterator()
	{
		return new CachedRedditFetcherIterator(this);
	}
}
