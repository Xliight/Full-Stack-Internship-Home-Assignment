import { BrowserRouter as Router, Route, Routes, Navigate } from 'react-router-dom';

import Home from "./components/Home";
import { Box } from '@chakra-ui/react';
import Result from './components/elements/Result';




function App() {




  return (
    <>
    <Router>
      <Box className="App" bgColor={"#f7f9fa"} >
        <Routes>
            <Route path='/' element={<Home/>}/>
            <Route path='/result' element={<Result/>}/>
            
            <Route path="*" element={<Navigate to='/'/>} />
        </Routes>
      </Box>
    </Router>
      

    </>
  );
}

export default App;
