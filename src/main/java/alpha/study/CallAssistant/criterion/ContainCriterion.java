package alpha.study.CallAssistant.criterion;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContainCriterion extends ScopeCriterion {
	private static final Logger logger = LoggerFactory.getLogger(ContainCriterion.class);         

	public ContainCriterion() {
		super();
	}

	public ContainCriterion(int id) {
		super(id);
	}
	
	public ContainCriterion(int id, boolean yes) {
		super(id, yes);
	}

	public ContainCriterion(int id, boolean yes, List<String> subjectList) {
		super(id, yes, subjectList);
	}

	public ContainCriterion(int id, boolean yes, String subject) {
		super(id, yes, subject);
	}

	@Override
	public boolean filter(String number) {
		if (subjectList == null || subjectList.isEmpty()) return false;
		Iterator<String> iterator = subjectList.iterator();
		while (iterator.hasNext()) {
			String subject = iterator.next();
			logger.info("ContainCriterion filter {} {}", yes, subject);
			Pattern pattern = Pattern.compile(subject);
			Matcher matcher = pattern.matcher(number);
			boolean find = matcher.find();
			if (find) {
				return yes ? true : false;
			}
		}

		return !yes;
	}
}
