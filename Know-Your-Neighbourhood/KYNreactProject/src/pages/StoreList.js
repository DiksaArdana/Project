import { useEffect, useState } from "react";
import { useSearchParams } from "react-router-dom";
import { Link } from "react-router-dom";
import Layout from "../components/Layout/Layout";
import {
  getListStore,
  getSearchByKeyword,
} from "../services/StoreService";

const StoreList = () => {
  const [searchParams] = useSearchParams();
  const [listCar, setListCar] = useState([]);

  // Get List Car
  useEffect(() => {
    if (
      searchParams.get("keyword") === null 
    ) {
      getListStore(
        (data) => {
          setListCar(data);
        },
        (error) => {
          console.log(error);
        }
      );
    }

    return () => {};
  }, [searchParams]);

  // Search By Keyword (Make, Model, Year)
  useEffect(() => {
    if (searchParams.get("keyword") !== null) {
      const keyword = searchParams.get("keyword");

      getSearchByKeyword(
        keyword,
        (data) => {
          setListCar(data);
        },
        (error) => {
          console.log(error);
        }
      );
    }

    return () => {};
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
        {listCar.map((store) => (
          <div className="col-12 col-md-6 col-md-4 col-lg-3 mb-3">
          <div className="card">
            <img className="card-img-top" src="https://cdn-icons-png.flaticon.com/512/149/149071.png" alt={store.name} />
            <div className="card-body d-flex justify-content-between flex-column">
              <p className=" fw-bold m-1">
                {store.name} 
              </p>
              <p className="m-1">{store.phone}</p>
              <p className="m-1">{store.localities}</p>
              <Link
                className="btn btn-primary btn-car"
                to={`${store.name}/${store.phone}/${store.localities}/${store.id}`}
              >
                Neighbor Details
              </Link>
            </div>
          </div>
        </div>
        ))}
      </div>
    </div>
</Layout>
  );
};

export default StoreList;