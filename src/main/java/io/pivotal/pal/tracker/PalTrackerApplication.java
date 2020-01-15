package io.pivotal.pal.tracker;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@SpringBootApplication
public class PalTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PalTrackerApplication.class, args);
    }

    @Bean
    TimeEntryRepository timeEntryRepository() {
        return new InMemoryTimeEntryRepository();
    }


    @Bean
    DataSource dataSource(){
        MysqlDataSource dataSource= new MysqlDataSource();
        dataSource.setURL(System.getenv("SPRING_DATASOURCE_URL"));
        return  dataSource;
    }
    @Bean
    @Primary
    TimeEntryRepository jdbcTimeEntryRepository()
    {
        return new JdbcTimeEntryRepository(dataSource());
    }


}
