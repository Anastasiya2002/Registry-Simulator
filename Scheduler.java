
import java.util.TreeMap;


public class Scheduler 
{
    // In main() after you create a Registry object, create a Scheduler object and pass in the students ArrayList/TreeMap
	// If you do not want to try using a Map then uncomment
	// the line below and comment out the TreeMap line
	
	//ArrayList<Student> students;
	
	TreeMap<String,ActiveCourse> schedule;
		
	public Scheduler(TreeMap<String,ActiveCourse> courses)
	{
	  schedule = courses;
	}		
	    
	public void setDayAndTime(String courseCode, String day, int startTime, int duration) throws RuntimeException
    {
        courseCode = courseCode.toUpperCase();
		ActiveCourse foundCourse = schedule.get(courseCode);
		//check if there is a course found
		if(foundCourse == null){
			throw new UnknownCourse();
		  }
		  //checks if the day is valid
		  else if(!day.equals("Mon") && !day.equals("Tue") && !day.equals("Wed") && !day.equals("Thu") && !day.equals("Fri")){
			throw new InvalidDay();
		  }
	      //checks if a start time is valid
		  else if(startTime < 800 || (startTime + (duration*100) ) > 1700){
			throw new InvalidTime();
		  }
		  //checks duration
		  else if(duration != 1 && duration != 2 && duration != 3){
			throw new InvalidDuration();
		  }
		  
		//checks if there is no lecture  collision
		 else{
            for (String code : schedule.keySet()) {
                ActiveCourse course = schedule.get(code);
                if (day.equals(course.getDay())) {
                    int firststart = startTime;
                    int secondstart = course.getStart();
                    for (int i = 0; i < duration; i++) {
                        for (int j = 0; j < course.getDuration(); j++) {
                            if (firststart == secondstart) {
                                System.out.println(firststart + " " + secondstart + code);
                                throw new LectureTimeCollision();
                            }
                            secondstart += 100;
                        }
                        firststart += 100;
                        secondstart = course.getStart();

                    }
                }
                
            }
        }

        foundCourse.setStart(startTime);
        foundCourse.setDay(day);
        foundCourse.setDuration(duration);
        
    }

	
	//if course found, clears schedule 
	public void clearSchedule(String courseCode)
	{
		ActiveCourse course = schedule.get(courseCode);
		if(course != null){
			course.setDay("");
			course.setStart(0);
			course.setDuration(0);
		}
	}

	//prints schedule	
	public void printSchedule()
	{
		String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri"};
		String[][] sched = new String[9][5];
		int start = 800;
		boolean changed = false;
		//adds classes and creates a 2d Array
		for(int i = 0; i < 9; i ++){
          for(int j = 0; j < 5; j++){
			 String day = days[j];
             for(String code : schedule.keySet()){
				ActiveCourse course = schedule.get(code);
                if(course.getDay()!= null){
					int startTime = course.getStart();
			    	if(course.getDay().equals(day) && (start == startTime || (start > startTime && start < startTime+ course.getDuration()*100))){
					 sched[i][j] = course.getCode()+" ";
					 changed = true;
					}	
				}	
			 }
			 if(!changed){sched[i][j] = "       ";}
			 changed = false;
		  }
		  start += 100;
		}
		start = 800;
		System.out.println("      Mon    Tue    Wed    Thu     Fri");
		//prints a 2d Array
		for(int i = 0; i < 9; i ++){
			if(start == 800 || start == 900){
				System.out.print("0"+start+" ");
			}
			else{
				System.out.print(start+" ");
			}
			for(int j = 0; j < 5; j++){
				System.out.print(sched[i][j]);
			}
	    start += 100;
        System.out.println();
		}			
	}

}

class UnknownCourse extends RuntimeException{
	public UnknownCourse(){};
	public UnknownCourse(String message){
		super(message);
	}
}

class InvalidDay extends RuntimeException{
	public InvalidDay(){};
	public InvalidDay(String message){
		super(message);
	}
}

class InvalidTime extends RuntimeException{
	public InvalidTime(){};
	public InvalidTime(String message){
		super(message);
	}
}

class InvalidDuration extends RuntimeException{
	public InvalidDuration(){};
	public InvalidDuration(String message){
		super(message);
	}
}

class LectureTimeCollision extends RuntimeException{
	public LectureTimeCollision(){};
	public LectureTimeCollision(String message){
		super(message);
	}
}


