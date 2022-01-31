package movietheatres;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.*;

public class MovieTheatreService {
    Map<String, List<MoviesInTheaters>> shows = new HashMap();

    public void readFromFile(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String[] elements;
            String line;
            while ((line = br.readLine()) != null) {
                elements = line.split("-");
                String theatre = elements[0];
                elements = elements[1].split(";");
                String movie = elements[0];
                elements = elements[1].split(":");
                LocalTime time = LocalTime.of(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]));
                if (!shows.containsKey(theatre)) {
                    shows.put(theatre, List.of(new MoviesInTheaters()));
                } else {
                    shows.get(theatre);
                }
            }
        } catch (
                IOException ioe) {
            throw new IllegalStateException("File beolvasási hiba", ioe);
        }
    }

    public Map<String, List<MoviesInTheaters>> getShows() {
        return shows
    }
}
