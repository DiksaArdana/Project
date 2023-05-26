import { Link } from "react-router-dom";
import Footer from "./footer";
import Navbar from "./navbar";


const navigateAdmin = (props) => {
  return (
    <div className="main-container">
      <Navbar />
      <div className="row">
        <div className="col-2 nav-color">
          <ul className="nav flex-column ">
            <li className="nav-item ">
              <Link className="nav-link" to={"/dashboard-user"}>User Dashboard</Link>
            </li>
            <li className="nav-item">
              <Link className="nav-link" to={"/dashboard-product"}>Product Dashboard</Link>
            </li>
            <li className="nav-item">
              <Link className="nav-link" to={"/dashboard-category"}>Category Dashboard</Link>
            </li>
            <li className="nav-item">
              <Link className="nav-link" to={"/dashboard-order"}>Order Dashboard</Link>
            </li>
          </ul>
        </div>
        <div className="col-10">
          <div className="container">
            {props.children}
          </div>
        </div>
      </div>

      <Footer />
    </div>
  );
};

export default navigateAdmin;