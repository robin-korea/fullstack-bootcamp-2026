import React from 'react'

function App() {

  const dog = {
    name : '강아지',
    age : 3,
    gender:'m'
  };

  let gender = "여자";
  if(dog.gender === "m"){
    gender = "남자";
  }

  return (
    <div>
        <h1>dog 객체 정보</h1>
        <ul>
            <li>{dog.name}</li>
            <li>{dog.age}</li>
            <li>{dog.gender}</li>
            <li>{gender}</li>
            <li>{dog.gender === "m" ? '남자' : '여자'}</li>
        </ul>
        <ul>
            {Object.values(dog).map((info, index) => {
                <li key={index}>{info}</li>
            })}
        </ul>
    </div>
  )
}

export default App