// [React Form]
// 1. html의 form 와 마찬가지의 역할
// 2. html 의 form 요소들은 사용자 입력한 값을 자체적으로 유지되지만
//    react의 form 요소들의 값은 컴포넌트의 state 속성에 저장되며
//    setState()함수를 통해서만 값을 업데이트 할 수 있다.

// 정상적으로 작동하고, form 양식이 제출되고 새로 고침.
import React from 'react'

function App() {
  return (
    <MyForm />
  )
}

function MyForm() {
  return (
    <form>
        <label>Enter Yout Name:
            <input type='text' />
        </label>
    </form>
  )
}

export default App