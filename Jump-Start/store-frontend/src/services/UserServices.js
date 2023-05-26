import axios from "axios";

export function getUserDetail(id,callback, errorCallback){
  axios
  .get(`http://localhost:8082/api/admin/profile/${id}`)
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
export function getListUser(callback, errorCallback){
    axios
    .get("http://localhost:8082/api/admin/user-list")
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
export function getListRider(callback, errorCallback){
  axios
  .get("http://localhost:8082/api/admin/rider-list")
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
export function getChartUser(id,callback, errorCallback){
  axios
  .get(`http://localhost:8082/api/chart/my-chart/${id}`)
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