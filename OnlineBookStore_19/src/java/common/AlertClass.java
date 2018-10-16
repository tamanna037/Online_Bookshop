

/**
 * Shows two types of alert: Error Alert and Confirmation alert with the msg
 * set as a parameter.
 *
 * Server and Client both have access to this class.
 */
public class AlertClass {

    /**
     * shows an error alert
     * @param errorMsg this message is showed with alert
     */
    public void showErrorAlert(String errorMsg){
        System.out.println("ERROR: "+errorMsg);
    }

    /**
     * shows an confirmation alert
     * @param confirmationMsg this message is showed with alert
     */
    public void showConfirmationAlert(String confirmationMsg){
        System.out.println("confirmation: "+confirmationMsg);
    }
}
