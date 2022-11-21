import React from 'react';
import { Outlet } from 'react-router-dom';
import Console from './Console';

const Home = () => {

    return (
        <div className='home-container'>
            <Console />
            <Outlet />
        </div>
    );
};

export default Home;