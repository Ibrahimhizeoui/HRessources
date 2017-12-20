import dao.EmployeeDao;
import model.Employee;

public class Main {

	public static void main(String[] args) {
		Employee employee = new Employee();
		EmployeeDao employeeDao = new EmployeeDao();
		employee.setFirstName("ib");
		employeeDao.saveEmployee(employee);

	}

}
