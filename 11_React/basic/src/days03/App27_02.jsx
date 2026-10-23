// 3) css모듈
//   (1) css 모듈은 별도의 파일에 배치된 구성 요소에 편리하다.
//      (컴포넌트 Header.jsx)
//   (2) 모듈 내의 css는 해당 모듈을 가져온 컴포넌트에서 만 사용할 수 있다.
//   (3) css 선택자 충돌에 대한 문제 X
//   (4) 모듈: .module.css 확장자로 저장

import React, { useState } from 'react'
import styles from './App27_02_style.module.css';

function App() {

  function handleClick(event){

  }

  const boxStyle = {

  }

  const [active, setActive] = useState(false);

  return (
    <div>
      <h1 className={styles.bigred}>React Style</h1>

      <button onClick={handleClick}>상태 변경</button>

      <div style={boxStyle}>
        {active ? '활성 상태입니다.' : '비활성 상태입니다.'}
      </div>
    </div>
  )
}

export default App