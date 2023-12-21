package be.kdg.java2.parsing;

import be.kdg.java2.Model.Monsters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class MonstersGsonParser {
    public static void writeJson(Monsters monsters, String fileName) {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(LocalDate.class,
                new LocalDateGsonAdapter().nullSafe());
        Gson gson = builder.setPrettyPrinting().create();
        String jsonString = gson.toJson(monsters);
        try (FileWriter jsonWriter = new FileWriter(fileName)) {
            jsonWriter.write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Monsters readJson(String fileName) {
        Monsters monsters = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(LocalDate.class,
                    new LocalDateGsonAdapter().nullSafe());
            Gson gson = builder.setPrettyPrinting().create();
            monsters = gson.fromJson(reader, Monsters.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return monsters;
    }
}
