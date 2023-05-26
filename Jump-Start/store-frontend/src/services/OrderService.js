import axios from "axios";

export function getListOrder(callback, errorCallback){
    axios
    .get("http://localhost:8082/api/order/order-list")
    .then((res) => {
      if (callback != null) {
        callback(res.data);
      }
    })
    .catch((err) => {
      if (errorCallback != null) {
        errorCallback(err.message);
      }
    });
}
export function getRequestDelivery(id,callback, errorCallback){
  axios
  .get(`http://localhost:8082/api/order/my-delivery/${id}`)
  .then((res) => {
    if (callback != null) {
      callback(res.data);
    }
  })
  .catch((err) => {
    if (errorCallback != null) {
      errorCallback(err.message);
    }
  });
}

