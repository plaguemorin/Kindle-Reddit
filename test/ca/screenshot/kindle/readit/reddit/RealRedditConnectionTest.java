package ca.screenshot.kindle.readit.reddit;

import java.util.Iterator;

/**
 * @author plaguemorin
 *         Date: 2/15/13
 *         Time: 8:44 PM
 */
public class RealRedditConnectionTest
{

	public static void main(String args[]) throws RedditException
	{
		final Reddit realRedditConnection = new RealRedditConnection();

		final ThingObjectListing redditTop = realRedditConnection.getRedditTop();
		final Iterator iterator = redditTop.iterator();
		while (iterator.hasNext())
		{
			System.out.println(iterator.next());
		}

	}

}
