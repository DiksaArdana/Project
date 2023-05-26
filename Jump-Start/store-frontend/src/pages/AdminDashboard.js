import axios from "axios";
import React, { useContext, useEffect, useRef, useState } from "react";
import UserAddForm from "../components/form/UserAdd";
import Layout from "../components/layout/NavigateAdmin";
import { getListUser } from "../services/UserServices";

const AdminDasboard = () => {
  const [listUser, setListUser] = useState([]);
  // Get List User
  useEffect(() => {
      getListUser(
        (data) => {
          console.log(data);
          setListUser(data);
        },
        (error) => {
          console.log(error);
        }
      );

    return () => {};
  });
  return (

    <div>
      <Layout>
        
        <h2 className="text-center">Dashboard Administator</h2>
        <UserAddForm/>
        <div className="container d-flex align-items-center justify-content-center">
          <table className="table border">
            <tr >
              <th >id</th>
              <th >Name</th>
              <th >Email</th>
              <th >Phone</th>
              <th >Address</th>
              <th >Role</th>
            </tr>
            {listUser.map((dta) => (
              <tr >
                <td >{dta.id}</td>
                <td >{dta.name}</td>
                <td >{dta.email}</td>
                <td >{dta.phone}</td>
                <td >{dta.address}</td>
                <td >{dta.role}</td>
              </tr>
            ))}
          </table>
        </div>


      </Layout>
    </div>
  )
}
export default AdminDasboard;