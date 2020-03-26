package jx.Tx;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@EnableTransactionManagement//开启基于注解的事务管理功能
@PropertySource("classpath:/dbconfig.properties")
@ComponentScan
@Configuration
public class TxConfig {

    @Value("${db.user}")
    private String user;
    @Value("${db.pwd}")
    private String pwd;
    @Value("${db.driverClass}")
    private String driverClass;

    //数据源
    @Bean
    public DataSource dataSource() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws Exception{
        //Spring对@Configuration类会进行特殊处理，给容器加组件的方法，多次调用都只是从容器中找组件
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return jdbcTemplate;
    }

    //在容器中注册事务管理器
    @Bean
    public PlatformTransactionManager platformTransactionManager() throws Exception{
        return new DataSourceTransactionManager(dataSource());
    }
}
