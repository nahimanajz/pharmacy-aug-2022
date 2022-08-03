import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { ToastContainer,toast } from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';

import { SERVLET_API_ROUTE, headers } from "../util";

export function Signup() {
  const [signupInfo, setData] = useState();
  const navigate = useNavigate()
  const handleChange =(e) => {
    setData({...signupInfo, [e.target.name]: e.target.value})
}
const handleSignup =() => {
    axios({
    method: 'post',
    url: `${SERVLET_API_ROUTE}/Signup`,
    data: signupInfo,
    headers
    }).then(({data}) => {
      toast(data)
      if(data.includes("successfully")){
        navigate('/login')
      }
    }).catch(err=> console.log(err))
}
  return (
    <div className="container">
      <div className="title">
        <h2>Responsive Registration Form</h2>
        <ToastContainer />
      </div>
      <div>
        <div className="grid">
          <div className="grid-col-2">
            <span>
              {" "}
              <i aria-hidden="true" className="fa fa-user"></i>{" "}
            </span>
            <input
              type="text"
              name="fname"
              required
              placeholder="First Name"
              className="md"              
              style={{with: 100}}
              onChange={handleChange}
            />
          </div>
          <div className="grid-col-2 ml">
            <span>
              {" "}
              <i aria-hidden="true" className="fa fa-user"></i>{" "}
            </span>
            <input
              type="text"
              name="lname"
              required
              placeholder="Last Name"
              className="md"            
              onChange={handleChange}

            />
          </div>
        </div>
        <div className="grid-col-2">
          <span>
            <i className="fa fa-user"></i>
          </span>
          <input type="text" placeholder="Username" name="username"  onChange={handleChange}/>
        </div>
        <div className="grid-col-2">
          <span>
            <i className="fa fa-user"></i>
          </span>
          <input type="number" 
            placeholder="age"
            name="age" 
            onChange={(e)=> setData({...signupInfo, [e.target.name]: parseInt(e.target.value)})}
            required   />
        </div>
        <div className="grid-col-2">
          <span>
            <i aria-hidden="true" className="fa fa-mobile "></i>
          </span>
          <input
            type="number"
            placeholder="phone Number"
            name="phoneNumber"
            onChange={handleChange}          
          />
        </div>
        <div className="grid-col-2">
          <span>
            <i aria-hidden="true" className="fa fa-lock"></i>
          </span>
          <input
            type="password"
            id="usr_password"
            placeholder="password"
            name="password"
            onChange={(e)=> setData({...signupInfo, [e.target.name]: parseInt(e.target.value)})}
          />
        </div>

        <div className="grid-col-2">
          <span>
            <i aria-hidden="true" className="fa fa-lock"></i>
          </span>
          <input
            type="password"
            name="retype_password"         
            placeholder="Re-type Password"                        
            onChange={(e)=> setData({...signupInfo, [e.target.name]: parseInt(e.target.value)})}
          />
        </div>
        <div className="input-container mt">
          <input type="radio" name="gender" value="male" id="male" 
              onChange={handleChange}
          />{" "}
          <label htmlFor="male">Male</label>
          <input type="radio" name="gender" value="female" id="female" 
            onChange={handleChange}
          
          />{" "}
          <label htmlFor="female">Female</label>
        </div>
        <div className="input-container">
          <select name="usertype" onChange={handleChange}>
            <option>Select User Type</option>
            <option value="admin">Admin</option>

            <option value="Patient">Patient</option>
            <option value="Physician">Physician</option>
            <option value="pharmacist">Pharmacist</option>
          </select>
        </div>
 
          <div className="checks" style={{marginLeft: -155, position: 'relative'}}>
            <input type="checkbox"/>
            <label htmlFor="terms"> I agree with terms and conditions</label> <br />
            <input type="checkbox" id="newsletter" className="mleft" />
            <label htmlFor="newsletter"> I want to receive newsletter </label>
          </div>
      
        
        <div>
          <button className="btn" onClick={handleSignup}> Register </button>
    
        </div>
      </div>
    </div>
  );
}
