package alpha.study.CallAssistant.criterion;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CriteriaFilter {
	private final int id;
	private String description;
	class CriterionConnector {
		final boolean and;
		final Criterion criterion;
		CriterionConnector(boolean and, Criterion criterion) {
			this.and = and;
			this.criterion = criterion;
		}
	}
	private List<CriterionConnector> criterionConnectorList = null;
	
	public CriteriaFilter() {
		this.id = 0;
	}

	public CriteriaFilter(int id) {
		this.id = id;
	}

	public int id() {
		return this.id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String description() {
		return this.description;
	}

	public boolean filter(String number) {
		if (this.criterionConnectorList == null) return false;
		boolean pass = false;
		Iterator<CriterionConnector> iterator = this.criterionConnectorList.iterator();

		if (iterator.hasNext()) {
			CriterionConnector criterionConnector = iterator.next();
			pass = criterionConnector.criterion.filter(number);
		}

		while (iterator.hasNext()) {
			CriterionConnector criterionConnector = iterator.next();
			if (criterionConnector.and) { // use AND operator 
				pass = pass && criterionConnector.criterion.filter(number);
			} else { // use OR operator
				if (pass) {
					// we have got the result, stop filter
					// TODO log
					break;
				} else {
					pass = criterionConnector.criterion.filter(number);
				}
			}
		}

		return pass;
	}

	public boolean addCriterion(boolean and, Criterion criterion) {
		if (criterion == null) return false;
		if (this.criterionConnectorList == null) this.criterionConnectorList = new LinkedList<>();
		return this.criterionConnectorList.add(new CriterionConnector(and, criterion));
	}

	public boolean addCriterion(Criterion criterion) {
		return addCriterion(false, criterion);
	}

	public void clearCriterions() {
		if (this.criterionConnectorList != null) this.criterionConnectorList.clear();
	}
}
