import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class csvWriter {

    private PrintWriter writer;

    public void createFile() {

        try {

            this.writer = new PrintWriter(new File("bad-data.csv"));

            StringBuilder sb = new StringBuilder();
            sb.append("A,");
            sb.append("B,");
            sb.append("C,");
            sb.append("D,");
            sb.append("E,");
            sb.append("F,");
            sb.append("G,");
            sb.append("H,");
            sb.append("I,");
            sb.append("J");

            writer.write(sb.toString());

            System.out.println("bad data csv file created!!");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    public void Write(String[] args) {

        StringBuilder sb = new StringBuilder();
        sb.append('\n');

        for (String s : args) {
            sb.append(s);
            sb.append(",");
        }

        sb.deleteCharAt(sb.length() - 1);

        this.writer.write(sb.toString());

        System.out.println("line inserted in bad data csv file!!");

    }

}


