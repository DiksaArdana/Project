import axios from "axios";
import {  useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getListCategory, getProductDetail } from "../../services/ProductServices";
import Layout from "../layout/NavigateAdmin";
import "./AuthForm.css";

const EditProductForm = () => {
  const [product, setProduct] = useState({
    productid: 0,
    name: "",
    price: 0,
    descr: "",
    img: null,
    category:0,
    status:"",
    event:"",
  });
  const params = useParams();
  useEffect(() => {
    // Get Product Detail
    getProductDetail(
      params.pid,
      (dta) => {
        setProduct({
          productid: dta.id,
          name: dta.name,
          price: dta.price,
          descr: dta.desc,
          img: dta.image,
          category: dta.category,
          event:dta.event,
          status: dta.status,
        });
      },
      (error) => {
        console.log(error);
      }
    );
    return () => { };
  }, [params.pid]);
  const [postStatus, setPostStatus] = useState("");
  const [name, setName] = useState(product.name);
  const [category, setCategory] = useState(product.category);
  const [event, setEvent] = useState(product.event);
  const [status, setStatus] = useState(product.status);
  const [descr, setDescr] = useState(product.descr);
  const [price, setPrice] = useState(product.price);
  const [image, setImage] = useState(null);
  const [listCategory, setListCategory] = useState([]);
  useEffect(() => {
    getListCategory(
      (data) => {
        console.log(data);
        setListCategory(data);
      },
      (error) => {
        console.log(error);
      }
    );

  return () => {};
});
  const onSubmitHandler = (e) => {
    e.preventDefault();
    const formData = new FormData();
    formData.append("pid", product.productid);
    formData.append("name", name);
    formData.append("image", image);
    formData.append("price", price);
    formData.append("status", status);
    formData.append("descr", descr);
    formData.append("category", category);
    formData.append("event", event);

    axios
      .post(
        "http://localhost:8082/api/products/edit-product",formData,
        {
          headers: { 
            "Content-Type": "multipart/form-data" },
        })
       
      .then((res) => {
        console.log(res.data);
        setPostStatus("SUCCESS")
        
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
        <h3 className="mb-3 fw-semibold text-center">Update Product Data</h3>
        <form onSubmit={onSubmitHandler}>
          {postStatus === "FAILED" && (
            <div className="form-error text-center">Update Failed</div>
          )}
          {postStatus === "SUCCESS" && (
            <div className="form-success text-center">
              Product Updated successfully!!
            </div>
          )}
              <input
                onChange={(e) => setName(e.target.value)}
                value={name}
                className="form-control mb-3 ps-4 pe-0"
                type="text"
                name="name"
                placeholder={product.name}
                required
              />
              <input
                onChange={(e) => setImage(e.target.files[0])}
                className="form-control mb-3 ps-4 pe-0"
                type="file"
                name="image"
                placeholder="Product Image"
                required
              />
               <input
               onChange={(e) => setPrice(e.target.value)}
               value={price}
                className="form-control mb-3 ps-4 pe-0"
                type="number"
                name="price"
                placeholder="Price"
                required
              />
              
              <input
                onChange={(e) => setDescr(e.target.value)}
                value={descr}
                className="form-control mb-3 ps-4 pe-0"
                type="text"
                name="descr"
                placeholder={product.descr}
                
              /> 
              <label> Category</label>
              <select
               onChange={(e) => setCategory(e.target.value)}
               value={category}
                className="form-control mb-3 ps-4 pe-0"
                type="text"
                name="category"
              >
                <option value={0}>==== Choose product category====</option>
                {listCategory.map((dta) => (
                  <option value={dta.id}>{dta.name}</option>
                ))}
              </select>
              <label> Event</label>
              <select
                onChange={(e) => setEvent(e.target.value)}
                value={event}
                className="form-control mb-3 ps-4 pe-0"
                type="text"
                name="event"
              >
                <option value={""}>===== Choose product event ====</option>
                <option value={"none"}>None</option>
                <option value={"promo"}>Promo</option>

              </select>
              <label> Status</label>
              <select
                onChange={(e) => setStatus(e.target.value)}
                value={status}
                className="form-control mb-3 ps-4 pe-0"
                type="text"
                name="status"
              >
                <option value={""}>==== Choose product availability </option>
                <option value={"available"}>Availabe</option>
                <option value={"outstock"}>Out Stock</option>

              </select> 
              <button type="submit" className="btn btn-primary btn-auth">
                Add New Product
              </button>
            </form>
      </div>
    </div>
    </Layout>
  );
};

export default EditProductForm;