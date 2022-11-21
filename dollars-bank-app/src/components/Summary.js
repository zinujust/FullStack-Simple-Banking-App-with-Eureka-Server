import React, { useState } from 'react';
import { useSelector } from 'react-redux';

const Summary = () => {

    const { id } = useSelector((state) => state.userLogin)
    const [cBalance, setCBalance] = useState(0)
    const [sBalance, setSBalance] = useState(0)

    const handleSummary = () => {
        fetch('http://localhost:8080/checking/balance/' + id, {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
            },
        })
            .then(response => response.json())
            .then(data => {
                console.log(data);
                setCBalance(data.balance)
            })

        fetch('http://localhost:8080/savings/balance/' + id, {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
            },
        })
            .then(response => response.json())
            .then(data => {
                console.log(data);
                setSBalance(data.balance)
            })
    }

    document.addEventListener('DOMContentLoaded', handleSummary())

    return (
        <div className='summary-container'>

            <div className='card'>
                <h1>Checking</h1>
                <h1>${cBalance} </h1>
            </div>

            <div className='card'>
                <h1>Savings</h1>
                <h1>${sBalance}</h1>
            </div>

        </div>
    );
};

export default Summary;