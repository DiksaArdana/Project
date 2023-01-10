
import axios from "axios";
import { useContext, useRef, useState } from "react";
import { useNavigate } from "react-router-dom";
import Layout from "../components/Layout/Layout";
import AuthContext from "../context/AuthContext";


const StoreAdd = () => {
  const authUser = useContext(AuthContext);
  const navigate = useNavigate();
  const [postStatus, setPostStatus] = useState("");

  const inputNameRef = useRef();
  const inputPhoneRef = useRef();
  const inputLocalitiesRef = useRef();


  const onSubmitHandler = (e) => {
    e.preventDefault();
    const inputName = inputNameRef.current.value;
    const inputPhone = inputPhoneRef.current.value;
    const inputLocalities = inputLocalitiesRef.current.value;

    axios
      .post(
        "http://localhost:8082/api/store/post-store",
        {
          name: inputName,
          phone: inputPhone,
          localities: inputLocalities,
        },
        {
          headers: { Authorization: `Bearer ${authUser.token}` },
        }
      )
      .then((res) => {
        console.log(res.data);
        navigate("/stores");
      })
      .catch((err) => {
        console.log(err.message);
        setPostStatus("FAILED");
      });

    inputNameRef.current.value = "";
    inputPhoneRef.current.value = "";
    inputLocalitiesRef.current.value = "";
  };

  return (
    <Layout>
    <div className="d-flex justify-content-center my-5">
      <div className="form-auth">
        <h3 className="mb-3 fw-semibold text-center">Post Neighbors</h3>
        {postStatus === "FAILED" && (
          <div className="form-error text-center">Failed to post data <br/> Phone number already exist</div>
        )}
        <form onSubmit={onSubmitHandler}>
          <label className="form-label">Full Name</label>
          <input className="form-control"
            ref={inputNameRef} 
            name="name" 
            type="text"
            required="required"/>
					

          <label className="form-label">Phone Number</label>
          <input
            ref={inputPhoneRef}
            className="form-control mb-3 ps-4 pe-0"
            type="text"
            name="phone"
          />

          <label className="form-label">Localities</label>
          <input
            ref={inputLocalitiesRef}
            className="form-control mb-3 ps-4 pe-0"
            type="text"
            name="localities"
          />

          <button
            type="submit"
            className="btn btn-success"
            style={{ width: "100%" }}
          >
            Post Data
          </button>
        </form>
      </div>
    </div>
    </Layout>
  );
};

export default StoreAdd;