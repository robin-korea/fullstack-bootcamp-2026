import React from 'react'

function App() {

  //DB 테이블 데이터
  const names = [
    {
      seq: 1,
      name: '강아지'
    },
    {
      seq: 2,
      name: '고양이'
    },
    {
      seq: 3,
      name: '타조'
    },
    {
      seq: 4,
      name: '이구아나'
    },
    {
      seq: 5,
      name: '곰'
    }
  ];

  return (
    <div>
      <h1>동물 정보 출력</h1>
        <ul>
            {names.map((item, index) => {
                return <li key={item.seq}>{item.name}</li>
            })}
        </ul>
    </div>
  )
}

export default App