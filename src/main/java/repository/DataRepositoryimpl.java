package repository;

import java.sql.Types;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import entity.Data;

public class DataRepositoryimpl implements DataRepository<Data>{

	@Autowired
	private JdbcOperations jdbcOperations;
	
	@Override
	public void persist(Data object) {
		Object[] params = new Object[] {object.getId(), object.getDescription()};
		int[] types = new int[]{Types.INTEGER, Types.VARCHAR};
		
		jdbcOperations.update("ISERT INTO data(id, description) VALUES (?, ?)", params, types);
	}

	@Override
	public void delete(Data object) {
		jdbcOperations.update("DELETE FROM data WHERE id = " + object.getId() + ";");
	}

	@Override
	public Set<String> getRandomData() {
		Set<String> result = new HashSet<>();
		SqlRowSet rowSet = jdbcOperations.queryForRowSet("SELECT description FROM data p ORDER BY RANDOM() LIMIT 50;");
		while (rowSet.next()) {
	           result.add(rowSet.getString("description"));
	    }
	    return result;
	}

}
