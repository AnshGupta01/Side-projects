import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Home from './Home';
import About from './About';
import Contact from './Contact';
import Error from './Error';
import MainHeader from './Component/MainHeader';

function App() {
  return (
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<MainHeader/>} >
        {/* To show home data on mainheader page we use index keyword */}
        <Route index element={<Home/>}/>
        <Route path='about' element={<About/>}/>
        <Route path='contact' element={<Contact/>}/>
        <Route path="*" element={<Error/>}/>
      </Route>  
    </Routes>
    </BrowserRouter>
  );
}

export default App;
