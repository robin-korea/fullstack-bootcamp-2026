import React, { useState } from 'react'

function App() {
  const [text, setText] = useState('초깃값');
  const [multiText, setMultiText] = useState('초깃값');
  const [flag, setFlag] = useState(true);
  const [gender, setGender] = useState('f');

  return (
    <div>
      <h1>각 종 컨트롤 + 상태 관리</h1>

       <h2>텍스트 박스</h2>
      <div>
        <input
          type="text"
          value={text}
          onChange={(event) => setText(event.target.value)}
        />
      </div>
      <div class="message">{text}</div>

      <h2>다중라인 텍스트 박스</h2>
      <div>
        {/* <textarea onChange={event => setText(event.target.value)}>{text}</textarea> */}
        <textarea
          value={multiText}
          onChange={(event) => setMultiText(event.target.value)}
        ></textarea>
      </div>
      <div class="message">{multiText}</div>

      <h2>체크 박스</h2>
      <div>
        <input
          type="checkbox"
          checked={flag}
          onChange={(event) => setFlag(event.target.checked)}
        />
      </div>
      {/* 리액트는 표현식에 boolean을 넣으면 아무것도 출력 안한다. */}
      <div class="message">{flag ? '참' : '거짓'}</div>

      <h2>셀렉트 박스</h2>
      <div>
        <select
         value={gender}
         onChange={(event) => setGender(event.target.value)}
        >
          <option value="m">남자</option>
          <option value="f">여자</option>
        </select>
      </div>
      <div class="message">{gender}</div>
    </div>
  )
}

export default App