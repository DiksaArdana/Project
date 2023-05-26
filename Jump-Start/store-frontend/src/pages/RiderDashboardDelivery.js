
import axios from "axios";
import React, { useContext, useEffect, useState } from "react";
import { BsCheckCircleFill } from "react-icons/bs";
import Layout from "../components/layout/navigate";
import AuthContext from "../services/AuthContext";
import { getRequestDelivery } from "../services/OrderService";

const RiderDasboard = () => {
  const authCtx = useContext(AuthContext);
  const [listDelivery, setListDelivery] = useState([]);
  const formData = new FormData();
  // Get List User
  useEffect(() => {
      getRequestDelivery(
        authCtx.userId,
        (data) => {
          console.log(data);
          setListDelivery(data);
        },
        (error) => {
          console.log(error);
        }
      );
    return () => {};
  },[authCtx.userId]);
  return (

    <div>
      <Layout>
        
        <h2 className="text-center mt-3">Rider Dasboard</h2>
        <div className="container d-flex align-items-center justify-content-center">
          <table className="table border">
            <thead>
            <tr >
              <th >id</th>
              <th >Product</th>
              <th >Sub Total</th>
              <th >Info User</th>
              <th >Order Address</th>
            </tr>
            </thead>
            <tbody>
            {listDelivery.map((dta) => (
              <tr >
                <td >{dta.id}</td>
                <td ><img  width={"100px"} src={dta.order.chart.product.image}/> <span>{dta.order.chart.product.name} x{dta.order.chart.qty}</span></td>
                <td >${dta.order.chart.total}</td>
                <td ><p>Name: {dta.order.chart.user.name}</p><p>Phone: {dta.order.chart.user.phone}</p> <p>Email: {dta.order.chart.user.email}</p></td>
                <td ><p>{dta.order.chart.user.address}</p> </td>
                <td >
                <form onSubmit={(e)=>{
                        formData.append("did", dta.id);
                        axios
                        .post("http://localhost:8082/api/order/edit-delivery", formData,
                        {
                          headers: { 
                            "Content-Type": "multipart/form-data" },
                        })
                        .then((res) => {
                          console.log(res);
                          alert("Product Delivery Success!")
                        })
                        .catch((err) => {
                          console.log(err.message);
                        });
                      }}>
                  <button className="btn" type="submit"><BsCheckCircleFill className="fs-2 text-success" /></button>
                </form>
                </td>
              </tr>
              ))}
              </tbody>
          </table>
        </div>
      </Layout>
    </div>
  )
}
export default RiderDasboard;