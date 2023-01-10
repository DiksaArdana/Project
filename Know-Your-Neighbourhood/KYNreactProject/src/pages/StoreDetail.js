import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import Car from "../components/Layout/Store";
import Layout from "../components/Layout/Layout";
import { getStoreDetail } from "../services/StoreService";


const StoreDetail = () => {
  const [store, setStore] = useState({
    name: "",
    phone: "",
    localities: "",
  });

  const params = useParams();

  useEffect(() => {
    // Get Store Detail
    getStoreDetail(
      params.storeId,
      (store) => {
        setStore({
          name: store.name,
          phone: store.phone,
          localities: store.localities,
        });
      },
      (error) => {
        console.log(error);
      }
    );

    return () => {};
  }, [params.storeId]);

  return (
    <Layout>
    <Car {...store} />
    </Layout>
  );
};

export default StoreDetail;