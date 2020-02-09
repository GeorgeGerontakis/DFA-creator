import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MainClass {
	
	public static List<State> states = new LinkedList<State>();
	
	public static State getStateByName(String name) {
		for (int j = 0; j < states.size(); j++) {
			if(states.get(j).getName().equals(name)) return states.get(j).getState();
		}
		//if state not found create it!
		State newCreatedState = new State(name,false,false,null);
		states.add(newCreatedState);
		return newCreatedState;
	}
		
	public static void main(String[] args) {

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(System.getProperty("user.home")+"/Desktop/dfa.txt"));
			int statesNumber = Integer.parseInt(reader.readLine()); // useless :P
			char[] alphabet = reader.readLine().replace(" ", "").toCharArray();
			states.add(new State(reader.readLine(),true,false,null)); //only one starting state!
			String[] finalStates = reader.readLine().split(" ");
			for (int i = 0; i < finalStates.length; i++) {
				getStateByName(finalStates[i]).setFinal(true);
			}
			String line = reader.readLine();
			while (line != null) {
				String[] lineStringArray = line.split(" ");
				String stateName = lineStringArray[0];
				char condition = lineStringArray[1].charAt(0);
				State goToState = getStateByName(lineStringArray[2]);
				Transition transition = new Transition(goToState,condition);
				getStateByName(stateName).addTransition(transition);
				line = reader.readLine();
			}
			reader.close();
			
			//construct DFA
			DFA dfa = new DFA(alphabet,states);
			
			System.out.println("DFA Loaded successfully!");
			System.out.println("Example word input: 100001101");
			
	        Scanner input = new Scanner(System.in);
	        
	        while(true) {
	        	System.out.println("Enter a word: ");
	        	String word = input.nextLine();
	        	String result;
	        	if(dfa.runDFA(word)) result = "word accepted!"; else result = "word not accepted!";
	        	System.out.println(result);
	        }			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
