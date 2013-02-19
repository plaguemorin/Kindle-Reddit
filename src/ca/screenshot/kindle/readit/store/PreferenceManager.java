package ca.screenshot.kindle.readit.store;

/**
 * User: plaguemorin
 * Date: 15/02/13
 * Time: 12:35 PM
 */
public interface PreferenceManager
{
	void loadPreferences();

	void savePreferences();

	String getPreference(String name);
}
