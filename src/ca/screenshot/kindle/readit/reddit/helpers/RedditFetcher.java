package ca.screenshot.kindle.readit.reddit.helpers;

import ca.screenshot.kindle.readit.reddit.RedditException;
import ca.screenshot.kindle.readit.reddit.thing.Listing;
import ca.screenshot.kindle.readit.reddit.thing.RedditObject;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author plaguemorin
 *         Date: 2/17/13
 *         Time: 9:32 AM
 */
public class RedditFetcher
{
	private static final Logger LOGGER = Logger.getLogger(RedditFetcher.class);

	public static RedditObject fetchRedditObject(final String url, final Map paramMap) throws RedditException
	{
		final JSONObject jsonObject;
		try
		{
			jsonObject = HttpConnectionHelper.get(url, paramMap, "");
		}
		catch (ParseException e)
		{
			LOGGER.error("Error", e);
			throw new RedditException("JSON Returned by server is invalid", e);
		}
		catch (IOException e)
		{
			LOGGER.error("Error", e);
			throw new RedditException("Unable to communicate with remote server", e);
		}
		return ThingFactory.convert(jsonObject);
	}

	public static Listing fetchRedditListingObject(final String url, final String before,
												   final String after, final int count) throws RedditException
	{
		final Map paramMap = new HashMap(3);
		if (before != null)
		{
			paramMap.put("before", before);
		}

		if (after != null)
		{
			paramMap.put("after", after);
		}

		if (count > 0 && count < 100)
		{
			paramMap.put("limit", String.valueOf(count));
		}

		return (Listing) fetchRedditObject(url, paramMap);
	}
}
