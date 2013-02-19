package ca.screenshot.kindle.readit.ui;

import ca.screenshot.kindle.readit.FlowManager;
import ca.screenshot.kindle.readit.reddit.ThingObjectListing;

/**
 * User: plaguemorin
 * Date: 15/02/13
 * Time: 1:38 PM
 */
public interface UserInterface
{
	void init();

	void setFlowManager(FlowManager flowManager);

	void setDisplayName(String userName);

	void setUserIsLogedOn(boolean b);

	void displayListing(ThingObjectListing thingObjectListing);

	void displayError(String message);

	void setCurrentSubreddit(String s);
}
