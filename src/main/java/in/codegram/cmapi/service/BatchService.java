package in.codegram.cmapi.service;

import in.codegram.cmapi.domain.Batch;

public interface BatchService {

	 Batch saveOrUpdate(Batch batch );
	 Iterable<Batch> findAllBatch();
	 void delete(String BatchID);
}
