package alpha.study.CallAssistant.criterion;

public abstract class Criterion {
	private transient final int id;
	transient String description;
	transient boolean yes = true;
	
	public Criterion() {
		this.id = 0;
	}

	public Criterion(int id) {
		this.id = id;		
	}

	public Criterion(int id, boolean yes) {
		this.id = id;
		this.yes = yes;
	}

	public int id() {
		return this.id;
	}

	public String description() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean setYes(boolean yes) {
		boolean prev = this.yes;
		this.yes = yes;
		return prev;
	}

	public boolean yes() {
		return this.yes;
	}

	public abstract boolean filter(String number);
}
