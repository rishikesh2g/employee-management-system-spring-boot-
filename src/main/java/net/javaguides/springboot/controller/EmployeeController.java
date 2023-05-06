package net.javaguides.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.service.EmployeeService;

/*The controller handles HTTP requests and responses related to employee data.*/
@Controller  // which marks it as a Spring MVC controller.
public class EmployeeController {

	@Autowired // which indicates that Spring should inject an instance of the
				// "EmployeeService" interface into the controller.
	private EmployeeService employeeService;

	// display list of employees
	@GetMapping("/")
	public String viewHomePage(Model model)/* {
		return findPaginated(1, "firstName", "asc", model);
	}
*/
	
	
	{
	
		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		return "index";

	}

	
	
	
	public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/templates/imagedata";

	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		// create model attribute to bind form data
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		// save employee to database
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}

	/*
	 * @GetMapping("/showFormForUpdate/{id}")
	 * 
	 * public String showFormForUpdate(@RequestParam(value = "id") long id, Model
	 * model) {
	 * 
	 * // get employee from the service Employee employee =
	 * employeeService.getEmployeeById(id);
	 * 
	 * // set employee as a model attribute to pre-populate the form
	 * model.addAttribute("employee", employee); return "update_employee"; }
	 */

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable long id, Model model) {

	    // get employee from the service
	    Employee employee = employeeService.getEmployeeById(id);

	    // set employee as a model attribute to pre-populate the form
	    model.addAttribute("employee", employee);
	    return "update_employee";
	}
	
	
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value = "id") long id) {

		// call delete employee method
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/";
	}

	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir, Model model) {
		int pageSize = 5;

		Page<Employee> page = employeeService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Employee> listEmployees = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listEmployees", listEmployees);
		return "index";
	}
	
//	Search option 
	
	@GetMapping("/search")
	public String search(Model model, @RequestParam("keyword") String keyword) {
	    List<Employee> employees = employeeService.search(keyword);
	    model.addAttribute("employees", employees);
	    return "redirect:/";
	}



	

	
	
	
}
