import React from 'react'

// [1] class 속성, App10.css 추가
// [2] button을 클릭할 때 이벤트 처리 속성 추가: camelCase
// [3] 버튼을 비활성화/활성화 true/false 값을 할당하지 않으면 true 로 인식
// [4] inline css 적용: style=""
import './App10.css'

function App() {
  const x = "myclass";

  const btn_click = () => {
    alert("버튼 클릭됨!!");
  }

  // js 객체만 JSX의 css 속성명으로 사용 할 수 있다.
  // font-size camelCase 로 작성
  const divStyle = {
      color: "red"
    , fontSize: "20px"
    , backgroundColor : "lightyellow"
  }

  return (
    <>
      <h1 className={x}>
          Hello World!
      </h1>
      <button onClick={btn_click} disabled>Click me 1</button>
      <button onClick={btn_click} disabled={true}>Click me 2</button>
      <button onClick={btn_click} disabled={false}>Click me 3</button>
      <div style={divStyle}>
        Lorem ipsum dolor sit amet consectetur, adipisicing elit. Odit sint debitis cupiditate distinctio laudantium sit quos. Tempore qui consequuntur porro doloremque harum vel possimus facilis eligendi delectus placeat, reiciendis quidem.
        
      </div>
   </>
  )
}

export default App