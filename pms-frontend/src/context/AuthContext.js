import React, from 'react';
import { createContext, useState, useContext } from 'react';
import { useNavigate } from 'react-router-dom';
import { registerUser, loginUser } from '../services/api';

const AuthContext = createContext(null);

export const AuthProvider = ({ children }) => {
    const [user, setUser] = useState(null);
    const [token, setToken] = useState(localStorage.getItem('token'));
    const navigate = useNavigate();

    const login = async (username, password) => {
        try {
            const response = await loginUser({ username, password });
            const userToken = response.data.token; // Assuming the token is in response.data.token
            setToken(userToken);
            localStorage.setItem('token', userToken);
            // You might want to fetch user details here and set the user object
            // For now, we'll just navigate
            navigate('/');
        } catch (error) {
            console.error('Login failed:', error);
            throw error;
        }
    };

    const register = async (username, password, role) => {
        try {
            await registerUser({ username, password, role });
            navigate('/login');
        } catch (error) {
            console.error('Registration failed:', error);
            throw error;
        }
    };

    const logout = () => {
        setUser(null);
        setToken(null);
        localStorage.removeItem('token');
        navigate('/login');
    };

    const value = { token, user, login, register, logout };

    return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>;
};

export const useAuth = () => {
    return useContext(AuthContext);
};