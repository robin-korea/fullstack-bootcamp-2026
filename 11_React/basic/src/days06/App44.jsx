import React from 'react'

function App() {

  const [todoContent, setTodoContent] = useState('');
  const [todoList, setTodoList] = useState([]);
  const txtTodo = useRef(null);
  
  useEffect(() => {
    txtTodo.current.focus();
  }, []);

  function handlerAdd(){
    if(todoContent.trim() === ''){
        alert("할일 내용 입력하세요!")
        return;
    }
  }

   setTodoList([...todoList, todoContent]);    
   setTodoContent('');                
   txtTodo.current.focus(); 
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
        {todoList.map((todo, index) => (
          <li key={index}>{todo}</li>
        ))}
      </ul>
    </>
  )
}

export default App