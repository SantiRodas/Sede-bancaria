package collections;

public interface StackInterface<H> {

public void push(H newValue);
	
	public H pop();
	
	public H peek();

	public void empty();
	
	public boolean isEmpty();
	
}
