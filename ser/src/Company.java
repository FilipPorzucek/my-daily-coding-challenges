import java.io.Serializable;
import java.util.Arrays;

public class Company implements Serializable {
public static final int MAX_EMPYES=3;
    Empluyee[] empluyees=new Empluyee[MAX_EMPYES];
    private int index=0;

   public void add(Empluyee empluyee){
    empluyees[index]=empluyee;
    index++;
    }

    @Override
    public String toString() {
       StringBuilder builder=new StringBuilder();
        for (Empluyee empluyee : empluyees) {
            builder.append(empluyee.toString());
            builder.append("\n");
        }
        return builder.toString();
    }
}
