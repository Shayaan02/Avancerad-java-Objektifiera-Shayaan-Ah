import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

class FilePanel extends JPanel {
    private final JButton chooseFileButton;
    private FileListener fileListener;

    public FilePanel() {
        chooseFileButton = new JButton("Choose File");
        chooseFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(FilePanel.this);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    if (fileListener != null) {
                        fileListener.fileSelected(selectedFile);
                    }
                }
            }
        });

        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(chooseFileButton);
    }

    public void setFileListener(FileListener listener) {
        this.fileListener = listener;
    }
}
