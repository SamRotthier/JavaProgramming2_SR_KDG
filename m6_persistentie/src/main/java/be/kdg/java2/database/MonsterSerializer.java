package be.kdg.java2.database;

import be.kdg.java2.Model.Monsters;

import java.io.*;

public class MonsterSerializer {

    private final String FILENAME;

    public MonsterSerializer(String filename){
        FILENAME = filename;
    }

    public void serialize(Monsters monsters) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream("db/"+FILENAME);
             ObjectOutputStream out = new ObjectOutputStream(fileOut);){
            out.writeObject(monsters);
        }
    }

    public Monsters deserialize() throws IOException, ClassNotFoundException {
        Monsters monsters = null;
        try(FileInputStream fileIn = new FileInputStream("db/"+FILENAME);
            ObjectInputStream in = new ObjectInputStream(fileIn);) {
            monsters = (Monsters) in.readObject();
        }
        return monsters;
    }

}
