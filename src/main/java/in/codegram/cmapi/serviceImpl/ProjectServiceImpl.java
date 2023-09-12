package in.codegram.cmapi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.codegram.cmapi.domain.Project;
import in.codegram.cmapi.exception.ProjectIdException;
import in.codegram.cmapi.repository.ProjectRepository;
import in.codegram.cmapi.service.ProjectService;

@Service
public class ProjectServiceImpl  implements ProjectService{
	
	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public Project saveOrUpdate(Project project) {
		try {
			return projectRepository.save(project);
		} catch (Exception ex) {
			throw new ProjectIdException("Project Id :"+ project.getProjectIdentifier() +"already exists");
		} 
		
	}

	@Override
	public Iterable<Project> findAllProjects() {
		
		return projectRepository.findAll();
	}

	@Override
	public void delete(String projectId) {
		Project project=projectRepository.findByProjectIdentifier(projectId);
		
		projectRepository.delete(project);
		
	}

}
