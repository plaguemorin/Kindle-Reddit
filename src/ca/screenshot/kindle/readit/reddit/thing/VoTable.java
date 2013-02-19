package ca.screenshot.kindle.readit.reddit.thing;

/**
 * User: plaguemorin
 * Date: 15/02/13
 * Time: 3:41 PM
 */
public interface VoTable
{
	Long getUpVotes();

	Long getDownVotes();

	Boolean hasBeenLikedByUser();

	void setUpVotes(Long l);

	void setDownVotes(Long l);

	void setHasBeenLikedByUser(Boolean b);
}
