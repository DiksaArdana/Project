import React, { useContext, useEffect, useState } from "react";
import AddDeliveryForm from "../components/form/DeliveryAdd";
import Layout from "../components/layout/NavigateAdmin";
import AuthContext from "../services/AuthContext";
import { getListOrder } from "../services/OrderService";
const OrderDasboard = () => {
  const [listProduct, setListProduct] = useState([]);
  // Get List Order
  useEffect(() => {
    getListOrder(
      (data) => {
        console.log(data);
        setListProduct(data);
      },
      (error) => {
        console.log(error);
      }
    );
    return () => { };
  });
  return (

    <div>
      <Layout>
        <h2 className="text-center">Dashboard Admin</h2>
       <AddDeliveryForm/>
        <div className="container d-flex align-items-center justify-content-center">
          <table className="table border">
            <thead>
            <tr >
              <th >id</th>
              <th >Order</th>
              <th >Price</th>
              <th >User Detail</th>
              <th >Date</th>
              <th >Status</th>
            </tr>
            </thead>
            <tbody>
            {listProduct.map((dta) => (
              <tr >
                <td >{dta.id}</td>
                <td ><img  width={"100px"} src={dta.chart.product.image}/><span>{dta.chart.product.name} x{dta.chart.qty}</span></td>
                <td >${dta.chart.total}</td>
                <td ><p>Name: {dta.chart.user.name}</p> <p>Phone: {dta.chart.user.phone}</p> <p>Email: {dta.chart.user.email}</p><p>Address: {dta.chart.user.address}</p></td>
                <td >{dta.date}</td>
                <td >{dta.status}</td>
              </tr>
            ))}
            </tbody>
          </table>
        </div>


      </Layout>
    </div>
  )
}
export default OrderDasboard;