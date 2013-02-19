package ca.screenshot.kindle.readit.ui.kindle;

import com.amazon.kindle.kindlet.ui.pages.LocationIterator;
import com.amazon.kindle.kindlet.ui.pages.PageModel;

import java.util.NoSuchElementException;

/**
 * User: plaguemorin
 * Date: 18/02/13
 * Time: 3:47 PM
 */
public class PageModelIterator implements LocationIterator
{
	private final PageModel pageModel;
	private boolean forward;
	private int position;

	public PageModelIterator(final PageModel pageModel, final int nextPosition, final boolean forward)
	{
		this.forward = forward;
		this.pageModel = pageModel;
		position = nextPosition;
	}

	public boolean isForward()
	{
		return forward;
	}

	public boolean hasNext()
	{
		return position + 1 < pageModel.getLastLocation();
	}

	public Object next() throws NoSuchElementException
	{
		return pageModel.getElementAt(++position);
	}

	public int nextLocation()
	{
		return position;
	}

	public int previousLocation()
	{
		return position - 1;
	}

	public void remove() throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException("Removing is not supported");
	}

	public void close()
	{
	}
}
