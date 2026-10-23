// [React 컴포넌트]
// 1. 컴포넌트는 독립적이고 재사용 가능한 코드 조각
// 2. 자바스크립트 함수와 동일한 목적하지만 차이점은 HTML 요소를 반환
// 3. 2가지 종류의 컴포넌트
//    1) 클래스 컴포넌트
//    2) 함수 컴포넌트 + 훅(Hooks) (권장)

import React from 'react'

/*
function App() {
  return (
    <h1>Hi~</h1>
  )
}
*/
// [2] props 인수는 속성을 나타내는 '<property>' 형식으로 컴포넌트에 전달 가능

function Car(props) {
    return (
        <h2>I am a {props.color} Car.</h2>
    )
}

function App() {
  return (
    <>
        <h1>안녕하세요!</h1>
        <Car color="red" />
        <Car color="blue" />
        <Car />
    </>
  )
}
export default App