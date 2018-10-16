<style>
    form.nav {
    display: inline;
}
</style>
<h4>username : <% out.print(session.getAttribute("username"));%><h4>
<a href="createAccount.jsp">Create An Account</a>
<a href="login.jsp">Login</a>
<a href="home.jsp">Home</a>
<a href="bookstore.jsp">Book store</a>
<a href="cart.jsp">My Cart</a>
<form method="post" action="CustomerOrderHistory.do" class="nav">
<input type="submit" value="Order History" align="right" />
</form>
<form method="post" action="LogOut.do" class="nav">
<input type="submit" value="LogOut" align="right" />
</form>

<br>
<br>
