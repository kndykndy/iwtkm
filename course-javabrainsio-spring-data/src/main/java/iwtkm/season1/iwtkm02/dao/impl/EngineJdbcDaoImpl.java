package iwtkm.season1.iwtkm02.dao.impl;

import iwtkm.season1.iwtkm02.dao.AbstractJdbcPartDao;
import iwtkm.season1.iwtkm02.model.AbstractPart;
import iwtkm.season1.iwtkm02.model.impl.Engine;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

@Configuration
public class EngineJdbcDaoImpl extends AbstractJdbcPartDao<Engine> {

  private static class EngineRowMapper implements RowMapper<Engine> {

    @Override
    public Engine mapRow(ResultSet rs, int rowNum) throws SQLException {
      return new Engine(rs.getInt("id"), rs.getString("name"), 0);
    }

  }

  @Override
  public void createNew(AbstractPart part) {
    // using simple insert
//    jdbcTemplate.update(
//        "insert into parts(id, name) values(?,?)",
//        new Object[]{part.getId(), part.getName()});

    // using named parameters
    final SqlParameterSource sqlParameterSource =
        new MapSqlParameterSource("id", part.getId()).addValue("name", part.getName());

    namedParameterJdbcTemplate.update(
        "insert into parts(id, name) values(:id, :name)", sqlParameterSource);
  }

  @Override
  public Engine getById(int id) {
    return jdbcTemplate.queryForObject(
        "select * from parts where id=?", new Object[]{id}, new EngineRowMapper());
  }

  @Override
  public List getAll() {
    return jdbcTemplate.query("select * from parts", new EngineRowMapper());
  }

}
