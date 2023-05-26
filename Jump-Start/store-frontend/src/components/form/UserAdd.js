import axios from "axios";
import { useContext, useRef, useState } from "react";
import { Link } from "react-router-dom";
import "./AuthForm.css";
import { BsPinMap } from "react-icons/bs";
import AuthContext from "../../services/AuthContext";
const UserAddForm = () => {
  const authUser = useContext(AuthContext);
  const inputNameRef = useRef();
  const inputEmailRef = useRef();
  const inputAddressRef = useRef();
  const inputPhoneRef = useRef();
  const inputPasswordRef = useRef();
  const inputRoleRef = useRef();

  const [registerStatus, setRegisterStatus] = useState("");

  const onSubmitHandler = (e) => {
    e.preventDefault();
    const inputName = inputNameRef.current.value;
    const inputAddress = inputAddressRef.current.value;
    const inputPhone = inputPhoneRef.current.value;
    const inputEmail = inputEmailRef.current.value;
    const inputPassword = inputPasswordRef.current.value;
    const inputRole = inputRoleRef.current.value;

    axios
      .post("http://localhost:8082/api/admin/post-user",
       {
        name: inputName,
        email: inputEmail,
        address: inputAddress,
        phone: inputPhone,
        password: inputPassword,
        role:inputRole
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
    inputRoleRef.current.value = "";

  };

  return (
    <div className="d-flex justify-content-center">
      <div className="form-auth my-5 py-5 bg-light">
        <h3 className="mb-3 fw-semibold text-center">AddNewUser</h3>
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
          <select
            ref={inputRoleRef}
            className="form-control mb-3 ps-4 pe-0"
            name="role"
          >
            <option value={""}>===== Choose role =====</option>
            <option value={"user"}>User</option>
            <option value={"admin"}>Admin</option>
            <option value={"rider"}>Rider</option>
          </select>
          <button type="submit" className="btn btn-primary btn-auth">
            Add New User
          </button>
        </form>
        
      </div>
    </div>
  );
};

export default UserAddForm;