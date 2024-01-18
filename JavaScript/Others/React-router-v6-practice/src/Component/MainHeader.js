import { Outlet } from "react-router-dom";
import Header from "./Header";

const MainHeader = () => {
    return (
    <>
    <Header/>
    {/* <section>
        <h1>Home</h1>
    </section> */}
    <Outlet/>    
    </>
    )
}

export default MainHeader;