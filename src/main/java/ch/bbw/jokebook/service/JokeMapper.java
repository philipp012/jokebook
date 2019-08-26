package ch.bbw.jokebook.service;

import ch.bbw.jokebook.model.Joke;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JokeMapper {
    public static Joke createJokeObject(ResultSet entry) throws SQLException {
        Joke tmpJoke = new Joke();
        mapJokeData(tmpJoke, entry);
        return tmpJoke;
    }

    private static void mapJokeData(Joke joke, ResultSet entry) throws SQLException {
        joke.setId(entry.getInt("id"));
        joke.setText(entry.getString("text"));
        joke.setRating(entry.getInt("rating"));
        joke.setDate(entry.getDate("date"));
    }
}
