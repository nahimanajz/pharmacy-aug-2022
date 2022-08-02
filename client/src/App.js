import { Routes, Route } from 'react-router-dom';
import './App.css';
import './index.css';
import { Signup } from './screens/Signup';
import Signin from './screens/Signin';
import { Info } from './screens/Info';
function App() {
  return (
    <div className="app__container">
      <Routes>
        <Route path="/" element={<Signup/>}/>
        <Route path="/login" element={<Signin/>}/>
        <Route path="/info" element={<Info />}/>

      </Routes>
    </div>
  );
}

export default App;
