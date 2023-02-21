import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstPage extends JDialog {

    private JPanel TopPanel;
    private JButton loginAsAdminButton;
    private JButton loginAsPatientButton;
    private JButton loginAsDoctorButton;

    public FirstPage(JFrame parent) {
        super(parent);
        setTitle("Wellcome!!!!!");
        setContentPane(TopPanel);
        setMinimumSize(new Dimension(540, 960));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        loginAsPatientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginForm loginForm = new LoginForm(null);
                User user = loginForm.user;
                if (user != null) {
                    PatientInfo patient = new PatientInfo(null,user.email,user.password);
                    System.out.println("Successful Authentication of: " + user.name);
                    System.out.println("          ID     : " + user.email);
                    System.out.println("          Phone  : " + user.phone);
                    System.out.println("          Address: " + user.address);
                }
                else {
                    System.out.println("Authentication canceled");
                }
                dispose();
            }
        });
        loginAsAdminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        loginAsDoctorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginDoctor ld = new LoginDoctor(null);
                Doctor doc = ld.doc;
                if (doc != null){
                    DoctorInfo di = new DoctorInfo(null,doc.name,doc.id,doc.dept);
                }
                dispose();
            }
        });
        setVisible(true);
    }
}
