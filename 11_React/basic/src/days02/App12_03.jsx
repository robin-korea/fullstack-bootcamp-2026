import React from 'react'
import Li from './App12_03_Li.jsx';

// App12_03_Li.jsx 파일로 분리해서 컴포넌트
// function Li(item) {
//     return <li key={item}>* {item}</li>
// }

function App() {
  
  const animals = ['강아지', '고양이', '타조', '이구아나', '곰'];

  return (
    <div>
      <h1>반복문</h1>
      <ul>
        {
            animals.map( (item, index) => {
                // return <li key={index}>{item}</li>
                return Li(item)
            })
        }
      </ul>
    </div>
  )
}

export default App