package in.codegram.cmapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.codegram.cmapi.domain.Technology;


@Repository 
public interface TechnologyRepository extends CrudRepository<Technology, Long> {
	
   
    	

		Technology findByTechnologyIdentifier(String technologyId);
    
}
