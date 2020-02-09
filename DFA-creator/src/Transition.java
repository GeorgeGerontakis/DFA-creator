
public class Transition {
	private State goToState;
	private char condition;
	
	public Transition(State goToState, char condition) {
		this.goToState = goToState;
		this.condition = condition;
	}
	
	public char getCondition() {
		return condition;
	}
	
	public State getStateToGo() {
		return goToState;
	}
}
