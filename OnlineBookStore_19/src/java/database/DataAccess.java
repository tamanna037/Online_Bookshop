/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;


import Interfaces.SharedConstants;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AddByAdmin;
import model.CartItem;
import model.DelivaryMan;
import model.OrderDetails;
import model.OrderSummary;
import model.ShownBookData;

/**
 *
 * @author DELL
 */
public class DataAccess implements SharedConstants{
     String dbURL = "jdbc:oracle:thin:@localhost:1521:ORCL";
    String username = "bookstore";
    String password = "bookstore";

    Connection conn = null;
    public DataAccess()
    {
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(dbURL, username, password);
            if(conn!=null) System.out.println("Connection successfully established.");
            else System.out.println("Could not establish connection");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public String createAccount(String firstName, String lastName, String username, String password,
            String email,String address,String thana,String zilla,String postalCode,String contactno) {
        try
        {
           CallableStatement cstmt = conn.prepareCall("{? = call createAccount(?,?,?,?,?,?,?,?,?,?)}");
            cstmt.registerOutParameter(1, java.sql.Types.VARCHAR);
            cstmt.setString(2, firstName);
            cstmt.setString(3, lastName);
            cstmt.setString(4, username);
            cstmt.setString(5, password);
            cstmt.setString(6, email);
            cstmt.setString(7, address);
            cstmt.setString(8, thana);
            cstmt.setString(9, zilla);
            cstmt.setString(10, postalCode);
            cstmt.setString(11, contactno);
            
            Boolean check = cstmt.execute();
            return cstmt.getString(1);
        }
        catch(SQLException e){
            e.printStackTrace();
            return e.getMessage();
            }
        }
    
    public String existUser(String username, String password) {
        try
        {
            String uType=null;
            String query = "select userType from accountuser where username = ? and password = ? ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
            {
                uType=rs.getString("userType");
                return uType;
            }
            return INVALID_USERNAME;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return unknown_error;
        }
    }
   
    public ArrayList<ShownBookData> getShownBookData() {
        ArrayList<ShownBookData> arrayList =new ArrayList<>();
        try{
        PreparedStatement stmt=conn.prepareStatement("select * from FullBookList");
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            ShownBookData book = new ShownBookData(rs.getString("bookid"),rs.getString("booktitle"),
                    rs.getString("author"),rs.getString("Publication"),rs.getString("category"),
                    rs.getString("subCategory"),rs.getInt("price"),
                    rs.getString("isbn"),rs.getInt("PublishedYear"),rs.getString("edition"),rs.getString("language"),
                    rs.getInt("pages"),rs.getString("description"),rs.getInt("discount"));
            
            if(rs.getInt("quantity")==0)book.setAvailability("no");else book.setAvailability("yes");
            
            arrayList.add(book);
            System.out.println(book);
        }
        rs.close();
        stmt.close();
        return arrayList;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return arrayList;
        
    }
    
    public ArrayList<OrderDetails> getCustomerOrderHistory(String username)
    {
         
        ArrayList<OrderDetails> orderList = new ArrayList<OrderDetails>();
        
        try {
            PreparedStatement ps = conn.prepareStatement("select bo.* \n" +
                                                        ",(select thananame from thana t where t.THANAID = BO.THANAID) as THANA\n" +
                                                        ",(select district from thana t where t.THANAID = BO.THANAID) as district\n" +
                                                        "from bookorder bo\n" +
                                                        "where BO.CUSTOMERID = ?"+
                                                        "order by bo.dateofbookorder desc"
                                                        );
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String orderId = rs.getString("orderId");
                ps = conn.prepareStatement( "select od.* \n" +
                                            ",(select BOOKTITLE from book b where b.BOOKID = od.bookid) as title\n" +
                                            ",findAuthorName(OD.bookid)as author\n" +
                                            "from ORDERDETAILS od\n" +
                                            "where OD.ORDERID = ?\n" 
                                            );
                ps.setString(1, orderId);
                ResultSet rs1 = ps.executeQuery();
                ArrayList<CartItem> itemList = new ArrayList<CartItem>();
                while(rs1.next()){
                    System.out.print(rs1.getString("title"));
                    CartItem item = new CartItem(rs1.getString("bookid"),rs1.getString("title"),rs1.getString("author")
                                    ,rs1.getInt("quantity"),rs1.getInt("buyingprice"));
                    itemList.add(item);
                }
                OrderDetails od = new OrderDetails(itemList,rs.getString("orderid"),rs.getDate("dateOfBookOrder"),
                                rs.getInt("totalprice"),rs.getString("address"),rs.getString("thana"),
                                rs.getString("district"),rs.getString("delivaryStatus"),rs.getString("paymentstatus"));
                orderList.add(od);
            }
            return orderList;
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return null;
    }

    public String insertOrder(ArrayList<CartItem> cart, String username, String[] address) {
        try{
        
        String sql =" DECLARE\n" +
                    "       bookIdList bop.id_type;\n" +
                    "       quantityList bop.q_type;\n" +
                    "    BEGIN\n";
        int length= cart.size();
        for(int i=0;i<length;i++){
            CartItem book = cart.get(i);
            sql +=  "       bookIdList("+(i+1)+") := '"+book.getId()+"';\n";
            sql +=  "       quantityList("+(i+1)+") := "+book.getQuantity()+";\n";   
        }
        sql +=      "      bop.insert_order(bookIdList,?,quantityList,50,?,?,?,?);\n" +
                    "    END;";
        System.out.println(sql);
        CallableStatement cs = conn.prepareCall(sql);
        cs.setString(1,username);
        cs.setString(2,address[0] );
        cs.setString(3, address[1]);
        cs.setString(4, address[2]);
        cs.registerOutParameter(5, java.sql.Types.VARCHAR);
        cs.execute();
        String orderId = cs.getString(5);
        System.out.print("orderID "+orderId);
        return order_successful;

        }catch(SQLException e){
            if(e.getErrorCode()==20001||e.getErrorCode()==20002||e.getErrorCode()==20003)
                return e.getMessage();
            else {
                e.printStackTrace();
                return unknown_error;
            }
            
            
        }
    }
    
    public boolean isAdmin(String username)
    {
        try {
            PreparedStatement ps = conn.prepareStatement("select userType from accountuser where username=?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                System.out.println("is admin : "+rs.getString("userType"));
                if((rs.getString("userType")).equalsIgnoreCase("a"))
                    return true;
            }
           
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
         return false;
    }

    public String insertDelivaryMan(String first,String last, String email,String contact,
                                    String address, String thana,String zilla, String admin)
    {
         try {
             System.out.println(contact+admin);
             CallableStatement cs = conn.prepareCall("{? = call insertDelivaryMan(?,?,?,?,?,?,?,?)}");
             cs.registerOutParameter(1, java.sql.Types.VARCHAR);
             cs.setString(2, first);
             cs.setString(3, last);
             cs.setString(4, email);
             cs.setString(5, contact);
             cs.setString(6, address);
             cs.setString(7, thana);
             cs.setString(8, zilla);
             cs.setString(9, admin);
             System.out.println("gsdf");
             
             cs.execute();
             String dmId = cs.getString(1);
             System.out.print("dmID: " +dmId);
             return dm_inserted+" dm_id: "+dmId;
         } catch (SQLException ex) {
             int err = ex.getErrorCode();
             if(err==00001){
                 return "email must be unique";
             }else if(err==20001||err==20002||err==20003){
                 return ex.getMessage();
             }/*else if(err==20004){
                 return "This action can be done by admin only ";
             }*/
             Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
             return ex.getMessage();
         }
        
    }
    
    public ArrayList<OrderSummary> getOrderSummary(String orderListType){
        try{
            //String sql;
            PreparedStatement ps=null;
            if(orderListType.equals("full")){

                ps = conn.prepareStatement("select bo.* \n" +
                                            ",(select thananame from thana t where t.THANAID = BO.THANAID) as THANA\n" +
                                            ",(select district from thana t where t.THANAID = BO.THANAID) as district\n" +
                        ",(select (firstname||' '||lastname||'('||DELIVARYMANID||')') from DELIVARYMAN d where d.DELIVARYMANID = BO.DELIVARYMANID) as dm"+
                                            " from bookorder bo\n" +
                                            " order by bo.dateofbookorder desc");
            }else{

                ps = conn.prepareStatement("select bo.* \n" +
                                            ",(select thananame from thana t where t.THANAID = BO.THANAID) as THANA\n" +
                                            ",(select district from thana t where t.THANAID = BO.THANAID) as district\n" +
                        ",(select (firstname||' '||lastname||'('||DELIVARYMANID||')') from DELIVARYMAN d where d.DELIVARYMANID = BO.DELIVARYMANID) as dm"+
                                            " from bookorder bo\n" +
                                            " where delivarystatus = ? "+
                                            " order by bo.dateofbookorder desc");
                ps.setString(1, orderListType);
            }
            ResultSet rs = ps.executeQuery();
            ArrayList<OrderSummary> arr = new ArrayList<OrderSummary>();
            while(rs.next()){
             
                OrderSummary os = new OrderSummary(rs.getString("orderid"),rs.getString("customerid"),rs.getInt("totalPrice"),
                        rs.getString("address"),rs.getString("thanaid"),rs.getString("thana"),rs.getString("district"),rs.getDate("dateOfBookOrder"),
                        rs.getString("paymentStatus"),rs.getString("delivaryStatus"),rs.getString("dm"),
                        rs.getString("delivarymanId"),rs.getString("adminid"));
                arr.add(os);
                System.out.println(os);
            }
            return arr;

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public OrderDetails getViewOrderDetails(String orderId){
        try{
            PreparedStatement ps = conn.prepareStatement("select bo.* \n" +
                                                        ",(select thananame from thana t where t.THANAID = BO.THANAID) as THANA\n" +
                                                        ",(select district from thana t where t.THANAID = BO.THANAID) as district\n" +
                                                        "from bookorder bo\n" +
                                                        "where BO.orderid = ?"+
                                                        "order by bo.dateofbookorder desc"
                                                        );
            ps.setString(1, orderId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                ps = conn.prepareStatement( "select od.* \n" +
                                            ",(select BOOKTITLE from book b where b.BOOKID = od.bookid) as title\n" +
                                            ",findAuthorName(OD.bookid)as author\n" +
                                            "from ORDERDETAILS od\n" +
                                            "where OD.ORDERID = ?\n" 
                                            );
                ps.setString(1, orderId);
                ResultSet rs1 = ps.executeQuery();
                ArrayList<CartItem> itemList = new ArrayList<CartItem>();
                while(rs1.next()){
                    System.out.print(rs1.getString("title"));
                    CartItem item = new CartItem(rs1.getString("bookid"),rs1.getString("title"),rs1.getString("author")
                                    ,rs1.getInt("quantity"),rs1.getInt("buyingprice"));
                    itemList.add(item);
                }
                OrderDetails od = new OrderDetails(itemList,rs.getString("orderid"),rs.getDate("dateOfBookOrder"),
                                rs.getInt("totalprice"),rs.getString("address"),rs.getString("thana"),
                                rs.getString("district"),rs.getString("delivaryStatus"),rs.getString("paymentstatus"));
                return od;
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<DelivaryMan> getDelivaryManList(String thanaId){
        try{
            PreparedStatement ps = conn.prepareStatement("select dm.*, (DM.FIRSTNAME||' '||DM.LASTNAME) as name \n" +
                                                        ", findDMContactNo(dm.delivarymanid) as contact\n" +
                                                        ", findDMWorkArea (DM.delivarymanid) as area \n"+
                                                        ", (select count(*) from BOOKORDER Bo \n" +
                                                        "where BO.DELIVARYMANID = DM.delivarymanid\n" +
                                                        "and DELIVARYSTATUS = 'working') as working\n" +
                                                        ", (select count(*) from BOOKORDER Bo \n" +
                                                        "where BO.DELIVARYMANID = DM.delivarymanid\n" +
                                                        "and DELIVARYSTATUS = 'completed') as completed\n" +
                                                        "from DELIVARYMAN dm " + " JOIN DELIVERSIN di\n" +
                                                        "on dm.DELIVARYMANId = di.delivarymanid\n"+
                                                        "where di.AREAID = ?");
            ps.setString(1, thanaId);
            ResultSet rs = ps.executeQuery();
            ArrayList<DelivaryMan> dmList = new ArrayList<DelivaryMan>();
            while(rs.next()){
                 DelivaryMan dm = new DelivaryMan(rs.getString("delivarymanid"),rs.getString("name"),rs.getString("contact")
                         ,rs.getString("area"),rs.getInt("working"),rs.getInt("completed"));
                 dmList.add(dm);
                 System.out.println(dm);
            }
            return dmList;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<DelivaryMan> getDelivaryManList(){
        try{
            PreparedStatement ps = conn.prepareStatement("select dm.*, (DM.FIRSTNAME||' '||DM.LASTNAME) as name \n" +
                                                        ", findDMContactNo(dm.delivarymanid) as contact\n" +
                                                        ", findDMWorkArea (DM.delivarymanid) as area \n"+
                                                        ", (select count(*) from BOOKORDER Bo \n" +
                                                        "where BO.DELIVARYMANID = DM.delivarymanid\n" +
                                                        "and DELIVARYSTATUS = 'working') as working\n" +
                                                        ", (select count(*) from BOOKORDER Bo \n" +
                                                        "where BO.DELIVARYMANID = DM.delivarymanid\n" +
                                                        "and DELIVARYSTATUS = 'completed') as completed\n" +
                                                        "from DELIVARYMAN dm " );
            ResultSet rs = ps.executeQuery();
            ArrayList<DelivaryMan> dmList = new ArrayList<DelivaryMan>();
            while(rs.next()){
                 DelivaryMan dm = new DelivaryMan(rs.getString("delivarymanid"),rs.getString("name"),rs.getString("contact")
                         ,rs.getString("area"),rs.getInt("working"),rs.getInt("completed"));
                 dmList.add(dm);
                 System.out.println(dm);
            }
            return dmList;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public DelivaryMan getDelivaryManLDetails(String dmId){
        try{
            PreparedStatement ps = conn.prepareStatement("select dm.*, (DM.FIRSTNAME||' '||DM.LASTNAME) as name \n" +
                                                        ", findDMContactNo(dm.delivarymanid) as contact\n" +
                                                        ", findDMWorkArea (DM.delivarymanid) as area \n"+
                                                        ", (select count(*) from BOOKORDER Bo \n" +
                                                        "where BO.DELIVARYMANID = DM.delivarymanid\n" +
                                                        "and DELIVARYSTATUS = 'working') as working\n" +
                                                        ", (select count(*) from BOOKORDER Bo \n" +
                                                        "where BO.DELIVARYMANID = DM.delivarymanid\n" +
                                                        "and DELIVARYSTATUS = 'completed') as completed\n" +
                                                        "from DELIVARYMAN dm " +
                                                        "where dm.delivarymanId = ?");
            ps.setString(1, dmId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                 DelivaryMan dm = new DelivaryMan(rs.getString("delivarymanid"),rs.getString("name"),rs.getString("contact")
                         ,rs.getString("area"),rs.getInt("working"),rs.getInt("completed"));
                 System.out.println("dm details: "+dm);
                 return dm;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public String assignDeliveryMan(String orderId, String dmId, String admin){
         
        try{
            PreparedStatement ps = conn.prepareStatement("update BOOKORDER\n" +
                    "set DELIVARYMANID = ?, PAYMENTSTATUS = 'pending', ADMINID = ? \n" +
                    "where ORDERID = ?");
            ps.setString(1  , dmId);
            ps.setString(2  , admin);
            ps.setString(3, orderId);
            int count = ps.executeUpdate();
            if(count == 1)
                return "You Successfully Assigned delivery man id:"+dmId+ " for order id:"+orderId;
            
        }catch(SQLException e){
            e.printStackTrace();
            return e.getMessage();
        }
        return null;
    }
    
    public String cancelOrder(String orderId){
        try{
             CallableStatement cstmt = conn.prepareCall("{? = call CancelOrder(?)}");
             cstmt.registerOutParameter(1, java.sql.Types.VARCHAR);
             cstmt.setString(2, orderId);
             
             Boolean check = cstmt.execute();
             System.out.println("cancel Order : "+check);
             System.out.println(cstmt.getString(1));
             return cstmt.getString(1);
            
        }catch(SQLException e){
            e.printStackTrace();
            return e.getMessage();
        }
    }
    
    public  ArrayList<String> getDistrictName(){
        try{
    
        PreparedStatement stmt=conn.prepareStatement("select distinct district from thana order by district");
        ResultSet rs = stmt.executeQuery();
        ArrayList<String> arr = new ArrayList<String> ();
        while(rs.next()){
            arr.add(rs.getString("district"));
        }
        return arr;
        }catch(SQLException e){
            e.printStackTrace();
        }
         return null;
    }

    public  ArrayList<String> getThanaName(){
        try{
    
        PreparedStatement stmt=conn.prepareStatement("select distinct thananame from thana order by thananame");
        ResultSet rs = stmt.executeQuery();
        ArrayList<String> arr = new ArrayList<String> ();
        while(rs.next()){
            arr.add(rs.getString("thananame"));
        }
        return arr;
        }catch(SQLException e){
            e.printStackTrace();
        }
         return null;
    }

    public  ArrayList<String> getThanaName(String district){
        try{
    
        PreparedStatement stmt=conn.prepareStatement("select distinct thananame from thana order by thananame"
                                                    +" where district = ?");
        stmt.setString(1,district);
        ResultSet rs = stmt.executeQuery();
        ArrayList<String> arr = new ArrayList<String> ();
        while(rs.next()){
            arr.add(rs.getString("thananame"));
        }
        return arr;
        }catch(SQLException e){
            e.printStackTrace();
        }
         return null;
    }

    public String updateDeliveryStatus(String orderId, String status){
        try{
            PreparedStatement ps = conn.prepareStatement("update BOOKORDER\n" +
                    "set DELIVARYStatus = ?" +
                    "where ORDERID = ?");
            ps.setString(1  , status);
            ps.setString(2  , orderId);
            int count = ps.executeUpdate();
            if(count == 1)
                return "You Successfully Updated delivary status to :"+status+" for orderID: "+orderId;
        }catch(SQLException e){
            e.printStackTrace();
            return e.getMessage();
        }
            return null;
    }
    
    public String updatePaymentStatus(String orderId, String status){
        try{
            PreparedStatement ps = conn.prepareStatement("update BOOKORDER\n" +
                    "set PaymentStatus = ?" +
                    "where ORDERID = ?");
            ps.setString(1  , status);
            ps.setString(2  , orderId);
            int count = ps.executeUpdate();
            if(count == 1)
                return "You Successfully Updated delivary status to :"+status+" for orderID: "+orderId;
        }catch(SQLException e){
            e.printStackTrace();
            return e.getMessage();
        }
            return null;
    }
    
    public String getThanaId(String thana, String zilla){
        try{
            PreparedStatement ps = conn.prepareStatement("select thanaid from thana where thananame= ? and district=?");
            ps.setString(1  , thana);
            ps.setString(2  , zilla);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                return rs.getString("thanaId");
            return null;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    
    public String addDeliveryManWorkingArea(String dmId,String thana,String zilla){
         try
        {
           CallableStatement cstmt = conn.prepareCall("{? = call addDeliveryManWorkingArea(?,?,?)}");
            cstmt.registerOutParameter(1, java.sql.Types.VARCHAR);
            cstmt.setString(2, dmId);
            cstmt.setString(3, thana);
            cstmt.setString(4, zilla);
            Boolean check = cstmt.execute();
            return cstmt.getString(1);
        }
        catch(SQLException e){
            e.printStackTrace();
            return e.getMessage();
            }
    }
    
    public String deleteDeliveryManWorkingArea(String dmId,String thana,String zilla){
         try
        {
            System.out.println("delete da: "+dmId+thana+zilla);
            CallableStatement cstmt = conn.prepareCall("{? = call deleteDMWorkingArea(?,?,?)}");
            cstmt.registerOutParameter(1, java.sql.Types.VARCHAR);
            cstmt.setString(2, dmId);
            cstmt.setString(3, thana);
            cstmt.setString(4, zilla);
            Boolean check = cstmt.execute();
            return cstmt.getString(1);
        }
        catch(SQLException e){
            e.printStackTrace();
            return e.getMessage();
            }
       
    }
    
    public String test(String username) throws SQLException{

        PreparedStatement stmt=conn.prepareStatement("select * from fullbooklist");
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            ShownBookData book = new ShownBookData(rs.getString("bookid"),rs.getString("booktitle"),
                    rs.getString("author"),rs.getString("Publication"),rs.getString("category"),
                    rs.getString("subCategory"),rs.getInt("price"),
                    rs.getString("isbn"),rs.getInt("PublishedYear"),rs.getString("edition"),rs.getString("language"),
                    rs.getInt("pages"),rs.getString("description"),rs.getInt("discount"));
            
            if(rs.getInt("quantity")==0)book.setAvailability("no");else book.setAvailability("yes");
            
            
            System.out.println(book);
        }
        rs.close();
        stmt.close();
         return null;
         
    }
        
    public static void main(String[] args) throws SQLException{
        DataAccess da = new DataAccess();
        //tring res = da.createAccount("fariha", "islam", "farisha", "fariha", "farfiha.t13@gmail.com", "green road", "Dhanmondi", "Dhaka", "1205", "01534907008");
        //System.out.println(res);
        //System.out.println(da.test("fariha"));  
        //da.getCustomerOrderHistory("fariha");
        //da.getOrderSummary("pending");
        //da.getDelivaryManList("26");
        da.cancelOrder("81");
    }
    
    public String addBook(String title, String author[], String publisher, String category[], String price, String isbn, String pubYear, String edition, String language, String pageNo, String description, String quantity, String discount,String admin) {
           try {
             ResultSet rs;
             
            
            
           
          
            publisher=publisher.split("@id=")[1]; //System.out.println("id:"+publisher);
             CallableStatement stmt = conn.prepareCall("{? = call insert_book2(?,?,?,?,?,?,?,?,?,?,?,?)}");
             stmt.registerOutParameter(1, java.sql.Types.VARCHAR);
             stmt.setString(2, title);
             
             stmt.setString(3,publisher);
            
             stmt.setString(4,price);
             stmt.setString(5, isbn);
             stmt.setString(6,pubYear);
             stmt.setString(7,edition);
             stmt.setString(8,language);
             stmt.setString(9, pageNo);
             stmt.setString(10,description);
             
             stmt.setString(11,quantity);
            
             stmt.setString(12,admin);
             
              stmt.setString(13,discount);
              
             stmt.execute();
            // Boolean check = stmt.execute();
             //System.out.println(check);
        
             
             String bid=stmt.getString(1);
             System.out.println("bid:"+bid);
             for(String auth: author)
             {
                 auth=auth.split("@id=")[1];
                 
                 stmt = conn.prepareCall("{call insert_writes(?,?)}");
                 stmt.setString(1, auth);
                  stmt.setString(2, bid);
                  stmt.execute();
                 
             }
             
             
              for(String cat: category)
             {
               
                 stmt = conn.prepareCall("{call insert_bookbycat(?,?)}");
                 stmt.setString(1, bid);
                  stmt.setString(2, cat);
                  stmt.execute();
                 
             }
          //   System.out.println(value);
             
            return BOOK_ADDED;
             //else return BOOK_INSERTION_FAILED;
             
         } catch (SQLException ex) {
                ex.printStackTrace();
            }
         return null;
         }
      
    public String addAuthor(String authorName,String info,String birthDate,String deathDate) {
    
    
         try {
             ResultSet rs;
             PreparedStatement stmt;
             
             String authorID=null;
             
             
             CallableStatement cstmt = conn.prepareCall("{? = call insert_author(?,?,?,?)}");
             cstmt.registerOutParameter(1, java.sql.Types.VARCHAR);
             cstmt.setString(2, authorName);
             cstmt.setString(3, info);
             cstmt.setString(4, birthDate);
             cstmt.setString(5, deathDate);
             
             Boolean check = cstmt.execute();
             System.out.println(check);
             
             
             return AUTHOR_ADDED;
             
         } catch (SQLException ex) {
                ex.printStackTrace();
            }
         return null;
}

    public String addCategory(String subCat,String cat) {
    
    
         try {
             ResultSet rs;
             PreparedStatement stmt;
             
             String publisherID=null;
             
             
             CallableStatement cstmt = conn.prepareCall("{? = call insert_category(?,?)}");
             
             cstmt.setString(2,subCat);
             cstmt.setString(3, cat);
           cstmt.registerOutParameter(1, java.sql.Types.VARCHAR);
           
             
             
            
             
             Boolean check = cstmt.execute();
             System.out.println(check);
             String value=cstmt.getString(1);
             
              if(value.equals("-1")) {return SUBCATEGORY_EXISTS;}
              else return CATEGORY_ADDED;
             // else return CATEGORY_INSERTION_FAILED;
             
         } catch (SQLException ex) {
                ex.printStackTrace();
            }
         return null;
}

    public String addPublisher(String pName,String pAddress,String info) {
    
    
         try {
             ResultSet rs;
             PreparedStatement stmt;
             
             String publisherID=null;
             
             
             CallableStatement cstmt = conn.prepareCall("{? = call insert_publisher(?,?,?)}");
             
             cstmt.registerOutParameter(1, java.sql.Types.VARCHAR);
             cstmt.setString(2,pName );
             cstmt.setString(3, pAddress);
             cstmt.setString(4, info);
             
             
             Boolean check = cstmt.execute();
             System.out.println(check);
             String value=cstmt.getString(1);
             
             //if(value.equals("0")){ return PUBLISHER_INSERTION_FAILED;}
             //else 
             return PUBLISHER_ADDED;
             
         } catch (SQLException ex) {
                ex.printStackTrace();
            }
         return null;
}   

  public ArrayList<AddByAdmin > getAuthorData() {
        ArrayList<AddByAdmin> arrayList =new ArrayList<>();
        try{
        PreparedStatement stmt=conn.prepareStatement("select * from author");
        ResultSet rs = stmt.executeQuery();

         String str,info,id;
         
 
        while(rs.next()){
            str=new String(rs.getString("name"));
            
            id=new String(rs.getString("authorid"));
            str+="(";
            
            
            if((rs.getString("dateofbirth")==null) || rs.getString("dateofbirth").isEmpty()){}
         else{  
              str+=rs.getString("dateofbirth").split("-")[0];}
           
            str+="-";
            
            if(rs.getString("dateofdeath")==null || rs.getString("dateofdeath").isEmpty()){}
            else{
                   str+=rs.getString("dateofdeath").split("-")[0];}
            str+=")";
        
            info=rs.getString("authorinfo");
            if(info==null || info.isEmpty()){
                
            }
            else{
            if(info.length()>20) info=info.substring(0,20);
            str+=info;
            }
            
            AddByAdmin addByAdmin=new AddByAdmin(str,id);
            arrayList.add(addByAdmin);
            //System.out.println(book);
        }
        rs.close();
        stmt.close();
        return arrayList;
        }
        catch(SQLException e){}
        return arrayList;
        
    }
    public ArrayList<AddByAdmin > getPublisherData() {
         ArrayList<AddByAdmin> arrayList =new ArrayList<>();
        try{
        PreparedStatement stmt=conn.prepareStatement("select * from PUBLICATION");
        ResultSet rs = stmt.executeQuery();

         String str,info,id;
         
 
        while(rs.next()){
            str=new String(rs.getString("name"));
            id=new String(rs.getString("publisherid"));
            info=rs.getString("publisherinfo");
            if(info == null || info.isEmpty()){
                
            }else{
            if(info.length()>20) info=info.substring(0,20);
            str+="("+info+")";
            }
            
            AddByAdmin addByAdmin=new AddByAdmin(str,id);
            arrayList.add(addByAdmin);
           //System.out.println("p:"+addByAdmin);
        }
        rs.close();
        stmt.close();
        return arrayList;
        }
        catch(SQLException e){}
        return arrayList;
        
    }
    
     public ArrayList<String > getSubCategoryData() {
        ArrayList<String> arrayList =new ArrayList<>();
        try{
        PreparedStatement stmt=conn.prepareStatement("select * from Category");
        ResultSet rs = stmt.executeQuery();

         String str,info;
         
 
        while(rs.next()){
            str=new String(rs.getString("subcategoryname"));
   
            arrayList.add(str);
           System.out.println("c:"+str);
        }
        rs.close();
        stmt.close();
        return arrayList;
        }
        catch(SQLException e){}
        return arrayList;
        
    }
     
      public ArrayList<String > getCategoryData() {
        ArrayList<String> arrayList =new ArrayList<>();
        try{
        PreparedStatement stmt=conn.prepareStatement("select Distinct categoryname from Category");
        ResultSet rs = stmt.executeQuery();

         String str,info;
         
 
        while(rs.next()){
            str=new String(rs.getString("categoryname"));
   
            arrayList.add(str);
           System.out.println("c:"+str);
        }
        rs.close();
        stmt.close();
        return arrayList;
        }
        catch(SQLException e){}
        return arrayList;
        
    }

      public ArrayList<ShownBookData> searchByName(String search,String homeFlag) {
        ArrayList<ShownBookData> arrayList =new ArrayList<>();
        try{
            
            search="%"+search+"%";
            System.out.println("sooo:"+search);
          
        PreparedStatement stmt=conn.prepareStatement("select booktitle from book");
        ResultSet rs=stmt.executeQuery();
        
        
        if(homeFlag.equals(SearchByName)){
        stmt=conn.prepareStatement("select * from BOOK where booktitle like ? ");}
        
        else if(homeFlag.equals(SearchByAuthor)){
        stmt=conn.prepareStatement("SELECT *\n" +
                                    "FROM AUTHOR a join WRITES w\n" +
                                    "on a.AUTHORID=w.AUTHORID \n" +
                                    "join BOOK b\n" +
                                    "on b.bookid=w.bookid\n" +
                                    "where a.name like ? ");
       
        }
        else if(homeFlag.equals(SearchByCat)){
        stmt=conn.prepareStatement("SELECT *\n" +
                                    "FROM Category c join BOOKBYCATEGORY bc\n" +
                                    "on c.CATEGORYID=bc.CATEGORY \n" +
                                    "join BOOK b\n" +
                                    "on bc.bookid=b.bookid\n" +
                                    "where (c.CATEGORYNAME like ? "+
                                     "or  c.SUBCATEGORYNAME like ? )");
        stmt.setString(2,search);
        }
        else if(homeFlag.equals(SearchByPub)){
                stmt=conn.prepareStatement("SELECT *\n" +
                                "FROM Publication pu join BOOK b\n" +
                                "on b.PUBLISHERID=pu.PUBLISHERID\n" +
                                "where pu.Name like ? ");}
           
        
       stmt.setString(1,search);
       rs = stmt.executeQuery();

        while(rs.next()){
             System.out.println("s:"+rs.getString("booktitle"));
            ShownBookData book = new ShownBookData(rs.getString("booktitle"),rs.getInt("price"),
                    rs.getString("isbn"),rs.getInt("PublishedYear"),rs.getString("edition"),rs.getString("language"),
                    rs.getInt("pages"),rs.getString("description"),rs.getInt("discount"));
            String bookid = rs.getString("bookid");
            String publisher = rs.getString("publisherid");
            System.out.println(bookid+" "+publisher);
            String authors ="";
            stmt=conn.prepareStatement("select name from AUTHOR WHERE AUTHORID = (select AUTHORID from WRITES where bookid = ?)");
            stmt.setString(1, bookid);
            ResultSet rs1 = stmt.executeQuery();
            while( rs1.next()){
                authors += rs1.getString("name")+", ";
            }
            String publication="";
            stmt=conn.prepareStatement("select NAME from PUBLICATION where PUBLISHERID= ?");
            stmt.setString(1,publisher);
            rs1 = stmt.executeQuery();
            while( rs1.next()){
                publication += rs1.getString("name")+" ";
            }
            String category ="";
            stmt=conn.prepareStatement("select SUBCATEGORYNAME from CATEGORY where CATEGORYID = (select CATEGORY from BOOKBYCATEGORY where bookid = ?)");
            stmt.setString(1, bookid);
            rs1 = stmt.executeQuery();
            while( rs1.next()){
                category += rs1.getString("subcategoryname")+", ";
            }
            
            book.setAuthor(authors);
            book.setPublisher(publication);
            book.setCategory(category);
            if(rs.getInt("quantity")==0)book.setAvailability("no");else book.setAvailability("yes");
            
            arrayList.add(book);
            //System.out.println(book);
        }
        rs.close();
        stmt.close();
        return arrayList;
        }
        catch(SQLException e){}
        return arrayList;
        
    }
      
          public String updateBook(String title, String[] author, String publisher, String[] category, String price, String isbn, String pubYear, String edition, String language, String pageNo, String description, String quantity, String discount, String admin,String bid) {
    /*
         try {
        
         //    author=author.split("@id=")[1];// System.out.println("id:"+author);
   
             publisher=publisher.split("@id=")[1]; //System.out.println("id:"+publisher);
             CallableStatement stmt = conn.prepareCall("{call update_book(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            
           //  System.out.println("title:"+title+"bid"+bid+"dis"+discount);
             stmt.setString(1, title);
           //  stmt.setString(2, author);
             stmt.setString(2,publisher);
             //stmt.setString(4,category);
             stmt.setString(3,price);
             stmt.setString(4, isbn);
             stmt.setString(5,pubYear);
             stmt.setString(6,edition);
             stmt.setString(7,language);
             stmt.setString(8, pageNo);
             stmt.setString(9,description);
             stmt.setString(10,quantity);
             
             stmt.setString(11,admin);
             stmt.setString(12,discount);
             stmt.setString(13,bid);
              
             stmt.execute();
             //Boolean check = stmt.execute();
             //System.out.println(check);
            
             
              PreparedStatement stmt = conn.prepareCall("select authorid from writes where bookid=?");
              stmt.setString(1, bid);
                ResultSet rs=  stmt.executeQuery();
               while(rs.next())
               {
                   System.out.println("aaa:"+rs.getString("authorid"));
               }
                
                  
                  
              
                  
              for(String auth: author)
             {
                 auth=auth.split("@id=")[1];
                 
                 
                 stmt = conn.prepareCall("{call insert_writes(?,?)}");
                 stmt.setString(1, auth);
                  stmt.setString(2, bid);
                  System.out.println("auth:"+ auth);
                  stmt.execute();
                  System.out.println("auth:"+ auth);
                 
             }
             
             
                 stmt = conn.prepareCall("{call delete_bookbycat(?)}");
                 stmt.setString(1, bid);
                  stmt.execute();
                  
              for(String cat: category)
             {
  
                  stmt = conn.prepareCall("{call insert_bookbycat(?,?)}");
                 stmt.setString(1, bid);
                  stmt.setString(2, cat);
                
             }
             
             return BOOK_UPDATED;
            } catch (SQLException ex) {
                       ex.printStackTrace();
                   }*/
         return null;
         }

    public String deleteBook(String bid) {
  
         try {
    
             CallableStatement stmt = conn.prepareCall("{call delete_book(?)}");

             stmt.setString(1, bid);
             
              
             stmt.execute();

             return BOOK_DELETED;
            } catch (SQLException ex) {
                       ex.printStackTrace();
                   }
         return null;
         } 
    
    public ShownBookData getBookData(String bid) {
        
        ShownBookData sb=new ShownBookData();
        try{
      /*  PreparedStatement stmt=conn.prepareStatement("select * from book b join writes w "
                + "on b.bookid=w.bookid "
                + "join bookbycategory bc "
                + "on bc.bookid=b.bookid "
                + "where b.bookid like ?");*/
      
      PreparedStatement stmt=conn.prepareStatement("select * from book where bookid like ?");
        stmt.setString(1,bid);
        ResultSet rs = stmt.executeQuery();
      
         
        String pid=null;
        if(rs.next()){
           // aid=rs.getString("authorid");
            pid=rs.getString("publisherid");
           // cid=rs.getString("category");
            sb.setTitle(rs.getString("booktitle"));
        sb.setDiscount(rs.getInt("discount"));
        sb.setQuantity(rs.getInt("quantity"));
        sb.setDescription(rs.getString("description"));
        sb.setEdition(rs.getString("edition"));
        sb.setIsbn(rs.getString("isbn"));
        sb.setLanguage(rs.getString("language"));
        sb.setPageNo(rs.getInt("pages"));
        sb.setPrice(rs.getInt("price"));
        sb.setPubYear(rs.getInt("publishedyear"));}
        System.out.println("haha");
        
        stmt=conn.prepareStatement("select * from author a join writes w on a.authorid=w.authorid where w.bookid like ?");
        stmt.setString(1,bid);
        
        rs = stmt.executeQuery();
        System.out.println("haha");
        ArrayList authorList=new ArrayList<String> ();
        while(rs.next())
        {
            System.out.println("haha");
            String str=new String(rs.getString("name"));
            
             str+="(";
            
            if((rs.getString("dateofbirth")==null) || rs.getString("dateofbirth").isEmpty()){}
         else{   str+=
              str+=rs.getString("dateofbirth").split("-")[0];}
            
            str+="-";
            
            if(rs.getString("dateofdeath")==null || rs.getString("dateofdeath").isEmpty()){}
            else{
                   str+=rs.getString("dateofdeath").split("-")[0];}
            str+=")";
                    
        
            
            String info=new String(rs.getString("authorinfo"));
            if(info.length()>20) info=info.substring(0,20);
            str+=info;
            str+= " @id="+rs.getString("authorid");
            authorList.add(str);
           System.out.println(str);
            
        }
        sb.setAuthorList(authorList);
        
        stmt=conn.prepareStatement("select * from Publication where publisherid like ?");
        stmt.setString(1,pid);
        rs = stmt.executeQuery();
        if(rs.next())
        {
            String str=new String(rs.getString("name"));
            String info=new String(rs.getString("publisherinfo"));
            if(info.length()>20) info=info.substring(0,20);
            str+="("+info+")";
            str+=" @id="+pid;
            sb.setPublisher(str);
            
        }
        
        stmt=conn.prepareStatement("select * from category c join bookbycategory bc on bc.category=c.categoryid where bc.bookid like ?");
        stmt.setString(1,bid);
        ArrayList catList=new ArrayList<String> ();
        rs = stmt.executeQuery();
        System.out.println("haha3");
        while(rs.next())
        {
            String str=new String(rs.getString("subcategoryname"));
            catList.add(str);
          //  sb.setSubCategory(str);
            System.out.println(str);
        }sb.setCatList(catList);
           //System.out.println("rss:"+str);
        
        rs.close();
        stmt.close();
        return sb;
        }
        catch(SQLException e){}
        return sb;
        
    } 
    
    
}


