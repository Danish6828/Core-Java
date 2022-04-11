package SpringJDBC;

import java.sql.DriverManager;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import SpringJDBCDao.StudentDao;
import SpringJDBCDao.StudentDaoImplements;

@Configuration
public class JDBCConfiguration {
	@Bean("ds")
	public DataSource getDataSource() {
		System.out.println("With Annotation");
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("Danish@6828");
		return ds;
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(getDataSource());
		return jt;
	}
	
	@Bean("studentDao")
	public StudentDao getStudenDao() {
		StudentDaoImplements sd = new StudentDaoImplements();
		sd.setJdbcTemplate(getJdbcTemplate());
		return sd;
	}
}
