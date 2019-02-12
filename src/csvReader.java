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
        int badlineCounter = 0;
        int goodlineCounter = 0;


        try {

            br = new BufferedReader(new FileReader(csvFile));
            SQLiteManager sqlManag = new SQLiteManager();

            while ((line = br.readLine()) != null) {

                String[] row = line.split(",");
                boolean goodRecord = true;

                for (int i = 0; i < row.length; i++) {

                    if (row[i].equals("") || row[i] == null)
                        goodRecord = false;

                    System.out.println("line nr " + lineCounter + " / value nr " + i + ": " + row[i]);

                }

                if(goodRecord) {
                    sqlManag.insertRow(row);
                    goodlineCounter++;
                } else {
                    badlineCounter++;
                }

                lineCounter++;

            }

            try {
                LogManager.writeToLog(goodlineCounter, badlineCounter, lineCounter);
            } catch (IOException e) {
                e.printStackTrace();
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

