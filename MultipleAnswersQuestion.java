import java.util.ArrayList;


public class MultipleAnswersQuestion extends Question
{	
	public MultipleAnswersQuestion(String question, ArrayList<String> possibleResponses) 
	{
		super(question, possibleResponses);
	}

	@Override
	void receiveStudentAnswer(String answer)
	{
		char[] answers = answer.toCharArray();
		int[] answersToRecord = new int[getStudentSubmissions().length];
		for (int i = 0; i < answers.length; ++i)
		{
			int index = ((int) answers[i]) - ASCII_ALPHA_ADDER;
			++answersToRecord[index];
		}
		
		// For simulation's sake, if the student answered "A", it would be recorded as +1 A
		// If they answered "AA", it would be treated as if the student deselected A. Similarly
		// if they answered "AAA", it would be treated as if the student selected, deselected,
		// and reselected A. Clearly, if a letter is "clicked" an odd number of times, it will
		// appear as selected, whereas if a letter is "clicked" an even number of times (including
		// zero), it will appear as unselected.
		for (int i = 0; i < answersToRecord.length; ++i)
		{
			if (answersToRecord[i] % 2 != 0)
			{
				incrementResponseCount(i);
			}
		}
	}

}
