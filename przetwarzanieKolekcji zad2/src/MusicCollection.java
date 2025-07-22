import java.util.List;
import java.util.stream.Collectors;

class MusicCollection {
    public static void main(String[] args) {
        List<Song> songs = List.of(
                new Song("Nothing Else Matters", 386, "Metallica", Song.Genre.METAL),
                new Song("No One", 248, "Alicia Keys", Song.Genre.POP),
                new Song("Nothing Else Matters", 386, "Metallica", Song.Genre.METAL),
                new Song("Believer", 216, "Imagine Dragons", Song.Genre.ROCK),
                new Song("Fear of The Dark", 438, "Iron Maiden", Song.Genre.METAL),
                new Song("Enter Sandman", 346, "Metallica", Song.Genre.METAL),
                new Song("The Unforgiven", 348, "Metallica", Song.Genre.METAL),
                new Song("Girl on Fire", 404, "Alicia Keys", Song.Genre.POP)
        );

        int time = timeOfMusicFromGenre(songs, Song.Genre.POP);
        System.out.println("Łaczny czas muzyki tego gatunku w liscie to"+time);

        long artist = numberOfSongFromArtist(songs, "Alicia Keys");
        System.out.println("Ilośc piosenek tego artysty w liscie to"+artist);

        List<Song> songsWithoutRock = distincListwithoutGenre(songs, Song.Genre.METAL);
        System.out.println("Lista piosenek bez wskazanego gatunku"+songsWithoutRock);
    }

    private static List<Song> distincListwithoutGenre(List<Song> songs, Song.Genre genre) {
      return   songs.stream()
                .filter(s->!s.getGenre().equals(genre))
                .distinct()
                .collect(Collectors.toList());

    }

    private static long numberOfSongFromArtist(List<Song> songs,String artist) {
        long count = songs.stream()
                .filter(s -> s.getArtist().equals(artist))
                .count();


        return count;
    }

    private static int timeOfMusicFromGenre(List<Song> songs, Song.Genre genre) {
        int sum = songs.stream()
                .filter(s -> s.getGenre().equals(genre))
                .mapToInt(s -> s.getLength())
                .sum();

return sum;
    }

}