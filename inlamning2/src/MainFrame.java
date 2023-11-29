import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;  // Import ArrayList
import java.util.List;
import java.util.Collections;

public class MainFrame extends JFrame {
    private final FilePanel filePanel;
    private final DisplayPanel displayPanel;

    public MainFrame(String title) {
        super(title);
        setLayout(new BorderLayout());

        filePanel = new FilePanel();
        displayPanel = new DisplayPanel();

        add(filePanel, BorderLayout.NORTH);
        add(displayPanel, BorderLayout.CENTER);

        filePanel.setFileListener(new FileListener() {
            @Override
            public void fileSelected(File file) {
                try {
                    List<String> data = readDataFromFile(file);
                    displayPanel.displayData(data);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(MainFrame.this, "Error reading file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private List<String> readDataFromFile(File file) throws IOException {
        List<String> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            // Read and discard the header row
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
        }
        Collections.sort(data); // Sort the data alphabetically
        return data;
    }


}
