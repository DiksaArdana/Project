import axios from "axios";
import { useContext, useEffect, useState } from "react";
import { BsBasket2Fill } from "react-icons/bs";
import { Link, useParams } from "react-router-dom";
import Layout from "../components/layout/navigate";
import AuthContext from "../services/AuthContext";
import { getProductDetail } from "../services/ProductServices";

const Product = () => {
  const authUser = useContext(AuthContext);
  const [product, setProduct] = useState({
    productid: 0,
    name: "",
    price: 0,
    descr: "",
    img: null,
  });
  const [qty, setQty] = useState(1);
  const [registerStatus, setRegisterStatus] = useState("");
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
          img: dta.image
        });
      },
      (error) => {
        console.log(error);
      }
    );
    return () => { };
  }, [params.pid]);

  const onSubmitChart = (e) => {
    e.preventDefault(); 
    const total = qty * product.price;
    const formData = new FormData();
    formData.append("qty", qty);
    formData.append("subtotal", total);
    formData.append("uid", authUser.userId);
    formData.append("pid", product.productid);

    axios
      .post("http://localhost:8082/api/chart/post-chart",formData,
      {
        headers: { 
          "Content-Type": "multipart/form-data" },
      })
      .then((res) => {
        setRegisterStatus("SUCCESS");
        console.log(res);
      })
      .catch((err) => {
        setRegisterStatus("FAILED");
        console.log(err.message);
      });
  };
  return (
    <Layout>
      <section className="py-5" id="product-detail">
        <div className="container px-5 my-5">
          <div className="row gx-5 align-items-center">
            <div className="col-lg-6"><img className="img-fluid rounded mb-5 mb-lg-0" src={product.img} alt={product.name} width={"425px"} /></div>
            <div className="col-lg-6">
              <div className="card border-0 shadow rounded-3">
                {registerStatus === "FAILED" && (
                  <div className="form-error text-center">Erorr Invalid</div>
                )}
                {registerStatus === "SUCCESS" && (
                  <div className="form-success text-center">
                    Successfully Added to chart!
                  </div>
                )}
                <ul class="card-body list-group list-group-flush">
                  <li class="list-group-item">{product.name}</li>
                  <li class="list-group-item text-success">Price: {product.price} $</li>
                  {!authUser.isLoggedIn && (
                    <li class="list-group-item d-flex">
                      <div className="flex-grow-1">
                        <div className="row align-items-center">
                          <div className="col-auto">Qty :</div>
                          <div className="col-auto"><input className="form-control" type={"number"}></input></div>
                        </div>
                      </div>
                      <Link className="btn btn-success" to={"/login"}><BsBasket2Fill /> Add Chart</Link>
                    </li>)}
                  {authUser.role === "user" && (
                    <li class="list-group-item">
                      <form className="d-flex" onSubmit={onSubmitChart}>
                        <div className="px-2">Qty</div>
                        <div className="flex-grow-1"> <input onChange={(e) => setQty(e.target.value)} value={qty} className="form-control" type="number" /> </div>
                        <div className="px-2"> <button className="btn btn-success" type="submit"><BsBasket2Fill /> Add Chart</button></div>
                      </form>
                    </li>)}
                  <li class="list-group-item">Product Description:</li>
                  <li class="list-group-item">{product.descr}</li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </section>
    </Layout>
  );
}

export default Product;