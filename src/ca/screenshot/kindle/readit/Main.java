package ca.screenshot.kindle.readit;

import ca.screenshot.kindle.readit.reddit.RealRedditConnection;
import ca.screenshot.kindle.readit.reddit.Reddit;
import ca.screenshot.kindle.readit.store.PreferenceManager;
import ca.screenshot.kindle.readit.store.StaticPreferenceManager;
import ca.screenshot.kindle.readit.ui.UserInterface;
import ca.screenshot.kindle.readit.ui.kindle.KindleUserInterface;
import com.amazon.kindle.kindlet.AbstractKindlet;
import com.amazon.kindle.kindlet.KindletContext;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

import java.io.IOException;

/**
 * User: plaguemorin
 * Date: 14/02/13
 * Time: 4:43 PM
 */
public final class Main extends AbstractKindlet
{
	private static final Logger LOGGER = Logger.getLogger(Main.class);
	private Reddit model;
	private UserInterface view;
	private ApplicationController controller;
	private PreferenceManager preferenceManager;

	public void create(final KindletContext context)
	{
		final String log = context.getHomeDirectory().getAbsolutePath() + "/log.txt";
		Logger.getRootLogger().setLevel(Level.TRACE);
		try
		{
			Logger.getRootLogger().addAppender(new FileAppender(new SimpleLayout(), log));
		}
		catch (IOException e)
		{
			LOGGER.error("Error", e);
		}

		LOGGER.info("Application Flow: Creating controller");
		super.create(context);
		preferenceManager = new StaticPreferenceManager();

		controller = new KindleApplication();
		if (controller instanceof KindletContextAware)
		{
			((KindletContextAware) controller).setKindletContext(context);
		}

		view = new KindleUserInterface();
		if (view instanceof KindletContextAware)
		{
			((KindletContextAware) view).setKindletContext(context);
		}

		model = new RealRedditConnection();
		if (model instanceof KindletContextAware)
		{
			((KindletContextAware) model).setKindletContext(context);
		}

		controller.setPreferenceManager(preferenceManager);
		controller.setView(view);
		controller.setModel(model);
		controller.init();
	}

	public void start()
	{
		LOGGER.info("Application Flow: Starting controller");
		super.start();
		controller.start();
	}

	public void stop()
	{
		LOGGER.info("Application Flow: Stopping controller");
		controller.stop();
		super.stop();
	}

	public void destroy()
	{
		LOGGER.info("Application Flow: Destroying controller");
		controller.destroy();
		controller = null;
		model = null;
		view = null;
		preferenceManager = null;
		super.destroy();
	}
}
