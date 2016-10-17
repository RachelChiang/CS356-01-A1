import java.util.ArrayList;


public class Student
{
	private final String studentID;
	private String response;
	
	public Student(String id)
	{
		studentID = id;
	}
	
	public void setResponse(String response)
	{
		this.response = response;
	}
	
	public String getResponse()
	{
		return response;
	}
}
