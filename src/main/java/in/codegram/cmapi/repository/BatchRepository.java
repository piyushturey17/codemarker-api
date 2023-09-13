package in.codegram.cmapi.repository;

import org.springframework.data.repository.CrudRepository;

import in.codegram.cmapi.domain.Batch;


public interface BatchRepository extends CrudRepository<Batch,  Long >{

	Batch findByBatchIdentifier(String BatchID);

}
