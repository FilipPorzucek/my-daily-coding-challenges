import java.util.Random;

public class Dice {
    private final static Random  RANDOM=new Random();
  private final static String[] SIDES={
          """
                   --------
                 |         | 
                 |    0    |
                 |         |
                  --------
""",
          """
                  --------
                 |        0| 
                 |         |
                 |0        |
                  --------
""",
          """
                  --------
                 |0       0| 
                 |         |
                 |0        |
                  --------
""","""
                  --------
                 |0       0| 
                 |         |
                 |0      0 |
                  --------
""","""
                   --------
                 |0       0| 
                 |    0    |
                 |0      0 |
                  --------
""","""
                   --------
                 |0   0   0| 
                 |         |
                 |0  0   0 |
                  --------
"""

  };
  static String roll(){
int side=RANDOM.nextInt(SIDES.length);
return  SIDES[side];
  }
}
