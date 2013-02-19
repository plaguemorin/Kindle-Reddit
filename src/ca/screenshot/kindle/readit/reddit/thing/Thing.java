package ca.screenshot.kindle.readit.reddit.thing;

/**
 * @see https://github.com/reddit/reddit/wiki/JSON
 *      User: plaguemorin
 *      Date: 15/02/13
 *      Time: 3:39 PM
 */
public abstract class Thing extends RedditObject
{
	private String id;
	private String name;

	public String getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
