import {mockMembers} from '../mocks/members.js'

import React, { useState } from 'react'

function App() {

  // const page = 1;
  const [page, setPage] = useState(1);
  const pageSize = 10;
  const start = (page - 1) * pageSize;
  const end = start + pageSize;

  // 총 페이지수 : 2.5 -> 3
  const totalPages = Math.ceil(mockMembers.length / pageSize);

  const list = mockMembers.slice(start, end);

  function handlePrevious(){
    if(page > 1){
      setPage(page - 1);
    }
  }

  function handleNext(){
    if(page < totalPages){
      setPage(page + 1);
    }
  }

  return (
    <>
          <h1>회원 목록</h1>

            <div>전체 회원: {mockMembers.length}명</div>
            <div>현재 페이지: {page}페이지</div>
            <hr />

            <ul>
                {list.map((member) => (
                <li key={member.id}>{member.name}</li>
                ))}
            </ul>
            
            <hr />

            <button
              onClick={handlePrevious}
              disabled={page === 1}
              style={{ cursor: page === 1 ? 'not-allowed' : 'pointer' }}
            >
              이전 페이지
            </button>{' '}
            <button
              onClick={handleNext}
              disabled={page === totalPages}
              style={{ cursor: page === totalPages ? 'not-allowed' : 'pointer' }}
            >
              다음 페이지
            </button>
        </>
  )
}

export default App