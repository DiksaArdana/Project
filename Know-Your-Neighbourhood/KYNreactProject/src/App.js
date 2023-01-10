import Home from "./pages/Home";
import { Navigate, Route, Routes } from "react-router-dom";
import Login from "./pages/Login";
import Register from "./pages/Register";
import PostCar from "./pages/StoreAdd";

import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle"
import { useContext } from "react";
import AuthContext from "./context/AuthContext";
import OAuth2RedirectHandler from "./components/Auth/OAuth2/OAuth2RedirectHandler";
import Profile from "./pages/Profile";
import CarList from "./pages/StoreList";
import CarDetail from "./pages/StoreDetail";
import AboutUs from "./pages/AboutUs";
import ContactUs from "./pages/ContactUs";
import Terms from "./pages/Terms";

function App() {
  const authUser = useContext(AuthContext);
  return (
    

    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/about" element={<AboutUs />} />
      <Route path="/contact" element={<ContactUs />} />
      <Route path="/terms" element={<Terms />} />
      <Route path="/stores/:name/:phone/:localities/:storeId" element={<CarDetail />} />
      {!authUser.isLoggedIn && (
        <>
          <Route path="/login" element={<Login />} />
          <Route path="/signup" element={<Register />} />
        </>
      )}
      <Route
        path="/post-store"
        element={authUser.isLoggedIn ? <PostCar /> : <Navigate to="/login" />}
      />
      <Route
        path="/stores"
        element={authUser.isLoggedIn ? <CarList /> : <Navigate to="/login" />}
      />
      <Route path="/oauth2/redirect" element={<OAuth2RedirectHandler />} />
      <Route
        path="/profile"
        element={authUser.isLoggedIn ? <Profile /> : <Navigate to="/login" />}
      />
      <Route path="*" element={<Navigate to="/" replace />} />
    </Routes>

  );
}

export default App;

