import React, { useState } from 'react';
import { useSelector } from 'react-redux';

const Transfer = () => {

    const [account1, setAccount1] = useState('checking');
    const [account2, setAccount2] = useState('savings');
    const [amount, setAmount] = useState(5);

    const { id } = useSelector((state) => state.userLogin);

    const handleSubmit = () => {
        const model = {
            "userId": id,
            "balance": amount
        }

        if (account1 !== account2) {
            fetch('http://localhost:8080/' + account1 + "/subtract", {
                method: "PUT",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(model)
            })
                .then(() => {
                    let Transaction = {
                        "id": 0,
                        "userId": id,
                        "type": `WITHDRAW_${account1.toUpperCase()}`,
                        "balance": amount,
                        "time": 0
                    }

                    fetch('http://localhost:8080/transaction/create', {
                        method: "POST",
                        headers: {
                            "Content-Type": "application/json"
                        },
                        body: JSON.stringify(Transaction)
                    })
                })

            fetch('http://localhost:8080/' + account2 + "/add", {
                method: "PUT",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(model)
            })
                .then(() => {
                    let Transaction = {
                        "id": 0,
                        "userId": id,
                        "type": `WITHDRAW_${account2.toUpperCase()}`,
                        "balance": amount,
                        "time": 0
                    }

                    fetch('http://localhost:8080/transaction/create', {
                        method: "POST",
                        headers: {
                            "Content-Type": "application/json"
                        },
                        body: JSON.stringify(Transaction)
                    })
                })


        }
    }

    return (
        <div className='transfer-container'>
            <h1>Transfer</h1>
            <form onSubmit={handleSubmit}>
                <div className='transfer-from'>
                    <h3>Transfer from: </h3>
                    <div>
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
                            <select value={account1} onChange={(e) => setAccount1(e.target.value)} >
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
                    </div>
                </div>
                <div className='transfer-to'>
                    <h3>Transfer to: </h3>
                    <div>
                        <label>Account: </label>
                        <select value={account2} onChange={(e) => setAccount2(e.target.value)} >
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
                </div>
                <input type='submit' value='Submit' />
            </form>
        </div>
    );
};

export default Transfer;