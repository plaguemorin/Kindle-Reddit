package ca.screenshot.kindle.readit;

import ca.screenshot.kindle.readit.reddit.Reddit;
import ca.screenshot.kindle.readit.store.PreferenceManager;
import ca.screenshot.kindle.readit.ui.UserInterface;

/**
 * User: plaguemorin
 * Date: 15/02/13
 * Time: 1:40 PM
 */
public interface ApplicationController extends FlowManager
{
	void init();

	void start();

	void stop();

	void destroy();

	void setView(UserInterface view);

	void setModel(Reddit model);

	void setPreferenceManager(PreferenceManager preferenceManager);
}
