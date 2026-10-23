// [React 클래스 컴포넌트]
// 1. React 16.8 이전에는 클래스 컴포넌트가 React 컴포넌트의 상태와 생명주기 를 추적하는 유일한 방법이었다.
// 2. 훅(Hooks) 이 추가되면서 함수형 컴포넌트도 상태와 생명주기
// 3. 함수형 컴포넌트가 선호/권장
/// 4. 클래스 컴포넌트의 상태 관리: App13_03.jsx

import React from "react"

// [1] 클래스 컴포넌트

// [2] 생성자 추가
class Car extends React.Component {

    // model 속성을 생성자의 props 에 전달
    constructor(props){
        super(props);
        // 클래스 컴포넌트의 상태(state)를 관리하는 객체에 빨강색 저장
        this.state = {color: "red"};

    }

    render(){
        return <h1>Hi, I am a {this.state.color}/{this.props.model} Car!</h1>
    }

}

// Garage 구성요소 내의 자식 구성요소 여러개 사용
class Garage extends React.Component{

    render(){
        return (
            <div>
                <Car />
                <Car />
            </div>
        )
    }
}

function App(){
    return (
        <Car model="Mustang2" />
    )
}

export default App