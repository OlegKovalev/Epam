package se03.task1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CrazyLogger {

    private StringBuilder logger;

    public CrazyLogger() {
        logger = new StringBuilder();
    }

    public String getLogger() {
        return logger.toString();
    }

    public void addInformation(Object message) {
        String s = new SimpleDateFormat("dd-MM-YYYY : HH-mm").format(Calendar.getInstance().getTime());
        logger.append(s + " " + message.toString() + "\n");
    }

    public void logInput(InputStream inStream) {
        try {
            addInformation(inStream.read());
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    public OutputStream findInfo(String msg, OutputStream outStream) {
        String[] lines = getLogger().split("\n");

        try {
            for (String line : lines) {
                if (line.contains("msg")) {
                    outStream.write(line.getBytes(StandardCharsets.UTF_8));
                }
            }
            outStream.flush();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        return outStream;
    }
}
