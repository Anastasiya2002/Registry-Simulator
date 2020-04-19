
import java.util.ArrayList;
import java.lang.Comparable;

// Make class Student implement the Comparable interface
// Two student objects should be compared by their name
public class Student implements Comparable<Student>
{
  private String name;
  private String id;
  public  ArrayList<CreditCourse> courses;
  
  
  public Student(String name, String id)
  {
	 this.name = name;
	 this.id = id;
	 courses   = new ArrayList<CreditCourse>();
  }
  
  public String getId()
  {
	  return id;
  }
  
  public String getName()
  {
	  return name;
  }
  
  // add a credit course to list of courses for this student
  public void addCourse(String courseName, String courseCode, String descr, String format,String sem, double grade)
  {
	  // create a CreditCourse object
	  // set course active
    // add to courses array list
    CreditCourse course = new CreditCourse(courseName,courseCode,descr,format,sem,grade);
    course.setActive();
    courses.add(course);
  }
  
  
  
  // Prints a student transcript
  // Prints all completed (i.e. non active) courses for this student (course code, course name, 
  // semester, letter grade
  // see class CreditCourse for useful methods
  public void printTranscript()
  {
    //iterates through an array list of objects
	  for(CreditCourse course : this.courses){
      //checks if the course is not active
      if(!course.getActive()){
        System.out.println(course.displayGrade());
      }
    }
  }
  
  // Prints all active courses this student is enrolled in
  // see variable active in class CreditCourse
  public void printActiveCourses()
  {
    for(CreditCourse course : this.courses){
      //checks if course is active
      if(course.getActive()){
        System.out.println(course.getDescription());
      }
    }
	 
  }
  
  // Drop a course (given by courseCode)
  // Find the credit course in courses arraylist above and remove it
  // only remove it if it is an active course
  public void removeActiveCourse(String courseCode)
  {
    //finds a course in credit course by its course code
    CreditCourse tmp = null;
	  for(CreditCourse course : this.courses){
      if(course.getCode().equals(courseCode) && course.getActive()){
         tmp = course;
      }
    }
    if(tmp != null){
      this.courses.remove(tmp);
    }
  }
  
  public String toString()
  {
	  return "Student ID: " + id + " Name: " + name;
  }
  
  // override equals method inherited from superclass Object
  // if student names are equal *and* student ids are equal (of "this" student
  // and "other" student) then return true
  // otherwise return false
  // Hint: you will need to cast other parameter to a local Student reference variable
  
  public boolean equals(Object other)
  {
    Student otherStudent = (Student) other;
    return this.name.equals(otherStudent.name) && this.id.equals(otherStudent.id); 
  }

  public int compareTo(Student other){
    Student otherStudent = (Student) other;
    return this.getName().compareTo(otherStudent.getName());
  }
  
}
