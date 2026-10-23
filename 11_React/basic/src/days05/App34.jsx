import React from 'react'
import { Link, Route, Routes, useParams } from 'react-router-dom';

function Base(){
    return (
        <ul>
            <li>
                <Link to="/user/1/홍길동">1번 회원</Link>
            </li>
            <li>
                <Link to="/user/2/강아지">2번 회원</Link>
            </li>
            <li>
                <Link to="/user/3/고양이">3번 회원</Link>
            </li>
        </ul>
    );
}

function User(){
    // 2개의 파라미터가 넘어오고 있다
    const {id, name} = useParams();
    return (
        <>
            <h1>User 정보</h1>
            <p>회원 번호: {id}</p>
            <p>회원 이름: {name}</p>
        </>
    )
}

function App() {
  return (
    <>
      <h1>User 목록</h1>
      <Routes>
        <Route path='/' element={ <Base/> } />
        <Route path='/user/:id/:name' element={ <User/>} />
      </Routes>
    </>
  );
}

export default App