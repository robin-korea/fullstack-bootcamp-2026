// [React 구조 분해 속성]
// 1. 구조 분해 할당을 사용하면 컴포넌트가 받을 수 있는 속성을 제한할 수 있다.
// 2. React는 중괄호{}을 사용해서 props 를 구조 분해한다.

import React from 'react'

/* [1]
function Car({model}){
  return (
    <h1>My Car is {model}</h1>
  )
}
*/
/*
// [2] Car 컴포넌트 내부에서 필요한 속성만을 구조 분해해서 사용
function Car(props){

  // 내부에서 구조 분해
  const {brand, model} = props;

  return (
    <h1>My Car is {model} / {brand}</h1>
  )
}
*/

/*
// [3] 2개는 구조분해 해서 받고 나머지 속성을 모두 객체에 받는 법
// ...rest : 나머지 속성을 가지고 있는 객체
function Car({brand, model, ...rest}){

  // 내부에서 구조 분해
  // const {brand, model} = props;

  return (
    <h1>My Car is {model} / {brand} / {rest.color}</h1>
  )
}
*/

// [4] 구조분해 할당을 사용하면 속성의 기본값을 설정할 수 있다.
function Car({brand, name="KKK"}){

  return (
    <h1>My Car is {brand} / {name}. </h1>
  )
}

function App() {
  // JSX 내부에 문자열은 "", 숫자는 중괄호{} 표현식
  return (
    <div>
      <Car brand="Ford" model = "Mustang" color="red" year={1969} />
    </div>
  )
}

export default App