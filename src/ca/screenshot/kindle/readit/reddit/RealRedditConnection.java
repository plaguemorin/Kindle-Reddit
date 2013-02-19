package ca.screenshot.kindle.readit.reddit;

import ca.screenshot.kindle.readit.reddit.helpers.CachedEndlessFetcher;

/**
 * User: plaguemorin
 * Date: 15/02/13
 * Time: 12:14 PM
 */
public class RealRedditConnection implements Reddit
{
	public ThingObjectListing getRedditTop() throws RedditException
	{
		return new CachedEndlessFetcher("/top.json");
	}
}
