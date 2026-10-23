import React, { useState } from 'react'

function App() {

  const [name, setName] = useState('');
  const [age, setAge] = useState('');
  const [address, setAddress] = useState('');

  return (
    <>
      <h1>다중 컨트롤 + useState</h1>
      <form>
        <div>
          <label>이름: </label>
          <input
            type="text"
            onChange={(event) => setName(event.target.value)}
          />
        </div>
        <div>
          <label>나이: </label>
          <input type="text" onChange={(event) => setAge(event.target.value)} />
        </div>
        <div>
          <label>주소: </label>
          <input
            type="text"
            onChange={(event) => setAddress(event.target.value)}
          />
        </div>
        <div>
          <h3>입력값 확인</h3>
          <ul>
            <li>이름: {name}</li>
            <li>나이: {age}</li>
            <li>주소: {address}</li>
          </ul>
        </div>
      </form>
    </>
  )
}

export default App