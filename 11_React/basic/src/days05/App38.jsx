// [React Hooks(훅)]
// 1. 훅(Hooks) 이란? 함수형 컴포넌트에서 React의 상태 및 생명주기 기능에 접근할 수 있도록 해주는 함수.
// 2. 상태 란? 일반적으로 추적해야 하는 어플리케이션 데이터 또는 속성을 의미

// [useState 훅 설명]
// 1. useState 훅을 사용하면 함수 컴포넌트의 상태를 추적할 수 있다.
// 2. 상태 == 데이터 또는 속성을 의미
// 3. import {useState} from 'react'
// 4. = useState(초기값)
// 5. 형식    상태변수 상태변수를 업데이트하는 함수  초기값
//      const [color, setColor] = useState('red')

import React, { useState } from 'react'

function App() {

    // const color = 'red';

    const [color, setColor] = useState('red');
    const [brand, setBrand] = useState("Ford");
    const [model, setModel] = useState("Mustang");
    const [year, setYear] = useState("1964");
    const [car, setCar] = useState({});
    const [names, setNames] = useState([]);

  return (
    <div>
      <h1 style={{color: color}}>My favorite color is {color} </h1>

      <div style={{
        display: 'flex',
        gap: '10px',
        justifyContent: 'center'
      }}>

        <button type='button' onClick={() => setColor('blue')}>Blue</button>
        <button type='button' onClick={() => setColor('green')}>Green</button>
        <button type='button' onClick={() => setColor('red')}>Red</button>
        <button type='button' onClick={() => setColor('black')}>Black</button>
      </div>
    </div>
  )
}

export default App