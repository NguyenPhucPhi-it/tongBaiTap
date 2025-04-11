package baiTapHash;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainApp extends JFrame {
    private List<User> users = new ArrayList<>();

    public MainApp() {
        setTitle("Ứng dụng Quản lý Người dùng");
        setSize(400, 300);
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("Quản lý người dùng", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        mainPanel.add(title, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        JButton registerBtn = new JButton("➕  Đăng ký người dùng");
        JButton loginBtn = new JButton("🔐  Đăng nhập");
        JButton exportBtn = new JButton("📤  Xuất XML");
        JButton importBtn = new JButton("📥  Nhập XML");

        buttonPanel.add(registerBtn);
        buttonPanel.add(loginBtn);
        buttonPanel.add(exportBtn);
        buttonPanel.add(importBtn);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        add(mainPanel);

        registerBtn.addActionListener(e -> showRegisterDialog());
        loginBtn.addActionListener(e -> showLoginDialog());
        exportBtn.addActionListener(e -> XMLUtils.exportUsers(users));
        importBtn.addActionListener(e -> {
            users = XMLUtils.importUsers();
            JOptionPane.showMessageDialog(this, "Đã nhập " + users.size() + " người dùng.");
            showUserListDialog(users);
        });
    }

    private void showRegisterDialog() {
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        Object[] message = {
                "Tên người dùng:", usernameField,
                "Mật khẩu:", passwordField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Đăng ký", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin.");
                return;
            }

            String hashed = AuthUtils.hashPassword(password);
            users.add(new User(username, hashed));
            JOptionPane.showMessageDialog(this, "Đăng ký thành công!");
        }
    }

    private void showLoginDialog() {
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        Object[] message = {
                "Tên người dùng:", usernameField,
                "Mật khẩu:", passwordField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Đăng nhập", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            for (User user : users) {
                if (user.getUsername().equals(username)
                        && AuthUtils.checkPassword(password, user.getHashedPassword())) {
                    JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Sai tên đăng nhập hoặc mật khẩu!");
        }
    }

    private void showUserListDialog(List<User> importedUsers) {
        if (importedUsers.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Danh sách người dùng trống.");
            return;
        }

        StringBuilder sb = new StringBuilder("📋 Danh sách người dùng:\n\n");
        for (User user : importedUsers) {
            sb.append("👤 ").append(user.getUsername()).append("\n");
        }

        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(300, 200));

        JOptionPane.showMessageDialog(this, scrollPane, "Danh sách người dùng", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainApp().setVisible(true));
    }
}
