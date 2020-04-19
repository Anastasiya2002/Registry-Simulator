
public class CreditCourse  extends Course
{
	// add a constructor method with appropriate parameters
	// should call the super class constructor
	private String  semester;
    public  double  grade;
	public  boolean active;
	
	public CreditCourse(String name, String code, String descr, String fmt,String semester, double grade)
	{
		super(name, code, descr, fmt);
		this.semester = semester;
		this.grade= grade;
	}
	
	public boolean getActive()
	{
		// add code and remove line below
		return active;
	}
	
	public void setActive()
	{
		this.active = true;
	}
	
	public void setInactive()
	{
		this.active = false;
	}
	
	public String displayGrade()
	{
		// Change line below and print out info about this course plus which semester and the grade achieved
		// make use of inherited method in super class
		return(this.getCode() +" "+ this.getName()+ " "+ semester + " Grade " + convertNumericGrade(grade));
	}
	
}