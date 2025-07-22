import java.util.Scanner;

public class TranformText {
    private static final double PROGRESS_STEP=0.5;
    private static final int PROGRESS_BAR_LENGTH = 10;
    private final static double PROGRESS_MAC_VALUE=100;
    private final static  String PROGRSS_BAR_SYMBOL="#";
    private final static String PRINT_FORMAT="Wczytywanie %c %5.2f%% (%-"+PROGRESS_BAR_LENGTH+"s)\r";

    public static void main(String[] args) {
        double progres=0.0;
        for (int i = 0; progres<=PROGRESS_MAC_VALUE; i++) {
            char progrsIndicator=i%2==0? '/':'\\';
            String progressBar=getProgressBar(progres);
            progres=i*PROGRESS_STEP;
            System.out.printf(PRINT_FORMAT, progrsIndicator, progres, progressBar);
            pause();

        }
    }

    private static String getProgressBar(double progres) {
        double progressBarStep=PROGRESS_MAC_VALUE/PROGRESS_BAR_LENGTH;
        int numberOfDots=(int)(progres/progressBarStep);
        return PROGRSS_BAR_SYMBOL.repeat(numberOfDots);
    }

    private static void pause() {
        try {
            Thread.sleep(200);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
