package com.hr.web.app;
import com.zaxxer.hikari.HikariDataSource;
import com.hr.web.services.User;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Configuration
public class DataSourceConfig {
    @Value("${spring.datasource.url}")
    private String dbUrl;
    @Value("${spring.datasource.username}")
    private String dbUsername;
    @Value("${spring.datasource.password}")
    private String dbPassword;
    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(dbUrl);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPassword);
        return dataSource;
    }
    
    
    @Service
    public class UserService {
        private final JdbcTemplate jdbcTemplate;
        @Autowired
        public UserService(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }
        public List<User> getUsers() {
            return jdbcTemplate.query(
                "SELECT * FROM users",
                (rs, rowNum) -> new User(rs.getLong("id"), rs.getString("name"))
            );
        }
    }
    
    
}







