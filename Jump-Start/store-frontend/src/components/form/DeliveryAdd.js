import axios from "axios";
import { useEffect, useState } from "react";
import { getListRider } from "../../services/UserServices";
import "./AuthForm.css";

const AddDeliveryForm = () => {
  const [userid, setUserid] = useState(0);
  const [orderid, setOrderid] = useState(0);
  const [postStatus, setPostStatus] = useState("");
  const [listRaider, setListRaider] = useState([]);
  useEffect(() => {
    getListRider(
      (data) => {
        console.log(data);
        setListRaider(data);
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
    formData.append("riderid", userid);
    formData.append("orderid", orderid);

    axios
      .post(
        "http://localhost:8082/api/order/post-delivery", formData,
        {
          headers: {
            "Content-Type": "multipart/form-data"
          },
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
        <h3 className="mb-3 fw-semibold text-center"> Order Delivery </h3>
        <form onSubmit={onSubmitHandler}>
          {postStatus === "FAILED" && (
            <div className="form-error text-center">Deliver Failed</div>
          )}
          {postStatus === "SUCCESS" && (
            <div className="form-success text-center">
              Order Rider successfully!!
            </div>
          )}
          <label>Rider ID:</label>
          <select
               onChange={(e) => setUserid(e.target.value)}
               value={userid}
                className="form-control mb-3 ps-4 pe-0"
                type="text"
                name="raider"
              >
                <option value={0}>==== Choose  Raider====</option>
                {listRaider.map((dta) => (
                  <option value={dta.id}>{dta.name}({dta.address})</option>
                ))}
              </select>
          <label>OrderID:</label>
          <input onChange={(e) => setOrderid(e.target.value)}
            value={orderid}
            className="form-control mb-3 ps-4 pe-0"
            type="number"
            name="oid"
            required></input>
          <button type="submit" className="btn btn-color btn-auth">
            Deliver Order
          </button>
        </form>
      </div>
    </div>
  );
};

export default AddDeliveryForm;