// [React select]
// 1. html 다른 점: selected 속성X -> value 속성 사용

import React, { useState } from 'react'

function App() {

  const [myCar, setMyCar] = useState('Ford');

  const handleChange = (event) => {
    setMyCar(event.target.value);
  }

  const [gender, setGender] = useState('f');

  return (
    <form>
      <select value={gender} onChange={(event => setGender(event.target.value))}>
        <option value="m">남자</option>
        <option value="f">여자</option>
      </select>
      <br /><br />
      <p>
         {gender}
      </p>
      <hr />
      <select value={myCar} onChange={handleChange}>
        <option value="Ford">Ford</option>
        <option value="Volvo">Volvo</option>
        <option value="Fiat">Fiat</option>
      </select>
      <br /><br />
      선택한 차 : <input type='text' value={myCar} readOnly/>
    </form>
  )
}

export default App