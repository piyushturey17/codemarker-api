package in.codegram.cmapi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.codegram.cmapi.domain.Test;
import in.codegram.cmapi.exception.TestIdException;
import in.codegram.cmapi.repository.TestRepository;
import in.codegram.cmapi.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestRepository testRepository;
	
	@Override
	public Test saveOrUpdate(Test test) {
		
		try {
			
			return testRepository.save(test);
			
		}catch(Exception ex) {
			//handling logic -- rethrow exception to sent till UI layer
			throw new TestIdException("Test Id : "+test.getTestIdentifier()+" already exist");
		}
	}

	@Override
	public Iterable<Test> findAllTests() {
		
		return testRepository.findAll();
	}

	@Override
	public void delete(String testId) {
		Test test = testRepository.findByTestIdentifier(testId);
		testRepository.delete(test);
	}

	

}
