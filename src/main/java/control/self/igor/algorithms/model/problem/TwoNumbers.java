package control.self.igor.algorithms.model.problem;

@SuppressWarnings("hiding")
public abstract class TwoNumbers<Number> {

    private Number first;
    private Number second;

    public TwoNumbers(Number first, Number second) {
	this.first = first;
	this.second = second;
    }

    public Number getFirst() {
	return first;
    }

    public Number getSecond() {
	return second;
    }

}
