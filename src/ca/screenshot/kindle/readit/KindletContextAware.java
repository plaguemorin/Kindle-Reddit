package ca.screenshot.kindle.readit;

import com.amazon.kindle.kindlet.KindletContext;

/**
 * User: plaguemorin
 * Date: 15/02/13
 * Time: 3:14 PM
 */
public interface KindletContextAware
{
	void setKindletContext(final KindletContext kindletContext);
}
