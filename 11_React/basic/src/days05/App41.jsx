// [useCallback == useMemo 훅]

// 1. 서로 다른 두 컴포넌트가 같은 값을 보여주고 바꿔야 할 때 상태를 어디에 두어야 하는 지 체크해 보자

import React, { useState } from 'react'

function BoxA(props){
    // const [count, setCount] = useState(0);
     return (
    <>
      <h2>BoxA</h2>
      <div>count: {props.count}</div>
      <button onClick={(event) => props.onIncrease(props.count + 1)}>증가</button>
    </>
  );
}

function BoxB(props){
    // const [count, setCount] = useState(0);
     return (
    <>
      <h2>BoxB</h2>
      <div>count: {props.count}</div>
      <button onClick={(event) => props.onIncrease(props.count + 1)}>증가</button>
    </>
  );
}

function App() {
  
  // 부모 컴포넌트에 자식 컴포넌트가 공유할 상태 변수 선언
  const [count, setCount] = useState(0);

  return (
    <div>
      <BoxA count={count} onIncrease={setCount}/>
      <br />
      <br />
      <BoxB count={count} onIncrease={setCount}/>

      <hr />
      <button onClick={(event) => setCount(count + 1)}>증가</button>
    </div>
  )
}

export default App