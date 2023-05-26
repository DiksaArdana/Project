import { useContext, useEffect, useState } from "react";
import { BsPersonCircle } from "react-icons/bs";
import { Link, NavLink, useNavigate } from "react-router-dom";
import AuthContext from "../../services/AuthContext";
import { getListCategory } from "../../services/ProductServices";
import SearchForm from "../form/SearchForm";
import logo from "../img/Jumpstart-logo.png"

const Navbar = (props) => {
    const authUser = useContext(AuthContext);
    const navigate = useNavigate();
    const [listCategoryNav, setListCategoryNav] = useState([]);
    const logoutHandler = () => {
        authUser.logout();
        navigate("/login");
    };
    useEffect(() => {
        getListCategory(
          (data) => {
            console.log(data);
            setListCategoryNav(data);
          },
          (error) => {
            console.log(error);
          }
        );
    
      return () => {};
    },[]);
    return (
        <nav className="navbar nav-color navbar-expand-lg bg-body-tertiary px-5">
            <div className="container-fluid">
                <a className="navbar-brand" href="/">
                    <img src={logo} alt="" width="80" height="74" /></a>
                <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                        <li className="nav-item dropdown">
                            <a className="nav-link dropdown-toggle fw-bold" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Category
                            </a>
                            <ul className="dropdown-menu bg-warning">
                                {listCategoryNav.map((dta) => (
                                    <li><Link to={`/products?keyword=${dta.id}`} className="dropdown-item bg-warning text-dark" >{dta.name}</Link></li>
                                ))}

                            </ul>
                        </li>
                        <li className="nav-item">
                            <SearchForm/>
                        </li>
                    </ul>
                    {!authUser.isLoggedIn && (
                        <div className="nav-button d-flex flex-column flex-lg-row mx-3">
                            <NavLink to="/login" className="btn btn-color me-0 me-lg-3 mb-3 mb-lg-0 text-light">Login</NavLink>
                            <NavLink to="/signup" className="btn btn-success mb-3 mb-lg-0">Signup</NavLink>
                        </div>)}
                    {authUser.isLoggedIn && (
                        <div className=" text-light fs-5 item-allign-center">
                            <div className="navbar-nav dropdown">
                                <a className="nav-link dropdown-toggle text-light fs-5" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    <BsPersonCircle /> {authUser.name}
                                </a>
                                <ul className="dropdown-menu bg-warning px-3 " aria-labelledby="navbarDropdown">
                                {authUser.role ==="user" && (
                                    <li className="mb-3"><NavLink to="/mychart" className="btn btn-color text-light w-100 me-0 me-lg-3 mb-3 mb-lg-0">Chart</NavLink></li>
                                )}
                                {authUser.role ==="rider" && (
                                    <li className="mb-3"><NavLink to="/dashboard-delivery" className="btn btn-color text-light w-100 me-0 me-lg-3 mb-3 mb-lg-0">Delivery</NavLink></li>
                                )}
                                    <li className="mb-3"><NavLink to="/profile" className="btn btn-color text-light w-100 me-0 me-lg-3 mb-3 mb-lg-0">Profile</NavLink></li>
                                    <li className="mb-3"><button className=" btn btn-color text-light w-100 mb-3 mb-lg-0" onClick={logoutHandler}>Logout </button></li>
                                </ul>
                            </div>
                        </div>)}
                </div>
            </div>
        </nav>
    )
}
export default Navbar;