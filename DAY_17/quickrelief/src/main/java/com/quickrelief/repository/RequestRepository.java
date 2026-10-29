package com.quickrelief.repository;

import com.quickrelief.model.SupplyRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class RequestRepository {
    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<SupplyRequest> requestRowMapper = (resultSet, rowNumber) ->
            new SupplyRequest(
                    resultSet.getLong("id"),
                    resultSet.getString("item_name"),
                    resultSet.getInt("quantity"),
                    resultSet.getString("status"),
                    resultSet.getString("requested_by")
            );

    public RequestRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public SupplyRequest save(String itemName, int quantity,
                              String status, String requestedBy) {
        String sql = """
                INSERT INTO requests (item_name, quantity, status, requested_by)
                VALUES (?, ?, ?, ?)
                """;

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(
                    sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, itemName);
            statement.setInt(2, quantity);
            statement.setString(3, status);
            statement.setString(4, requestedBy);
            return statement;
        }, keyHolder);

        Number generatedId = keyHolder.getKey();
        if (generatedId == null) {
            throw new IllegalStateException("Database did not return the new request ID.");
        }

        return jdbcTemplate.queryForObject("""
                SELECT id, item_name, quantity, status, requested_by
                FROM requests
                WHERE id = ?
                """, requestRowMapper, generatedId.longValue());
    }
}
