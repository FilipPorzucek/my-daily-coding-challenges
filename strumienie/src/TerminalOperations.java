import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TerminalOperations {
    public static void main(String[] args) {
        Stream<EqualOfMatch> matches = generate();
        sortedMatches(matches);
        System.out.println("Wszystkie mecze Lecha");
        Stream<EqualOfMatch> matches2 = generate();
        printMatchwithTeam(matches2,"Lech").forEach(System.out::println);

        Stream<EqualOfMatch> matches3 = generate();
        System.out.println("Liczba druzyn w turnieju" +countDistincTeams(matches3));


        Stream<EqualOfMatch> matches4 = generate();
        System.out.println("Liczba goli w turnieju"+numberOfGoals(matches4));
    }

    private static int numberOfGoals(Stream<EqualOfMatch> matches4) {
        return matches4.mapToInt(EqualOfMatch::getGoalsSum)
                .sum();

    }

    private static long countDistincTeams(Stream<EqualOfMatch> matches3) {

return
        matches3.map(EqualOfMatch::getTeamNames)
                .flatMap(Arrays::stream)
                .distinct()
                .count();

    }

    private static Stream<EqualOfMatch> generate() {
        Stream<EqualOfMatch> matches = Stream.of(
                new EqualOfMatch("FC Barcelona", "Real Madryt", 5, 3),
                new EqualOfMatch("Athletico", "Liverpool", 3, 2),
                new EqualOfMatch("City", "PSG", 1, 2),
                new EqualOfMatch("Lech", "Legia", 1, 3),
                new EqualOfMatch("Chelsea", "Bilbao", 2, 1)

        );
        return matches;
    }

    private static void sortedMatches(Stream<EqualOfMatch> matches) {
        Stream<EqualOfMatch> sorted = matches.sorted((m1, m2) -> Integer.compare(m2.getNumberOfHostsGoals(), m1.getNumberOfHostsGoals()));
        sorted.forEach(System.out::println);
    }

    private static List<EqualOfMatch> printMatchwithTeam(Stream<EqualOfMatch> matches,String team) {
        return matches
                .filter(m->m.containsTeam(team))
                .collect(Collectors.toList());

    }
}
