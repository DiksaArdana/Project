import axios from "axios";
import {  useEffect, useState } from "react";
import { getListCategory } from "../../services/ProductServices";

import "./AuthForm.css";

const AddProductForm = () => {
  const [postStatus, setPostStatus] = useState("");
  const [name, setName] = useState("");
  const [category, setCategory] = useState(0);
  const [event, setEvent] = useState("");
  const [status, setStatus] = useState("");
  const [descr, setDescr] = useState("");
  const [price, setPrice] = useState(0);
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

    formData.append("name", name);
    formData.append("image", image);
    formData.append("price", price);
    formData.append("status", status);
    formData.append("descr", descr);
    formData.append("category", category);
    formData.append("event", event);

    axios
      .post(
        "http://localhost:8082/api/products/post-product",formData,
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
    <div className="d-flex justify-content-center">
      <div className="form-auth my-5 py-5 bg-light">
        <h3 className="mb-3 fw-semibold text-center">Add New Product</h3>
        <form onSubmit={onSubmitHandler}>
          {postStatus === "FAILED" && (
            <div className="form-error text-center">Failed to save data!</div>
          )}
          {postStatus === "SUCCESS" && (
            <div className="form-success text-center">
              Product Added successfully!!
            </div>
          )}
              <input
                onChange={(e) => setName(e.target.value)}
                value={name}
                className="form-control mb-3 ps-4 pe-0"
                type="text"
                name="name"
                placeholder="Product name"
                required
              />
              <input
                onChange={(e) => setImage(e.target.files[0])}
                className="form-control mb-3 ps-4 pe-0"
                type="file"
                name="image"
                placeholder="Product Image"
              />
               <input
               onChange={(e) => setPrice(e.target.value)}
               value={price}
                className="form-control mb-3 ps-4 pe-0"
                type="number"
                name="price"
                placeholder="Price"
              />
              
              <input
                onChange={(e) => setDescr(e.target.value)}
                value={descr}
                className="form-control mb-3 ps-4 pe-0"
                type="text"
                name="descr"
                placeholder="Add product description here"
                required
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
  );
};

export default AddProductForm;