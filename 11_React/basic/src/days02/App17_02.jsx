// [React 조건부 렌더링] 삼항 연산자로 수정
import React from 'react'

function MisssedGoal(){
  return <h1>MISSED!!!</h1>
}

function MadeGoal(){
  return <h1>GOAL~~~</h1>
}

// function CheckGoal({isGoal})
function CheckGoal(props){
  const isGoal = props.isGoal;
  
  // 삼항 연산자로 수정
  return (
    <>
      {isGoal ? <MadeGoal /> : <MisssedGoal/>}
    </>
  )
  // if(isGoal){
  //   return <MadeGoal />
  // }else{
  //   return <MisssedGoal />
  // }
}

function App() {
  return (
    <div>
      <CheckGoal isGoal = {false} />
      <CheckGoal isGoal />
    </div>
  )
}

export default App