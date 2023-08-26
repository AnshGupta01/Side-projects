import React from "react";
import { useNavigate } from "react-router-dom";

const Contact = () => {

    const navigate = useNavigate();


    const goToHome = () => {
        navigate("/");
    };

    return (
        <>
        <section>
            <h1>Contact</h1>
            <button onClick={goToHome}>Go to Home Page</button>
            {/* Code to go to the previous page (GO back Funcitonality) */}
            <button onClick={() => navigate(-1)}>GO BACK</button>
        </section>
        </>
        )
    }

export default Contact;    