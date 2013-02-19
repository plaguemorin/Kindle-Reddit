package ca.screenshot.kindle.readit.reddit.thing;

/**
 * @author plaguemorin
 *         Date: 2/16/13
 *         Time: 3:59 PM
 */
public abstract class RedditObject
{
	private String kind;

	protected String getKind()
	{
		return kind;
	}

	protected void setKind(String kind)
	{
		this.kind = kind;
	}
}
