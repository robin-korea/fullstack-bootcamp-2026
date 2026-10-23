// [React 클래스 컴포넌트 상태]
// 1. 클래스 컴포넌트는 내장 state 객체가 있다.
// 2. state 객체는 해당 컴포넌트에 속하는 속성 값을 저장하는 곳이다.
// 3. state 객체가 변경되면 컴포넌트가 다시 렌더링 된다.
// 4. 버튼을 클릭해서 this.state 상태 객체의 색상 (color = red => blue) 변경
//        -> 자동으로 컴포넌트가 다시 랜더링된다.


import React from "react";

class App extends React.Component{

    constructor(props){
        super(props);
        this.state={       // 함수형 컴포넌트 에는 상태 존재 X 그래서 상태 관리를 못함 (Hooks 이 추가되어 이거 사용하면 상태관리)
            brand: "Ford",
            model: "Mustang",
            color: "red",
            year : 1964
        }
    }

    static getDerivedStateFromProps(props, state) {
        return {favoritecolor: props.favcol };
    }

    // 1) this.setState() 메서드: this.state 상태 객체의 color 속성값을 blue 변경
    handleButtonClick = () => {
        // alert("버튼이 눌러졌습니다.")
        this.setState({color:"blue"});
    }

    render () {
        return (
            <div>
                <h1>My {this.state.brand}</h1>
                <p>
                    It is a {this.state.color} {this.state.model} from {this.state.year}.
                </p>
                <button onClick={this.handleButtonClick}>Change color</button>
            </div>
        )
    }
} 

export default App;