import axios from "axios";
import { useState } from "react";
import {BsFacebook, BsInstagram, BsLinkedin, BsTwitter, BsYoutube} from "react-icons/bs"
import { NavLink } from "react-router-dom";

const Footer = ()=>{
  const [email, setEmail] = useState("")
  const [registerStatus, setRegisterStatus] = useState("")
  const onSubmitHandler = (e) => {
    e.preventDefault();
  const formData = new FormData();
    formData.append("userName", email);
  axios
      .post(`http://localhost:8082/api/messages/mail`,formData)
      .then((res) => {
        setRegisterStatus("SUCCESS");
        console.log(res);
      })
      .catch((err) => {
        setRegisterStatus("FAILED");
        console.log(err.message);
      });
  } 
  return(

    <footer >
    <div className="contentfooter">
      <div className="top">
        <div className="logo-details">
          <span className="logo_name">Jumpstart</span>
        </div>
        <div className="media-icons">
        <NavLink to="#"><BsFacebook></BsFacebook></NavLink>
        <NavLink to="#"><BsTwitter/></NavLink>
        <NavLink to="#"><BsInstagram/></NavLink>
        <NavLink to="#"><BsLinkedin/></NavLink>
        <NavLink to="#"><BsYoutube/></NavLink>

        </div>
      </div>
      <div className="link-boxes">
        
        <ul className="box">
          <li className="link_name">Page</li>
          <li><NavLink to="/">Homepage</NavLink></li>
          <li><NavLink to="/about-us">About Us</NavLink></li>
          <li><NavLink to="/contact">Contact Us</NavLink></li>
          <li><NavLink to="/terms"> Terms and Conditions</NavLink></li>
        </ul>
        <ul className="box">
          <li className="link_name">Account</li>
          <li><NavLink to="/login"> Login</NavLink></li>
          <li><NavLink to="/signup"> Sign Up</NavLink></li>
        </ul>
        <form className="box input-box" onSubmit={onSubmitHandler}>
          <li className="link_name">Subscribe</li>
          {registerStatus === "FAILED" && (
            <div className="form-error text-center">Subcribe Failed</div>
          )}
          {registerStatus === "SUCCESS" && (
            <div className="form-success text-center">
              Thank you for subcribed!
            </div>
          )}
          <li><input onChange={(e) => setEmail(e.target.value)} value={email} type="text" placeholder="Enter your email"/></li>
          <li><button type="submit" className="button-sub">Subscribe</button></li>
        </form>
      </div>
    </div>
    <div className="bottom-details">
      <div className="bottom_text">
        <span className="copyright_text">Copyright © 2023 <a href="#">Jumpstart.com</a>All rights reserved</span>
        
      </div>
    </div>
  </footer>

    );
};
export default Footer;