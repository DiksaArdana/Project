import { useRef } from "react";
import { BsSearch } from "react-icons/bs";
import { useNavigate } from "react-router-dom";
import "./AuthForm.css";

const SearchForm = () => {
  const navigate = useNavigate();
  const inputKeywordRef = useRef();

  const onSubmitHandler = (e) => {
    e.preventDefault();
    const keywordValue = inputKeywordRef.current.value;
    navigate(`/products?keyword=${keywordValue}`);
    inputKeywordRef.current.value = "";
  };

  return (
    <form id="searchForm" className="d-flex" onSubmit={onSubmitHandler}>
      <input
        ref={inputKeywordRef}
        className="form-control me-3"
        type="text"
        name="keyword"
        placeholder="Search by product name"
      />
      <button type="submit" className="btn btn-outline-primary">
        <BsSearch />
      </button>
    </form>
  );
};

export default SearchForm;