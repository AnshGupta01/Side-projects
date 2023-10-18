import "./App.css";

//components
import NavBar from "./components/NavBar";
import Alluser from "./components/all_users";
import Adduser from "./components/add_users";
import Ansh from "./components/ansh";
import EditUser from "./components/editUser";

import { BrowserRouter, Routes, Route } from "react-router-dom";

function App() {
  return (
    <BrowserRouter>
      <NavBar />
      <Routes>
        <Route path="/" element={<Ansh />} />
        <Route path="/add" element={<Adduser />} />
        <Route path="/all" element={<Alluser />} />
        <Route path="/edit/:id" element={<EditUser />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
