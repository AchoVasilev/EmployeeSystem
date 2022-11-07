import './App.css';
import Navbar from './components/Navbar';
import AddEmployee from './components/AddEmployee';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import ListEmployees from './components/ListEmployees';

function App() {
  return (
    <>
      <BrowserRouter>
        <Navbar />
        <Routes>
          <Route path='/' element={<ListEmployees />}></Route>
          <Route index element={<ListEmployees />}></Route>
          <Route path='/employeeList' element={<ListEmployees />}></Route>
          <Route path='/addEmployee' element={<AddEmployee />}></Route>
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
