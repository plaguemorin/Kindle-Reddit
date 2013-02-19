package ca.screenshot.kindle.readit;

import ca.screenshot.kindle.readit.reddit.Reddit;
import ca.screenshot.kindle.readit.reddit.RedditException;
import ca.screenshot.kindle.readit.reddit.ThingObjectListing;
import ca.screenshot.kindle.readit.store.PreferenceManager;
import ca.screenshot.kindle.readit.ui.UserInterface;
import com.amazon.kindle.kindlet.KindletContext;
import com.amazon.kindle.kindlet.net.CancelledConnectivityRequestException;
import com.amazon.kindle.kindlet.net.NetworkDisabledException;
import org.apache.log4j.Logger;

/**
 * User: plaguemorin
 * Date: 15/02/13
 * Time: 1:40 PM
 */
public class KindleApplication implements ApplicationController, KindletContextAware, FlowManager
{
	private static final Logger LOGGER = Logger.getLogger(KindleApplication.class);
	private static final String DEFAULT_USER_NAME = "Anonymous";
	private KindletContext kindletContext;
	private PreferenceManager preferenceManager;
	private UserInterface userInterface;
	private Reddit model;

	public void init()
	{

	}

	public void start()
	{
		preferenceManager.loadPreferences();
		userInterface.init();
		userInterface.setFlowManager(this);

		requestNetwork();
	}

	private void requestNetwork()
	{
		try
		{
			kindletContext.getConnectivity().requestConnectivity(true);
		}
		catch (NetworkDisabledException e)
		{
			LOGGER.error("Error", e);
			userInterface.displayError(e.getMessage());
		}
		catch (CancelledConnectivityRequestException e)
		{
			LOGGER.error("Error", e);
			userInterface.displayError(e.getMessage());
		}
		catch (InterruptedException e)
		{
			LOGGER.error("Error", e);
			userInterface.displayError(e.getMessage());
		}
	}

	public void stop()
	{
		preferenceManager.savePreferences();
	}

	public void destroy()
	{

	}

	public void setView(final UserInterface view)
	{
		userInterface = view;
	}

	public void setModel(final Reddit model)
	{
		this.model = model;
	}

	public void setPreferenceManager(final PreferenceManager preferenceManager)
	{
		this.preferenceManager = preferenceManager;
	}

	private void doActionShowAnonymous()
	{
		LOGGER.info("Showing Anonymous application");
		userInterface.setDisplayName(DEFAULT_USER_NAME);
		userInterface.setUserIsLogedOn(false);

		doActionShowFrontPage();
	}

	private void doActionShowFrontPage()
	{
		LOGGER.info("Loading the front page");

		userInterface.setCurrentSubreddit("Front Page");
		kindletContext.getProgressIndicator().setString("Loading front page");
		kindletContext.getProgressIndicator().setIndeterminate(true);
		try
		{
			final ThingObjectListing redditTop = model.getRedditTop();
			userInterface.displayListing(redditTop);
		}
		catch (RedditException e)
		{
			LOGGER.error("Error", e);
			userInterface.displayError(e.getMessage());
		}
		finally
		{
			kindletContext.getProgressIndicator().setIndeterminate(false);
		}
	}

	public void setKindletContext(final KindletContext kindletContext)
	{
		this.kindletContext = kindletContext;
	}

	public void showFrontPage()
	{
		// if (preferenceManager.getPreference("hasLogin")
		// { this.action_login() } else {
		doActionShowAnonymous();
// }
	}
}
