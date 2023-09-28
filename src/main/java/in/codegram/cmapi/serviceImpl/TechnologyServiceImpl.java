package in.codegram.cmapi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.codegram.cmapi.domain.Technology;
import in.codegram.cmapi.exception.TechnologyIdException;

import in.codegram.cmapi.repository.TechnologyRepository;
import in.codegram.cmapi.service.TechnologyService;


@Service
public class TechnologyServiceImpl  implements TechnologyService{
	
	@Autowired
	private TechnologyRepository technologyRepository;

	@Override
	public Technology saveOrUpdate(Technology technology) {
		try {
		return technologyRepository.save(technology);
	}catch(Exception ex) {
		throw new TechnologyIdException("technologyId:"+technology.getTechnologyIdentifier()+"already exists");
	}
	}
	@Override
	public Iterable<Technology> findAllTechnology() {
		
		return technologyRepository.findAll();
	}

	@Override
	public void delete(String technologyId) {
	 Technology technology=technologyRepository.findByTechnologyIdentifier(technologyId);//FP01,FP02
	 technologyRepository.delete(technology);
	}
	
	@Override
	public Technology findTechnologyByTechnologyIdentifier(String technologyIdentifier) {
		Technology technology = technologyRepository.findByTechnologyIdentifier(technologyIdentifier);
		if(technology==null) {
			throw new TechnologyIdException("Technology Id :"+technologyIdentifier+"does not exist");
		}
		return technology;
		
	}

}
