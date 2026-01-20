// 8. For a programme (such as, BCSE), each Instructor has name and phone number. Each textbook 
// has a title, author name and publisher. Each course (that is, subject) has a course name, instructor and 
// text book.   
// • One can set the data for a textbook and view the same.   
// • One can view instructor information and set the information.   
// • One can set the course data and view the same.    
// Design and implement the classes. 
// Sajjad Ahmed Shaaz, 002410501093

class Instructor {
    String name;
    String phoneNumber;

    Instructor(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    
    void setInstructor(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    void viewInstructor() {
        System.out.println("Instructor Name: " + name);
        System.out.println("Instructor Phone Number: " + phoneNumber);
    }
}

class Textbook {
    String title, author, publisher;

    Textbook(String title, String author, String publisher) {
        this.title=title;
        this.author=author;
        this.publisher=publisher;
    }

    void setTextbook(String title, String author, String publisher) {
        this.title=title;
        this.author=author;
        this.publisher=publisher;
    }

    void viewTextbook() {
        System.out.println("Bool Title: " + title);
        System.out.println("Bool Author: " + author);
        System.out.println("Bool Publisher: " + publisher);
    }
}

class Course {
    String name;
    Instructor instructor;
    Textbook textbook;

    Course(String name, Instructor instructor, Textbook textbook) {
        this.name=name;
        this.instructor=instructor;
        this.textbook=textbook;
    }

    void viewCourse() {
        System.out.println("Course Name : "+name);
        instructor.viewInstructor();
        textbook.viewTextbook();
    }
}

public class Programme {

    public static void main(String[] args) {
        Instructor i=new Instructor("feynman", "9999999999");
        Textbook book=new Textbook("Feynman Lectures", "Feynman", "University Press");    
        Course course=new Course("Physics", i, book);
        course.viewCourse();        
    }
}
