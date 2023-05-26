import Footer from "./footer";
import Navbar from "./navbar";


const navigate = (props) => {
  return (
    <div className="main-container">
      <Navbar />
      <div className="container">
        {props.children}
      </div>
      <Footer/>
    </div>
  );
};

export default navigate;