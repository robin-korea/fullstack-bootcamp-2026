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

    const todo = {
      id: crypto.randomUUID(), 
      content: todoContent,
      done: false
    };
    
    setTodoList([...todoList, todo]);    
    setTodoContent('');                
    txtTodo.current.focus(); 
  }

  function handleDelete(id){
    if (window.confirm('정말 삭제할까요?')){
      setTodoList(todoList.filter((todo) => todo.id !== id));
    }
  }

  //
  const doneCount = todoList.filter((todo) => todo.done).length;

  function handleToggle(id){

    setTodoList(
      todoList.map((todo) => 
        todo.id === id ? {...todo, done: !todo.done} : todo
      )
    )
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
        onKeyDown={(e) => {
          if (e.key === 'Enter') handleAdd();
        }}
      />

      {' '}

      <button onClick={handleAdd}>추가</button>
      
     <hr />
      <div>전체 할일: {todoList.length}개</div>
      <div>완료한 할일: {doneCount}개</div>
      <div>진행중 할일: {todoList.length - doneCount}개</div>
    <hr />

        <table style={{ width: '600px' }}>
        <thead>
          <tr>
            <th style={{ width: '350px' }}>할일</th>
            <th style={{ width: '100px' }}>상태</th>
            <th style={{ width: '250px' }}>관리</th>
          </tr>
        </thead>
        { 
          todoList.length == 0 ? (
            <tbody>
              <tr>
                <td colSpan={3}>아직 등록된 할일이 없습니다.</td>
              </tr>
            </tbody>
          ) : (
            <tbody>
              {todoList.map((todo) => (
                <tr key={todo.id}>
                  <td
                    style={{
                      textDecoration: todo.done ? 'line-through' : 'none',
                      color: todo.done ? '#fb0303' : '#555555'
                    }}
                  >
                    {todo.content}
                  </td>
                  <td>{todo.done ? '[완료]' : '[진행중]'}</td>
                  <td>
                    <button onClick={() => handleToggle(todo.id)}>
                      완료/미완료
                    </button>
                    {' '}
                    <button onClick={() => handleDelete(todo.id)}>삭제</button>
                  </td>
                </tr>
              ))}
            </tbody>
          )
        }
      </table>


    </>
  )
}

export default App;