import java.util.ArrayList;
import java.util.Scanner;

public class SimulationDriver implements Constants
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String typePrompt = "Please select a question type or \"exit\" to quit:"
				+ "\n A. Single Answer Multiple Choice\n B. Multiple Answers Multiple Choice";
		ArrayList<String> responses = new ArrayList<String>();
		
		System.out.println("Welcome!\n" + typePrompt);
		String input = sc.nextLine();
		while (!(input.equalsIgnoreCase("exit")))
		{
			if (input.equalsIgnoreCase("a") || input.equalsIgnoreCase("b"))
			{
				String questionType = input;
				System.out.println("Enter a question to ask:");
				String question = sc.nextLine();
				int counter = 0;
				boolean isDone = false;
				
				System.out.println("Please input possible responses, separated by new lines, "
						+ "or input only \"done\" or \"d\" when finished");
				while (!(isDone))
				{
					char letterChoice = (char)(ASCII_ALPHA_ADDER + counter);
					System.out.print(" " + letterChoice + "? ");
					input = sc.nextLine();
					if ((input.equalsIgnoreCase("done")) || (input.equalsIgnoreCase("d")))
					{
						isDone = true;
					}
					else
					{
						responses.add(letterChoice + ". " + input);
					}
					++counter;
				}
				StudentGenerator studentsList = new StudentGenerator(--counter);
				ConsoleIVoteService iVote = new ConsoleIVoteService(questionType, question, responses, studentsList.getStudents());
				iVote.receiveSubmissions();
				iVote.displayStatistics();
			}
			else
			{
				System.out.println("Bad input. Please try again.");
			}
			System.out.println(typePrompt);
			input = sc.nextLine();
		}
		System.out.println("Thank you for using the I Vote Service. Goodbye.");
	}
}
