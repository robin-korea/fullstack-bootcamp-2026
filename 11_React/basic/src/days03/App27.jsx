// [React CSS 스타일링]
// 1) 인라인 스타일링
// 2) css 스타일시트
// 3) css 모듈

import React from 'react'
import './App27_02_style.css';

const Header = () => {
  return (
    <>
      <h1 style={{color:'red'}}>Hello Header Style!</h1>
      <p>Add a little style!</p>
    </>
  )
}

// JSX CSS 객체로 스타일링
function Footer(){

  const myStyle = {
    color: "white",
    backgroundColor: "DodgerBlue",
    padding: "10px",
    fontFamily: "Sans-Serif"
  };

  return (
    <>
      <h1 style={myStyle}>Hello Footer Style!</h1>
      <p>Footer</p>
    </>
  )
}

// 2) CSS 스타일 시트
const Main = () => {
  return (
    <>
      <h3>Hello Main Style!</h3>
      <div>Main</div>
    </>
  )
}

function App() {
  return (
    <div>
      <Header />
      <Main />
      <Footer />
    </div>
  )
}

export default App