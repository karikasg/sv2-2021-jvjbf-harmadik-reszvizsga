package streams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SongService {
    private List<Song> songs = new ArrayList<>();

    public void addSong(Song song) {
        songs.add(song);
    }

    public Optional<Song> shortestSong() {
        return songs.stream().min(Comparator.comparing(Song::getLength));
    }

    public List<Song> findSongByTitle(String title) {
        return songs.stream().filter(o -> o.getTitle().equals(title)).toList();
    }

    public boolean isPerformerInSong(Song title, String name) {
        return title.getPerformers().stream().anyMatch(o -> o.equals(name));
    }

    public List<String> titlesBeforeDate(LocalDate date) {
        return songs.stream().filter(o -> o.getRelease().isBefore(date)).map(Song::getTitle).toList();
    }
}
