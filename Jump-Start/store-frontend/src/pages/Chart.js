import { PayPalButtons, PayPalScriptProvider } from "@paypal/react-paypal-js";
import axios from "axios";
import { useContext, useEffect, useState } from "react";
import { BsFillCreditCardFill, BsXCircle } from "react-icons/bs";
import Layout from "../components/layout/navigate";
import AuthContext from "../services/AuthContext";
import { getChartUser } from "../services/UserServices";

const Chart = () => {
  const authCtx = useContext(AuthContext);
  const [listChart, setListChart] = useState([]);
  const formData = new FormData();
  // Get List Chart for User
  useEffect(() => {
    getChartUser(
      authCtx.userId,
      (data) => {
        console.log(data);
        setListChart(data);
      },
      (error) => {
        console.log(error);
      }
    );
    return () => { };
  }, [authCtx.userId]);
  const totalPrice = listChart.reduce((acc, curr) => acc + curr.total, 0);
  return (
    <Layout>
      <section className="py-5" id="product-chart">
        <div className="container px-5 my-5">
          <div className="row gx-5 align-items-center">
            <div className="col-lg-8">
              {listChart.map((dta) => (
                <div className="card border-0 shadow rounded-3">
                  <div className="card-body">
                    <div className="d-flex">
                      <div className="flex-grow-1 row">
                        <div className="col-4 d-flex d-flex justify-content-center">
                          <img className="rounded-circle mx-3" src={dta.product.image} alt="..." width={"125px"} />
                        </div>
                        <div className="col-8 d-flex align-items-center">
                          <ul class="list-group list-group-flush mx-3">
                            <li class="list-group-item fw-bold">{dta.product.name}</li>
                            <li class="list-group-item">Price: $ {dta.product.price} </li>
                            <li class="list-group-item">Quantity : {dta.qty}</li>
                            <li class="list-group-item">SubTotal: $ {dta.total}</li>
                          </ul>
                        </div>
                      </div>
                      <div className="d-flex align-items-center ">
                        {/* <button className="btn" onClick={() => {
                          formData.append("cid", dta.id);
                          axios
                            .post("http://localhost:8082/api/order/post-order", formData,
                              {
                                headers: {
                                  "Content-Type": "multipart/form-data"
                                },
                              })
                            .then((res) => {
                              console.log(res);
                              alert("Thank you for your order")
                            })
                            .catch((err) => {
                              console.log(err.message);
                            });
                        }}> <BsFillCreditCardFill className="fs-2 text-success" /></button> */}
                        <PayPalScriptProvider options={{"client-id": "AQqyospfBAurXS1lfRNyYq1yJ06RPFV1xLAo91mB4F7DFHzZIuqEKeqKvGLrquP9avtLfuLDvwdlGby3"}}>
                        <PayPalButtons
                        createOrder={(data, actions) => {

                        return actions.order.create({
                          purchase_units: [
                            {
                              amount: {
                                value: `${dta.total}`,
                              },
                            },
                          ],
                        });
                      }}
                      onApprove={async (data, actions) => {
                        formData.append("cid", dta.id);
                        axios
                        .post("http://localhost:8082/api/order/post-order", formData,
                        {
                          headers: { 
                            "Content-Type": "multipart/form-data" },
                        })
                        .then((res) => {
                          console.log(res);
                          alert("Thank you for your order")
                        })
                        .catch((err) => {
                          console.log(err.message);
                        });
                      }}
                      />
                      </PayPalScriptProvider>
                      </div>
                      <div className="d-flex align-items-center px-3 ">
                        <form onSubmit={() => {
                          formData.append("cid", dta.id);
                          axios
                            .post("http://localhost:8082/api/chart/edit-chart", formData,
                              {
                                headers: {
                                  "Content-Type": "multipart/form-data"
                                },
                              })
                            .then((res) => {
                              console.log(res);
                            })
                            .catch((err) => {
                              console.log(err.message);
                            });
                        }} ><button type="submit" className="btn"><BsXCircle className="fs-2 text-danger" /></button></form>
                      </div>
                    </div>
                  </div>
                </div>
              ))}
            </div>
            <div className="col-lg-4">
              <div className="card border-0 shadow rounded-3">
                <div class="card-body">
                  <table className="table">
                    <th className="row">
                      <td className="col">Product</td>
                      <td className="col">Qty</td>
                      <td className="col"> SubTotal</td>
                    </th>
                    {listChart.map((dta) => (
                      <tr className="row">
                        <td className="col">{dta.product.name}</td>
                        <td className="col">{dta.qty}</td>
                        <td className="col">${dta.total}</td>
                      </tr>
                    ))}
                  </table>
                  <hr></hr>
                  <div className="d-flex align-items-center mb-3"><div className="flex-grow-1">Total</div> <div className="px-2">${totalPrice}</div> </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
    </Layout>
  );
}

export default Chart;