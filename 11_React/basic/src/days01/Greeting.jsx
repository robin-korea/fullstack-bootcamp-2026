import React from 'react'

// rafce
// const Greeting = (props) => {
const Greeting = ({name}) => {    
  return (
    <div>
      {/* <h1>Hello World!!! {props.name}</h1> */}
      <h1>Hello World!!!~ {name}</h1>
    </div>
  )
}

export default Greeting
