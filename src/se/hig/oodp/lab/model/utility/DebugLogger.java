/**
 * DVG303 :: Objektorienterad design och programmering
 * 860224 Jonas Sjöberg
 * Högskolan i Gävle
 * tel12jsg@student.hig.se
 */

package se.hig.oodp.lab.model.utility;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author  Jonas Sjöberg
 *		    tel12jsg@student.hig.se
 * @date	Sep 28, 2015
 */
public class DebugLogger
{
    public static final Logger         log        = Logger.getLogger(DebugLogger.class.getName());
    public static final ConsoleHandler logHandler = new ConsoleHandler();

    public DebugLogger()
    {
        init();
    }

    private void init()
    {
        logHandler.setLevel(Level.ALL);
        log.setLevel(Level.ALL);
        log.addHandler(logHandler);
    }
}
