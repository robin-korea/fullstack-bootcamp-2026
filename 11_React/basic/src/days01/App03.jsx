import { useState } from 'react'
// import heroImg from '../assets/hero.png'
// import reactLogo from '../assets/react.svg'
// import viteLogo from '../assets/vite.svg'
// import '../App.css'

function App() {
  
  const userArr = [
    {id:1, name:'john', age:20},
    {id:2, name:'admin', age:15},
    {id:3, name:'hong', age:25}
  ];

  return (
       <ul>
         {userArr.map(user => <li key={user.id}>{user.name}/{user.age}</li>)}
       </ul>
  );
}

export default App
