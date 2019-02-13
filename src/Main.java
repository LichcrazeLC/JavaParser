
public class Main {

    public static void main(String[] args) {

        SQLiteManager dbManager = new SQLiteManager();

        dbManager.dropTable();
        dbManager.createTable();

        csvReader reader = new csvReader();
        reader.readFile();

    }

}
