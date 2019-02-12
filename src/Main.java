import java.util.ArrayList;
import java.util.List;

public class Main {


    public static List<cvsEntity> tableObjs = new ArrayList<cvsEntity>();

    public static void main(String[] args) {
        csvReader reader = new csvReader();
        reader.readFile();
    }

}
