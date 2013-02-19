package ca.screenshot.kindle.readit.reddit;

/**
 * User: plaguemorin
 * Date: 15/02/13
 * Time: 1:37 PM
 */
public interface Reddit
{
	ThingObjectListing getRedditTop() throws RedditException;
}
