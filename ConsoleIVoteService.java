import java.util.ArrayList;


public class ConsoleIVoteService implements IVoteService, Constants
{
	private Question question;
	private Student[] students;
	
	public ConsoleIVoteService(String questionType, String question, ArrayList<String> responses, Student[] students)
	{
		if (questionType.equalsIgnoreCase("a"))
		{
			this.question = new SingleAnswerQuestion(question, responses);
		}
		else if (questionType.equalsIgnoreCase("b"))
		{
			this.question = new MultipleAnswersQuestion(question, responses);
		}
		this.students = students;
	}

	@Override
	public void receiveSubmissions()
	{
		for (int i = 0; i < students.length; ++i)
		{
			question.receiveStudentAnswer(students[i].getResponse());
		}
	}

	@Override
	public void displayStatistics()
	{
		System.out.println("QUESTION: " + question.getQuestion());
		for (int i = 0; i < question.getPossibleResponses().size(); ++i)
		{
			System.out.println("  " + question.getPossibleResponses().get(i));
		}
		System.out.println(" Students answers are as follows: ");
		for (int i = 0; i < question.getStudentSubmissions().length; ++i)
		{
			System.out.println("  " + (char)(i + ASCII_ALPHA_ADDER) + " : " + question.getStudentSubmissions()[i]);
		}
	}

}
