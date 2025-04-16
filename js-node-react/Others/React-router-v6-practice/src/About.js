import { useNavigate } from "react-router-dom";

const About = () => {

    const navigate = useNavigate();

    const goToContact = () => {
        navigate("/contact");
    };

    return (
        <>
        <section>
            <h1>About</h1>
            <button onClick={() => goToContact()}>Go to contact Page</button>
            {/* Code to go to the previous page (GO back Funcitonality) */}
            <button onClick={() => navigate(-1)}>GO BACK</button>
        </section>
        
        
        </>
        )
    }

export default About;   