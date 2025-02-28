package com.ethancavanaugh.ch13ex1.repositories;

import com.ethancavanaugh.ch13ex1.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AccountRepository {
    private final JdbcTemplate jdbc;

    public AccountRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Account> findAll(){
        String sql = "SELECT * FROM account";

        return jdbc.query(sql, new AccountMapper());
    }

    public Account findById(long id){
        String sql = "SELECT * FROM account WHERE id = ?";

        return jdbc.queryForObject(sql, new AccountMapper(), id);
    }

    public void setBalance(long id, BigDecimal balance){
        String sql = "UPDATE account SET balance = ? WHERE id = ?";

        jdbc.update(sql, balance, id);
    }

    private static final class AccountMapper implements RowMapper<Account> {
        @Override
        public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
            Account a = new Account();
            a.setId(rs.getLong("id"));
            a.setName(rs.getString("name"));
            a.setBalance(rs.getBigDecimal("balance"));
            return a;
        }
    }
}
