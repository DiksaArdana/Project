
import React, { useContext, useEffect, useState } from "react";
import AddCategoryForm from "../components/form/CategoryAdd";
import Layout from "../components/layout/NavigateAdmin";
import AuthContext from "../services/AuthContext";
import { getListCategory } from "../services/ProductServices";
const CategoryDasboard = () => {
  const authCtx = useContext(AuthContext);
  const [listProduct, setListProduct] = useState([]);

  // Get List User
  useEffect(() => {
      getListCategory(
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
        
        <h2>Dashboard Admin</h2>
        <AddCategoryForm/>
        <div className="container d-flex align-items-center justify-content-center">
          <table className="table border">
            <tr >
              <th >id</th>
              <th >Category</th>
              <th >Image</th>
            </tr>
            {listProduct.map((dta) => (
              <tr >
                <td >{dta.id}</td>
                <td >{dta.name}</td>
                <td ><img  width={"100px"} src={dta.image}/></td>
              </tr>
              ))}
          </table>
        </div>


      </Layout>
    </div>
  )
}
export default CategoryDasboard;