import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class FileWorker {
    public String[] readAllLines(String path) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            return br.lines().toArray(String[]::new);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void writeAllLines(String[] lines, String path) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            for(String line : lines)
                bw.append(line + '\n');
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
