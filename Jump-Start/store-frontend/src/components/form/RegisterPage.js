import axios from "axios";
import { useRef, useState } from "react";
import { Link } from "react-router-dom";
import "./AuthForm.css";
import fbLogo from "../img/fb-logo.png";
import { BsPinMap } from "react-icons/bs";
const RegisterPage = () => {
  const inputNameRef = useRef();
  const inputEmailRef = useRef();
  const inputAddressRef = useRef();
  const inputPhoneRef = useRef();
  const inputPasswordRef = useRef();
  const FACEBOOK_AUTH_URL =
  "http://localhost:8082/oauth2/authorize/facebook?redirect_uri=http://localhost:3000/oauth2/redirect";

  const [registerStatus, setRegisterStatus] = useState("");

  const onSubmitHandler = (e) => {
    e.preventDefault();
    const inputName = inputNameRef.current.value;
    const inputAddress = inputAddressRef.current.value;
    const inputPhone = inputPhoneRef.current.value;
    const inputEmail = inputEmailRef.current.value;
    const inputPassword = inputPasswordRef.current.value;

    axios
      .post("http://localhost:8082/api/auth/signup", {
        name: inputName,
        email: inputEmail,
        address: inputAddress,
        phone: inputPhone,
        password: inputPassword,
        role:"user"
      })
      .then((res) => {
        setRegisterStatus("SUCCESS");
        console.log(res);
      })
      .catch((err) => {
        setRegisterStatus("FAILED");
        console.log(err.message);
      });

    inputNameRef.current.value = "";
    inputAddressRef.current.value = "";
    inputPhoneRef.current.value = "";
    inputEmailRef.current.value = "";
    inputPasswordRef.current.value = "";

  };

  return (
    <div className="d-flex justify-content-center">
      <div className="form-auth my-5 py-5 bg-light">
        <h3 className="mb-3 fw-semibold text-center">Register</h3>
        <form onSubmit={onSubmitHandler}>
          {registerStatus === "FAILED" && (
            <div className="form-error text-center">Register Failed</div>
          )}
          {registerStatus === "SUCCESS" && (
            <div className="form-success text-center">
              {inputNameRef.current.value} Register successfully!!
            </div>
          )}
          <input
            ref={inputNameRef}
            className="form-control mb-3 ps-4 pe-0"
            type="text"
            name="name"
            placeholder="Your name"
          />
          <input
            ref={inputEmailRef}
            className="form-control mb-3 ps-4 pe-0"
            type="email"
            name="email"
            placeholder="Email"
          />
          <input
            ref={inputPasswordRef}
            className="form-control mb-3 ps-4 pe-0"
            type="password"
            name="password"
            placeholder="Password"
          />
          <div className="d-flex">
          <input
            ref={inputAddressRef}
            className="form-control mb-3 ps-4 pe-0 me-3"
            type="text"
            name="address"
            placeholder="Your address base on google maps"
          /><Link to={"https://www.google.co.id/maps/"} target="_blank"><BsPinMap/></Link>
          </div>
          <input
            ref={inputPhoneRef}
            className="form-control mb-3 ps-4 pe-0"
            type="text"
            name="phone"
            placeholder="Phone number"
          />
          <button type="submit" className="btn btn-color btn-auth">
            Register
          </button>
          <div className="or-separator">
          <span className="or-text">OR</span>
        </div>
        <div className="social-login text-center">
          <a className="btn btn-block social-btn facebook" href={FACEBOOK_AUTH_URL}>
            <img src={fbLogo} alt="Facebook" /> Log in with Facebook
          </a>
        </div>
          <Link
            to="/login"
            className="d-block mt-3 text-center text-decoration-none"
          >
            Already have an account?
          </Link>
        </form>
      </div>
    </div>
  );
};

export default RegisterPage;