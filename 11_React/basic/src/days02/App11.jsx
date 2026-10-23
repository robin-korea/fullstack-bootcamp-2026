// [React 이벤트]
// HTML DOM 이벤트와 마찬가지로 React도 사용자 이벤트에 따라 동작 처리 가능
// click, change, mouseover 등 이벤트 지원
// React 이벤트는 camelCase 구문으로 작성

import React from 'react'

function App() {

  const clickhandler = () => {
    alert("버튼 3 클릭됨!")
  }

  const clickhandler2 = (name, event) => {
    alert(`버튼 4 ${name} 클릭됨! - ${event.type}`)
  }

  return (
    <>
      <button onClick={function (){
        alert('버튼 1 클릭됨');
      }}>button 1</button>
      <button onClick={()=>{
        alert('버튼 2 클릭됨');
      }}>button 2</button>
      <button onClick={clickhandler}>button 3</button>

      {/* 버튼을 클릭할 때 매개변수를 넘기도록 */}
      {/* 함수 홀출을 해야 하는데 아래 표현식은 등록 */}
      {/* <button onClick={clickhandler2("홍길동")}>button 4</button> */}
      <button onClick={(event) => clickhandler2("홍길동", event)}>button 4</button>
    </>
  )
}

export default App