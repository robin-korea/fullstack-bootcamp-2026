// [React textarea]

import React, { useState } from 'react'

function App() {

  const [mtext, setMtext] = useState('');

  function handlerChange(event){
    setMtext(event.target.value);
  }

  return (
    <form>
      <label>
        작성:
        <textarea value={mtext} onChange={handlerChange}/>
      </label>
      <p>
        작성한 내용: {mtext}
      </p>
    </form>
  )
}

export default App