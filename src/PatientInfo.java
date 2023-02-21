import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class PatientInfo extends JDialog{

    private JPanel patientPanel;
    private JLabel ID;
    private JLabel Mob;
    private JLabel Add;
    private JLabel Nam;
    private JButton nextButton;
    private JButton Appoint;

    public PatientInfo(JFrame parent,String Id,String pass) {
        super(parent);
        setTitle("Information");
        setContentPane(patientPanel);
        setMinimumSize(new Dimension(540, 960));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        user = getAuthenticatedUser(Id,pass);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Prescription ps=new Prescription(null,user.password,user.email);
                dispose();
            }
        });
        Appoint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ApointInADoctor a = new ApointInADoctor(null,user.doctor,user.docDept,user.email);
                dispose();
            }
        });
        setVisible(true);
    }
    public User user;
    private User getAuthenticatedUser(String email, String password) {
        User user = null;

        final String DB_URL = "jdbc:mysql://localhost/MyStore?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...

            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM users WHERE email=? AND password=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.name = resultSet.getString("name");
                user.email = resultSet.getString("email");
                user.phone = resultSet.getString("phone");
                user.address = resultSet.getString("address");
                user.password = resultSet.getString("password");
                user.doctor = resultSet.getString("doctor");
                user.docDept = resultSet.getString("docDept");
                Nam.setText(user.name);
                ID.setText(user.email);
                Add.setText(user.address);
                Mob.setText(user.phone);
            }

            stmt.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }


        return user;
    }
}
