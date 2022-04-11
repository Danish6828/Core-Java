package SpringJDBC;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import SpringJDBCDao.StudentDao;
import SpringJDBCEntities.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Program is started...");

		ApplicationContext ac = new AnnotationConfigApplicationContext(JDBCConfiguration.class);
		StudentDao sd = ac.getBean("studentDao", StudentDao.class);
		
		 //Insert
		 /*Student s = new Student();
		 s.setId(106);
		 s.setName("unknown");
		 s.setCity("Mumbai");
		 int r = sd.insert(s);
		 System.out.println(r + " " + "student inserted");*/

		 //Update
		 /*Student s = new Student();
		 s.setName("Zohaib");
		 s.setCity("Mumbai");
		 s.setId(106);
		 int r = sd.update(s);
		 System.out.println(r + " " + "student updated");*/

		 //Delete
		 /*int r = sd.delete(106);
		 System.out.println(r + " " + "student deleted");*/

		 //Single select or Single student data fetch
		 /*Student st = sd.getStudent(101);
		 System.out.println(st);*/

		// Multiple select or Multiple student data fetch
		List<Student> st = sd.getAllStudent();
		Iterator<Student> itr = st.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
