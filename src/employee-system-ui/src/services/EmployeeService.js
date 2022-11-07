import axios from "axios";

const baseUrl = "http://localhost:8080/employees";

class EmployeeService {

    saveEmployee(employee) {
        return axios.post(baseUrl, employee);
    }
}

export default new EmployeeService();