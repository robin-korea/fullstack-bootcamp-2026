// [React Props.children]
// 1. 컴포넌트의 시작태그 ~ 종료태그 사이의 내용(content)을 다른 컴포넌트로 전달 할 수 있다.
// 2. 부모 컴포넌트에서 자식 및 자식 컴포넌트의 시작 태그~종료 태그 사이의 내용을 전달한다.
// 3. Props.children

import React from 'react'

function ChildContent({child}){
  return (
      <p>
        This was written in the Parent component,
          but displayed as a part of the {child} component
      </p>
  )
}

function Son(props){
  return (
    <div style={{backgroundColor: 'lightgreen'}}>
      <h2>Son</h2>
      {/* <ChildContent /> */}
      <div>{props.children}</div>
    </div>
  )
}

function Daughter(props){
  return (
    <div style={{backgroundColor: 'lightcyan'}}>
      <h2>Daughter</h2>
      {/* <ChildContent /> */}
      <div>{props.children}</div>
    </div>
  )
}
function Parent(){
  return (
    <div>
      <h1>My Two Children</h1>
      <Son>
        <ChildContent child="son" />
      </Son>
      <br />
      <Daughter>
        <ChildContent child="daughter" />
      </Daughter>
    </div>
  )
}

function App() {
  return (
    <Parent />
  )
}

export default App