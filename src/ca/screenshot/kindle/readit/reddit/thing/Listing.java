package ca.screenshot.kindle.readit.reddit.thing;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author plaguemorin
 *         Date: 2/16/13
 *         Time: 4:00 PM
 */
public class Listing extends RedditObject implements List
{
	public static final String OBJECT_NAME = "Listing";

	private String before;
	private String after;
	private String modhash;
	private List data = new LinkedList();

	public Listing()
	{
		setKind(OBJECT_NAME);
	}

	public String getBefore()
	{
		return before;
	}

	public void setBefore(final String before)
	{
		this.before = before;
	}

	public String getAfter()
	{
		return after;
	}

	public void setAfter(final String after)
	{
		this.after = after;
	}

	public String getModhash()
	{
		return modhash;
	}

	public void setModhash(final String modhash)
	{
		this.modhash = modhash;
	}

	public List getData()
	{
		return Collections.unmodifiableList(data);
	}

	public void addChild(final RedditObject item)
	{
		data.add(item);
	}

	public int size()
	{
		return data.size();
	}

	public boolean isEmpty()
	{
		return data.isEmpty();
	}

	public boolean contains(final Object o)
	{
		return data.contains(o);
	}

	public Iterator iterator()
	{
		return data.iterator();
	}

	public Object[] toArray()
	{
		return data.toArray();
	}

	public boolean add(final Object o)
	{
		return data.add(o);
	}

	public boolean remove(final Object o)
	{
		return data.remove(o);
	}

	public boolean containsAll(final Collection c)
	{
		return data.containsAll(c);
	}

	public boolean addAll(final Collection c)
	{
		return data.addAll(c);
	}

	public boolean addAll(final int index, final Collection c)
	{
		return data.addAll(index, c);
	}

	public boolean removeAll(final Collection c)
	{
		return data.removeAll(c);
	}

	public boolean retainAll(final Collection c)
	{
		return data.retainAll(c);
	}

	public void clear()
	{
		data.clear();
	}

	public Object get(final int index)
	{
		return data.get(index);
	}

	public Object set(final int index, final Object element)
	{
		return data.set(index, element);
	}

	public void add(final int index, final Object element)
	{
		data.add(index, element);
	}

	public Object remove(final int index)
	{
		return data.remove(index);
	}

	public int indexOf(final Object o)
	{
		return data.indexOf(o);
	}

	public int lastIndexOf(final Object o)
	{
		return data.lastIndexOf(o);
	}

	public ListIterator listIterator()
	{
		return data.listIterator();
	}

	public ListIterator listIterator(final int index)
	{
		return data.listIterator(index);
	}

	public List subList(final int fromIndex, final int toIndex)
	{
		return data.subList(fromIndex, toIndex);
	}

	public Object[] toArray(final Object[] a)
	{
		return data.toArray(a);
	}
}
