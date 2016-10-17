import java.util.ArrayList;


public abstract class Question implements Constants {
	private String question;
	private ArrayList<String> possibleResponses;
	private int[] studentSubmissions;
	
	public Question(String question, ArrayList<String> possibleResponses)
	{
		this.question = question;
		this.possibleResponses = possibleResponses;
		this.studentSubmissions = new int[possibleResponses.size()];
		for (int i = 0; i < this.studentSubmissions.length; ++i)
		{
			studentSubmissions[i] = 0;
		}
	}
	
	public String getQuestion()
	{
		return question;
	}
	
	public ArrayList<String> getPossibleResponses()
	{
		return possibleResponses;
	}
	
	public void incrementResponseCount(int index)
	{
		++studentSubmissions[index];
	}
	
	public int[] getStudentSubmissions()
	{
		return studentSubmissions;
	}
	
	abstract void receiveStudentAnswer(String answer);
}
