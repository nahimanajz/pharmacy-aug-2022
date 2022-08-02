// TODO: verify user type From client
export const isUserAuthenicated = (req, res, next) => {
    const userType = req.body.userType
    userType.toLowerCase() 
    if(userType == 'admin' || userType == 'patient' || userType == 'pharmacist' || userType == 'physician'){
       next()
    }
    else{
        // usertype is not valid
        return res.status(403).send(`${userType} is not authorized`)
    }
   

    }