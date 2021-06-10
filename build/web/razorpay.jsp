<%-- 
    Document   : razorpay
    Created on : 24 May, 2021, 10:55:05 PM
    Author     : aksha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Security Amount</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://checkout.razorpay.com/v1/checkout.js"></script>
        <link rel="stylesheet" href="style.css">
        <style>
            button{
                color:#3bb78f;
            }
            input[type="submit"] {
/*    appearance: auto;
    user-select: none;
    white-space: pre;
    align-items: flex-start;
    text-align: center;
    cursor: default;
    color: -internal-light-dark(black, white);
    background-color:#3bb78f;
    box-sizing: border-box;
    padding: 1px 6px;
    border-width: 2px;
    border-style: outset;
    border-color: -internal-light-dark(rgb(118, 118, 118), rgb(133, 133, 133));
    border-image: initial;*/
 color: #fff;
    border: 2px;
    border-radius: 5%;
    padding-left: 0;
    margin: auto auto;
    padding: auto auto;
    font-size: 20px;
    font-weight: 500;
    cursor: pointer;
    background-color: #3bb78f;
background-image: linear-gradient(315deg, #3bb78f 0%, #0bab64 74%);
  align-items: center;
  text-align: center;  

}
</style>
    </head>
    <body>
        <div class="wrapper">

            <div style="text-align: center;" class="title">Security Amount</div>
            <center>
                <br><form action="customer_register.html" method="POST">
            <script src="https://checkout.razorpay.com/v1/checkout.js" 
            data-key="rzp_test_PailUJuF9kx8sf"
            data-amount="50000"    
            data-currency="INR" 
            data-buttontext=" Pay Now "
            data-name="Farmer's E-Helper"    
            data-description=""    
            data-image="https://thumbs.dreamstime.com/b/indian-farmer-cartoon-character-vector-ceremony-cleaned-clipart-consume-dance-dancer-day-dip-dress-each-early-eventually-excellent-164417070.jpg"    
            data-prefill.name=""    
            data-prefill.email=""    
            data-theme.color="#F37254">
        </script>
        <input type="hidden" custom="Hidden Element" name="hidden"></form></center>
        </div>

        
            
            
    </body>
</html>
