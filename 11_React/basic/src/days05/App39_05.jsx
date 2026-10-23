import React, { useEffect } from 'react'
import { Link, Route, Routes } from 'react-router-dom'

function Home() {
  return (
    <>
      <h2>시작 페이지</h2>
      <p>시작 페이지입니다.</p>
      <p>시작 페이지입니다.</p>
      <p>시작 페이지입니다.</p>
    </>
  );
}

function Admin() {
  return (
    <>
      <h2>관리자 페이지</h2>
      <p>관리자 페이지입니다.</p>
      <p>관리자 페이지입니다.</p>
      <p>관리자 페이지입니다.</p>
    </>
  );
}

function Member() {
  // 첫 번째 렌더링 될 때 한 번만 효과를 주겠다.
  useEffect(
    () => {
      const id = setInterval(() => {
                console.log('Member 업무 > ' + new Date().toTimeString());
              }, 1000);
      return () => {
          console.log('Member Cleanup');
          clearInterval(id);
      };
    }
        , []
  )
  return (
    <>
      <h2>회원 페이지</h2>
      <p>회원 페이지입니다.</p>
      <p>회원 페이지입니다.</p>
      <p>회원 페이지입니다.</p>
    </>
  );
}


function App() {
  return (
    <>
      <nav>
        <Link to="/">Home</Link>    {' '}|{' '}
        <Link to="/admin">Admin</Link>    {' '}|{' '}
        <Link to="/member">Member</Link>
      </nav>

      <Routes>
        <Route path='/' element={<Home />}/>
        <Route path='/admin' element={<Admin />}/>
        <Route path='/member' element={<Member />}/>
      </Routes>
    </>
  )
}

export default App