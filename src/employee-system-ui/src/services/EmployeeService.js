import axios from "axios";

const baseUrl = "http://localhost:8080/employees";

class EmployeeService {

    saveEmployee(employee) {
        return axios.post(baseUrl, employee);
    }

    getEmployees() {
        return axios.get(baseUrl);
    }
}

export default new EmployeeService();