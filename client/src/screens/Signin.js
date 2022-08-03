import axios from "axios";
import {  useEffect, useState } from "react"
import { useNavigate } from "react-router-dom";
import { ToastContainer,toast } from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';
import { NODE_API_ROUTE, SERVLET_API_ROUTE,headers } from "../util";

export default function Signin() {
    const [loginInfo, setData] = useState();
    const [loadData, setLoadData] = useState(false);
    const [userType, setUserType] = useState()
    const navigate = useNavigate();

    const handleLogin =   () => {
        axios({
            method: 'post',
            url: `${SERVLET_API_ROUTE}/Authenticate`,
            data: loginInfo,
            headers
            }).then(({data}) => {   
                console.log(data)                         
               if(data.toLowerCase().includes('invalid')){ 
                toast.error(data)
               } else {
                setLoadData(true)
                setUserType(data.toLowerCase())
               }
            }).catch( err => toast.error("Something went wrong"))
        
        

    }
    const fetchMedicalInfo = async () => {        
            const { data } = await axios.post(`${NODE_API_ROUTE}`, {userType})
            //setData(data)
            // if(data.includes('You are not authorized')){ 
            //     toast.success(data)
            // } else {
                navigate('/info', { state: data });
            //}
            
       
    }
    const handleChange =(e) => {
        setData({...loginInfo, [e.target.name]: e.target.value})
    }
    useEffect( ()=> {
        if(loadData){
            fetchMedicalInfo()
        }
    },[loadData])
    return (
        <div className="container">
        <div className="form_container">
            <div className="title">
                <h2>Login Form</h2>
                <ToastContainer />
            </div>
            <div className="forms">
		            <div className="grid-col-2">
                      <span><i className="fa fa-user"></i></span>
                       <input type="text" 
                       placeholder="Username" 
                       name="username" 
                       onChange={handleChange}/>
                    </div>
                   <div className="grid-col-2">
                        <span><i className="fa fa-lock"></i></span>
                        <input 
                         type="password"
                         placeholder="password" 
                        name="password" 
                        onChange={handleChange}/>
                     </div>
                             
                  <button className="btn" onClick={handleLogin}> Login </button>
           
                </div>
            </div>
        </div>
    )
}