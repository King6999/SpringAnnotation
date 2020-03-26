package jx.Tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    public JdbcTemplate jdbcTemplate;

    public void insert(){
        String sql = "insert into `table_user` (name,age) values(?,?)";
        jdbcTemplate.update(sql, "king",26);

    }
}
