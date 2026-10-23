// [논리 && 연산자]
// 1. 왼쪽 피연산자가 참일 경우에만 오른쪽 피 연산자가 렌더링된다

import React from 'react'

function Car(props){
  return (
    <>
      {props.brand && <h1>My Car is {props.brand}.</h1>}
    </>
  )
}

function App() {
  return (
    <div>
      1. <Car brand="Ford" />
      2. <Car />
    </div>
  )
}

export default App