// [URL Parameters]
// 1. URL 파라미터는 라우트 경로에 추가할 수 있는 변수이다. 
// 2. 주로 컴포넌트 간에 데이터를 전달하는 데 사용된다. 
// 3. 경로 http://localhost:5173/customer/Tobias에서 URL 파라미터는 Tobias이다. 
// 4. URL 파라미터를 사용하면 URL의 일부가 변경될 수 있는 동적 라우트를 만들 수 있다. 
// 5. URL에 변수를 넣는다고 생각하면 된다.
// 6. React Router는 컴포넌트에서 이러한 파라미터에 접근할 수 있도록 useParams 훅을 제공한다. 
// 7. 다음은 다양한 고객에게 인사를 건넬 수 있는 간단한 인사말 페이지 예제입니다.

import React from 'react'
import { Link, Route, Routes, useParams } from 'react-router-dom'

function UserInfo(){
    const {name} = useParams(); 
    return (
        <>
            <h1>{name} 사원 정보 조회</h1>
            <h3>이름: </h3>
            <h3>나이: </h3>
            <h3>주소: </h3>
        </>
    )
}

function App() {
  return (
    <>
      <nav>
        <Link to="/customer/Hong">Hong</Link> | 
        <Link to="/customer/Admin">Admin</Link> |
        <Link to="/customer/Kenik">Kenik</Link>
      </nav>

      <Routes>
        <Route path='/customer/:name' element={<UserInfo />} />
      </Routes>
    </>
  )
}

export default App