package ca.screenshot.kindle.readit.ui.kindle;

import ca.screenshot.kindle.readit.reddit.RedditException;
import ca.screenshot.kindle.readit.reddit.ThingObjectListing;
import com.amazon.kindle.kindlet.ui.pages.LocationIterator;
import com.amazon.kindle.kindlet.ui.pages.PageModel;

import java.util.NoSuchElementException;

/**
 * User: plaguemorin
 * Date: 18/02/13
 * Time: 1:18 PM
 */
public class RedditListingPageModel implements PageModel
{
	private final ThingObjectListing objectListing;

	public RedditListingPageModel(final ThingObjectListing objectListing)
	{
		this.objectListing = objectListing;
	}

	public int getInitialLocation()
	{
		return getFirstLocation();
	}

	public int getFirstLocation()
	{
		return 0;
	}

	public int getLastLocation()
	{
		return objectListing.getSize();
	}

	public LocationIterator locationIterator(final int location, final boolean forward)
	{
		return new PageModelIterator(this, location, forward);
	}

	public Object getElementAt(final int i) throws NoSuchElementException
	{
		try
		{
			return objectListing.getObjectAt(i);
		}
		catch (RedditException e)
		{
			throw new RuntimeException("Unable to fetch object", e);
		}
	}
}
