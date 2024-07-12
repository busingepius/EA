import React from 'react'
import ReactDOM from 'react-dom/client'
import './index.css'
import {
  BrowserRouter, Routes, Route
} from 'react-router-dom'
import SignIn from './SignIn.jsx'
import SignUp from './SignUp.jsx'
import Home from './Home.jsx'

import {Provider} from 'react-redux'
import store from './store.jsx'

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <Provider store={store}>
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<Home />} />
        <Route path='/signin' element={<SignIn />} />
        <Route path='/signup' element={<SignUp />} />
      </Routes>
    </BrowserRouter>
    </Provider>
  </React.StrictMode>,
)
