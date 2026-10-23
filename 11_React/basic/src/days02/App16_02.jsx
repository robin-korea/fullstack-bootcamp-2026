import React from 'react'

function Dog (props) {
    return (
        <div>
            <h3>강아지</h3>
            <ul>
                <li>{props.name}</li>
                <li>{props.age}</li>
                <li>{props.char}</li>
            </ul>
        </div>
    )
}

function Child (props) {
    return (
        <div>
            <h3>아들</h3>
            {props.children}
        </div>
    )
}

function Parent () {
    return (
        <>
            <h1>props.children</h1>
            <Dog name="멍멍이" age="2" char="활발함" />
            <Dog name="잠보" age="5" char="잠만잠" />
            <Dog name="새침이" age="3" char="맨날 삐짐" />

            <h1>Child 태그 확인</h1>
            <Child>
                여기서는 내용이 문자열입니다.
            </Child>
            <Child>
                <button>btn1</button>
                <button>btn2</button>
            </Child>
            <Child>
                <ul>
                <li>Lorem.</li>
                <li>Pariatur?</li>
                <li>Optio.</li>
                </ul>
            </Child>
        </>
    )
}

function App() {
  return (
    <Parent />
  )
}

export default App