package ca.screenshot.kindle.readit.reddit.thing;

/**
 * @author plaguemorin
 *         Date: 2/17/13
 *         Time: 9:36 AM
 */
public class Comment extends Thing implements VoTable, Created
{
	private String approved_by;
	private String author;
	private String author_flair_css_class;
	private String author_flair_text;
	private String banned_by;
	private String body;
	private String body_html;
	// edited
	private Integer glided;
	private String link_id;
	private String link_title;
	private Integer num_reports;
	private String parent_id;
	private String subreddit;
	private String subreddit_id;

	public Long getCreated()
	{
		return null;
	}

	public Long getCreatedUtc()
	{
		return null;
	}

	public void setCreated(Long l)
	{
	}

	public void setCreatedUtc(Long l)
	{
	}

	public Long getUpVotes()
	{
		return null;
	}

	public Long getDownVotes()
	{
		return null;
	}

	public Boolean hasBeenLikedByUser()
	{
		return null;
	}

	public void setUpVotes(Long l)
	{
	}

	public void setDownVotes(Long l)
	{
	}

	public void setHasBeenLikedByUser(Boolean b)
	{
	}
}
