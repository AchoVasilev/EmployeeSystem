import axios from "axios";

const baseUrl = "http://localhost:8080/employees";

class EmployeeService {

    saveEmployee(employee) {
        return axios.post(baseUrl, employee);
    }

    getEmployees() {
        return axios.get(baseUrl);
    }

    deleteEmployee(id) {
        return axios.delete(baseUrl + '/' + id);
    }

    getEmployeeById(id) {
        return axios.get(baseUrl + '/' + id);
    }

    updateEmployee(id, employee) {
        return axios.put(baseUrl + '/' + id, employee);
    }
}

export default new EmployeeService();