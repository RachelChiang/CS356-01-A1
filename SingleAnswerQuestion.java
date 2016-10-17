import java.util.ArrayList;


public class SingleAnswerQuestion extends Question
{
	public SingleAnswerQuestion(String question, ArrayList<String> possibleResponses)
	{
		super(question, possibleResponses);
	}

	@Override
	void receiveStudentAnswer(String answer)
	{
		char last = answer.charAt(answer.length() - 1);
		int index = ((int) last) - ASCII_ALPHA_ADDER;
		incrementResponseCount(index);
	}
}