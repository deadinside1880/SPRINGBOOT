package com.example.First_project.run;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

@Repository
public class JDBCClientRunRepository {

    private final JdbcClient jdbcClient;

    public JDBCClientRunRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Run> findAll() {
        return jdbcClient.sql("SELECT * FROM Run").query(Run.class).list();
    }

    public Optional<Run> findById(Integer id) {
        return jdbcClient.sql("SELCT * FROM Run WHERE id = :id").param("id", id).query(Run.class).optional();
    }

    public void create(Run run) {
        var updated = jdbcClient
                .sql("INSERT INTO Run (id, title, time_started, time_ended, kilometers, location) values(?,?,?,?,?,?)")
                .params(List.of(run.id(), run.title(), run.timeStarted(), run.timeEnded(), run.kilometers(),
                        run.location().toString()))
                .update();

        Assert.state(updated == 1, "Failed to create run " + run.title());
    }

    public void update(Run run, Integer id) {
        var updated = jdbcClient
                .sql("UPDATE Run SET title = ?, time_started = ?, time_ended = ?, kilometers = ?, location = ?")
                .params(List.of(run.title(), run.timeStarted(), run.timeEnded(), run.kilometers(),
                        run.location().toString()))
                .update();

        Assert.state(updated == 1, "Could not update Run " + run.title());
    }

    public void delete(Integer id) {
        var updated = jdbcClient
                .sql("DELETE FROM Run WHERE id = :id")
                .param("id", id)
                .update();

        Assert.state(updated == 1, "Could not delete Run " + id);
    }

    public void saveAll(List<Run> runs) {
        runs.stream().forEach(this::create);
    }
}
