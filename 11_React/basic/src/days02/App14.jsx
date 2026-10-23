// [React Props]
// 1. React 컴포넌트에 전달되는 인자가 props 이다.
// 2. 속성은 html 속성을 통해 컴포넌트로 전달된다.
//  예) <Car 속성명=속성값  속성명=속성값 /> -> 속성들 -> props

import React from 'react'

function Car (props) {
    return (
        <>
            <h2>My {props.carInfo.name} {props.carInfo.model} </h2>
            <p>It is {props.carInfo.color} and it is from {props.carInfo.year}!</p>
        </>
    )
}

function App() {
  const carInfo = {
    name : "Ford",
    model : "Mustang",
    color : "red",
    year : 1969
  }

  return (
    <div>
      <Car carInfo={carInfo} />
    </div>
  )
}

export default App