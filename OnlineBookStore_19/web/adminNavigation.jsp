<style>
    form.nav {
    display: inline;
}
</style>
<h4>Admin username : <% out.print(session.getAttribute("username"));%><h4>
<a href="bookstore.jsp"> Book Store</a>
<a href="addBook.jsp">Add Book</a>
<a href="addCategory.jsp">Add Category</a>
<a href="addAuthor.jsp">Add Author</a>
<a href="addPublisher.jsp">Add Publisher</a>
<a href="addDelivaryMan.jsp">Add Delivary Man</a>
<a href="adminViewOrders.jsp">View Orders</a>
<form method="post" action="AdminViewDeliveryMan.do" class="nav">
<input type="submit" value="View Delivery Men" align="right" />
</form>
<br>
<br>
<br>