import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
    @Bean
    public DataSource dataSource(DataSourceProperties properties) {
        DataSourceBuilder factory = DataSourceBuilder.create();
        factory.url("jdbc:mysql://localhost:3306/petdatabase");
        factory.username("root");
        factory.password(SecurePasswordGenerator());
        return factory.build();
    }

    private String SecurePasswordGenerator() {

        return "Ibrahima_22";
    }
}
