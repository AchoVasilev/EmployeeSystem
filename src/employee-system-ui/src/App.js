import './App.css';
import Navbar from './components/Navbar';
import AddEmployee from './components/AddEmployee';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import ListEmployees from './components/ListEmployees';
import EditEmployee from './components/EditEmployee';

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
          <Route path='/editEmployee/:id' element={<EditEmployee />}></Route>
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
