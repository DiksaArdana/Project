import React, { useEffect, useState } from "react";
import { BsFillPencilFill } from "react-icons/bs";
import { Link } from "react-router-dom";
import AddProductForm from "../components/form/ProductAdd";
import Layout from "../components/layout/NavigateAdmin";
import { getListProduct } from "../services/ProductServices";
const ProductDasboard = () => {
  const [listProduct, setListProduct] = useState([]);
  // Get List Product
  useEffect(() => {
      getListProduct(
        (data) => {
          console.log(data);
          setListProduct(data);
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
        <h2 className="text-center">Dashboard Admin</h2>
        <AddProductForm/>
        <div className="container d-flex align-items-center justify-content-center">
          <table className="table border">
            <tr >
              <th >id</th>
              <th >Product Name</th>
              <th >Category</th>
              <th >Price</th>
              <th >Event</th>
              <th >Status</th>
              <th >Image</th>
            </tr>
            {listProduct.map((dta) => (
              <tr >
                <td >{dta.id}</td>
                <td >{dta.name}</td>
                <td >{dta.category.name}</td>
                <td >${dta.price}</td>
                <td >{dta.event}</td>
                <td >{dta.status}</td>
                <td ><img  width={"100px"} src={dta.image}/></td>
                <td><Link to={`/edit-product/${dta.id}`}><BsFillPencilFill/></Link></td>
              </tr>
              ))}
          </table>
        </div>


      </Layout>
    </div>
  )
}
export default ProductDasboard;