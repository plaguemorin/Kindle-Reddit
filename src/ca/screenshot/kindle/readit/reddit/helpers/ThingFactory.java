package ca.screenshot.kindle.readit.reddit.helpers;

import ca.screenshot.kindle.readit.reddit.RedditException;
import ca.screenshot.kindle.readit.reddit.thing.Created;
import ca.screenshot.kindle.readit.reddit.thing.Link;
import ca.screenshot.kindle.readit.reddit.thing.Listing;
import ca.screenshot.kindle.readit.reddit.thing.RedditObject;
import ca.screenshot.kindle.readit.reddit.thing.Thing;
import ca.screenshot.kindle.readit.reddit.thing.VoTable;
import org.apache.log4j.Logger;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author plaguemorin
 *         Date: 2/16/13
 *         Time: 3:49 PM
 */
public final class ThingFactory
{
	private static final Logger LOGGER = Logger.getLogger(ThingFactory.class);

	private ThingFactory()
	{
	}

	public static RedditObject convert(final Map jsonObject) throws RedditException
	{
		// Make sure it's a valid thing
		if (!jsonObject.containsKey("kind"))
		{
			LOGGER.error("JSON Object doesn't have a \"Kind\"");
			throw new RedditException("Invalid JSON Response");
		}

		final String kind = getString(jsonObject, "kind");
		if (Listing.OBJECT_NAME.equals(kind))
		{
			return convertListing((Map) jsonObject.get("data"));
		}

		if (Link.OBJECT_NAME.equals(kind))
		{
			return convertLink((Map) jsonObject.get("data"));
		}

		return null;
	}

	private static Link convertLink(final Map jsonObject)
	{
		final Link link = new Link();
		convertThing(link, jsonObject);

		link.setAuthor(getString(jsonObject, "author"));
		link.setAuthorFlairCssClass(getString(jsonObject, "author_flair_css_class"));
		link.setAuthorFlairText(getString(jsonObject, "author_flair_text"));
		link.setClicked(getBoolean(jsonObject, "clicked"));
		link.setDomain(getString(jsonObject, "domain"));
		link.setHidden(getBoolean(jsonObject, "hidden"));
		link.setSelf(getBoolean(jsonObject, "is_self"));
		link.setLinkFlairCssClass(getString(jsonObject, "link_flair_css_class"));
		link.setLinkFlairText(getString(jsonObject, "link_flair_text"));
		// media
		// media_embed
		link.setNumberComments(getLong(jsonObject, "num_comments"));
		link.setOver18(getBoolean(jsonObject, "over_18"));
		link.setPermalink(getString(jsonObject, "permalink"));
		link.setSaved(getBoolean(jsonObject, "saved"));
		link.setScore(getLong(jsonObject, "score"));
		link.setSelfText(getString(jsonObject, "selftext"));
		link.setSelfTextHtml(getString(jsonObject, "selftext_html"));
		link.setSubreddit(getString(jsonObject, "subreddit"));
		link.setSubredditId(getString(jsonObject, "subreddit_id"));
		link.setThumbnail(getString(jsonObject, "thumbnail"));
		link.setTitle(getString(jsonObject, "title"));
		link.setUrl(getString(jsonObject, "url"));
		// edited

		convertVoTable(link, jsonObject);
		convertCreated(link, jsonObject);

		return link;
	}

	private static Boolean getBoolean(final Map jsonObject, final String name)
	{
		if (jsonObject.containsKey(name))
		{
			final Object obj = jsonObject.get(name);
			if (obj instanceof Boolean)
			{
				return (Boolean) obj;
			}
		}

		return null;
	}

	private static Long getLong(final Map jsonObject, final String name)
	{
		if (jsonObject.containsKey(name))
		{
			final Object obj = jsonObject.get(name);
			if (obj instanceof Long)
			{
				return (Long) obj;
			}

			if (obj instanceof Number)
			{
				return new Long(((Number) obj).longValue());
			}
		}

		return null;
	}

	private static String getString(final Map jsonObject, final String name)
	{
		if (jsonObject.containsKey(name))
		{
			final Object obj = jsonObject.get(name);
			if (obj == null)
			{
				return (String) obj;
			}

			if (obj instanceof String)
			{
				return (String) obj;
			}

			return obj.toString();
		}
		return null;
	}

	private static void convertThing(final Thing thing, final Map jsonObject)
	{
		thing.setId(getString(jsonObject, "id"));
		thing.setName(getString(jsonObject, "name"));
	}

	private static void convertCreated(final Created created, final Map jsonObject)
	{
		created.setCreated(getLong(jsonObject, "created"));
		created.setCreatedUtc(getLong(jsonObject, "created_utc"));
	}

	private static void convertVoTable(final VoTable voTable, final Map jsonObject)
	{
		voTable.setDownVotes(getLong(jsonObject, "downs"));
		voTable.setUpVotes(getLong(jsonObject, "ups"));
		//voTable.setHasBeenLikedByUser();
	}

	private static Listing convertListing(final Map jsonObject) throws RedditException
	{
		final Listing object = new Listing();
		object.setBefore(getString(jsonObject, "before"));
		object.setAfter(getString(jsonObject, "after"));
		object.setModhash(getString(jsonObject, "modhash"));

		final List children = (List) jsonObject.get("children");
		final Iterator iterator = children.iterator();
		while (iterator.hasNext())
		{
			object.addChild(convert((Map) iterator.next()));
		}

		return object;
	}
}
