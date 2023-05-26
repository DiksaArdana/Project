import axios from "axios";
import {  useContext, useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import AuthContext from "../../services/AuthContext";
import { getUserDetail } from "../../services/UserServices";
import Layout from "../layout/navigate";

import "./AuthForm.css";

const EditProfileForm = () => {
  const authUser = useContext(AuthContext);
  const navigate = useNavigate();
  const [user, setUser] = useState({
    name: "",
    address: "",
    phone: "",
    img: null,
  });
  useEffect(() => {
    // Get Product Detail
    getUserDetail(
      authUser.userId,
      (dta) => {
        setUser({
          name: dta.name,
          address: dta.address,
          phone:dta.phone,
          img: dta.image
        });
      },
      (error) => {
        console.log(error);
      }
    );
    return () => { };
  }, [authUser.userId]);

  const [postStatus, setPostStatus] = useState("");
  const [name, setName] = useState("");
  const [address, setAddress] = useState("");
  const [phone, setPhone] = useState("");
  const [image, setImage] = useState(null);
  const onSubmitHandler = (e) => {
    e.preventDefault();
    
    const formData = new FormData();
    formData.append("uid", authUser.userId);
    formData.append("name", name);
    formData.append("image", image);
    formData.append("address", address);
    formData.append("phone", phone);

    axios
      .post(
        "http://localhost:8082/api/auth/edit-profile",formData,
        {
          headers: { 
            "Content-Type": "multipart/form-data" },
        })
       
      .then((res) => {
        console.log(res.data);
        setPostStatus("SUCCESS")
        navigate("/profile")
      })
      .catch((err) => {
        console.log(err.message);
        setPostStatus("FAILED");
      });
  };

  return (
    <Layout>
    <div className="d-flex justify-content-center">
      <div className="form-auth my-5 py-5 bg-light">
        <h3 className="mb-3 fw-semibold text-center">Update Profile</h3>
        <form onSubmit={onSubmitHandler}>
          {postStatus === "FAILED" && (
            <div className="form-error text-center">Update Failed</div>
          )}
          {postStatus === "SUCCESS" && (
            <div className="form-success text-center">
              Profile Updated successfully!!
            </div>
          )}
              <input
                onChange={(e) => setName(e.target.value)}
                value={name}
                className="form-control mb-3 ps-4 pe-0"
                type="text"
                name="name"
                placeholder={user.name}
                required
              />
              <label>Profile image:</label>
              <input
                onChange={(e) => setImage(e.target.files[0])}
                className="form-control mb-3 ps-4 pe-0"
                type="file"
                name="image"
                required
              />
              <label>address:</label>
               <input
               onChange={(e) => setAddress(e.target.value)}
               value={address}
                className="form-control mb-3 ps-4 pe-0"
                type="text"
                name="address"
                placeholder={user.address}
                required
              />
              <label>Phone number: </label>
              <input
                onChange={(e) => setPhone(e.target.value)}
                value={phone}
                className="form-control mb-3 ps-4 pe-0"
                type="text"
                name="phone"
                placeholder={user.phone}
                required
              /> 
              <button type="submit" className="btn btn-primary btn-auth">
                Update Profile
              </button>
            </form>
      </div>
    </div>
    </Layout>
  );
};

export default EditProfileForm;