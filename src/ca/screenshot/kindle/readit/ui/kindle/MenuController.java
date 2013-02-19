package ca.screenshot.kindle.readit.ui.kindle;

import ca.screenshot.kindle.readit.FlowManager;
import com.amazon.kindle.kindlet.ui.KMenu;
import com.amazon.kindle.kindlet.ui.KMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: plaguemorin
 * Date: 19/02/13
 * Time: 11:25 AM
 */
public class MenuController implements ActionListener
{
	private KMenu menu;
	private KMenuItem showTop;
	private FlowManager flowManager;

	public MenuController()
	{
		menu = new KMenu();
		showTop = createMenuItem("Show top Reddit", "SHOW_TOP");
	}

	public KMenu getMainMenu()
	{
		menu.removeAll();
		menu.add(showTop);

		return menu;
	}

	private KMenuItem createMenuItem(final String label, final String commandName)
	{
		final KMenuItem item = new KMenuItem();
		item.addActionListener(this);
		item.setLabel(label);
		item.setActionCommand(commandName);

		return item;
	}

	public void actionPerformed(final ActionEvent e)
	{
		if ("SHOW_TOP".equals(e.getActionCommand()))
		{
			flowManager.showFrontPage();
		}
	}

	public void setFlowManager(final FlowManager flowManager)
	{
		this.flowManager = flowManager;
	}
}
