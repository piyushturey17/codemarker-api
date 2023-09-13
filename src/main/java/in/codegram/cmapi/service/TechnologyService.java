package in.codegram.cmapi.service;

import java.util.List;

import in.codegram.cmapi.domain.Technology;


public interface TechnologyService {
	Technology saveOrUpdate(Technology technology);
	
   void delete(String technologyId);
Iterable<Technology> findAllTechnology();

}