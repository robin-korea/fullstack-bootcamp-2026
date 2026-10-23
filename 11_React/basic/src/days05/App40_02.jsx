// useState, useRef, useEffect 조합하여 이전 상태를 추적
// 1. useRef 사용해서 이전 상태 값을 추적한느 데 사용할 수 있다.

import React, { useEffect, useRef, useState } from 'react'

function App() {

  const [inputValue, setInputValue] = useState(""); // 2
  const previousInputValue = useRef("");
  
  // 4 (렌더링이 완료된 후에 useEffect 안의 함수 실행)
  useEffect(
    ()=>{
       previousInputValue.current = inputValue;
    }
        ,[inputValue]
  )

  // 3
  return (
    <div>
      <input
        type="text"
        value={inputValue}
        onChange={(e) => setInputValue(e.target.value)}  // 1   
      />
      <h2>Current Value: {inputValue}</h2> 
      <h2>Previous Value: {previousInputValue.current}</h2>
    </div>
  )
}

export default App
