import React from 'react'
import { Link, Outlet, Route, Routes, useParams } from 'react-router-dom'

function Home(){
    return (
        <>
            <h2>시작 페이지</h2>
            <p>시작 페이지입니다.</p>
            <p>시작 페이지입니다.</p>
            <p>시작 페이지입니다.</p>
            <p>시작 페이지입니다.</p>
            <p>시작 페이지입니다.</p>
            <p>시작 페이지입니다.</p>
        </>
    )

}

function Member(){
    return (
        <>
            <h2>회원 페이지</h2>
            <p>회원 페이지입니다.</p>
            <p>회원 페이지입니다.</p>
            <p>회원 페이지입니다.</p>
            <p>회원 페이지입니다.</p>
            <p>회원 페이지입니다.</p>
            <p>회원 페이지입니다.</p>
        </>
    )
    
}

// 게시판 목록
function BoardList(){
    return (
    <>
      <table>
        <thead>
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>이름</th>
            <th>날짜</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>1</td>
            <td>
              <Link to="/board/view/1">게시판입니다.</Link>
            </td>
            <td>홍길동</td>
            <td>2026-09-14</td>
          </tr>
          <tr>
            <td>2</td>
            <td>
              <Link to="/board/view/2">리액트 수업중</Link>
            </td>
            <td>홍길동</td>
            <td>2026-09-14</td>
          </tr>
          <tr>
            <td>3</td>
            <td>
              <Link to="/board/view/3">월요일입니다.</Link>
            </td>
            <td>홍길동</td>
            <td>2026-09-14</td>
          </tr>
        </tbody>
      </table>
      <div>
        <Link to="/board/add">글쓰기</Link>
      </div>
    </>
    )
}

function BoardAdd(){
    return (
    <>
      <table>
        <tr>
          <th>제목</th>
          <td className="left">
            <input type="text" />
          </td>
        </tr>
        <tr>
          <th>내용</th>
          <td>
            <textarea></textarea>
          </td>
        </tr>
      </table>
      <div>
        <Link to="/board">돌아가기</Link>
        <button>글쓰기</button>
      </div>
    </>
    )
}

function BoardView(){
    const {seq} = useParams();

    return (
        <>
      <table>
        <tr>
          <th>번호</th>
          <td className="left">{seq}</td>
        </tr>
        <tr>
          <th>제목</th>
          <td className="left">게시판입니다.</td>
        </tr>
        <tr>
          <th>내용</th>
          <td className="left">내용입니다.</td>
        </tr>
      </table>
      <div>
        <Link to="/board">돌아가기</Link>
      </div>
    </>
    )
}

function Board(){
    return (
        <>
            <h1>게시판{Board}</h1>
            <Outlet />
        </>
    )
}

function App() {
  return (
    <>
      <h1>Project</h1>
      <nav>
        <Link to="/" >Home</Link> {' '} | {' '}
        <Link to="/member" >회원</Link> {' '} | {' '}
        <Link to="/board" >게시판</Link>
      </nav>

      <hr />
      <Routes>
        <Route path='/' element={<Home />} />
        <Route path='/member' element={<Member />} />
        {/*
        <Route path='/board' element={<BoardList />} />
        <Route path='/board/add' element={<BoardAdd />} />
        <Route path='/board/view/:seq' element={<BoardView />} />
        */}
        <Route path='/board' element={<Board />} >
            <Route index element={<BoardList />} />
            <Route path='add' element={<BoardAdd />} />
            <Route path='view/:seq' element={<BoardView />} />
        </Route>
      </Routes>
    </>
  )
}

export default App
