import { useState } from 'react'
// import heroImg from '../assets/hero.png'
// import reactLogo from '../assets/react.svg'
// import viteLogo from '../assets/vite.svg'
// import '../App.css'
 
// App 컴포넌트
function App() {

  const [count, setCount] =  useState(0);
  
  return (
      <button onClick={()=> setCount(count+1)}>Count : {count}</button> 
  );
}

export default App
