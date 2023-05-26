import { Link } from "react-router-dom";
import Layout from "../components/layout/navigate";
import ImageSlider from "../components/layout/ImageSlider";
import { SliderData } from "../components/layout/SliderData";
import { useEffect, useState } from "react";
import { getListCategory, getPromoProduct } from "../services/ProductServices";

const Home = () => {
  const [listProduct, setListProduct] = useState([]);
  const [listCategory, setListCategory] = useState([]);
    // Get List Product
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
      getPromoProduct(
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
    <Layout>
      {/* Carousel */}
      <div className="row">
        <div className="col">
          <ImageSlider slides={SliderData} />
        </div>
      </div>
      {/* Category */}
      <div className="row p-4" style={{backgroundColor:"#fcbf49"}}>
        <h4 className="">Product Category</h4>
        {listCategory.map((dta) => (
        <div className="col">
          <Link className="card bg-white text-dark" to={`/products?keyword=${dta.id}`}>
            <img className="card-img p-3"  style={{maxHeight:"150px"}} src={dta.image} alt="Card image" />
            <div className="card-img-overlay d-flex align-items-center justify-content-center ">
              <h5 className="card-title bg-light opacity-50">{dta.name}</h5>
            </div>
          </Link>
        </div>
        ))}
      </div>
      {/* Product Promo */}
      <div className="mt-3 row">
      {listProduct.map((dta) => (
        <div className="col-12 col-md-6 col-md-4 col-lg-3 mb-3">
          <div className="card p-3">
            <img className="card-img-top img-thumb" src={dta.image} alt="Product"  />
            <div className="card-body d-flex justify-content-between flex-column">
              <p className=" fw-bold ">{dta.name}</p>
              <p className=" fw-normal ">Price: ${dta.price}</p>

              <Link
                className="btn btn-color btn-car"
                to={`/product/${dta.name}/${dta.id}`}>
                Order
              </Link>
            </div>
          </div>
        </div>
      ))}
      </div>
    </Layout>
  );
}

export default Home;