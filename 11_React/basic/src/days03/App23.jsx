// [React radio]

import React, { useState } from 'react'

function App() {

  const [selectedFruit, setSelectedFruit] = useState('cherry');

  const handleChange = (event) => {
    setSelectedFruit(event.target.value);
  }

  const handleSubmit = (event) => {
    event.preventDefault();
    alert(`선택한 과일은 ${selectedFruit}이다.`);
  }

  return (
    <form onSubmit={handleSubmit}>
      <p>좋아하는 과일: </p>
      <label>
        <input type='radio' name='fruit' value='apple'
        checked={selectedFruit === 'apple'}
        onChange={handleChange} />Apple
      </label>
      <br />
      <label>
        <input type='radio' name='fruit' value='banana'
        checked={selectedFruit === 'banana'}
        onChange={handleChange} />Banana
      </label>
      <br />
      <label>
        <input type='radio' name='fruit' value='cherry'
        checked={selectedFruit === 'cherry'}
        onChange={handleChange} />Cherry
      </label>
      <br />
      <button type='submit'>Submit</button>
    </form>
  )
}

export default App