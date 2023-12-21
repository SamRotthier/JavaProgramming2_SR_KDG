package be.kdg.java2.parsing;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
    public LocalDate unmarshal(String s) throws Exception {
        return LocalDate.parse(s);
    }
    public String marshal(LocalDate date) throws Exception {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
