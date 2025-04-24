package view;

import model.Student;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.*;

public class StudentStreamGUI extends JFrame {
    private JTextArea resultArea;
    private List<Student> students;

    public StudentStreamGUI() {
        setTitle("Student Stream Demo");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        students = Arrays.asList(
            new Student("An", 45),
            new Student("Bình", 78),
            new Student("Chi", 90),
            new Student("Dũng", 62),
            new Student("Hà", 49)
        );

        resultArea = new JTextArea(10, 40);
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Arial", Font.PLAIN, 14));

        JButton btnBai1 = new JButton("Bài 1 - Điểm cao nhất");
        JButton btnBai2 = new JButton("Bài 2 - Điểm trung bình");
        JButton btnBai3 = new JButton("Bài 3 - Phân loại Pass/Fail");

        btnBai1.addActionListener(e -> showMaxScoreStudent());
        btnBai2.addActionListener(e -> showAverageScore());
        btnBai3.addActionListener(e -> showGroupedStudents());

        JPanel panel = new JPanel(new GridLayout(1, 3, 10, 10));
        panel.add(btnBai1);
        panel.add(btnBai2);
        panel.add(btnBai3);

        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Kết quả"));

        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void showMaxScoreStudent() {
        Student topStudent = students.stream()
            .max(Comparator.comparingInt(Student::getScore))
            .orElse(null);
        if (topStudent != null) {
            resultArea.setText("Học sinh điểm cao nhất:\n" + topStudent);
        }
    }

    private void showAverageScore() {
        double avg = students.stream()
            .mapToInt(Student::getScore)
            .average()
            .orElse(0);
        resultArea.setText("Điểm trung bình của lớp: " + String.format("%.2f", avg));
    }

    private void showGroupedStudents() {
        Map<String, List<Student>> map = students.stream()
            .collect(Collectors.groupingBy(s -> s.getScore() >= 50 ? "Pass" : "Fail"));

        StringBuilder sb = new StringBuilder();
        sb.append("Pass:\n");
        map.getOrDefault("Pass", new ArrayList<>()).forEach(s -> sb.append(s).append("\n"));
        sb.append("Fail:\n");
        map.getOrDefault("Fail", new ArrayList<>()).forEach(s -> sb.append(s).append("\n"));

        resultArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentStreamGUI().setVisible(true));
    }
}
