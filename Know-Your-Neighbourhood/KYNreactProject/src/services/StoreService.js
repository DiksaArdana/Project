import axios from "axios";

// GET List Car
export function getListStore(callback, errorCallback) {
  axios
    .get("http://localhost:8082/api/store/store-list")
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

// GET Car Detail
export function getStoreDetail(id, callback, errorCallback) {
  axios
    .get(`http://localhost:8082/api/store/store-detail?sid=${id}`)
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

// GET Search By Keyword
export function getSearchByKeyword(keyword, callback, errorCallback) {
  axios
    .get(`http://localhost:8082/api/store/search?keyword=${keyword}`)
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

