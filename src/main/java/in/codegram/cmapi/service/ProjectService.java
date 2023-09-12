package in.codegram.cmapi.service;

import in.codegram.cmapi.domain.Project;

public interface ProjectService {
	 Project saveOrUpdate(Project project);
	Iterable<Project> findAllProjects();
	
	void delete(String projectId);

}
