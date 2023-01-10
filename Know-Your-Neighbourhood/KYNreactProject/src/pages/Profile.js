import { useContext } from "react";
import AuthContext from "../context/AuthContext";
import "../App.css";
import Layout from "../components/Layout/Layout";

const userImage =
  "https://scontent.fdps5-1.fna.fbcdn.net/v/t1.30497-1/84628273_176159830277856_972693363922829312_n.jpg?stp=c94.0.320.320a_dst-jpg_p320x320&_nc_cat=1&ccb=1-7&_nc_sid=12b3be&_nc_ohc=UmZNJ3g2P7wAX825NN5&_nc_ht=scontent.fdps5-1.fna&edm=AP4hL3IEAAAA&oh=00_AfDllgfXZJncqvVi8QbcTByKeVtQKqdyTiUW8XzahsQqCg&oe=63CE5099";

const Profile = () => {
  const authCtx = useContext(AuthContext);

  return (
    <Layout>
      <div className="d-flex justify-content-center align-items-center my-5 py-5">
        <div className="profile">
          <div className="profile-picture">
            <img src={userImage} alt="User" />
          </div>
          <h2 className="text-center mt-3 fw-semibold">{authCtx.name}</h2>
        </div>
      </div>
    </Layout>
  );
};

export default Profile;