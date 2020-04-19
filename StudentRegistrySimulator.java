
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class StudentRegistrySimulator 
{
  public static void main(String[] args)
  { 
		Registry registry = null;
		try{
			registry = new Registry();
		} catch(IOException exception){
			System.out.println("students.txt File Not Found");
			return;
		} catch(IllegalArgumentException exception){
			System.out.println("Bad File Format students.txt");
			return;
		}
		
		
		Scheduler scheduler = new Scheduler(registry.getCourse());

		Scanner scanner = new Scanner(System.in);
	  	System.out.print(">");
	  
	  while (scanner.hasNextLine())
	  {
		  String inputLine = scanner.nextLine();
		  if (inputLine == null || inputLine.equals("")) continue;
		  
		  Scanner commandLine = new Scanner(inputLine);
		  String command = commandLine.next();
		  
		  if (command == null || command.equals("")) continue;
		  
		  else if (command.equalsIgnoreCase("L") || command.equalsIgnoreCase("LIST"))
		  {
			  registry.printAllStudents();
		  }
		  else if (command.equalsIgnoreCase("Q") || command.equalsIgnoreCase("QUIT")){
				commandLine.close();
		    	return;
		  }
		  
		  else if (command.equalsIgnoreCase("REG"))
		  {
			  // register a new student in registry
			  // get name and student id string 
			  // e.g. reg JohnBoy 74345
			  // Checks:
			  //  ensure name is all alphabetic characters
			  //  ensure id string is all numeric characters
			  String name = commandLine.next();
			  String id = null;
			  if(commandLine.hasNext()){id = commandLine.next();}
			  if(isStringOnlyAlphabet(name)){
			   if(id != null){
                if(isNumeric(id)){    
				  boolean done = registry.addNewStudent(name, id);
				  if (!done){
					System.out.println("Student " +name + " already registered");
				  }
				}
				else{
					System.out.println("Invalid Characters in ID "+id); 
				}
			  }	
			} 
			  else{
				  System.out.println("Invalid Characters in Name " + name);
			  }		  
		  }
		  else if (command.equalsIgnoreCase("DEL"))
		  {
			  // delete a student from registry
			  // get student id
			  // ensure numeric
			  // remove student from registry
			  String id = commandLine.next();
			  if(isNumeric(id)){
				  registry.removeStudent(id);
			  }
		      else{
				System.out.println("Invalid Characters in ID "+ id); 	  
			  }

		  }
		  
		  else if (command.equalsIgnoreCase("ADDC"))
		  {
			 // add a student to an active course
			 // get student id and course code strings
			 // add student to course (see class Registry)
			String id = commandLine.next();
			String code = commandLine.next();
			registry.addCourse(id,code);
			  
		  }
		  else if (command.equalsIgnoreCase("DROPC"))
		  {
			  // get student id and course code strings
			  // drop student from course (see class Registry)
			  String id = commandLine.next();
			  String code = commandLine.next();
			  registry.dropCourse(id, code);
		  }
		  else if (command.equalsIgnoreCase("PAC"))
		  {
			  // print all active courses
			  registry.printActiveCourses();
		  }		  
		  else if (command.equalsIgnoreCase("PCL"))
		  {
			  // get course code string
			  // print class list (i.e. students) for this course
			  String code = commandLine.next();
			  registry.printClassList(code);
		  }
		  else if (command.equalsIgnoreCase("PGR"))
		  {
			  // get course code string
			  // print name, id and grade of all students in active course
			  String code = commandLine.next();
			  registry.printGrades(code);
		  }
		  else if (command.equalsIgnoreCase("PSC"))
		  {
			  // get student id string
			  // print all credit courses of student
			  String id = commandLine.next();
			  registry.printStudentCourses(id);
			  
		  }
		  else if (command.equalsIgnoreCase("PST"))
		  {
			  // get student id string
			  // print student transcript
			  String id = commandLine.next();
			  registry.printStudentTranscript(id);
			  
		  }
		  else if (command.equalsIgnoreCase("SFG"))
		  {
			  // set final grade of student
			  // get course code, student id, numeric grade
			  // use registry to set final grade of this student (see class Registry)
			  String code = commandLine.next();
			  String id = commandLine.next();
			  double grade = commandLine.nextDouble();
			  registry.setFinalGrade(code, id, grade);
		  }
		  else if (command.equalsIgnoreCase("SCN"))
		  {
			  // get course code
			  // sort list of students in course by name (i.e. alphabetically)
			  // see class Registry
			  String code = commandLine.next();
			  registry.sortCourseByName(code);
		  }
		  else if (command.equalsIgnoreCase("SCI"))
		  {
			// get course code
			// sort list of students in course by student id
			// see class Registry
			String code = commandLine.next();
			registry.sortCourseById(code);
		  }
		
		  else if(command.equalsIgnoreCase("SCH")){
			  String courseCode = commandLine.next();
			  String day = commandLine.next();
			  int start = commandLine.nextInt();
			  int duration = commandLine.nextInt();
			  try{
			  scheduler.setDayAndTime(courseCode, day, start, duration);
			  }
			  catch(UnknownCourse e1){
				  System.out.println("Unknown course: " + courseCode);
			  }
			  catch(InvalidDay e2){
                  System.out.println("Invalid Lecture day");
			  }
			  catch(InvalidTime e3){
				  System.out.println("Invalid Lecture Start Time");
			  }
			  catch(InvalidDuration e4){
				  System.out.println("Invalid Lecture Duration");				
			  }
			  catch(LectureTimeCollision e5){
				  System.out.println("Lecture Time Collision");
			  }
		  }
		  
		  else if(command.equalsIgnoreCase("CSCH")){
			  String courseCode = commandLine.next();
			  scheduler.clearSchedule(courseCode);
		  }
		  else if(command.equalsIgnoreCase("PSCH")){
			  scheduler.printSchedule();
		  }
		  System.out.print("\n>");
	  }
  }
  
  private static boolean isStringOnlyAlphabet(String str) 
  { 
	  // write method to check if string str contains only alphabetic characters 
	  for(int i = 0; i < str.length(); i++){
		char ch = str.charAt(i);
		//checks if a character is a digit
		if(Character.isDigit(ch)){
           return false;
		}
	  }return true;
}
  
  public static boolean isNumeric(String str)
  {
	  // write method to check if string str contains only numeric characters
	  for(int i = 0; i < str.length(); i++){
		char ch = str.charAt(i);
		//checks if a character is not a digit
		if(!Character.isDigit(ch)){
           return false;
		}
	  }return true;
	  
  }
  
  
}