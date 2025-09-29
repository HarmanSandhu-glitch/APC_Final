import React from 'react';
import { Link } from 'react-router-dom';
import { useAuth } from '../context/AuthContext';
import './Navbar.css';

const Navbar = () => {
    const { token, logout } = useAuth();

    return (
        <nav className="navbar">
            <Link to="/" className="navbar-brand">Payroll MS</Link>
            <div className="navbar-links">
                {token ? (
                    <>
                        <Link to="/">Dashboard</Link>
                        <Link to="/employees">Employees</Link>
                        <button onClick={logout} className="logout-button">Logout</button>
                    </>
                ) : (
                    <>
                        <Link to="/login">Login</Link>
                        <Link to="/register">Register</Link>
                    </>
                )}
            </div>
        </nav>
    );
};

export default Navbar;