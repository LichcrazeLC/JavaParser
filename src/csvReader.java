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

                cvsEntity newObj = new cvsEntity(row[0], row[1], row[2], row[3], row[4], row[5],
                                                row[6], row[7], row[8], row[9]);

                Main.tableObjs.add(newObj);

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

