## Student Management System

A simple console-based Student Management System implemented in Java. This application allows users to manage a collection of students by adding, removing, searching, and displaying student information. Data is stored in a text file for persistence between application runs.

### Features

- **Add Student**: Add a new student with details like name, roll number, and grade.
- **Remove Student**: Remove a student using their roll number.
- **Search Student**: Search for a student by roll number.
- **Display All Students**: List all students currently in the system.
- **File Storage**: Student data is saved to and loaded from a text file.

### Setup Instructions

1. **Clone the Repository**
   ```bash
   git clone https://github.com/yshivangi36/student-management-system.git
   cd student-management-system
   ```

2. **Compile the Java Files**
   ```bash
   javac Student.java StudentManagementSystem.java Main.java
   ```

3. **Run the Application**
   ```bash
   java Main
   ```

##Example
#### Initial Menu Display
```plaintext
Student Management System
1. Add Student
2. Remove Student
3. Search Student
4. Display All Students
5. Exit
Choose an option: 
```

#### Adding a New Student
```plaintext
Choose an option: 1
Enter name: Alice Johnson
Enter roll number: A123
Enter grade: A
Student added successfully.
```

#### Displaying All Students
```plaintext
Choose an option: 4
Name: Alice Johnson, Roll Number: A123, Grade: A
```

#### Exiting the System
```plaintext
Choose an option: 5
Exiting...
```
