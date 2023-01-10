import {BsFacebook, BsInstagram, BsTwitter} from "react-icons/bs"
const Footer = ()=>{
    return(
<footer className="footer mt-auto bg-dark p-3">
    <div className="d-flex mb-3">
      <div className="text-light fa-4">© Know Your Neighbour Pte Ltd. 2023 All rights reserved.</div>
      <div className="ms-auto text-light fs-5"> 
        <ul className="list-group list-group-horizontal-md bg-dark">
          <li className="list-group-item bg-dark "><a href="instagram.com" className="text-light" target="_blank"><BsInstagram/> kyn_org</a></li>
          <li className="list-group-item bg-dark "><a href="facebook.com" className="text-light " target="_blank"><BsFacebook/> kyn_org</a></li>
          <li className="list-group-item bg-dark "><a href="twitter.com" className="text-light" target="_blank"><BsTwitter/> kyn_org</a></li>
        </ul>
      </div>
    </div>
</footer>

    );
};
export default Footer;