// 메모리 누수를 줄이기 위한 정리 코딩이 필요
// 타임아웃, 더 이상 필요하지 않는 효과는 해제

import React, { useEffect, useState } from 'react'

function App() {

  const [count, setCount] = useState(0); 

  // 버튼을 클릭하면 count * 2 해서 값을 calculation 변수에 저장
  useEffect(() => {
    let timer = setTimeout(
      () => {setCount(() => count + 1); }
      , 1000
    );

    // useEffect 훅의 끝에 반환 함수를 포함 해서 누수 정리할 수 있다.
    return () => clearTimeout(timer);
  }
  , []); // 1번

  return (
    <div>
      <p>Count : {count}</p>
    </div>
  )
}

export default App