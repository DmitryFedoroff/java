import java.io.File;

public class Main {
    public static void main(String[] args) {
        byte[] gridState = {1, 2, 0, 1, 2, 1, 0, 0, 3};
        int serializedState = serializeGridState(gridState);
        String fileName = "gridState.dat";
        GridStateFileWriter writer = new GridStateFileWriter();
        writer.writeToFile(serializedState, fileName);

        File file = new File(fileName);
        long fileSize = file.length();
        System.out.println("Size of the created file: " + fileSize + " bytes.");
    }

    private static int serializeGridState(byte[] gridState) {
        if (gridState == null || gridState.length != 9) {
            throw new IllegalArgumentException("Grid state should be an array of 9 elements.");
        }

        int serializedState = 0;

        for (int i = 0; i < gridState.length; i++) {
            if (gridState[i] < 0 || gridState[i] > 3) {
                throw new IllegalArgumentException("Each element should be in the range [0, 3].");
            }
            serializedState |= (gridState[i] << (i * 2));
        }
        return serializedState;
    }
}
