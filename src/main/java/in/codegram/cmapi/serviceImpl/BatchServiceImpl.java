package in.codegram.cmapi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import in.codegram.cmapi.domain.Batch;
import in.codegram.cmapi.exception.BatchIdException;
import in.codegram.cmapi.repository.BatchRepository;
import in.codegram.cmapi.service.BatchService;

@Service
public class BatchServiceImpl implements BatchService{

	@Autowired
	private BatchRepository batchRepository;
	
	@Override
	public Batch saveOrUpdate(Batch batch ) {
		
		try {
			return batchRepository.save(batch );
		} catch(Exception ex){
			throw new BatchIdException("Batch Id :"+ batch.getBatchIdentifier() +"  already exists");

		}
		
		
		
	}

	@Override
	public Iterable<Batch> findAllBatch() {
		
		return batchRepository.findAll();
	}

	@Override
	public void delete(String BatchID) {
	Batch batch=batchRepository.findByBatchIdentifier(BatchID);
		
	batchRepository.delete(batch);
		
	}

	
}













































