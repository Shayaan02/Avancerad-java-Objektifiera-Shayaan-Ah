import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.List;

class DisplayPanel extends JPanel {
    private final JTextArea textArea;

    public DisplayPanel() {
        textArea = new JTextArea();
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
    }

    public void displayData(List<String> data) {
        Collections.sort(data);
        StringBuilder sb = new StringBuilder();
        for (String line : data) {
            sb.append(line).append("\n");
        }
        textArea.setText(sb.toString());
    }
}
