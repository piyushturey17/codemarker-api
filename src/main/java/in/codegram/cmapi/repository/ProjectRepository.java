package in.codegram.cmapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.codegram.cmapi.domain.Project;


@Repository 
public interface ProjectRepository extends CrudRepository<Project, Long> {
	Project findByProjectIdentifier(String projectId);

}
