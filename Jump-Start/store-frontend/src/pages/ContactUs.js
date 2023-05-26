
import axios from "axios";
import { useState } from "react";
import Layout from "../components/layout/navigate";
const Contact = () => {
  const scriptURL = 'https://script.google.com/macros/s/AKfycbwt5nsuykQGoqthLEHAz4SI1ocV65DqFojt9iTC63C8OaUkUB1KC9XgclLa1HvFYXRd/exec'
  const [email, setEmail] = useState("");
  const [subject, setSubject] = useState("");
  const [message, setMessage] = useState("");
  const [postStatus, setPostStatus] = useState("");

  const onSubmitHandler = (e) => {
    e.preventDefault()
    const formData = new FormData();
    formData.append("email", email);
    formData.append("subject", subject);
    formData.append("message", message);

    axios
      .post(
        scriptURL, formData
      )
      .then((res) => {
        console.log(res.data);
        setPostStatus("SUCCESS")
      })
      .catch((err) => {
        console.log(err.message);
        setPostStatus("FAILED")
      });
  }
  return (
    <Layout>
      <div className="card border-0 shadow rounded-3 overflow-hidden my-4">
        <div className="card-body p-0">
          <div className="row gx-0">
            <div className="col-lg-6 col-xl-5">

              <div className="bg-light rounded-3 py-3">
                <div className="text-center mb-5">

                  <h1 className="fw-bolder ">Get in touch</h1>
                  <p className="lead fw-normal text-muted mb-0">We'd love to hear from you</p>
                </div>
                <div className="row justify-content-center">
                  <div className="col-md">
                    <form class="px-5" onSubmit={onSubmitHandler}>
                      {postStatus === "FAILED" && (
                        <div className="form-error text-center">Failed to send message</div>
                      )}
                      {postStatus === "SUCCESS" && (
                        <div className="form-success text-center">
                          Your message sended successfully!!
                        </div>
                      )}
                      <div className="form-floating mb-3">
                        <input
                          onChange={(e) => setEmail(e.target.value)}
                          value={email}
                          className="form-control"
                          id="name"
                          type="email"
                          placeholder="user@email.com" />
                        <label for="name">Email</label>
                      </div>
                      <div className="form-floating mb-3">
                        <input
                          className="form-control"
                          onChange={(e) => setSubject(e.target.value)}
                          value={subject}
                          id="name"
                          type="text"
                          placeholder="Message Subject" />
                        <label for="name">Subject</label>
                      </div>
                      <div className="form-floating mb-3">
                        <textarea
                          className="form-control"
                          onChange={(e) => setMessage(e.target.value)}
                          value={message}
                          id="message"
                          type="text"
                          placeholder="Enter your message here..."
                          style={{ height: "8rem" }}></textarea>
                        <label for="message">Message</label>
                      </div>
                      <div className="d-grid"><button class="btn btn-color mb-3 btn-lg" id="submitButton" type="submit">Submit</button></div>
                    </form>
                  </div>
                </div>
              </div>
            </div>
            <div className="col-lg-6 col-xl-7"><div className="bg-contact"></div></div>
          </div>
        </div>
      </div>

    </Layout>
  );
}

export default Contact;