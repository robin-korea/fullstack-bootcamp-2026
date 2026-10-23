// [DB -> JSON 배열 상품 객체 -> 출력]
function Product({seq, name, price, color}){
  return(
    <tr>
      <td>{seq}</td>
      <td>{name}</td>
      <td>{price}</td>
      <td>{color}</td>
    </tr>
  )
}

function ProductList(){
  // DB 처리된 상품 정보 데이터셋
  const list = [
    { seq: 1, name: '노트북', price: 2000000, color: '검정' },
    { seq: 2, name: '마우스', price: 100000, color: '하양' },
    { seq: 3, name: '키보드', price: 500000, color: '노랑' },
    { seq: 4, name: '모니터', price: 2500000, color: '파랑' },
    { seq: 5, name: '태블릿', price: 1200000, color: '주황' }
  ];

  return (
    <>
      <h1>상품 목록</h1>
      <table border={1}>
        <thead>
          <tr>
            <th>번호</th>
            <th>제품명</th>
            <th>가격</th>
            <th>색상</th>
          </tr>
        </thead>
        <tbody>
          {
            list.map((item) => (
                <Product key={item.seq} 
                         seq={item.seq}
                         name={item.name}
                         price={item.price}
                         color={item.color}
                />
            ))
          }
        </tbody>
      </table>
    </>
  )
}

function App(){
  return (
    <ProductList />
  )
}

export default App