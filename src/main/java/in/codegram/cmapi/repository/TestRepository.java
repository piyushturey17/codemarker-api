package in.codegram.cmapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.codegram.cmapi.domain.Test;

@Repository
public interface TestRepository extends CrudRepository<Test, Long> {

	Test findByTestIdentifier(String testId);
	
}
