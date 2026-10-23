import React from 'react'

// [1] JSX 식에는 부모 요소가 하나 있어야 한다.
// function App() {
//   return (
//         <h1>My Car</h1>
//         <p>It has 10*3 horsepower</p>
//   )
// }

// [2] 부모 요소 하나 추가
// function App() {
//   return (
//     <div>
//         <h1>My Car</h1>
//         <p>It has 10*3 horsepower</p>
//     </div>
//   )
// }

// [3] JSX 표현식 {} 중괄호
// function App() {
//   return (
//     <div>
//         <h1>My Car</h1>
//         <p>It has {10*3} horsepower</p>
//     </div>
//   )
// }

// [4] JSX 불필요한 부모 요소(div) 제거...
// function App() {
//   return (
//     <>
//         <h1>My Car</h1>
//         <p>It has {10*3} horsepower</p>
//     </>
//   )
// }

// [5] JSX 불필요한 부모 요소(div) 제거... key 값 설정
// 중괄호 {} 묶으면 js 표현식, 변수, 함수, 객체 를 JSX 내부에 삽입할 수 있다.
function App() {
  const name = 'hong';

  const message = `이름은 ${name}이다.`

  function test(kw){
    return kw * 100;
  }

  const person = {
    name:"admin",
    age:30
  }
  return (
    <React.Fragment>
        <h1>My Car</h1>
        <p>It has {10*3} horsepower - {name} / {test(12)} / {person.name} / {person.age}</p>
    </React.Fragment>
  )
}

export default App