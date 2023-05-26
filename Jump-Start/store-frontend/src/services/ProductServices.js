import axios from "axios";

export function getListProduct(callback, errorCallback){
    axios
    .get("http://localhost:8082/api/products/products-list")
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
export function getAvailableProduct(callback, errorCallback){
  axios
  .get("http://localhost:8082/api/products/products-available")
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
export function getPromoProduct(callback, errorCallback){
  axios
  .get("http://localhost:8082/api/products/products-promo")
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
export function getSearchProduct(keyword,callback, errorCallback){
  axios
  .get(`http://localhost:8082/api/products/products-search?keyword=${keyword}`)
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
export function getProductDetail(id,callback, errorCallback){
  axios
  .get(`http://localhost:8082/api/products/product-detail?pid=${id}`)
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
export function getListCategory(callback, errorCallback){
  axios
  .get("http://localhost:8082/api/products/category-list")
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
