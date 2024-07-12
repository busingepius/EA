import { configureStore } from '@reduxjs/toolkit'
import tokenReducer from './tokenSlice.jsx'

export default configureStore({
  reducer: {
    token: tokenReducer,
  },

})