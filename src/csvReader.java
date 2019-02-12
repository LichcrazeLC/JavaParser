import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class csvReader {


    String csvFile = "/Users/tekwill/Desktop/csvTable.csv";
    BufferedReader br = null;

    public void readFile(){

        String line = "";
        int lineCounter = 0;

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                String[] row = line.split(",");
                lineCounter++;

                for (int i = 0; i < row.length; i++) {
                    System.out.println();
                    System.out.println("line nr " + lineCounter + " / value nr " + i + ": " + row[i]);
                }

                SQLiteManager sqlManag = new SQLiteManager();
                sqlManag.insertRow(row);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

