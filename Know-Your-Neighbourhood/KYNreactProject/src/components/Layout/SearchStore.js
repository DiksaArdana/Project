import { useRef } from "react";
import { useNavigate } from "react-router-dom";

const SearchStore = () => {
  const navigate = useNavigate();
  const inputKeywordRef = useRef();

  const onSubmitHandler = (e) => {
    e.preventDefault();
    const keywordValue = inputKeywordRef.current.value;

    navigate(`/stores?keyword=${keywordValue}`);
    inputKeywordRef.current.value = "";
  };

  return (
    <form id="searchForm" className="d-flex" onSubmit={onSubmitHandler}>
      <input
        ref={inputKeywordRef}
        className="form-control"
        type="text"
        name="keyword"
        required
        placeholder="Search by Name,Phone, or Localities"
      />
      <button type="submit" className="btn btn-outline-success">
        Search
      </button>
    </form>
  );
};

export default SearchStore;