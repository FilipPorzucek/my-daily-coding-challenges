public class Main {
    public static void main(String[] args) {
        int wysokosc = 5; // Wysokość piramidy

        for (int i = 1; i <= wysokosc; i++) {
            // Drukowanie spacji przed gwiazdkami
            for (int j = 1; j <= (wysokosc - i); j++) {
                System.out.print(" ");
            }

            // Drukowanie gwiazdek
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }

            System.out.println(); // Przejście do nowej linii
        }
    }
}
