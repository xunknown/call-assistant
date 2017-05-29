package alpha.study.CallAssistant.criterion;

import java.util.LinkedList;
import java.util.List;

public abstract class ScopeCriterion extends Criterion {
	transient List<String> subjectList = null;

	public ScopeCriterion() {
		super();
	}

	public ScopeCriterion(int id) {
		super(id);
	}

	public ScopeCriterion(int id, boolean yes) {
		super(id, yes);
	}

	public ScopeCriterion(int id, boolean yes, List<String> subjectList) {
		super(id, yes);
		this.subjectList = subjectList;
	}

	public ScopeCriterion(int id, boolean yes, String subject) {
		super(id, yes);
		addSubject(subject);
	}

	public List<String> getSubjectList() {
		return this.subjectList;
	}

	public void setSubjectList(List<String> subjectList) {
		this.subjectList = subjectList;
	}

	public void addSubjectList(List<String> subjectList) {
		if (subjectList == null) return;
		if (this.subjectList == null) this.subjectList = new LinkedList<>();
		this.subjectList.addAll(subjectList);
	}

	public boolean addSubject(String subject) {
		if (subject == null) return false;
		if (this.subjectList == null) this.subjectList = new LinkedList<>();
		return subjectList.add(subject);
	}

	public boolean removeSubject(String subject) {
		if (subject == null) return true;
		if (this.subjectList == null) return true;
		return this.subjectList.remove(subject);
	}

	public void clearSubjectList() {
		if (this.subjectList != null) this.subjectList.clear();
	}
}
