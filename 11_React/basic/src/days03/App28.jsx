// css 모듈:  css 충돌 해결
import React from 'react'
import ComponentA from './App28_ComponentA'
import ComponentB from './App28_ComponentB'

function App() {
  return (
    <div>
      <h1>React Style Module~</h1>
      <ComponentA />
      <ComponentB />
    </div>
  )
}

export default App