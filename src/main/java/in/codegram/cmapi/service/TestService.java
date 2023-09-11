package in.codegram.cmapi.service;

import in.codegram.cmapi.domain.Test;

public interface TestService {
	
	public Test saveOrUpdate(Test test);
	
	Iterable<Test> findAllTests();
	
	void delete(String testId);

}
