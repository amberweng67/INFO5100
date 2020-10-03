class Student {
    String name;
    String id;
    public Student(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

}

class Course {
    String name;
    int numberOfStudent;
    Student[] registedStudents;
    final static int MAX_NUMBER = 10;

    public Course(String name) {
        this.name = name;
        this.numberOfStudent = 0;
        this.registedStudents = new Student[MAX_NUMBER];
    }
    public Student[] getStudents() {
        return this.registedStudents;
    }
    public boolean isFull() {
        if (this.numberOfStudent == MAX_NUMBER) {
            return true;
        }
        return false;
    }

    public String getName() {
        return this.name;
    }
    public int getNumberOfStudent(){
        return this.numberOfStudent;
    }
    public void registerStudent(Student student) {
        if (!this.isFull()) {
            this.registedStudents[numberOfStudent] = student;
            this.numberOfStudent++;
        }
    }
}

class Test {
    public static void main(String[] args) {
        Course course = new Course("5100");
        Student student1 = new Student("student1", "1");
        Student student2 = new Student("student2", "2");
        Student student3 = new Student("student3", "3");
        course.registerStudent(student1);
        course.registerStudent(student2);
        course.registerStudent(student3);

        System.out.println(course.isFull());
        System.out.println(course.numberOfStudent);
        for (Student student: course.registedStudents) {
            if (student != null) {
                System.out.println(student.id);
            }
        }
    }
}

