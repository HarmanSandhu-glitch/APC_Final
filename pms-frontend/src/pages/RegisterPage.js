import React, { useState } from 'react';
import { useAuth } from '../context/AuthContext';
import './Form.css';

const RegisterPage = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');
    const { register } = useAuth();

    const handleSubmit = async (e) => {
        e.preventDefault();
        setError('');
        try {
            // Defaulting role to "USER". You can add a dropdown for role selection.
            await register(username, password, 'USER');
        } catch (err) {
            setError('Registration failed. Please try again.');
        }
    };

    return (
        <div className="form-container">
            <form onSubmit={handleSubmit}>
                <h2>Register</h2>
                {error && <p className="error-message">{error}</p>}
                <div className="form-group">
                    <label>Username</label>
                    <input
                        type="text"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                        required
                    />
                </div>
                <div className="form-group">
                    <label>Password</label>
                    <input
                        type="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        required
                    />
                </div>
                <button type="submit">Register</button>
            </form>
        </div>
    );
};

export default RegisterPage;