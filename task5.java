//Student course registration system

//Import library
import java.util.*;

//class for courses
class Course 
{
    //variable of course class
    String code;
    String title;
    String description;
    int capacity;
    int enrolledStudents;
    List<String> schedule;

    // Constructor of course
    public Course(String code, String title, String description, int capacity, List<String> schedule) 
    {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.enrolledStudents = 0;
    }
}

//class for students
class Student 
{
    //variable of student class
    String id;
    String name;
    List<Course> registeredCourses;

    // Constructor of student
    public Student(String id, String name) 
    {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }
}

//main class
public class task5
{
    //variable for main class
    static Map<String, Course> courses = new HashMap<>();
    static Map<String, Student> students = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) 
    {
        initializeCourses();
        initializeStudents();

        //choice interface running in loop until you choose exit
        boolean running = true;
        while (running) 
        {
            System.out.println("\nCourse Registration System");
            System.out.println("1. Display Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. Display Databases");
            System.out.println("5. Add Student");
            System.out.println("6. Add Course");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) 
            {
                case 1:
                    displayCourses();
                    break;
                case 2:
                    registerForCourse();
                    break;
                case 3:
                    dropCourse();
                    break;
                case 4:
                    displayDatabases();
                    break;
                case 5:
                    addStudent();
                    break;
                case 6:
                    addCourse();
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    //function for default courses
    static void initializeCourses() 
    {
        courses.put("CS101", new Course("CS101", "Introduction to Computer Science", "Basic concepts of computer science", 50, List.of("Mon 10:00 AM", "Wed 10:00 AM")));
        courses.put("MATH201", new Course("MATH201", "Calculus I", "Differential and integral calculus", 60, List.of("Tue 2:00 PM", "Thu 2:00 PM")));
        courses.put("ENG301", new Course("ENG301", "Technical Writing", "Professional writing for technical fields", 40, List.of("Fri 9:00 AM")));
    }

    //function for default students
    static void initializeStudents() 
    {
        students.put("S001", new Student("S001", "John Doe"));
        students.put("S002", new Student("S002", "Jane Smith"));
        students.put("S003", new Student("S003", "Bob Johnson"));
    }

    //function for display courses 
    static void displayCourses() 
    {
        System.out.println("\nAvailable Courses:");
        for (Map.Entry<String, Course> entry : courses.entrySet()) 
        {
            Course course = entry.getValue();
            System.out.println(course.code + " - " + course.title + " (" + (course.capacity - course.enrolledStudents) + " slots available)");
            System.out.println("Description: " + course.description);
            System.out.println("Schedule: " + String.join(", ", course.schedule));
            System.out.println();
        }
    }

    //function for registercourse
    static void registerForCourse() 
    {
        System.out.print("Enter your student ID: ");
        String studentId = sc.next();
        Student student = students.get(studentId);

        if (student == null) 
        {
            System.out.println("Invalid student ID!");
            return;
        }

        System.out.print("Enter the course code: ");
        String courseCode = sc.next();
        Course course = courses.get(courseCode);

        if (course == null) 
        {
            System.out.println("Invalid course code!");
            return;
        }

        if (course.enrolledStudents >= course.capacity) 
        {
            System.out.println("Course is full!");
            return;
        }

        if (student.registeredCourses.contains(course)) 
        {
            System.out.println("You are already registered for this course!");
            return;
        }

        student.registeredCourses.add(course);
        course.enrolledStudents++;
        System.out.println("Registration successful!");
    }

    //function for drop course
    static void dropCourse() 
    {
        System.out.print("Enter your student ID: ");
        String studentId = sc.next();
        Student student = students.get(studentId);

        if (student == null) 
        {
            System.out.println("Invalid student ID!");
            return;
        }

        System.out.print("Enter the course code: ");
        String courseCode = sc.next();
        Course course = courses.get(courseCode);

        if (course == null) 
        {
            System.out.println("Invalid course code!");
            return;
        }

        if (!student.registeredCourses.contains(course)) 
        {
            System.out.println("You are not registered for this course!");
            return;
        }

        student.registeredCourses.remove(course);
        course.enrolledStudents--;
        System.out.println("Course dropped successfully!");
    }

    //function for display student database in ascending order using studentid
    static void displayDatabases() 
    {
        System.out.println("\nStudent Database:");
        List<Student> studentList = new ArrayList<>(students.values());
        studentList.sort(Comparator.comparing(s -> s.id));

        for (Student student : studentList) 
        {
            System.out.println("Student ID: " + student.id + " - Name: " + student.name);
            System.out.println("Registered Courses:");
            if (student.registeredCourses.isEmpty()) 
            {
                System.out.println("No courses registered.");
            } 
            else 
            {
                for (Course course : student.registeredCourses) 
                {
                    System.out.println("- " + course.code + " - " + course.title);
                }
            }
            System.out.println();
        }
    }

    //function for you have to add student
    static void addStudent() 
    {
        System.out.print("Enter student ID: ");
        String id = sc.next();
        sc.nextLine();
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        if (students.containsKey(id)) 
        {
            System.out.println("Student ID already exists!");
            return;
        }

        Student student = new Student(id, name);
        students.put(id, student);
        System.out.println("Student added successfully!");
    }

    //function for you have to add course
    static void addCourse() 
    {
        System.out.print("Enter course code: ");
        String code = sc.next();
        sc.nextLine();
        System.out.print("Enter course title: ");
        String title = sc.nextLine();
        System.out.print("Enter course description: ");
        String description = sc.nextLine();
        System.out.print("Enter course capacity: ");
        int capacity = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        System.out.print("Enter course schedule (separated by commas): ");
        String scheduleInput = sc.nextLine();
        List<String> schedule = new ArrayList<>();
        for (String s : scheduleInput.split(",")) 
        {
            schedule.add(s.trim());
        }

        if (courses.containsKey(code)) 
        {
            System.out.println("Course code already exists!");
            return;
        }

        Course course = new Course(code, title, description, capacity, schedule);
        courses.put(code, course);
        System.out.println("Course added successfully!");
    }
}