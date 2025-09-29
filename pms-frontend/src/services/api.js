import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080'; // Your API Gateway URL

const client = axios.create({
    baseURL: API_BASE_URL,
    headers: {
        'Content-Type': 'application/json',
    },
});

// Add a request interceptor to include the token in all requests
client.interceptors.request.use((config) => {
    const token = localStorage.getItem('token');
    if (token) {
        config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
}, (error) => {
    return Promise.reject(error);
});


// --- Auth Service ---
export const registerUser = (userData) => client.post('/api/v1/auth/register', userData);
// NOTE: Assuming a login endpoint exists at /api/v1/auth/login
export const loginUser = (credentials) => client.post('/api/v1/auth/login', credentials);


// --- Employee Service ---
export const getEmployees = () => {
    return client.get('/api/v1/employees');
};