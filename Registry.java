//Anastasiya Yutsevych 500939747
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.TreeMap;
import java.io.File ;

public class Registry 
{
   private TreeMap<String, Student>      students = new TreeMap<String,Student>();
   private TreeMap<String, ActiveCourse> courses  = new TreeMap<String, ActiveCourse>();
   
   public Registry() throws IOException, IllegalArgumentException
   {
	// Add some students
	   // in A2 we will read from a file
	   readFile();
       
	   /*Student s1 = new Student("JohnOliver", "34562");
	   Student s2 = new Student("HarryWindsor", "38467");
	   Student s3 = new Student("SophieBrown", "98345");
	   Student s4 = new Student("FaisalQuereshi", "57643");
	   Student s5 = new Student("GenghisKhan", "25347");
	   Student s6 = new Student("SherryTu", "46532");
	   students.add(s1);
	   students.add(s2);
	   students.add(s3);
	   students.add(s4);
	   students.add(s5);
	   students.add(s6);
	   */
	   
	   ArrayList<Student> list = new ArrayList<Student>();
	   
	   // Add some active courses with students
	   String courseName = "Computer Science II";
	   String courseCode = "CPS209";
	   String descr = "Learn how to write complex programs!";
	   String format = "3Lec 2Lab";
	   //list.add(s2); list.add(s3); list.add(s4);
	   Student s2 = students.get("38467");
	   Student s3 = students.get("98345");
	   Student s4 = students.get("57643");
	   if(s2!= null){list.add(s2);}
	   if(s3!= null){list.add(s3);}
	   if(s4!= null){list.add(s4);}
	   courses.put(courseCode,new ActiveCourse(courseName,courseCode,descr,format,"W2020",list));
	   // Add course to student list of courses
	   s2.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   s3.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   s4.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	  
	   // CPS511
	   list.clear();
	   courseName = "Computer Graphics";
	   courseCode = "CPS511";
	   descr = "Learn how to write cool graphics programs";
	   format = "3Lec";
	   //list.add(s1); list.add(s5); list.add(s6);
	   Student s1 = students.get("34562");
	   Student s5 = students.get("25347");
	   Student s6 = students.get("46532");
	   if(s1!= null){list.add(s1);}
	   if(s5!= null){list.add(s5);}
	   if(s6!= null){list.add(s6);}
	   courses.put(courseCode,new ActiveCourse(courseName,courseCode,descr,format,"F2020",list));
	   s1.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   s5.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   s6.addCourse(courseName,courseCode,descr,format,"W2020", 0);
	   
	   // CPS643
	   list.clear();
	   courseName = "Virtual Reality";
	   courseCode = "CPS643";
	   descr = "Learn how to write extremely cool virtual reality programs";
	   format = "3Lec 2Lab";
	   //list.add(s1); list.add(s2); list.add(s4); list.add(s6);
	   if(s1!= null){list.add(s1);}
	   if(s2!= null){list.add(s2);}
	   if(s4!= null){list.add(s4);}
	   if(s6!= null){list.add(s6);}

	   courses.put(courseCode,new ActiveCourse(courseName,courseCode,descr,format,"W2020",list));
	   s1.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   s2.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   s4.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   s6.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   
	   //CPS706
	   list.clear();
	   courseName = "Computer Networks";
	   courseCode = "CPS706";
	   descr = "Learn about Computer Networking";
	   format = "3Lec 1Lab";
	   courses.put(courseCode,new ActiveCourse(courseName,courseCode,descr,format,"W2020",list));
	   
	   //CPS616
	   list.clear();
	   courseName = "Algorithms";
	   courseCode = "CPS616";
	   descr = "Learn about Algorithms";
	   format = "3Lec 1Lab";
	   courses.put(courseCode,new ActiveCourse(courseName,courseCode,descr,format,"W2020",list));


   }
   
   public void readFile() throws IOException, IllegalArgumentException {
	    File inputFile = new File("students.txt");
		Scanner in = new Scanner(inputFile);
		while(in.hasNextLine()){
			String[] dataFromFile = in.nextLine().split(" ");
			if(dataFromFile.length == 2){
				String name = dataFromFile[0] ;
				String id = dataFromFile[1];
				Student student = new Student(name, id);
				students.put(id,student);		
			}else{
				throw new IllegalArgumentException();
			}
		
		}
	}
 	

   public TreeMap<String, ActiveCourse> getCourse(){
	   return courses;
   }	
   
   // Add new student to the registry (students arraylist above) 
   public boolean addNewStudent(String name, String id)
   {
	   // Create a new student object
	   // check to ensure student is not already in registry
	   // if not, add them and return true, otherwise return false
	   // make use of equals method in class Student
	   Student newstudent = new Student(name, id);
	   //iterates through an array list of students
	   for(String key : students.keySet()){
		   //checks if student is already in a list
		   Student student = students.get(key);
		   if(newstudent.equals(student)){
			   return false;
		   }
	   }
	   students.put(id, newstudent);
	   return true;
	   
   }
   // Remove student from registry 
   public boolean removeStudent(String studentId)
   {
	   // Find student in students arraylist
	   // If found, remove this student and return true
	   Student student = students.get(studentId);
	     if (student != null){
			   students.remove(studentId);
			   return true;
		   }

	   
	   return false;
   }
   
   // Print all registered students
   public void printAllStudents()
   {
      for(String key : students.keySet())
	   {
		   System.out.println("ID: " + students.get(key).getId() + " Name: " + students.get(key).getName() );   
	   }
	   
   }
   
   // Given a studentId and a course code, add student to the active course
   public void addCourse(String studentId, String courseCode)
   {
	   // Find student object in registry (i.e. students arraylist)
	   // Check if student has already taken this course in the past Hint: look at their credit course list

	   // If not, then find the active course in courses array list using course code
	   // If active course found then check to see if student already enrolled in this course
	   // If not already enrolled
	   //   add student to the active course
	   //   add course to student list of credit courses with initial grade of 0
		boolean found = false;
		boolean enrolled = false;
		Student selectedStudent = null;
		courseCode = courseCode.toUpperCase();
		//finds a student by a student id
		  selectedStudent = students.get(studentId);			
		//invalid student handling
		if(selectedStudent == null) {
			return;
		}
		
        //checks if a course is in a credit course
		for (Course course : selectedStudent.courses){
			if(courseCode.equalsIgnoreCase(course.getCode())){
				found = true;
			}
		}
		//checks if a course is in an active course
		ActiveCourse selectedCourse = courses.get(courseCode);
		//checks if a student is enrolled in a course
		if(!found && selectedCourse != null){
			for(Student student : selectedCourse.getStudents()){
				if(selectedStudent.equals(student)){
					enrolled = true;
				}
			}
    
		}
		
	   if(!enrolled && !found){
		   selectedStudent.addCourse(selectedCourse.getName(), 
			  	selectedCourse.getCode(),
				selectedCourse.getDescription(),
				selectedCourse.getFormat(), 
				selectedCourse.getSemester(),
				0
			);
		   selectedCourse.getStudents().add(selectedStudent);

	   }
	}
	

	   
   
   // Given a studentId and a course code, drop student from the active course
   public void dropCourse(String studentId, String courseCode)
   {
	   // Find the active course
	   // Find the student in the list of students for this course
	   // If student found:
	   //   remove the student from the active course
	   //   remove the credit course from the student's list of credit courses
	   Student selectedStudent = null;
	   ActiveCourse selectedCourse = null;
	   //finds a course and a student
	   courseCode = courseCode.toUpperCase();
	        selectedCourse = courses.get(courseCode);
		      if(selectedCourse != null){
			   for(Student student : selectedCourse.getStudents()){
				   if(student.getId().equals(studentId)){
                      selectedStudent = student;
				   }
			   }
		   }
	   
	   if(selectedStudent != null){
		   selectedCourse.removeStudent(selectedStudent);
		   selectedStudent.removeActiveCourse(courseCode);
			   
		   
		   
	   }
   }
   
   // Print all active courses
   public void printActiveCourses()
   {
	   for (String courseCode : courses.keySet())
	   {
		   System.out.println(courses.get(courseCode).getDescription());
	   }
   }
   
   // Print the list of students in an active course
   public void printClassList(String courseCode)
   {
	courseCode = courseCode.toUpperCase();
	ActiveCourse course = courses.get(courseCode);
	    if(course != null){
            course.printClassList();
		   }
	   }
	  
   
   
   // Given a course code, find course and sort class list by student name
   public void sortCourseByName(String courseCode)
   {
	 //sort courses by their name
	 courseCode = courseCode.toUpperCase();
	 ActiveCourse course = courses.get(courseCode);
		 if(course != null){
			 course.sortByName();
		 }
	 }
	   
   
   
   // Given a course code, find course and sort class list by student name
   public void sortCourseById(String courseCode)
   {
	   //sort courses by id
	   courseCode = courseCode.toUpperCase();
	   ActiveCourse course = courses.get(courseCode);
		 if(course != null){
			 course.sortById();
		 }
	 }
   
   // Given a course code, find course and print student names and grades
   public void printGrades(String courseCode)
   {
	courseCode = courseCode.toUpperCase();
	ActiveCourse course = courses.get(courseCode);
		if(course != null){
			course.printGrades();
		}
	
	   
   }
   
   // Given a studentId, print all active courses of student
   public void printStudentCourses(String studentId)
   {
	Student student = students.get(studentId);
		if(student != null){
			student.printActiveCourses();
		}
	   
   }
   
   // Given a studentId, print all completed courses and grades of student
   public void printStudentTranscript(String studentId)
   {
		Student student = students.get(studentId);
			if(student != null){
			student.printTranscript();
		   }
	} 
	   
   
   
   // Given a course code, student id and numeric grade
   // set the final grade of the student
   public void setFinalGrade(String courseCode, String studentId, double grade)
   {
	   // find the active course
	   // If found, find the student in class list
	   // then search student credit course list in student object and find course
	   // set the grade in credit course and set credit course inactive

	   //sets a final grade and sets the course to inactive
	        courseCode = courseCode.toUpperCase();
			ActiveCourse course = courses.get(courseCode);
			 if(course != null){
			   for(Student student : course.getStudents()){
				   if(student.getId().equals(studentId)){
                       for(CreditCourse creditCourse : student.courses){
                          if(creditCourse.getCode().equalsIgnoreCase(courseCode)){
							  creditCourse.grade = grade;
							  creditCourse.setInactive();
						  }
					   }
				   }
			   }
		   }
	   
		}		   
   
  
}
