import React from 'react';

const TransactionCard = (prop) => {
    return (
        <>
            <li key={prop.index}>
                <div className='list'>
                    <p>{prop.value.id}</p>
                    <p>{prop.value.type}</p>
                    <p>{prop.value.balance}</p>
                    <p>{prop.value.time}</p>
                </div>
            </li>
        </>
    );
};

export default TransactionCard;