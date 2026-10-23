// 새로고침 뒤에도 값을 유지해서 사용하려면 컴포넌트 상태 밖에
// 유지하고 싶은 값을 저장해야 한다.
// useState(), useRef() X -> 브라우저 안에 저장

import React, { useEffect } from 'react'

function App() {
  
  function handleSave() {
    localStorage.setItem("name", "홍길동");
    sessionStorage.setItem("name", "서영학");
    //
    const names = [
        "임훈", "정창기", "김병훈"
    ];

    localStorage.setItem("names", JSON.stringify(names));
    alert("저장 완료!!!");
  }

  function handleRead() {
    const lsName = localStorage.getItem("name");
    const ssName = sessionStorage.getItem("name");

    alert( `${lsName} / ${ssName}`);

    //
    const names = JSON.parse(localStorage.getItem("names"));
    console.log(names)
  }

  // 두 번째 인자가 없기 때문에 렌더링이 발생할때 마다 호출된다.
  useEffect(() => {
    const lsName = localStorage.getItem("name");
    const ssName = sessionStorage.getItem("name");

    console.log( `${lsName} / ${ssName}`);
  })

  function handleEdit() {
    localStorage.setItem("name", "aaa");
    sessionStorage.setItem("name", "bbb");
    alert("수정 완료!!!");
  }

  function handleDelete() {
    localStorage.removeItem("name", "홍길동");
    sessionStorage.removeItem("name", "서영학");
    alert("삭제 완료!!!");
  }

  return (
    <div>
      <h1>localStorage 사용하는 예</h1>
      <button onClick={handleSave}>쓰기</button> {' '}
      <button onClick={handleRead}>읽기</button> {' '}
      <button onClick={handleEdit}>수정</button> {' '}
      <button onClick={handleDelete}>삭제</button> {' '}
    </div>
  )
}

export default App