import java.util.Scanner;

public class opa {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Wpisz napis");
        String wpis=scanner.nextLine();

       int digits= countDigits(wpis);
        System.out.println("Liczba cyfr w tekscie to"+digits);
        int letters=countLetters(wpis);
        System.out.println("Liczba liter w tekscie to"+letters);
        try {
            int biggestDigitInText = findBiggestDigit(wpis);
            System.out.println("Najweksza liczba to"+biggestDigitInText);
        }catch (DigitNotFoundException e){
            System.out.println("Brak cyfey w tekscie");
        }


    }

    private static int findBiggestDigit(String wpis) {
        char[] chars=wpis.toCharArray();
        final int notFound=-1;
        int biggestNumber=notFound;
        for (char aChar : chars) {
            if(Character.isDigit(aChar)){
               int digit= Character.getNumericValue(aChar);
               Integer.max(biggestNumber,digit);
            }
        }
        if(biggestNumber==notFound){
            throw new DigitNotFoundException();
        }
        return biggestNumber;
    }

    private static int countLetters(String wpis) {
        char[] letter=wpis.toCharArray();
        int letters=0;
        for (char c : letter) {
            if(Character.isLetter(c)){
                letters++;
            }
        }
        return  letters;
    }

    private static int countDigits(String wpis) {
        char[] chars=wpis.toCharArray();
        int ddigits=0;
        for (char aChar : chars) {
            if(Character.isDigit(aChar)){
                ddigits++;
            }
        }
        return ddigits;
    }

    private static class DigitNotFoundException extends RuntimeException  {

    }
}
