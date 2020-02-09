import java.util.LinkedList;
import java.util.List;

public class State {
	private String name;
	private boolean isStart;
	private boolean isFinal;
	private List<Transition> transitions;
	
	public State(String name,boolean isStart, boolean isFinal, List<Transition> transitions) {
		this.name = name;
		this.isStart = isStart;
		this.isFinal = isFinal;
		this.transitions = new LinkedList<Transition>();
	}
	
	public List<Transition> getStateTransitions(){
		return transitions;
	}
	
	public void addTransition(Transition transition) {
		transitions.add(transition);
	}
	
	public State getState(){
		return this;
	}
	
	public void setStart(boolean value) {
		isStart = value;
	}
	
	public boolean getStart() {
		return isStart;
	}
	
	public void setFinal(boolean value) {
		isFinal = value;
	}
	
	public boolean getFinal() {
		return isFinal;
	}
	
	public String getName() {
		return name;
	}
	
}
