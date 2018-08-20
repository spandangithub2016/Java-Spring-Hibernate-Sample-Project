<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Try1.css">

<title>Student Management System</title>
</head>
<body>
    
    <div id="header"><h1 style="font-size: 40px; padding-left: 230px; ">Student Management System</h1></div>
    <center>
    <br><br><br><br>   
        
        <div id="set">
            <div id="set2">
                <h2><marquee direction=RIGHT>Update Details</marquee></h2>
            </div>
            <br>
            <form name="ContactForm"  action="UpdateServlet" method="POST">
            
                
                <label>Full Name</label>
                <input type="text" id="fullname" name="fullname" value="${fullname}"><br>

                <label>User Name</label>
                <input type="text" id="username" name="username" value="${username}" readonly="readonly"><br>
                
                <label>Password</label>
                <input type="text" id="password" name="password" value="${password}"><br>
                
                <label>Adress</label>
                <input type="text" id="address" name="address" value="${address}"><br> 
 
                <label>Date Of Birth (dd/mm/yy)</label>
                <input type="Date" id="dob" name="dob" value="${dob}"><br><br>

                <label>Gender</label>
                <select name="gender" >
                    <option>--Select--</option>
                    <option id="male" value="Male">Male</option>
                    <option id="female" value="Female">Female</option>
                </select>
                
                <label>Email</label>
                <input type="text" id="email" name="email" value="${email}"><br>

                <label>Contact</label>
                <input type="text" id="phone" name="phone" value="${contact}"><br>

                <br><br>

                <input id="sub" type="submit" value="Update" >
                <input id="sub1" type="reset" value="Reset"><br>
                <br><br>
            </form>
        </div>
    </center>
</body>
</html>