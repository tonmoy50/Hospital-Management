package HospitalSystems;

import java.io.*;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author TONMOY
 */
public class Login_logic extends LogIn_Page{

    /*Declaration of private variables*/
    private String id;
    private String pass;
    private String concated;
    private String filename;
    private File file_obj;
    private String directory = "Management_files/ID_list";
    private String temp;

    /*End of Declaration of private variables*/
    public Login_logic(String id, String pass) {
        /*Constructor for assigning values*/

        this.filename = filename;
        this.id = id;
        this.pass = pass;
        this.file_obj = new File(directory);
        checkid();
    }

    private void checkid() {    //method for checking id and pass

        if (file_obj.isDirectory()) {
            String file_handler[] = file_obj.list();

            for (int i = 0; i < file_handler.length; i++) {

                this.filename = directory + "/" + file_handler[i];

                try {
                    //File fileObj = new File("idpasslist.txt");
                    concated = this.id + " " + this.pass;

                    BufferedReader bf = new BufferedReader(new FileReader(this.filename));
                    
                    //BufferedReader bf = new BufferedReader(new FileReader("idpasslist_Staff"));
                    
                    temp = bf.readLine();
                    while (temp != null) {
                        //loop to search within a file
                        if (temp.equals(concated)) {
                            i = file_handler.length;
                            break;
                        }
                        temp = bf.readLine();
                        //System.out.println(temp);
                    }
                    bf.close();

                } catch (Exception fe) {
                    //System.out.println("File er kichu ekta hoiche :3 ");
                    
                    JOptionPane.showMessageDialog(null, "File Not Found");
                }

            }
            
            if (temp == null) {
                        JOptionPane.showMessageDialog(null, "User ID or Password doesn't match");
                    } else {
                        if(this.filename.equals("Management_files/ID_list/idpasslist_Patient.txt")){
                            System.out.println("Logging in you diseased Man");
                            //AddPatient ap = new AddPatient();
                            //add(ap);
                            setVisible(false);
                            //StaffPanel staffObject = new StaffPanel();
                             PatientPanel patientObject = new PatientPanel();
                             patientObject.setVisible(true);
                            
                        }
                        else{
                            System.out.println("Logging in....No Good Employee");
                            /*RegPatient rp = new RegPatient();
                            
                            rp.setVisible(true);*/
                            this.setVisible(false);
                            
                            StaffPanel staffObject = new StaffPanel();
                            staffObject.setVisible(true);
                            
                            
                        }
                    }
        }
    }

}
