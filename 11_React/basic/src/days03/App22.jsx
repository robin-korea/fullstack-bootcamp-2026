// [React Checkbox]

import React, { useState } from 'react'

function App() {

  const handleSubmit = (event) => {
    let fillings = '';
    if (inputs.tomato) fillings += 'tomato';
    if (inputs.onion) {
      if (inputs.tomato) fillings += ' and ';
      fillings += 'onion';
    }
    if (fillings == '') fillings = 'no fillings';
    alert(`"${inputs.firstname}" wants a burger with "${fillings}"`);
    event.preventDefault();
  }

  const handleChange = (event) => {
    const target = event.target;
    const key = target.name;
    const value = target.type === 'checkbox' ? target.checked : target.value;
    setInputs( values => ({...values, [key]:value}));
  }

  const [inputs, setInputs] = useState({
    firstname: 'admin',
    tomato: true,
    onion: false
  });

  return (
    <form onSubmit={handleSubmit}>
      <label>My name is:
      <input 
        type="text" 
        name="firstname" 
        value={inputs.firstname} 
        onChange={handleChange}
      />
      </label>

      <p>I want a burger with:</p>
      <label>Tomato:
      <input 
        type="checkbox" 
        name="tomato" 
        checked={inputs.tomato} 
        onChange={handleChange}
      />
      </label>
      <label>Onion:
        <input 
          type="checkbox" 
          name="onion" 
          checked={inputs.onion} 
          onChange={handleChange}
        />
      </label>
      <button type="submit">Submit</button>
    </form>
  )
}

export default App