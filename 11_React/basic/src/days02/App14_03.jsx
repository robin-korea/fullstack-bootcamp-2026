// [React Props] 컴포넌트 간에 속성 전달

import React from 'react'

function Car (props) {
    return (
        <>
            <h2>My {props.name} </h2>
        </>
    )
}

function App() {
  
  const name = "Ford";

  return (
    <div>
      <Car name = {name} />
    </div>
  )
}

export default App