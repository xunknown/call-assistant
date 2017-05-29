package alpha.study.CallAssistant.criterion;

import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResideInCriterion extends ScopeCriterion {
	private static final Logger logger = LoggerFactory.getLogger(BeginWithCriterion.class);         
	
	public ResideInCriterion() {
		super();
	}
	
	public ResideInCriterion(int id) {
		super(id);
	}
	
	public ResideInCriterion(int id, boolean yes) {
		super(id, yes);
	}

	public ResideInCriterion(int id, boolean yes, List<String> subjectList) {
		super(id, yes, subjectList);
	}

	public ResideInCriterion(int id, boolean yes, String subject) {
		super(id, yes, subject);
	}

	@Override
	public boolean filter(String number) {
		if (subjectList == null || subjectList.isEmpty()) return false;
		Iterator<String> iterator = subjectList.iterator();
		while (iterator.hasNext()) {
			String subject = iterator.next();
			logger.info("ResideInCriterion filter {} {}", yes, subject);
			if (number.equals(subject)) {
				return yes ? true : false;
			}
		}

		return !yes;
	}
}
