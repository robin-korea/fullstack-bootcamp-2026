// [React Props] 배열 속성


import React from 'react'

function Car (props) {
    return (
        <>
            <h2>My {props.carInfo[0]} {props.carInfo[1]} </h2>
        </>
    )
}

function App() {
  
  const carInfo = ["Ford", "Mustang"];

  return (
    <div>
      <Car carInfo={carInfo} />
    </div>
  )
}

export default App