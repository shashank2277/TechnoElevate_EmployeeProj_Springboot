package com.te.springboot.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springboot.Beans.EmployeeBean;
import com.te.springboot.Beans.EmployeeResponse;
import com.te.springboot.service.EmployeeService;

@RestController
public class SpringBootController {

	@Autowired
	EmployeeService service;

	@GetMapping("/")
	public String firstHandlerMethod() {
		return "TechnoElevate";
	}// end of firstHandler Method

	@GetMapping(path = "/getEmp", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse getEmployee(int id) {
		EmployeeResponse employeeResponse = new EmployeeResponse();
		EmployeeBean employeeBean = service.getEmployee(id);

		if (employeeBean != null) {
			employeeResponse.setStatusCode(200);
			employeeResponse.setMsg("success");
			employeeResponse.setDescription(" Data found for id : " + id);
			employeeResponse.setBean(employeeBean);
		} else {
			employeeResponse.setStatusCode(404);
			employeeResponse.setMsg("failure");
			employeeResponse.setDescription("Error Data Not found");
		}
		return employeeResponse;
	}// end of getEmp

	@GetMapping(path = "/getAll", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse getAll() {
		EmployeeResponse response = new EmployeeResponse();
		List<EmployeeBean> employeeBeans = service.getAllData();
		if (employeeBeans != null) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("Employee details found");
			response.setEmployeeBeans(employeeBeans);
		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Details Not found");
		}
		return response;
	}// end of getAll

	@DeleteMapping(path = "/delete/{emp_id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse deleteEmp(@PathVariable(name = "emp_id") int id) {
		EmployeeResponse employeeResponse = new EmployeeResponse();
		if (service.isdelete(id)) {
			employeeResponse.setStatusCode(200);
			employeeResponse.setMsg("success");
			employeeResponse.setDescription(" Data Deleted for id : " + id);
		} else {
			employeeResponse.setStatusCode(400);
			employeeResponse.setMsg("failure");
			employeeResponse.setDescription(" Data Not for id : " + id);
		}

		return employeeResponse;
	}//

	@PostMapping(path = "/add", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse addEmp(@RequestBody EmployeeBean employeeBean) {
		EmployeeResponse response = new EmployeeResponse();
		if (service.addEmployee(employeeBean)) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("Added Successfully");
		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Something Went Wrong");
		}
		return response;
	}//

	@PutMapping(path = "/update", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse updateEmp(@RequestBody EmployeeBean bean) {
		System.out.println(bean);
		EmployeeResponse response = new EmployeeResponse();
		if (service.updateEmployee(bean)) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("Added Successfully");
		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Something Went Wrong");
		}
		return response;
	}	

}
