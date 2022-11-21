import React from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { Link } from 'react-router-dom';
import { unsetAuthentication, unsetId, unsetToken } from '../store/userSlice';

const ProtectedLinks = () => {
    const dispatch = useDispatch();

    const handleLogout = () => {
        dispatch(unsetAuthentication())
        dispatch(unsetToken())
        dispatch(unsetId())
    }

    return (
        <div>
            <Link to='/' onClick={handleLogout}>Logout</Link>
        </div>
    )
}

const LoginLinks = () => {
    return (
        <div>
            <Link to='sign-in'>Sign In</Link>
            <Link to='register'>Register</Link>
        </div>
    )
}

const Header = () => {


    const { isAuthenticated } = useSelector((state) => state.userLogin)

    return (
        <div className='header-container'>
            <h1>Dollar Bank</h1>
            {isAuthenticated === true ? <ProtectedLinks /> : <LoginLinks />}
        </div>
    );
};

export default Header;