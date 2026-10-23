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

  // 1 2 3 페이지 번호
  const pages = [];
  for (let i = 1; i <= totalPages; i++) {
    pages.push(i); 
  }

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

            <div>
              {' '}
              {pages.map((pageNumber) => (
              <>
                <button
                  key={pageNumber}
                  onClick={() => setPage(pageNumber)}
                  disabled={pageNumber === page}
                  style={{
                    backgroundColor: pageNumber === page ? 'gold' : '#EFEFEF'
                  }}
                >
                  {pageNumber}
                </button>
                {' '}
              </>
            ))}
          </div>
        </>
  )
}

export default App