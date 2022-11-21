import React, { useEffect, useState } from 'react';
import { useSelector } from 'react-redux';
import TransactionCard from './TransactionCard';

const TransactionHistory = () => {

    const [arr, setArr] = useState([])
    const { id } = useSelector((state) => state.userLogin)

    const handleFetch = () => {
        fetch('http://localhost:8080/transaction/get-transactions/' + id)
            .then((response => response.json()))
            .then(data => {
                setArr(data);
                console.log(arr);
            })

    }

    useEffect(() => {
        handleFetch()

    }, [])

    return (
        <div className='transaction-container'>
            <h1>Transaction History</h1>
            <ul>
                <div>
                    <p>Transaction ID</p>
                    <p>Transaction Type</p>
                    <p>Amount</p>
                    <p>Date</p>
                </div>
                {
                    arr.map((value, index) => {
                        return <TransactionCard value={value} key={index} />
                    })
                }
            </ul >
        </div >
    );
};

export default TransactionHistory;