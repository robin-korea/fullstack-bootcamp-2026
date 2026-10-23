import React, { useState } from 'react'

function App() {

  let txt2 = 'A'; // 지역변수
  const [txt, setTxt] = useState('');
  const [txt3, setTxt3] = useState('');

  function method1(e){
    setTxt(e.target.value);
    txt2 = 'B';
  }

  function method2(e){
    setTxt3(e.target.value);
  }

  return (
    <div>
      <h1>제어 컴포넌트</h1>
      <form>
        <input type="text" onChange={method1} />
        <input type="text" onChange={method2} />
        <hr />
        <div>현재 입력값: {txt} </div>
        <div>txt2: {txt2}</div>
        <div>두번째 테스트박스 입력값: {txt3} </div>
      </form>
    </div>
  )
}

export default App