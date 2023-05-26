import { useEffect, useState } from "react";
import { Link, useSearchParams } from "react-router-dom";
import Layout from "../components/layout/navigate";
import { getAvailableProduct, getSearchProduct } from "../services/ProductServices";

const ProductList = () => {
  const [searchParams] = useSearchParams();
  const [listProduct, setListProduct] = useState([]);
  // Get List Product
  useEffect(() => {
    if (searchParams.get("keyword") === null) {
      getAvailableProduct(
        (data) => {
          setListProduct(data);
        },
        (error) => {
          console.log(error);
        }
      );
    }
    return () => { };
  }, [searchParams]);
  // Search By Keyword (Name and Category)
  useEffect(() => {
    if (searchParams.get("keyword") !== null) {
      const keyword = searchParams.get("keyword");
      getSearchProduct(
        keyword,
        (data) => {
          setListProduct(data);
        },
        (error) => {
          console.log(error);
        }
      );
    }
    return () => { };
  }, [searchParams]);

  return (
    <Layout>
      <div className="container my-5">
        <div className="mt-3 row">
          {searchParams.get("keyword") !== null && (
            <p className="text-secondary ms-1">
              Search "{searchParams.get("keyword")}"
            </p>
          )}
          {listProduct.map((dta) => (
            <div className="col-12 col-md-6 col-md-4 col-lg-3 mb-3">
              <div className="card p-3">
                <img className="card-img-top img-thumb" src={dta.image} alt={dta.name} />
                <div className="card-body d-flex justify-content-between flex-column">
                  <p className=" fw-bold m-1">
                    {dta.name}
                  </p>
                  <p className="m-1">Price : ${dta.price}</p>
                  <Link
                    className="btn btn-primary btn-car"
                    to={`/product/${dta.name}/${dta.id}`}
                  >
                    Order
                  </Link>
                </div>
              </div>
            </div>))}
        </div>
      </div>
    </Layout>
  );
}

export default ProductList;