import { useContext, useEffect, useState } from "react";
import AuthContext from "../services/AuthContext";
import "../App.css";
import Layout from "../components/layout/navigate";
import Navbar from "../components/layout/navbar";
import Footer from "../components/layout/footer";
import { Link } from "react-router-dom";
import { getUserDetail } from "../services/UserServices";

const Profile = () => {
  const authUser = useContext(AuthContext);
  const [user, setUser] = useState({
    name: "",
    email: "",
    address: "",
    phone: "",
    img: null,
  });
  useEffect(() => {
    // Get User Detail
    getUserDetail(
      authUser.userId,
      (dta) => {
        setUser({
          name: dta.name,
          email: dta.email,
          address: dta.address,
          phone:dta.phone,
          img: dta.imageUrl
        });
      },
      (error) => {
        console.log(error);
      }
    );
    return () => { };
  }, [authUser.userId]);
  return (
    <>
      {authUser.role === "admin" &&
      (<div className="main-container">
        <Navbar />
        <div className="row">
          <div className="col-2 nav-color">
            <ul className="nav flex-column ">
              <li className="nav-item ">
                <Link className="nav-link" to={"/dashboard-user"}>User Dashboard</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to={"/dashboard-product"}>Product Dashboard</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to={"/dashboard-category"}>Category Dashboard</Link>
              </li>
              <li className="nav-item">
              <Link className="nav-link" to={"/dashboard-order"}>Order Dashboard</Link>
            </li>
            </ul>
          </div>
          <div className="col-10">
            <div className="container">
              <div className="card border-0 shadow rounded-3 px-5 my-4">

                <div className="card-body ">
                  <div className="row">
                    <div className="col-4 ">
                      <div className="row">
                        <img className=" img-thumbnail m-3" src={user.img} alt="User" width={"150px"} height={"350"} />
                      </div>
                      <div className="row">
                        <Link to={"/edit-profile"} className="btn btn-primary mx-3 ">Edit profile</Link>
                      </div>

                    </div>
                    <div className="col-8 d-flex align-items-center">
                      <ul class="list-group list-group-flush mx-3">
                        <li class="list-group-item">Username : {user.name} </li>
                        <li class="list-group-item">Email :{user.email}</li>
                        <li class="list-group-item">Phonenumber: {user.phone}</li>
                      </ul>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <Footer />
      </div>)}
      {authUser.role === "user" &&
      (<Layout>
        <div className="card border-0 shadow rounded-3 px-5 my-4">

          <div className="card-body ">
            <div className="row">
              <div className="col-4 ">
                <div className="row">
                  <img className=" img-thumbnail m-3" src={user.img} alt="User" width={"150px"} height={"350"} />
                </div>
                <div className="row">
                <Link to={"/edit-profile"} className="btn btn-primary mx-3 ">Edit profile</Link>
                </div>

              </div>
              <div className="col-8 d-flex align-items-center">
                <ul class="list-group list-group-flush mx-3">
                  <li class="list-group-item">Username : {user.name}</li>
                  <li class="list-group-item">Email :{user.email}</li>
                  <li class="list-group-item">Phonenumber: {user.phone}</li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </Layout>)}
      {authUser.role === "rider" &&
      (<Layout>
        <div className="card border-0 shadow rounded-3 px-5 my-4">

          <div className="card-body ">
            <div className="row">
              <div className="col-4 ">
                <div className="row">
                  <img className=" img-thumbnail m-3" src={user.img} alt="User" width={"150px"} height={"350"} />
                </div>
                <div className="row">
                <Link to={"/edit-profile"} className="btn btn-primary mx-3 ">Edit profile</Link>
                </div>

              </div>
              <div className="col-8 d-flex align-items-center">
                <ul class="list-group list-group-flush mx-3">
                  <li class="list-group-item">Username : {user.name}</li>
                  <li class="list-group-item">Email :{user.email}</li>
                  <li class="list-group-item">Phonenumber:{user.phone}</li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </Layout>)}
    </>
  );
};

export default Profile;