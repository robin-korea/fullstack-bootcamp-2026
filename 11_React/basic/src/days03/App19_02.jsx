// 1. 요소의 입력값은 React state에 따라 결정되며, 해당 값의 변경 사항은
//    state 를 업데이트 하는 이벤트 핸들러에 의해 관리된다.
// 2. 함수형 컴포넌트 + 훅(Hooks)을 사용하면, 각 입력값을 추적하고
//    사용할 수 있다.
// 3. React Hooks:  함수형 컴포넌트에서 React의 상태 및 생명주기 기능에 "접근"할 수 있도록 해주는 함수이다.
import React, { useState } from 'react'

function MyForm(){

  const [name, setName] = useState('')

  function handlerChange(e){
    setName(e.target.value);
  }

  return (
    <form>
      <label>Enter Your Name:
        <input type='text' value={name} onChange={handlerChange}></input>
      </label>
      <p>
        Current Name: {name}
      </p>
    </form>
  )
}

function App() {
  return (
    <MyForm />
  )
}

export default App