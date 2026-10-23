import React, { useRef, useState } from 'react'
import { Link, Route, Routes } from 'react-router-dom';

function Member(){
    // 지역변수 선언
    let localNum = 0;

    function handleLocalNumClick(){
        localNum++;
        console.log("localNum: " + localNum);
    }

    const numRef = useRef(0);

    function handleRefNumClick(){
        numRef.current = numRef.current +1;
        console.log('numRef', numRef.current);
    }

    const [countState, setCountState] = useState(0);

    function handleStateCountClick(){
        setCountState(countState + 1);
        console.log('countState', countState);
    }

    return (
        <>
            <h2>회원(Member) 페이지</h2>
            <p>회원 페이지입니다.</p>
            <p>회원 페이지입니다.</p>
            <p>회원 페이지입니다.</p>

            <hr />

            <p>num: {localNum}</p>
            <button onClick={handleLocalNumClick}>증가</button>

            <hr />
 
            <p>numRef: {numRef.current}</p>
            <button onClick={handleRefNumClick}>증가</button>

            <hr />

            <p>countState: {countState}</p>
            <button onClick={handleStateCountClick}>증가</button>
        </>
    )
}

function Admin(){
    return (
        <>
          <h2>관리자(Admin) 페이지</h2>
        </>
    )
}
function Home(){
    return (
        <>
          <h2>시작(Home) 페이지</h2>
          <p>시작 페이지입니다.</p>
          <p>시작 페이지입니다.</p>
          <p>시작 페이지입니다.</p>
        </>
    )
}

function App() {
  return (
    <div>
        <nav>
            <Link to={'/'}>Home</Link>  {' '} | {' '}
            <Link to={'/member'}>Member</Link>  {' '} | {' '}
            <Link to={'/admin'}>Admin</Link>  {' '} | {' '}
         </nav>
          <Routes>
            <Route path='/' element={<Home />} />
            <Route path='/member' element={<Member />} />
            <Route path='/admin' element={<Admin />} />
          </Routes>
    </div>
  )
}

export default App