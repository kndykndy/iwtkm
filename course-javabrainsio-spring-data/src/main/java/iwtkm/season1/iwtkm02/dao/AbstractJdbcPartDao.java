package iwtkm.season1.iwtkm02.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public abstract class AbstractJdbcPartDao<T> implements PartDao {

  protected T part;

  protected JdbcTemplate jdbcTemplate;
  protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Autowired
  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Autowired
  public void setNamedParameterJdbcTemplate(
      NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
    this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
  }

  @Override
  public String getName(int id) {
    return jdbcTemplate.queryForObject(
        "select name from parts where id=?",
        new Object[]{id},
        String.class);
  }

  @Override
  public int getCount() {
    return jdbcTemplate.queryForObject(
        "select count(*) from parts",
        Integer.class);
  }

}
