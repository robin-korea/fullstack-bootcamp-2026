// [중첩 Routes]
// 1. 라우트 안에 또 다른 라우트를 넣을 수 있는데, 이를 중첩 라우트라고 한다. 
// 2. 중첩 라우트를 사용하면 새로운 URL로 이동할 때 페이지의 일부를 변경하면서 
//   다른 부분은 변경되지 않거나 다시 로드되지 않도록 할 수 있다. 
// 3. 마치 페이지 안에 또 다른 페이지가 있는 것과 같다. 
// 4. 위 예시를 사용하여 Products 컴포넌트 안에 렌더링될 CarProducts와 BikeProducts라는 
//    두 개의 새로운 컴포넌트를 추가해 보자.

// 뷰 = 컴포넌트
function Home() {
    return <h1>Home Page</h1>;
}

// 뷰 = 컴포넌트
function Contact() {
    return <h1>Contact Page</h1>;
}

function Products() {
    return (
        <div>
            <h1>Products Page</h1>
            <nav style={{marginBottom: '20px'}}>
                <Link to = "/products/car">Cars</Link> | {" "}
                <Link to = "/products/bike">Bikes</Link>
            </nav>
            <Outlet />
        </div>
    );
}

function CarProducts() {
  return (
    <div>
      <h2>Cars</h2>
      <ul>
        <li>Audi</li>
        <li>BMW</li>
        <li>Volvo</li>
      </ul>
    </div>
  );
}

function BikeProducts() {
  return (
    <div>
      <h2>Bikes</h2>
      <ul>
        <li>Yamaha</li>
        <li>Suzuki</li>
        <li>Honda</li>
      </ul>
    </div>
  );
}

import React from 'react'
import { Link, Outlet, Route, Routes } from 'react-router-dom';

function App() {
  return (
    <>
      <nav>
        <Link to = "/">Home</Link> | {" "}
        <Link to = "/products">Products</Link> | {" "}
        <Link to = "/contact">Contact</Link>
      </nav>

      <Routes>
          <Route path='/' element={<Home />} />
          <Route path='/products' element={<Products />} >
            <Route path='car' element={<CarProducts />} />
             <Route path='bike' element={<BikeProducts />} />
          </Route>
          <Route path='/contact' element={<Contact />} />
        </Routes>
    </>
  )
}

export default App