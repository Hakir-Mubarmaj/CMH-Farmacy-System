import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class PatientInfoD extends JDialog{

    private JLabel ID;
    private JLabel Mob;
    private JLabel Add;
    private JLabel Nam;
    private JButton nextButton;
    private JButton Appoint;
    private JPanel PatentPanel;

    public PatientInfoD(JFrame parent,String Id) {
        super(parent);
        setTitle("Information");
        setContentPane(PatentPanel);
        setMinimumSize(new Dimension(540, 960));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        user = getAuthenticatedUser(Id);
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
                dispose();
            }
        });
        setVisible(true);
    }
    public User user;
    private User getAuthenticatedUser(String email) {
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
