import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import student.Student;
import student.StudentManagementSystem;

public class StudentManagementGUI extends JFrame {
    private final StudentManagementSystem system;
    private JTextArea textArea;
    private JTextField nameField, rollNumberField, gradeField;
    private JButton addButton, removeButton, searchButton, displayButton;

    public StudentManagementGUI() {
        system = new StudentManagementSystem();
        createUI();
    }

   private void createUI() {
        setTitle("Student Management System");
        setSize(600, 400);
        setMinimumSize(new Dimension(600, 400));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
     
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

      
        gbc.gridx = 0;
        gbc.gridy = 0;
        northPanel.add(new JLabel("Name:"), gbc);
        nameField = new JTextField(20);
        gbc.gridx = 1;
        northPanel.add(nameField, gbc);

        
        gbc.gridx = 0;
        gbc.gridy = 1;
        northPanel.add(new JLabel("Roll Number:"), gbc);
        rollNumberField = new JTextField(20);
        gbc.gridx = 1;
        northPanel.add(rollNumberField, gbc);

        
        gbc.gridx = 0;
        gbc.gridy = 2;
        northPanel.add(new JLabel("Grade:"), gbc);
        gradeField = new JTextField(20);
        gbc.gridx = 1;
        northPanel.add(gradeField, gbc);

       
        addButton = new JButton("Add Student");
        gbc.gridx = 0;
        gbc.gridy = 3;
        northPanel.add(addButton, gbc);

        removeButton = new JButton("Remove Student");
        gbc.gridx = 1;
        northPanel.add(removeButton, gbc);

        searchButton = new JButton("Search Student");
        gbc.gridx = 0;
        gbc.gridy = 4;
        northPanel.add(searchButton, gbc);

        displayButton = new JButton("Display All Students");
        gbc.gridx = 1;
        northPanel.add(displayButton, gbc);

        add(northPanel, BorderLayout.NORTH);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

     
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAddStudent();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleRemoveStudent();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSearchStudent();
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleDisplayAllStudents();
            }
        });
    }

    private void handleAddStudent() {
        String name = nameField.getText().trim();
        String rollNumber = rollNumberField.getText().trim();
        String grade = gradeField.getText().trim();
        if (name.isEmpty() || rollNumber.isEmpty() || grade.isEmpty()) {
            textArea.setText("All fields are required.");
        } else {
            system.addStudent(new Student(name, rollNumber, grade));
            textArea.setText("Student added successfully.");
            clearFields();
        }
    }

    private void handleRemoveStudent() {
        String rollNumber = rollNumberField.getText().trim();
        if (rollNumber.isEmpty()) {
            textArea.setText("Roll number is required.");
        } else {
            system.removeStudent(rollNumber);
            textArea.setText("Student removed successfully.");
            clearFields();
        }
    }

    private void handleSearchStudent() {
        String rollNumber = rollNumberField.getText().trim();
        if (rollNumber.isEmpty()) {
            textArea.setText("Roll number is required.");
        } else {
            Student student = system.searchStudent(rollNumber);
            if (student != null) {
                textArea.setText(student.toString());
            } else {
                textArea.setText("Student not found.");
            }
        }
    }

    private void handleDisplayAllStudents() {
        List<Student> students = system.getAllStudents();
        if (students.isEmpty()) {
            textArea.setText("No students to display.");
        } else {
            StringBuilder sb = new StringBuilder();
            students.stream().forEach((student) -> {
                sb.append(student).append("\n");
            });
            textArea.setText(sb.toString());
        }
    }

    private void clearFields() {
        nameField.setText("");
        rollNumberField.setText("");
        gradeField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StudentManagementGUI().setVisible(true);
        });
    }
}
