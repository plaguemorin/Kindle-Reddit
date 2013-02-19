package ca.screenshot.kindle.readit.ui.kindle;

import ca.screenshot.kindle.readit.FlowManager;
import ca.screenshot.kindle.readit.KindletContextAware;
import ca.screenshot.kindle.readit.reddit.ThingObjectListing;
import ca.screenshot.kindle.readit.ui.UserInterface;
import com.amazon.kindle.kindlet.KindletContext;
import com.amazon.kindle.kindlet.ui.KBox;
import com.amazon.kindle.kindlet.ui.KBoxLayout;
import com.amazon.kindle.kindlet.ui.KComponent;
import com.amazon.kindle.kindlet.ui.KLabel;
import com.amazon.kindle.kindlet.ui.KLabelMultiline;
import com.amazon.kindle.kindlet.ui.KPanel;
import com.amazon.kindle.kindlet.ui.KTextComponent;
import com.amazon.kindle.kindlet.ui.KTextOptionPane;
import org.apache.log4j.Logger;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;

/**
 * User: plaguemorin
 * Date: 15/02/13
 * Time: 1:49 PM
 */
public class KindleUserInterface implements UserInterface, KindletContextAware
{
	private static final Logger LOGGER = Logger.getLogger(KindleUserInterface.class);
	private KeyEventDispatcher keyDispatcher;
	private KTextOptionPane textOptionPane;
	private MenuController menuController;
	private Container rootContainer;
	private KindletContext kindletContext;
	private FlowManager flowManager;

	public void init()
	{
		rootContainer = new KPanel(new BorderLayout(5, 5));
		menuController = new MenuController();
		textOptionPane = new TextOptionPane();
		keyDispatcher = new GlobalKeyDispatcher();

		kindletContext.setTextOptionPane(textOptionPane);
		kindletContext.setMenu(menuController.getMainMenu());
		kindletContext.getRootContainer().removeAll();
		kindletContext.getRootContainer().add(rootContainer);

		rootContainer.add(new KLabelMultiline("Please selection an action", KTextComponent.CENTER, KTextComponent.CENTER));

		((GlobalKeyDispatcher) keyDispatcher).setUserInteface(this);
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(keyDispatcher);
	}

	public void setFlowManager(FlowManager flowManager)
	{
		this.flowManager = flowManager;
		menuController.setFlowManager(this.flowManager);
	}

	public void setDisplayName(final String userName)
	{
		LOGGER.info("Setting display name to ".concat(userName));
		kindletContext.setSubTitle(userName);
	}

	public void setUserIsLogedOn(boolean b)
	{
		// Show Login menu or Logout menu
	}

	public void displayListing(final ThingObjectListing thingObjectListing)
	{
		LOGGER.info("Displaying listing of size ".concat(String.valueOf(thingObjectListing.getSize())));
/*
		final KPagedContainer container = new KPagedContainer(
				new RedditListingPageModel(thingObjectListing),
				PageProviders.createKBoxLayoutProvider(KBoxLayout.Y_AXIS, new ThingComponentProvider()));
*/
		final KComponent container = new ThingListingPanel(thingObjectListing);
		rootContainer.removeAll();
		rootContainer.add(container, BorderLayout.CENTER);
		rootContainer.add(new KLabel("Listing of objects"), BorderLayout.SOUTH);
		container.repaint();
	}

	public void displayError(final String message)
	{
		rootContainer.removeAll();
		rootContainer.add(new KLabelMultiline(message, KTextComponent.CENTER, KTextComponent.CENTER));
		rootContainer.repaint();
	}

	public void setCurrentSubreddit(String s)
	{
		LOGGER.info("Current sub-reddit is now ".concat(s));
	}

	public void setKindletContext(final KindletContext kindletContext)
	{
		this.kindletContext = kindletContext;
	}

	public void nextPage()
	{

	}

	private static class StatusBarBox extends KBox
	{
		// this overriding provides a black border on the bar.
		private final Insets myInsets = new Insets(2, 2, 2, 2);

		private StatusBarBox()
		{
			super(KBoxLayout.LINE_AXIS);
		}

		public Insets getInsets()
		{
			return myInsets;
		}

		public void paint(final Graphics g)
		{
			super.paint(g);
			final Dimension size = getSize();
			g.setColor(Color.BLACK);
			g.drawRect(0, 0, size.width, size.height);
		}
	}
}
