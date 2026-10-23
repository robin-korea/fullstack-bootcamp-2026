import { useState } from 'react'
// import heroImg from '../assets/hero.png'
// import reactLogo from '../assets/react.svg'
// import viteLogo from '../assets/vite.svg'
// import '../App.css'

function App() {
  const nameArr = ['홍길동','서영학','정창기'];
  return (
       <ul>
         {nameArr.map(name => <li key={name}>{name}</li>)}
       </ul>
  );
}

export default App
