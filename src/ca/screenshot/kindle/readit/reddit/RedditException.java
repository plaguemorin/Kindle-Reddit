package ca.screenshot.kindle.readit.reddit;

/**
 * @author plaguemorin
 *         Date: 2/15/13
 *         Time: 9:40 PM
 */
public class RedditException extends Exception
{

	public RedditException(final String s)
	{
		super(s);
	}

	public RedditException(final String s, final Throwable cause)
	{
		super(s, cause);
	}
}
