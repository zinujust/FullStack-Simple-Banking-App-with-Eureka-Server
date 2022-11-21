import { useSelector } from 'react-redux';
import { Route, Routes } from 'react-router-dom';
import './App.css';
import Deposit from './components/Deposit';
import Header from './components/Header';
import Home from './components/Home';
import Login from './components/Login';
import Register from './components/Register';
import SignIn from './components/SignIn';
import Summary from './components/Summary';
import TransactionHistory from './components/TransactionHistory';
import Transfer from './components/Transfer';
import Withdraw from './components/Withdraw';


function App() {

  const { isAuthenticated } = useSelector((state) => state.userLogin);

  return (
    <div className='container'>
      <Header />

      <Routes>
        <Route path='/' element={<Login />}>
          <Route path='sign-in' element={<SignIn />}></Route>
          <Route path='register' element={<Register />}></Route>
        </Route>
        <Route path='home' element={isAuthenticated && <Home />}>
          <Route index element={<Summary />} />
          <Route path='withdraw' element={<Withdraw />}></Route>
          <Route path='deposit' element={<Deposit />}></Route>
          <Route path='transfer' element={<Transfer />}></Route>
          <Route path='transaction_history' element={<TransactionHistory />}></Route>
          <Route path='*' element={<h1>Error: 404</h1>}></Route>
        </Route>
        <Route path='*' element={<h1>Error: 404</h1>}></Route>
      </Routes>
    </div>
  )
}

export default App;
