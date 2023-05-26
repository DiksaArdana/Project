import Layout from "../components/layout/navigate";
import Logo from "../components/img/Jumpstart-logo.png"
const About = () => {
    return (
        <Layout>
            <section className="py-5">
                <div className="container px-5 my-5">
                    <div className="row gx-5 align-items-center">
                        <div className="col-lg-6 order-first order-lg-last"><img className="img-fluid rounded mb-5 mb-lg-0" src={Logo} alt="..." /></div>
                        <div className="col-lg-6">
                            <h2 className="fw-bolder">Jumpstart</h2>
                            <p className="lead fw-normal text-muted mb-0">
                                Jumpstart is an online retail store, one of Jumpstart's innovations in the form of a one stop online store that provides a wide range of products on one site to meet all consumer needs.
                                <br/>
                                Jumpstart provides thousands of complete product choices at the best prices for all needs. A variety of selected products and promotions are here for you, ranging from daily needs such as groceries, food, drinks, fashion products, baby and children's clothing needs, health beauty products, gadget products & household electronic equipment, hobby needs, and various other products .
                            </p>
                        </div>
                    </div>
                </div>
            </section>
            <section className="py-5 bg-light" >
                <div className="container px-5 my-5">
                    <div className="row gx-5 align-items-center">
                        <div className="col-lg-6"><img className="img-fluid rounded mb-5 mb-lg-0" src="https://images.unsplash.com/photo-1563013544-824ae1b704d3?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80" alt="..." /></div>
                        <div className="col-lg-6">
                            <h2 className="fw-bolder">Save &amp; Easy Transaction</h2>
                            <p className="lead fw-normal text-muted mb-0">
                            Convenience and security in online transactions is our added value to you as a Jumpstart online shopping site. You can choose various payment methods, such as transfers between ATMs, paying on the spot or Cash On Delivery / COD, internet banking, electronic money payments, virtual payment points, ATMs Transfers, up to credit card payments (Visa, Master Card) from our Bank partners.
                            </p>
                        </div>
                    </div>
                </div>
            </section>
        </Layout>
    );
}

export default About;