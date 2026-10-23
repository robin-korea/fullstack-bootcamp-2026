// React 는 if 문을 지원하지만, JSX 내부에서는 사용할 수 없다.
// React 는 JSX 외부에서는 사용할 수 있고, 내부에서는 삼항 연산자를 사용한다.

import React from 'react'

// x가 100 이상이면 Admin 그렇지 않으면 Hong 대입 -> 출력
function App() {
  const x = 90;
  let y = "Admin";

  // JSX 외부
//   if (x < 100) {
//     y = "Hong";
//   }
  
  // JSX 내부에는 if 문 사용 X => ? : 사용
  return (
    <div>
      <h1>{y}</h1>
      <h1>{ x >= 100 ? y : 'Hong'}</h1>
    </div>
  )
}

export default App