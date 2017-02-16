package utils;

import java.util.Random;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import entity.Data;
import repository.DataRepository;

public class DataServiceImpl implements DataService{

	private static final Logger LOG = LoggerFactory.getLogger(DataServiceImpl.class);
	
	@Autowired
    @Qualifier("dataRespitory")
    private DataRepository dataRepository;
	
	@Override
	public boolean persist(String problem) {
		try {
            dataRepository.persist(new Data(new Random().nextInt(), problem));
            return true;
        } catch (Exception e) {
            LOG.error("ERROR SAVING DATA: " + e.getMessage(), e);
            return false;
        }
	}

	@Override
	public Set<String> getRandomData() {
		return dataRepository.getRandomData();
	}

}
