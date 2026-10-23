// [React 조건부 렌더링]
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
  if(isGoal){
    return <MadeGoal />
  }else{
    return <MisssedGoal />
  }
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