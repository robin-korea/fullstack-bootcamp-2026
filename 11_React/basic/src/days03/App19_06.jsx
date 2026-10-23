import React, { useState } from 'react'

function App() {

  const [form, setForm] = useState({
    name: '',
    age: '',
    address: ''
  });

  function handleForm(event){
    // 이름, 나이, 주소 ? event.target
    const key = event.target.name; // name, age, address
    const value = event.target.value;

     setForm((obj) => ({
      ...obj,
      [key]: value
    }));
  }

  return (
    <>
      <h1>다중 컨트롤 + useState</h1>
      <form>
        <div>
          <label>이름: </label>
          <input
            type="text"
            name="name"
            onChange={handleForm}
          />
        </div>
        <div>
          <label>나이: </label>
          <input type="text" 
           name="age"
           onChange={handleForm} />
        </div>
        <div>
          <label>주소: </label>
          <input
            type="text"
            name="address"
            onChange={handleForm}
          />
        </div>
        <div>
          <h3>입력값 확인</h3>
          <ul>
            <li>이름: {form.name}</li>
            <li>나이: {form.age}</li>
            <li>주소: {form.address}</li>
          </ul>
        </div>
      </form>
    </>
  )
}

export default App