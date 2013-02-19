package ca.screenshot.kindle.readit.reddit.helpers;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;

/**
 * @author plaguemorin
 *         Date: 2/15/13
 *         Time: 8:49 PM
 */
public final class HttpConnectionHelper
{
	private static final Logger LOGGER = Logger.getLogger(HttpConnectionHelper.class);

	private static final String POST_CONTENT_TYPE = "application/x-www-form-urlencoded; charset=UTF-8";
	private static final String USER_AGENT = "ca.screenshot kindle reddit client";
	private static final JSONParser JSON_PARSER = new JSONParser();

	private HttpConnectionHelper()
	{

	}

	/**
	 * It basically submits a POST request and returns a JSON object that
	 * corresponds to it.
	 */
	public static JSONObject post(final String apiParams, final Map queryParams, final String url,
								  final String cookie) throws IOException, ParseException, ProtocolException
	{
		final HttpURLConnection connection = getHttpURLConnection(url, queryParams, cookie);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", POST_CONTENT_TYPE);

		final int lengthOfParams = apiParams.length();
		final String stringLengthOfParams = String.valueOf(lengthOfParams);
		connection.setRequestProperty("Content-Length", stringLengthOfParams);

		final OutputStream outputStream = connection.getOutputStream();
		final DataOutputStream wr = new DataOutputStream(outputStream);
		try
		{
			wr.writeBytes(apiParams);
			wr.flush();
		}
		catch (IOException e)
		{
			LOGGER.error("Unable to post", e);
			throw e;
		}
		finally
		{
			wr.close();
		}

		return getJsonObject(connection);
	}

	/**
	 * This function submits a GET request and returns a JSON object that
	 * corresponds to it.
	 */
	public static JSONObject get(final String url, final Map paramMap, final String cookie) throws ParseException, IOException, ProtocolException
	{
		if (LOGGER.isDebugEnabled())
		{
			LOGGER.debug("Getting " + url);
		}
		final HttpURLConnection connection = getHttpURLConnection(url, paramMap, cookie);
		connection.setRequestMethod("GET");
		return getJsonObject(connection);
	}

	private static HttpURLConnection getHttpURLConnection(final String url, final Map queryParams, final String cookie) throws IOException
	{
		final String urlString = formatUrl(url, queryParams);
		final URL fullUrl = new URL("http", "www.reddit.com", 80, urlString);
		final HttpURLConnection connection = (HttpURLConnection) fullUrl.openConnection();
		connection.setDoOutput(true);
		connection.setUseCaches(false);
		connection.setRequestProperty("cookie", "reddit_session=" + cookie);
		connection.setRequestProperty("User-Agent", USER_AGENT);
		return connection;
	}

	private static String formatUrl(final String url, final Map queryParams)
	{
		final StringBuffer urlString = new StringBuffer(url.length());
		urlString.append(url);

		if (queryParams != null && !queryParams.isEmpty())
		{
			urlString.append('?');
			final Iterator entrySetItorator = queryParams.entrySet().iterator();
			while (entrySetItorator.hasNext())
			{
				final Map.Entry entry = (Map.Entry) entrySetItorator.next();
				urlString.append(entry.getKey());
				urlString.append('=');
				urlString.append(entry.getValue());
				urlString.append('&');
			}
		}
		return urlString.toString();
	}

	private static JSONObject getJsonObject(final URLConnection connection) throws IOException, ParseException
	{
		final InputStream inputStream = getInputStream(connection);
		final InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

		final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		try
		{
			final String line = bufferedReader.readLine();
			return (JSONObject) JSON_PARSER.parse(line);
		}
		finally
		{
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
		}
	}

	private static InputStream getInputStream(final URLConnection connection) throws IOException
	{
		final InputStream inputStream;
		try
		{
			inputStream = connection.getInputStream();
		}
		catch (IOException e)
		{
			// Log and rethrow
			LOGGER.error("Unable to open input stream", e);
			throw e;
		}
		return inputStream;
	}
}
