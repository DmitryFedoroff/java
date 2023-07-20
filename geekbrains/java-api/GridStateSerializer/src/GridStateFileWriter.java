import java.io.FileOutputStream;
import java.io.IOException;

public class GridStateFileWriter {
    public void writeToFile(int serializedState, String fileName) {
        try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
            outputStream.write((serializedState >> 16) & 0xFF);
            outputStream.write((serializedState >> 8) & 0xFF);
            outputStream.write(serializedState & 0xFF);
            System.out.println("Grid state has been successfully written to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing the grid state to the file.");
            e.printStackTrace();
        }
    }
}
