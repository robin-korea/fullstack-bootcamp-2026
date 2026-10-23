import React, { useState } from 'react'

function App() {
  
  const [text, setText] = useState('');
  const isValid = text.length >= 5; // false

  function m1(event){
    setText(event.target.value);
  }

  function send(event) {
    // submit 취소
    event.preventDefault();
    alert(text + " 전송");
  }
  
  return (
    <div>
      <h1>제어 컴포넌트</h1>
      <form onSubmit={send}>
        <input type='text' onChange={m1} />
        <hr />
        {!isValid && <p>5자 이상을 입력하세요.</p>}
        <hr />
        <div>현재 입력값: {text}</div>
        <hr />
        <input type='submit' value='보내기' disabled={!isValid} />
      </form>
    </div>
  )
}

export default App