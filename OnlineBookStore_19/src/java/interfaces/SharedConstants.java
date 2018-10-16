package Interfaces;


/**
 * This interface is a medium of connection between  server and client.
 * they exchanges command and requests and recognises them with help of this interface.
 * It is a common interface for server and client.
 */
public interface SharedConstants {

    /**************************boolean*********************************/

    int FALSE = 0;
    int TRUE  = 1;
    
    /***********************ERROR CODE***************************************/
    int USERNAME_NOT_AVAILABLE = 20001;


    /*************************INVALID*********************************/
    String account_created = "New account successfully created.";
    String contact_insertion_failed = "contact no insertion in database failed.";
    String customer_table_insertion_failed = "customer_table_insertion_failed";
    String thana_zilla_mismatch = "thana name and zilla donot match.";
    String username_unavailable = "This user name is not available";
    String unknown_error = " unknown error occured.";
    String email_occupied = "email already exists.";
    String INVALID_CATEGORY = "invalid category";
    String AUTHOR_INSERTION_FAILED = "AUTHOR_INSERTION_FAILED";
    String BOOKBYCATEGORY_INSERTION_FAILED = "BOOKBYCATEGORY_INSERTION_FAILED";
    String PUBLISHER_INSERTION_FAILED = "PUBLISHER_INSERTION_FAILED";
    String BOOK_INSERTION_FAILED = "BOOK_INSERTION_FAILED";
    String CATEGORY_INSERTION_FAILED = "category insertion failed.";
    String Writes_INSERTION_FAILED="writes insertion failed.";
    String order_successful = "Successfully ordered.";
    String dm_inserted = "Delivary man profile created successfully.";
    
    
    String SearchByName="Search By Name";
    String SearchByCat="Search By Category";
    String SearchByPub="Search By Publisher";
    String SearchByAuthor="Search By Author";
    String HOME="Home";
    
    String Successful_Search= "Successful Search";
    String Unsuccessful_Search="Unsuccessful Search";
    String INVALID_NID          = "INVALID_NID";
    String INVALID_USERNAME    = "INVALID_USER_NAME";
    String INVALID_PASSWORD     = "INVALID_PASSWORD";
    
    String SuccessLogin         ="SuccessLogin";
    String FailedLogin          ="FailedLogin";
    String ACCOUNT_INFO_VERIFIED = "Provided info were confirmed.";

    String CURRENT_PASSWORD_MISMATCH = "Current Password Didn't Match.";
    String BOOK_ADDED="You have successfully added books ";
    String AUTHOR_ADDED="You have successfully added AUTHOR ";
    String PUBLISHER_ADDED="You have successfully added PUBLISHER ";
    String CATEGORY_ADDED="You have successfully added Category ";
    String SUBCATEGORY_EXISTS = "SUBCATEGORY EXISTS";
    String NO_AUTHOR = "NO AUTHOR";
    String NO_PUBLISHER = "NO PUBLISHER";
    
    
    
    
    String ACCOUNT_EXISTS = "Account already exists for this NID.";
    String PROBLEM_INSERTED = "insertion successful.";
    String PROBLEM_INSERTION_FAILED = "insertion failed.";

 
    String PASSWORD_UPDATED = "Password was updated successfully.";
    String USER_NAME_UPDATED = "User name was updated successfully";
    String PASSWORD_UPDATE_FAILED = "Password update failed.";
    String USER_NAME_UPDATE_FAILED = "user name update failed.";
    String DELETE_ACCOUNT = "delete account.";
    String ACCOUNT_DELETED = "account deleted.";
    String ACTION_SUCCESS = "action success.";
    String ACTION_FAILED = "action failed.";
    String BOOK_UPDATED = " BOOK UPDATED";
    String BOOK_DELETED = "BOOK DELETED";
    
    
    /***********************15DEC*********************************/
    public default Boolean isNumber(String s){
        int len =s.length();
        for(int i=0;i<len;i++){
            if(s.charAt(i)<'0' || s.charAt(i)>'9')
                return false;
        }
        return true;
    }
    
    



}
