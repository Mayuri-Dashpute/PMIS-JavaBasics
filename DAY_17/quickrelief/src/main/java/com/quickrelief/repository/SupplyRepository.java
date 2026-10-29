package com.quickrelief.repository;

import com.quickrelief.model.Supply;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SupplyRepository {
    private final JdbcTemplate jdbcTemplate;

    // Custom RowMapper: converts each SQL row into a Supply object.
    private final RowMapper<Supply> supplyRowMapper = (resultSet, rowNumber) ->
            new Supply(
                    resultSet.getLong("id"),
                    resultSet.getString("item_name"),
                    resultSet.getInt("quantity")
            );

    public SupplyRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Supply> findAll() {
        String sql = "SELECT id, item_name, quantity FROM supplies ORDER BY id";
        return jdbcTemplate.query(sql, supplyRowMapper);
    }

    public Optional<Supply> findByItemName(String itemName) {
        String sql = "SELECT id, item_name, quantity FROM supplies WHERE LOWER(item_name) = LOWER(?)";
        List<Supply> results = jdbcTemplate.query(sql, supplyRowMapper, itemName);
        return results.stream().findFirst();
    }

    public Supply addOrRestock(String itemName, int quantity) {
        Optional<Supply> existing = findByItemName(itemName);

        if (existing.isPresent()) {
            String updateSql = """
                    UPDATE supplies
                    SET quantity = quantity + ?
                    WHERE id = ?
                    """;
            jdbcTemplate.update(updateSql, quantity, existing.get().getId());
            return findByItemName(itemName).orElseThrow();
        }

        String insertSql = "INSERT INTO supplies (item_name, quantity) VALUES (?, ?)";
        jdbcTemplate.update(insertSql, itemName, quantity);
        return findByItemName(itemName).orElseThrow();
    }

    // Stock is deducted only when enough quantity remains.
    public int deductStock(String itemName, int quantity) {
        String sql = """
                UPDATE supplies
                SET quantity = quantity - ?
                WHERE LOWER(item_name) = LOWER(?)
                  AND quantity >= ?
                """;
        return jdbcTemplate.update(sql, quantity, itemName, quantity);
    }
}
