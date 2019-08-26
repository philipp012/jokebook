package ch.bbw.jokebook.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ch.bbw.jokebook.model.Joke;

@Service
public class DatabaseService {

    public DatabaseService() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Joke> getJokes() throws ClassNotFoundException, SQLException {
        JokeMapper jokeMapper = new JokeMapper();
        ArrayList<Joke> jokes = new ArrayList<>();
        // Driver class für MySql-Datenbank laden
        Class.forName("com.mysql.cj.jdbc.Driver");
// Verbindung zur Datenbank herstellen
        String connectionUrl = "jdbc:mysql://localhost/jokeDB?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Connection connection = DriverManager.getConnection(connectionUrl, "root", "");
// Sql Befehl aufbauen und ausführen
        Statement stmt = connection.createStatement();
        ResultSet entries = stmt.executeQuery("SELECT * FROM joke");
// alle Datensätze aus dem ResultSet auslesen und
// (Schritt 1) in einer ArrayList ablegen
        while (entries.next()) {
            jokes.add(jokeMapper.createJokeObject(entries));
        }
// alle verwendeten Objekte schliessen
        entries.close();
        stmt.close();
        connection.close();
        return jokes;
    }


    // TODO: CRUD Funktionen implementieren
    public Joke createJoke(String text) {
        // Hinweis: Der Service kümmert sich um das Datum der Erstellung und
        // initialisiert das Rating. Die Id des Datensatzes wird durch
        // die Datenbank (autoincrement) automatisch gesetzt.

        return null;
    }

    public Joke readJoke(int id) {
        // den Joke mit der entsprechenden Id laden und zurückgeben
        return null;
    }

    public Joke updateJoke(Joke joke) {
        // den Joke mit der entsprechenden Id löschen
        return joke;
    }

    public void deleteJoke(int id) {
        // den Joke mit der entsprechenden Id löschen
    }

}
