import {useState} from "react";
import { useNavigate } from 'react-router-dom'


function LoginPage(){

    const [username, setUsername] = useState('')
    const [password, setPassword] = useState('')
    const [loginError, setLoginError] = useState('')
    const navigate = useNavigate()

    async function handleLogin(event){
        event.preventDefault()
            const csrfResponse = await fetch(
                'http://localhost:8080/csrf',
                {
                    credentials: 'include'
                }
            )
            const csrf = await csrfResponse.json()
            console.log(csrf)

            const loginData = new URLSearchParams()
            loginData.append('username', username)
            loginData.append('password', password)

            const loginResponse = await fetch(
                'http://localhost:8080/login',
                {
                method: 'POST',
                    headers: {
                    'Content-Type' : 'application/x-www-form-urlencoded',
                     [csrf.headerName]: csrf.token
                    },
                    body : loginData,
                    credentials: 'include'

                }

            )

        if (loginResponse.ok){
        console.log('Login Successful')
        navigate('/reports')}

        else{
            console.log('Login Failed')
            setLoginError('Invalid username or password')
        }
    }

    return (
        <main className="loginPage">
            <div className="loginBox">

                <p className="login-app-title">Clinical Report Generator</p>
                <h1 className="userLogin">Login</h1>

                <form onSubmit={handleLogin}>
                    <input
                        type="text"
                        placeholder="Username"
                        value={username}
                        onChange={(event) => setUsername(event.target.value)}
                    />

                    <input
                        type="password"
                        placeholder="Password"
                        value={password}
                        onChange={(event) => setPassword(event.target.value)}
                    />

                    {loginError && <p>{loginError}</p>}

                    <button type="submit">Login</button>
                </form>
            </div>
        </main>
    );
}

export default LoginPage;