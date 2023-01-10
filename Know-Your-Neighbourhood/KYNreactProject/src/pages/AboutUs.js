import React from "react";
import Layout from "../components/Layout/Layout";
import Banner from "../img/picture-1920-1080.jpg";
import { BiCalendarStar,BiHistory } from "react-icons/bi";
const AboutUs = () => {
    return (
        <Layout>
            <div className="p-5" style={{ backgroundImage: `url(${Banner})`, backgroundSize: "cover", minHeight: "480px" }}>
                <div className="row col-6 bg-light" style={{ opacity: "0.8" }}>
                    <h1 class="display-5 fw-bold">Get to Know Your Neighbors</h1>
                    <p class="col-md-8 fs-4">
                        Families across Denpasar neighborhoods share their hopes and aspirations. Discover their stories and perspectives on how systems in our city provide opportunities—and sometimes how those systems create obstacles.
                    </p>
                </div>
            </div>
            <div className="container px-5 my-5">
                <div className="row gx-5 justify-content-center">
                    <div className="col-lg-6">
                        <div className="text-center mb-5">
                           <h2> <BiHistory/></h2>
                            <h1 className="fw-bolder">Stories</h1>
                            <p className="lead fw-normal text-muted mb-0">Know your neighbors from their perspective. Stories about people and families across Denpasar neighborhoods.</p>
                        </div>
                    </div>
                    <div className="col-lg-6">
                        <div className="text-center mb-5">
                        <h2><BiCalendarStar /></h2>
                            <h1 className="fw-bolder">Event</h1>
                            <p className="lead fw-normal text-muted mb-0">Connect with your neighbors and get to know them. The city to hold events and experiences introducing you to new people and places. Join us at an upcoming event!</p>
                        </div>
                    </div>
                </div>
            </div>
        </Layout>
    )
}
export default AboutUs;
