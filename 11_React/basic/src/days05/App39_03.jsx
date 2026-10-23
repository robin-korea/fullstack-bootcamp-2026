import React, { useEffect, useState } from 'react'

function App() {

  const [count, setCount] = useState(0); 
  const [calculation, setCalculation] = useState(0); 

  // 버튼을 클릭하면 count * 2 해서 값을 calculation 변수에 저장
  useEffect(() => {
    setCalculation(() => count * 2);
  }
                , [count]);

  return (
    <div>
      <p>
        Count : {count}
      </p>
      <button onClick={() => setCount((count) => count + 1)}>count 증가</button>

      <p>calculation: {calculation}</p>
    </div>
  )
}

export default App