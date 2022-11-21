import { useState } from "react"
import ApiCalls from "../api/ApiCalls"

const Register = () => {

    const [fullname, setFullname] = useState('')
    const [phone, setPhone] = useState('')
    const [email, setEmail] = useState('')
    const [address, setAddress] = useState('')
    const [password, setPassword] = useState('')
    const [reEnteredPassword, setReEnteredPassword] = useState('')

    const handleSubmit = (e) => {
        e.preventDefault();

        if (password === reEnteredPassword) {
            const register = {
                "fullname": fullname,
                "phoneNumber": phone,
                "email": email,
                "address": address,
                "password": password
            }

            ApiCalls.register(register);
        }

        setFullname('')
        setPhone('')
        setEmail('')
        setAddress('')
        setPassword('')
        setReEnteredPassword('')
    }

    return (
        <div className='sign-in-container'>
            <form onSubmit={handleSubmit}>
                <label>Full Name</label>
                <input
                    type='text'
                    value={fullname}
                    placeholder='Full Name'
                    onChange={(e) => setFullname(e.target.value)}
                ></input>
                <label>Phone Number</label>
                <input
                    type='text'
                    value={phone}
                    placeholder='Phone Number'
                    onChange={(e) => setPhone(e.target.value)}
                ></input>
                <label>Email</label>
                <input
                    type='email'
                    value={email}
                    placeholder='Email'
                    onChange={(e) => setEmail(e.target.value)}
                ></input>
                <label>Address</label>
                <input
                    type='text'
                    value={address}
                    placeholder='Address'
                    onChange={(e) => setAddress(e.target.value)}
                ></input>
                <label>Password</label>
                <input
                    type='Password'
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                ></input>
                <label>Re-enter Password</label>
                <input
                    type='Password'
                    value={reEnteredPassword}
                    onChange={(e) => setReEnteredPassword(e.target.value)}
                ></input>
                <input type='submit' value='Submit'></input>
            </form>
        </div>
    )
}

export default Register;