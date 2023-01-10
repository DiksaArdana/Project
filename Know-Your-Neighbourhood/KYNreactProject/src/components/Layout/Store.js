
const Car = (props) => {
  return (
    <div className="container">
      <div className="my-4 row align-items-center justify-content-center">
        <div className="justi col-12 col-sm-8">
          <img className="img-fluid" alt={props.name} src="https://cdn-icons-png.flaticon.com/512/149/149071.png" />
        </div>
        <div className="car-description col-12 col-sm-4">
          <h4 className="fw-bold">
            {props.name} 
          </h4>
          <p className="text-secondary m-0">Phone Number:</p>
          <p className="text-black fs-5">{props.phone}</p>
          <p className="text-secondary m-0">Localities:</p>
          <p className="text-black fs-5">{props.localities}</p>
        </div>
      </div>
    </div>
  );
};

export default Car;