
import { Navigate, Route, Routes } from 'react-router-dom';
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle"
import "./components/layout/_myStyle.css"
import Home from './pages/Home';
import About from './pages/About';
import Contact from './pages/ContactUs';
import TermsCondition from './pages/TermsCondition';
import ProductList from './pages/ProductList';
import Product from './pages/Product';
import Chart from './pages/Chart';
import Register from './pages/Register';
import Login from './pages/Login';
import Profile from './pages/Profile';
import AdminDasboard from './pages/AdminDashboard';
import ProductDasboard from './pages/AdminDashboardProduct';
import OAuth2RedirectHandler from './services/OAuth2/OAuth2RedirectHandler';
import CategoryDasboard from './pages/AdminDashboardCategory';
import EditProductForm from './components/form/ProductEdit';
import OrderDasboard from './pages/AdminDashboardOrder';
import RiderDasboard from './pages/RiderDashboardDelivery';
import EditProfileForm from './components/form/UserEdit';
import { useContext } from 'react';
import AuthContext from './services/AuthContext';

function App() {
  const authUser = useContext(AuthContext);
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/about-us" element={<About />} />
      <Route path="/contact" element={<Contact />} />
      <Route path="/terms" element={<TermsCondition />} />
      <Route path="/products" element={<ProductList />} />
      <Route path="/product/:name/:pid" element={<Product />} />
      {!authUser.isLoggedIn && (
        <>
          <Route path="/signup" element={<Register />} />
          <Route path="/login" element={<Login />} />
        </>)}
      {authUser.isLoggedIn && (<>
        <Route path="/profile" element={<Profile />} />
        <Route path="/edit-profile" element={<EditProfileForm />} />
      </>)}
      <Route path="/mychart" element={authUser.role === "user" ? <Chart /> : <Navigate to={"/login"} />} />
      {authUser.role === "admin" && (<>
        <Route path="/dashboard-user" element={<AdminDasboard />} />
        <Route path="/dashboard-product" element={<ProductDasboard />} />
        <Route path="/edit-product/:pid" element={<EditProductForm />} />
        <Route path="/dashboard-category" element={<CategoryDasboard />} />
        <Route path="/dashboard-order" element={<OrderDasboard />} />
      </>)}
      <Route path="/dashboard-delivery" element={authUser.role === "rider" ? <RiderDasboard /> : <Navigate to={"/login"} />} />

      <Route path="/oauth2/redirect" element={<OAuth2RedirectHandler />} />
      <Route path="*" element={<Navigate to="/" replace />} />
    </Routes>
  );
}

export default App;
