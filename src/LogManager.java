import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogManager {

        public static void writeToLog(int successfulEntries, int badEntries, int totalEntries) throws IOException {

            Logger logger = Logger.getLogger(LogManager.class.getName());

            FileHandler fileHandler = new FileHandler("app.log", true);
            logger.addHandler(fileHandler);

            if (logger.isLoggable(Level.INFO)) {
                logger.info("#" + successfulEntries + "successful entries \n" +
                        "#" + badEntries + "bad entries \n" +
                        "#" + totalEntries + "total entries");
            }

        }

}
