import React from 'react';
import { Outlet } from 'react-router-dom';

const Login = () => {
    return (
        <div className='login-container'>
            <Outlet />

        </div >
    );
};

export default Login;