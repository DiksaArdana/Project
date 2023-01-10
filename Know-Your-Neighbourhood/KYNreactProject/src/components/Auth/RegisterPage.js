import axios from "axios";
import { useRef, useState } from "react";
import { Link } from "react-router-dom";
import "./AuthForm.css";

const RegisterPage = () => {
  const inputNameRef = useRef();
  const inputEmailRef = useRef();
  const inputPasswordRef = useRef();

  const [registerStatus, setRegisterStatus] = useState("");

  const onSubmitHandler = (e) => {
    e.preventDefault();
    const inputName = inputNameRef.current.value;
    const inputEmail = inputEmailRef.current.value;
    const inputPassword = inputPasswordRef.current.value;

    axios
      .post("http://localhost:8082/api/auth/signup", {
        name: inputName,
        email: inputEmail,
        password: inputPassword,
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
          <button type="submit" className="btn btn-primary btn-auth">
            Register
          </button>
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