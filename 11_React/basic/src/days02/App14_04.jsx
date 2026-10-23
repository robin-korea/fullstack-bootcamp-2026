import React from "react"

function Student(props){
  return (
    <div>
      저는 {props.name}이고, 나이는 {props.age}살 입니다.
    </div>
  )
}

function App(){
  return (
    <div>
      <h1>학생 명단</h1>
      <Student name = "홍길동1" age="20" />
      <Student name = "홍길동2" age="21" />
      <Student name = "홍길동3" age="22" />
      <Student name = "홍길동4" age="23" />
    </div>
  )
}
export default App