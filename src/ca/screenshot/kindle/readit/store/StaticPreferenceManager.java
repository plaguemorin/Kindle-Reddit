package ca.screenshot.kindle.readit.store;

import org.apache.log4j.Logger;

/**
 * User: plaguemorin
 * Date: 15/02/13
 * Time: 1:52 PM
 */
public class StaticPreferenceManager implements PreferenceManager
{
	private static final Logger LOGGER = Logger.getLogger(StaticPreferenceManager.class);

	public void loadPreferences()
	{
		LOGGER.info("Loading preferences");
	}

	public void savePreferences()
	{
		LOGGER.info("Saving preferences");

	}

	public String getPreference(final String name)
	{
		LOGGER.info("Fetching preferences: " + name);

		return null;
	}
}
