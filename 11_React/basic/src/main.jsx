import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './days06/App45_03.jsx'
import { BrowserRouter } from 'react-router-dom'

createRoot(document.getElementById('root')).render(
    <BrowserRouter>
      <App />
    </BrowserRouter>
)
