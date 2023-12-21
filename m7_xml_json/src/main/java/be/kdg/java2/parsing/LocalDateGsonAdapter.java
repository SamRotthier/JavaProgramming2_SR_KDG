package be.kdg.java2.parsing;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDate;

public class LocalDateGsonAdapter extends TypeAdapter<LocalDate> {

    public void write(final JsonWriter jsonWriter,
                      final LocalDate localDate) throws IOException {
        jsonWriter.value(localDate.toString());
    }

    public LocalDate read(final JsonReader jsonReader)
            throws IOException {
        return LocalDate.parse(jsonReader.nextString());
    }

}
