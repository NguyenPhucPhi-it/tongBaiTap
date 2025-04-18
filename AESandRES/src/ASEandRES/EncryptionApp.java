package ASEandRES;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class EncryptionApp extends JFrame {
    private JTextArea inputArea, resultArea;
    private JButton aesButton, rsaButton;
    private JPanel buttonPanel, mainPanel;

    public EncryptionApp() {
        setTitle("Mã hóa & Giải mã - AES & RSA");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Khung nhập liệu
        inputArea = new JTextArea( 5, 50);
        inputArea.setLineWrap(true);
        JScrollPane inputScroll = new JScrollPane(inputArea);
        inputScroll.setBorder(BorderFactory.createTitledBorder("Dữ liệu đầu vào"));

        // Kết quả hiển thị
        resultArea = new JTextArea(10, 50);
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        JScrollPane resultScroll = new JScrollPane(resultArea);
        resultScroll.setBorder(BorderFactory.createTitledBorder("Kết quả"));

        // Nút AES & RSA
        aesButton = new JButton("Mã hóa/Giải mã bằng AES");
        rsaButton = new JButton("Mã hóa/Giải mã bằng RSA");

        aesButton.addActionListener(this::handleAES);
        rsaButton.addActionListener(this::handleRSA);

        // Panel chứa nút
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(aesButton);
        buttonPanel.add(rsaButton);

        // Panel chính
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.add(inputScroll, BorderLayout.NORTH);
        mainPanel.add(resultScroll, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void handleAES(ActionEvent e) {
        resultArea.setText("Đang xử lý bằng AES...\n");
        new Thread(() -> {
            try {
                String input = inputArea.getText();
                AESEncryption aes = new AESEncryption();
                String encrypted = aes.encrypt(input);
                String decrypted = aes.decrypt(encrypted);
                SwingUtilities.invokeLater(() -> {
                    resultArea.setText("=== Kết quả AES ===\n");
                    resultArea.append("Mã hóa:\n" + encrypted + "\n\n");
                    resultArea.append("Giải mã:\n" + decrypted);
                });
            } catch (Exception ex) {
                resultArea.setText("Lỗi AES: " + ex.getMessage());
            }
        }).start();
    }

    private void handleRSA(ActionEvent e) {
        resultArea.setText("Đang xử lý bằng RSA...\n");
        new Thread(() -> {
            try {
                String input = inputArea.getText();
                RSAEncryption rsa = new RSAEncryption();
                String encrypted = rsa.encrypt(input);
                String decrypted = rsa.decrypt(encrypted);
                SwingUtilities.invokeLater(() -> {
                    resultArea.setText("=== Kết quả RSA ===\n");
                    resultArea.append("Mã hóa:\n" + encrypted + "\n\n");
                    resultArea.append("Giải mã:\n" + decrypted);
                });
            } catch (Exception ex) {
                resultArea.setText("Lỗi RSA: " + ex.getMessage());
            }
        }).start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EncryptionApp app = new EncryptionApp();
            app.setVisible(true);
        });
    }
}

