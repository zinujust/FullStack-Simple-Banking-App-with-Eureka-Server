import React, { useState } from 'react';
import { useSelector } from 'react-redux';

const Deposit = () => {

    const [account, setAccount] = useState('checking')
    const [amount, setAmount] = useState(5)
    const { id } = useSelector((state) => state.userLogin)

    const handleSubmit = (e) => {
        e.preventDefault();

        const model = {
            "userId": id,
            "balance": amount
        }

        switch (account) {
            case 'checking':

                fetch('http://localhost:8080/' + account + "/add", {
                    method: "PUT",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify(model)
                })

                let checkingTransaction = {
                    "id": 0,
                    "userId": id,
                    "type": 'DEPOSIT_CHECKING',
                    "balance": amount,
                    "time": 0
                }

                fetch('http://localhost:8080/transaction/create', {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify(checkingTransaction)
                })

                break;
            case 'savings':

                fetch('http://localhost:8080/' + account + "/add", {
                    method: "PUT",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify(model)
                })

                let savingsTransaction = {
                    "id": 0,
                    "userId": id,
                    "type": 'DEPOSIT_SAVINGS',
                    "balance": amount,
                    "time": 0
                }

                fetch('http://localhost:8080/transaction/create', {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify(savingsTransaction)
                })
                break;
            default:
        }

        setAmount(5)
        setAccount('checking')
    }

    return (
        <div className='deposit-container'>
            <h1>Deposit</h1>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Amount: $</label>
                    <input
                        type='number'
                        min='5'
                        value={amount}
                        onChange={(e) => setAmount(e.target.value)}
                        required
                    />
                </div>
                <div>
                    <label>Account: </label>
                    <select value={account} onChange={(e) => setAccount(e.target.value)} >
                        <option
                            value='checking'
                        >
                            Checking
                        </option>
                        <option
                            value='savings'
                        >
                            Savings
                        </option>
                    </select>
                </div>
                <input type='submit' value='Submit' />
            </form>
        </div>
    );
};

export default Deposit;