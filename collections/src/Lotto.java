import java.util.*;

public class Lotto {

  private static final int NO_OF_NUMBERS = 49;
  public static final int MAX_NUMBERS = 6;

  private List<Integer> numbers = new ArrayList<>();


  Lotto() {
    generate();
    randomize();
  }

  public void generate() {
    for (int i = 1; i < NO_OF_NUMBERS; i++) {
      numbers.add(i);
    }
  }

  void randomize() {
    Collections.shuffle(numbers);
  }

  int checkResults(List<Integer> userNumbers) {
    List<Integer> lottoResult = numbers.subList(0, 6);

  int found=0;
  for (int i=0;i<MAX_NUMBERS;i++){
    if(lottoResult.contains(userNumbers.get(i)))
      found++;

  }
  return found;
  }

}
