import { BrowserRouter, Routes, Route, Link, NavLink } from 'react-router-dom';

const navLinkStyles = ({ isActive }) => ({
  color: isActive ? '#007bff' : '#333',
  textDecoration: isActive ? 'none' : 'underline',
  fontWeight: isActive ? 'bold' : 'normal',
  padding: '5px 10px'
});

function Home() {
  return <h1>Home Page</h1>;
}

function About() {
  return <h1>About Page</h1>;
}

function Contact() {
  return <h1>Contact Page</h1>;
}

function App() {
  return (
      <div>
        <nav>
          <NavLink to='/' style = {navLinkStyles}>Home</NavLink> | {' '}
          <NavLink to='/contact' style = {navLinkStyles}>Contact</NavLink> | {' '}
          <NavLink to='/about' style = {navLinkStyles}>About</NavLink>
        </nav>

        <Routes>
          <Route path='/' element={<Home />} />
          <Route path='/contact' element={<Contact />} />
          <Route path='/about' element={<About />} />
        </Routes>
      </div>
  );
}

export default App;