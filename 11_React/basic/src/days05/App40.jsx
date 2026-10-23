// [useRef 훅 설명]
// 1. input 요소에 포커스 : DOM 요소에 접근
//     DOM 요소에 직접 접근하는 데도 사용
// 2. 렌더링 될 때 값을 유지 하는 목적으로 사용: useRef 훅 -> 화면이 렌더링 되지 않는다
// 3. 렌더링 될 때 값을 유지 하는 목적으로 사용: useState 훅 -> 화면이 렌더링 된다.

import React, { useEffect, useRef, useState } from 'react'

function App() {

  const count = useRef(0);
  const [inputValue, setInputValue] = useState("");

  // 매번 랜더링 될 때 마다 호출
  useEffect(()=>{
    count.current = count.current + 1;
  });

  return (
    <div>
      <p>Type in the input field: </p>
      <input type='text' value={inputValue} onChange={(e) => setInputValue(e.target.value)}/>

      <h1>useRef.count : {count.current}</h1>
    </div>
  )
}

export default App