package phoneAssignment;

public interface Ringable {
	default String ring() {
		return "ring ring ring";
	}
	default String unlock() {
		return "unlocked";
	}
}
