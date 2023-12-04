package be.kdg.java2.logging;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class SmallLogFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        LocalDateTime ldt = LocalDateTime.ofInstant(record.getInstant(), ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        ldt.format(formatter);
        String message = MessageFormat.format(record.getMessage(), record.getParameters());
        return String.format("%s Level: %s melding: \"%s\"%n", ldt.format(formatter), record.getLevel(), message);
    }
}
