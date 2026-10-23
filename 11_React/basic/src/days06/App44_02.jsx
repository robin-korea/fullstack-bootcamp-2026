import React, { useEffect, useRef, useState } from 'react'

function App() {
  const [todoContent, setTodoContent] = useState('');
  const [todoList, setTodoList] = useState([]);
  const txtTodo = useRef(null);
  
  useEffect(() => {
    txtTodo.current.focus();
  }, []);

  function handleAdd() {
    if (todoContent.trim() === '') {
        alert("할일 내용 입력하세요!");
        return;
    }

    // 1. 할 일 객체 생성
    const todo = {
      id: crypto.randomUUID(), 
      content: todoContent,
      done: false
    };
    
    // 2. 수정: 문자열(todoContent)이 아닌 방금 만든 객체(todo)를 배열에 추가합니다.
    setTodoList([...todoList, todo]);    
    setTodoContent('');                
    txtTodo.current.focus(); 
  }

  function handleDelete(id){
    if (window.confirm('정말 삭제할까요?')){
      setTodoList(todoList.filter((todo) => todo.id !== id));
    }
  }

  return (
    <>
      <h1>
        TodoList <small>React</small>
      </h1>

      <input
        type="text"
        value={todoContent}
        ref={txtTodo}
        onChange={(event) => setTodoContent(event.target.value)}
      />

      {' '}

      <button onClick={handleAdd}>추가</button>
      
      <ul>
        {todoList.map((todo) => (
          <li key={todo.id}>
            {todo.content}
            <button onClick={() => handleDelete(todo.id)}>삭제</button>
          </li>
        ))}
      </ul>
    </>
  )
}

export default App;