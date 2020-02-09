import java.util.LinkedList;
import java.util.List;

public class DFA {

	private char[] alphabet;
	private List<State> states;
	private State currentPosition;
	
	public DFA (char[] alphabet, List<State> states) {
		this.alphabet = alphabet;
		this.states = states;
		this.currentPosition = states.get(0);
	}
	
	private boolean alphabetContainsSymbol(char symbol) {
		for(int i = 0; i<alphabet.length; i++) {
			if(alphabet[i] == symbol) return true;
		}
		System.out.println("symbol " + symbol + " is not part of the initial alphabet!");
		return false;
	}
	
	public boolean runDFA(String word) {
		currentPosition = states.get(0);
		char[] wordCharArray = word.toCharArray();
    	for(int i = 0;i < wordCharArray.length; i++) {
    		if (!alphabetContainsSymbol(wordCharArray[i])) return false;
    		List<Transition> possibleTransitions = currentPosition.getStateTransitions();
    		for(int j = 0; j<possibleTransitions.size(); j++) {
    			if(possibleTransitions.get(j).getCondition() == wordCharArray[i]) currentPosition = possibleTransitions.get(j).getStateToGo();
    		}
    	}
    	return currentPosition.getState().getFinal();
	}
	

}
