import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Active University Course
//Anastasiya Yutsevych 500939747
 
public class ActiveCourse extends Course
{
	private ArrayList<Student> students; 
   private String             semester;
   private int lectureStart;
   private int lectureDuration;
   private String lectureDay;
	
	   
   // Add a constructor method with appropriate parameters
   // should call super class constructor to initialize inherited variables
   // make sure to *copy* students array list being passed in into new arraylist of students
   // see class Registry to see how an ActiveCourse object is created and used
   public ActiveCourse(String name, String code, String descr, String fmt,String semester,ArrayList<Student> students)
   {
      super(name,code,descr,fmt);
      this.students = new ArrayList<Student>(students);
      this.semester = semester;
   }

   public void setStart(int start){
      lectureStart = start;
   }

   public void setDuration(int duration){
      lectureDuration = duration;
   }

   public void setDay(String day){
      lectureDay = day;
   }

   public int getStart(){
      return lectureStart;
   }

   public int getDuration(){
      return lectureDuration;
   }

   public String getDay(){
      return lectureDay;
   }


   //method to remove a student
   public void removeStudent(Student student){
      students.remove(student);
   }

   public ArrayList<Student> getStudents(){
      return this.students;
   }
   public void setStudents(ArrayList<Student> students){
      this.students = students;
   }

   public String getSemester()
   {
	   return this.semester;
   }
   
   // Prints the students in this course  (name and student id)
   public void printClassList()
   {
	   for(Student student : students){
          System.out.println("Student ID: " + student.getId()+ " Name: " +student.getName());
      }
   }
   
   // Prints the grade of each student in this course (along with name and student id)
   // 
   public void printGrades()
   {
	  for(Student student : students){
        System.out.println(student.getName()+ " " + student.getId() + " " + getGrade(student.getId()));
     }
   }
   
   // Returns the numeric grade in this course for this student
   // If student not found in course, return 0 
   public double getGrade(String studentId)
   {
	  // Search the student's list of credit courses to find the course code that matches this active course
	  // see class Student method getGrade() 
     // return the grade stored in the credit course object
     
     //finds a student and a course to find a grade
     for(Student student : students){
        if(student.getId().equals(studentId)){
           for(CreditCourse creditCourse : student.courses){
              if(creditCourse.getCode().equals(this.getCode())){
                 return creditCourse.grade;
              }
           }
        }
     }
	  return 0; 
   }
   
   // Returns a String containing the course information as well as the semester and the number of students 
   // enrolled in the course
   // must override method in the superclass Course and use super class method getDescription()
   public String getDescription()
   {
      return super.getDescription() +" " +semester + " Enrolment " + students.size();
      
   }
    
   
   
   
   // Sort the students in the course by name using the Collections.sort() method with appropriate arguments
   // Make use of a private Comparator class below
   public void sortByName()
   {
 	  Collections.sort(students, new NameComparator());
   }
   
   // Fill in the class so that this class implement the Comparator interface
   // This class is used to compare two Student objects based on student name
   private class NameComparator implements Comparator<Student>
   {
      public int compare(Student a,Student b){
         return a.getName().compareTo(b.getName());
       }
   }
   
   // Sort the students in the course by student id using the Collections.sort() method with appropriate arguments
   // Make use of a private Comparator class below
   public void sortById()
   {
 	  Collections.sort(students, new IdComparator());
   }
   
   // Fill in the class so that this class implement the Comparator interface
   // This class is used to compare two Student objects based on student id
   private class IdComparator implements Comparator<Student>
   {
      public int compare(Student a, Student b){
         return a.getId().compareTo(b.getId());
      }
   	
   }

}
