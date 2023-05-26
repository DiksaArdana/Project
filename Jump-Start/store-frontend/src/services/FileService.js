import axios from "axios";

// DOWNLOAD FILE
export const getDownloadFileAPI = async (fileName) => {
    return await axios.get(`http://localhost:8082/file/downloadFile/${fileName}`, {
      fileName,
    });
  };
  
  // UPLOAD FILE
  export const postUploadFileAPI = async (fileName) => {
    return await axios.post(`http://localhost:8082/file/uploadFile`, {
      fileName,
    });
  };
  
  // UPLOAD MULTIPLE FILES
  export const postMultipleUploadFilesAPI = async (fileName) => {
    return await axios.post(`http://localhost:8082/file/uploadMultipleFiles`, {
      fileName,
    });
  };