import { useState } from 'react'
// import heroImg from './assets/hero.png'
// import reactLogo from './assets/react.svg'
// import viteLogo from './assets/vite.svg'
import './App.css'

// Greeting 컴포넌트
/* [1]
function Greeting(){
  return (
      <h1>Hello World~~</h1>
  )
}
*/
/* [2]
function Greeting(props){
  return (
      <h1>Hello World {props.name}/{props.age}~~</h1>
  )
}
*/
function Greeting({ name }){
  return (
      <h1>Hello World {name}~</h1>
  )
}

// App 컴포넌트
function App() {
  
  return (
      <Greeting  name="Hong" age={20} />
  );
}

export default App
