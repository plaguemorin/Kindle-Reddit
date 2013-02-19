package ca.screenshot.kindle.readit.reddit.thing;

/**
 * link (implements votable | created)
 * <p/>
 * <p/>
 * type	name	description
 * String	author	the account name of the poster. null if this is a promotional link
 * String	author_flair_css_class	the CSS class of the author's flair. subreddit specific
 * String	author_flair_text	the text of the author's flair. subreddit specific
 * boolean	clicked	probably always returns false
 * String	domain	the domain of this link. Self posts will be self.reddit.com while other examples include en.wikipedia.org and s3.amazon.com
 * boolean	hidden	true if the post is hidden by the logged in user. false if not logged in or not hidden.
 * boolean	is_self	true if this link is a selfpost
 * String	link_flair_css_class	the CSS class of the link's flair.
 * String	link_flair_text	the text of the link's flair.
 * Object	media	unknown. I need someone else to document this as I haven't done much research into this
 * Object	media_embed	unknown. I need someone else to document this as I haven't done much research into this
 * int	num_comments	the number of comments that belong to this link. includes removed comments.
 * boolean	over_18	true if the post is tagged as NSFW. False if otherwise
 * String	permalink	relative url of the permanent link for this link
 * boolean	saved	true if this post is saved by the logged in user
 * int	score	the net-score of the link. note: A submission's score is simply the number of upvotes minus the number of downvotes. If five users like the submission and three users don't it will have a score of 2. Please note that the vote numbers are not "real" numbers, they have been "fuzzed" to prevent spam bots etc. So taking the above example, if five users upvoted the submission, and three users downvote it, the upvote/downvote numbers may say 23 upvotes and 21 downvotes, or 12 upvotes, and 10 downvotes. The points score is correct, but the vote totals are "fuzzed".
 * String	selftext	the raw text. this is the unformatted text which includes the raw markup characters such as ** for bold. <, >, and & are escaped. Empty if not present.
 * String	selftext_html	the formatted escaped html text. this is the html formatted version of the marked up text. Items that are boldened by ** or *** will now have <em> or *** tags on them. Additionally, bullets and numbered lists will now be in html list format. NOTE: The html string will be escaped. You must unescape to get the raw html. Null if not present.
 * String	subreddit
 * String	subreddit_id
 * String	thumbnail	full url to the thumbnail for this link; "self" if this is a self post
 * String	title	the title of the link. may contain newlines for some reason
 * String	url	the link of this post. the permalink if this is a self-post
 * long	edited	Indicates if link has been edited. Will be the edit timestamp if the link has been edited and return false otherwise. https://github.com/reddit/reddit/issues/581
 * <p/>
 * User: plaguemorin
 * Date: 15/02/13
 * Time: 3:45 PM
 */
public class Link extends Thing implements Created, VoTable
{
	public static final String OBJECT_NAME = "t3";
	private String author;
	private String authorFlairCssClass;
	private String authorFlairText;
	private Boolean clicked;
	private String domain;
	private Boolean hidden;
	private Boolean self;
	private String linkFlairCssClass;
	private String linkFlairText;
	private Long numberComments;
	private Boolean over18;
	private String permalink;
	private Boolean saved;
	private Long score;
	private String selfText;
	private String selfTextHtml;
	private String subreddit;
	private String subredditId;
	private String thumbnail;
	private String title;
	private String url;
	private Long edited;
	private Long created;
	private Long createdUtc;
	private Long upVotes;
	private Long downVotes;
	private Boolean likedByUser;

	public Link()
	{
		setKind(OBJECT_NAME);
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(final String author)
	{
		this.author = author;
	}

	public String getAuthorFlairCssClass()
	{
		return authorFlairCssClass;
	}

	public void setAuthorFlairCssClass(final String authorFlairCssClass)
	{
		this.authorFlairCssClass = authorFlairCssClass;
	}

	public String getAuthorFlairText()
	{
		return authorFlairText;
	}

	public void setAuthorFlairText(final String authorFlairText)
	{
		this.authorFlairText = authorFlairText;
	}

	public Boolean getClicked()
	{
		return clicked;
	}

	public void setClicked(final Boolean clicked)
	{
		this.clicked = clicked;
	}

	public String getDomain()
	{
		return domain;
	}

	public void setDomain(final String domain)
	{
		this.domain = domain;
	}

	public Boolean getHidden()
	{
		return hidden;
	}

	public void setHidden(final Boolean hidden)
	{
		this.hidden = hidden;
	}

	public Boolean getSelf()
	{
		return self;
	}

	public void setSelf(final Boolean self)
	{
		this.self = self;
	}

	public String getLinkFlairCssClass()
	{
		return linkFlairCssClass;
	}

	public void setLinkFlairCssClass(final String linkFlairCssClass)
	{
		this.linkFlairCssClass = linkFlairCssClass;
	}

	public String getLinkFlairText()
	{
		return linkFlairText;
	}

	public void setLinkFlairText(final String linkFlairText)
	{
		this.linkFlairText = linkFlairText;
	}

	public Long getNumberComments()
	{
		return numberComments;
	}

	public void setNumberComments(final Long numberComments)
	{
		this.numberComments = numberComments;
	}

	public Boolean getOver18()
	{
		return over18;
	}

	public void setOver18(final Boolean over18)
	{
		this.over18 = over18;
	}

	public String getPermalink()
	{
		return permalink;
	}

	public void setPermalink(final String permalink)
	{
		this.permalink = permalink;
	}

	public Boolean getSaved()
	{
		return saved;
	}

	public void setSaved(final Boolean saved)
	{
		this.saved = saved;
	}

	public Long getScore()
	{
		return score;
	}

	public void setScore(final Long score)
	{
		this.score = score;
	}

	public String getSelfText()
	{
		return selfText;
	}

	public void setSelfText(final String selfText)
	{
		this.selfText = selfText;
	}

	public String getSelfTextHtml()
	{
		return selfTextHtml;
	}

	public void setSelfTextHtml(final String selfTextHtml)
	{
		this.selfTextHtml = selfTextHtml;
	}

	public String getSubreddit()
	{
		return subreddit;
	}

	public void setSubreddit(final String subreddit)
	{
		this.subreddit = subreddit;
	}

	public String getSubredditId()
	{
		return subredditId;
	}

	public void setSubredditId(final String subredditId)
	{
		this.subredditId = subredditId;
	}

	public String getThumbnail()
	{
		return thumbnail;
	}

	public void setThumbnail(final String thumbnail)
	{
		this.thumbnail = thumbnail;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(final String title)
	{
		this.title = title;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(final String url)
	{
		this.url = url;
	}

	public Long getEdited()
	{
		return edited;
	}

	public void setEdited(final Long edited)
	{
		this.edited = edited;
	}

	public Long getCreated()
	{
		return created;
	}

	public void setCreated(final Long l)
	{
		created = l;
	}

	public Long getCreatedUtc()
	{
		return createdUtc;
	}

	public void setCreatedUtc(final Long l)
	{
		createdUtc = l;
	}

	public Long getUpVotes()
	{
		return upVotes;
	}

	public void setUpVotes(final Long l)
	{
		upVotes = l;
	}

	public Long getDownVotes()
	{
		return downVotes;
	}

	public void setDownVotes(final Long l)
	{
		downVotes = l;
	}

	public Boolean hasBeenLikedByUser()
	{
		return likedByUser;
	}

	public void setHasBeenLikedByUser(final Boolean b)
	{
		likedByUser = b;
	}

	public String toString()
	{
		return title;
	}
}
