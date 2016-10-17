import java.util.Random;


public class StudentGenerator implements Constants
{
	private Student[] students = new Student[NUMBER_OF_STUDENTS];
	private Random rng = new Random();
	
	public StudentGenerator(int choices)
	{
		for (int i = 0; i < students.length; ++i)
		{
			students[i] = null;
		}
		generateStudents();
		for (int i = 0; i < students.length; ++i)
		{
			students[i].setResponse(generateResponses(choices));
		}
	}
	
	private void generateStudents()
	{
		for (int i = 0; i < students.length; ++i)
		{
			students[i] = new Student(generateID());
		}
	}
	
	private String generateID()
	{
		char[] id = new char[9];
		for (int i = 0; i < id.length; ++i)
		{
			id[i] = (char) (rng.nextInt(103) + ASCII_CHAR_ADDER);
		}
		
		if (isIDUnique(id.toString()))
		{
			return id.toString();
		}
		else
		{
			return generateID();
		}
	}
	
	private boolean isIDUnique(String id)
	{
		for (int i = 0; i < students.length; ++i)
		{
			if (students[i] != null)
			{
				if (id.equals(students[i]))
				{
					return false;
				}
			}
		}
		return true;
	}
	
	private String generateResponses(int choices)
	{
		char[] response = new char[rng.nextInt(choices) + 1];
		for (int i = 0; i < response.length; ++i)
		{
			response[i] = (char) (rng.nextInt(choices) + ASCII_ALPHA_ADDER);
		}
		String r = "";
		for (int i = 0; i < response.length; ++i)
		{
			r += response[i];
		}
		return r;
	}
	
	public Student[] getStudents()
	{
		return students;
	}
}
