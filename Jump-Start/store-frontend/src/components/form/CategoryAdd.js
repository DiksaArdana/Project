import axios from "axios";
import {  useState } from "react";
import "./AuthForm.css";

const AddCategoryForm = () => {
  const [postStatus, setPostStatus] = useState("");
  const [name, setName] = useState("");
  const [image, setImage] = useState(null);

  const onSubmitHandler = (e) => {
    e.preventDefault();
    
    const formData = new FormData();
    formData.append("name", name);
    formData.append("image", image);;

    axios
      .post(
        "http://localhost:8082/api/products/post-category",formData,
        {
          headers: { 
            "Content-Type": "multipart/form-data" },
        })
        .then((res) => {
        console.log(res.data);
        setPostStatus("SUCCESS")
        }).catch((err) => {
        console.log(err.message);
        setPostStatus("FAILED");
        });


  };

  return (
    <div className="d-flex justify-content-center">
      <div className="form-auth my-5 py-5 bg-light">
        <h3 className="mb-3 fw-semibold text-center">Add New Category</h3>
        <form onSubmit={onSubmitHandler}>
          {postStatus === "FAILED" && (
            <div className="form-error text-center">Register Failed</div>
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
                placeholder="Category name"
                required
              />
              <input
                onChange={(e) => setImage(e.target.files[0])}
                className="form-control mb-3 ps-4 pe-0"
                type="file"
                name="image"
                placeholder="Category Image"
              />
              <button type="submit" className="btn btn-color btn-auth">
                Add New Category
              </button>
            </form>
      </div>
    </div>
  );
};

export default AddCategoryForm;