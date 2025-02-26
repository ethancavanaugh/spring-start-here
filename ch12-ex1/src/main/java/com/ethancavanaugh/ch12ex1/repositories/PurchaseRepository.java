package com.ethancavanaugh.ch12ex1.repositories;

import com.ethancavanaugh.ch12ex1.model.Purchase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PurchaseRepository {

    private final JdbcTemplate jdbcTemplate;

    public PurchaseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Purchase> findAll(){
        String sql = "SELECT * FROM purchase";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Purchase p = new Purchase();
            p.setId(rs.getInt("id"));
            p.setProduct(rs.getString("product"));
            p.setPrice(rs.getDouble("price"));

            return p;
        });
    }

    public int save(Purchase p) {
        String sql = "INSERT INTO purchase (product, price) VALUES (?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, p.getProduct());
            ps.setDouble(2, p.getPrice());
            return ps;
        }, keyHolder);

        return keyHolder.getKey().intValue();
    }
}