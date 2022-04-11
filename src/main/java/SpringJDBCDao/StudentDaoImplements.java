package SpringJDBCDao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import SpringJDBCEntities.Student;

public class StudentDaoImplements implements StudentDao {

	private JdbcTemplate jdbcTemplate;

	public int insert(Student student) {
		// create query of insert
		String query = "insert into student(id,name,city) values(?,?,?)";
		// execute query
		int result = jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
		return result;
	}

	public int update(Student student) {
		// create query of update
		String query = "update student set name=?, city=? where id=?";
		// execute query
		int result = jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
		return result;
	}

	public int delete(int studentId) {
		// create querty of delete
		String query = "delete from student where id=?";
		// execute query
		int result = jdbcTemplate.update(query, studentId);
		return result;
	}

	public Student getStudent(int studentId) {
		// create query of single select
		String query = "Select * from student where id=?";
		// creating object of RowMapper
		RowMapper<Student> rm = new RowMapperImplements();
		// execute query
		Student st = jdbcTemplate.queryForObject(query, rm, studentId);
		return st;
	}

	public List<Student> getAllStudent() {
		// create query of multiple select
		String query = "Select * from student";
		// execute query
		List<Student> st = jdbcTemplate.query(query, new RowMapperImplements());
		return st;
	}

	private Object RowMapperImplements() {
		// TODO Auto-generated method stub
		return null;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
