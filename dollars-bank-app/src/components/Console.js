import React from 'react';
import { Link } from 'react-router-dom';

const Console = () => {
    return (
        <div className='console-container'>
            <Link to='' >Home</Link>
            <Link to='withdraw' >Withdraw</Link>
            <Link to='deposit'>Deposit</Link>
            <Link to='transfer'>Transfer</Link>
            <Link to='transaction_history'>Transaction History</Link>
        </div>
    );
};

export default Console;