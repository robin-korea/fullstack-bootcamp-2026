// 상품 추가, 수정, 삭제 (localStorage 사용)
// 더미 데이터 : mocks 폴더

import React, { useEffect, useRef, useState } from 'react'
import { mockProducts } from '../mocks/product.js'

function App() {
  
    const name = useRef('');
    const price = useRef('');
    const stock = useRef('');
    const category = useRef('');
    const idRef = useRef('');

    // (1) 수정 위치로 스크롤
    const editTitleRef = useRef(null);

    const [list, setList] = useState( () => {
        const result = localStorage.getItem("products");
        if(result != null){
            return JSON.parse(result);
        }else {
            return mockProducts;
        }
    })

    // console.log(list);
   
    // 두번째 인자값인 list 상태변수가 바뀌면 렌더링이 완료된 후 함수 실행 
    useEffect( () => {
        localStorage.setItem('products', JSON.stringify(list))
    }, [list])


    function handleSubmit(event){
        event.preventDefault();

        const data = new FormData(event.target); // form 요소

        const name = data.get("name");
        const price = Number(data.get("price"));
        const stock = Number(data.get("stock"));
        const category = data.get("category");

        const newItem = {
            id: Math.max(...mockProducts.map((item) => item.id)) + 1,
            name: name,
            price: price,
            stock: stock,
            category: category
        };

        setList([...list, newItem]);

    }

    function handleSubmit2(event){
        event.preventDefault();

        const data = new FormData(event.target); // form 요소

        const name = data.get("name");
        const price = Number(data.get("price"));
        const stock = Number(data.get("stock"));
        const category = data.get("category");
        const id = Number(data.get('id'));

        const editItem = {
            id: id,
            name: name,
            price: price,
            stock: stock,
            category: category
        };

        setList( list.map ((item) => (item.id == editItem.id) ? editItem : item));
    }

    function handleDelete(id){
        // list id 제거 => 렌더링 -> useEffect()
        setList( list.filter( (item) => item.id != id))
    }

    function handleEdit(id){
        
        // 수정할 상품 item
        const item = list.find((item) => item.id == id);

        name.current.value = item.name;
        price.current.value = item.price;
        stock.current.value = item.stock;
        category.current.value = item.category;
        idRef.current.value = item.id;

        editTitleRef.current.scrollIntoView({
            behavior: 'smooth',
            block: 'start'
        });
    }


    return (
    <div>
      <h1>Products - 상품 목록</h1>
      <ul>
        {list.map(
            (item) => (
                <li key={item.id}>
            {item.name}({item.price.toLocaleString()}원) {' '}
            <button
              onClick={() => {
                handleDelete(item.id);
              }}
            >
              delete
            </button>
            {' '}
            <button
              onClick={() => {
                handleEdit(item.id);
              }}
            >
              edit
            </button>
          </li>
            )
        )}
      </ul>
      <hr />

      <h2>상품 추가</h2>

      <form onSubmit={handleSubmit}>
        <div>
          <div>
            상품명: <input type="text" name="name" />
          </div>
          <div>
            가격: <input type="number" name="price" />
          </div>
          <div>
            재고: <input type="number" name="stock" />
          </div>
          <div>
            분류:
            <select name="category">
              <option value="컴퓨터용품">컴퓨터용품</option>
              <option value="도서">도서</option>
              <option value="운동용품">운동용품</option>
            </select>
          </div>
          <div>
            <button type="submit">추가하기</button>
          </div>
        </div>
      </form>

      <hr />
      <h2 ref={editTitleRef}>상품 수정</h2>

      <form onSubmit={handleSubmit2}>
        <div>
          <div>
            상품명: <input type="text" name="name" ref={name} />
          </div>
          <div>
            가격: <input type="number" name="price" ref={price} />
          </div>
          <div>
            재고: <input type="number" name="stock" ref={stock} />
          </div>
          <div>
            분류:
            <select name="category" ref={category}>
              <option value="컴퓨터용품">컴퓨터용품</option>
              <option value="도서">도서</option>
              <option value="운동용품">운동용품</option>
            </select>
          </div>
          <div>
            <button type="submit">수정하기</button>
          </div>
        </div>

        <input type="text" name="id" ref={idRef} />
      </form>
    </div>
  )
}

export default App