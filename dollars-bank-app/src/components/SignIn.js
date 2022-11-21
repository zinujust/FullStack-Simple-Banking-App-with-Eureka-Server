import { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";
import { setAuthentication, setId, setToken } from "../store/userSlice";

const SignIn = () => {

    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')

    const { isAuthenticated } = useSelector((state) => state.userLogin)
    const navigate = useNavigate();
    const dispatch = useDispatch();


    const handleSubmit = (e) => {
        e.preventDefault();

        const credentials = {
            "email": email,
            "password": password
        }

        let id = 0;
        let token = ''

        fetch("http://localhost:8080/user/authenticate", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "Accept": 'application/json',
            },
            body: JSON.stringify(credentials)
        })
            .then(response => response.json())
            .then(data => {
                token = `Bearer ${data.jwt}`;
                id = data.id;
                if (id !== 0) {
                    if (token !== '' || token !== 'Bearer undefined') {
                        dispatch(setToken(token));
                        dispatch(setId(id));
                        dispatch(setAuthentication());
                    }
                }
            })

        navigate('/home')


        setEmail('');
        setPassword('')
    }

    useEffect(() => {

    }, [isAuthenticated])


    return (
        <div className='sign-in-container'>
            <form onSubmit={handleSubmit}>
                <label>Email</label>
                <input
                    type='email'
                    value={email}
                    placeholder='Email'
                    onChange={(e) => setEmail(e.target.value)}
                    required
                ></input>
                <label>Password</label>
                <input
                    type='password'
                    value={password}
                    placeholder='Password'
                    onChange={(e) => setPassword(e.target.value)}
                    required
                ></input>
                <ul className="password-criteria">
                    <p>The password must consist of:</p>
                    <li>8 to 32 characters</li>
                    <li>At least ONE upper-case letter</li>
                    <li>a digit</li>
                    <li>a special character</li>
                </ul>
                <input type='submit' value='Submit'></input>
            </form>
        </div>
    )
}

export default SignIn;