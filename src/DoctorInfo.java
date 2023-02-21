import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DoctorInfo extends JDialog{
    private JPanel docInfo;
    private JLabel Nam;
    private JLabel ID;
    private JLabel dept;
    private JButton seeApointmentsButton;
    private JButton Close;

    public DoctorInfo(JFrame parent,String n,String i, String d) {
        super(parent);
        setTitle("Login");
        setContentPane(docInfo);
        setMinimumSize(new Dimension(540, 960));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Nam.setText(n);
        ID.setText(i);
        dept.setText(d);
        seeApointmentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doc = getAuthenticatedUser(i);
                CheckApointment c= new CheckApointment(null, doc.name);
                dispose();
            }
        });
        Close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }
    public Doctor doc;
    private Doctor getAuthenticatedUser(String dep) {
        Doctor doc = null;

        final String DB_URL = "jdbc:mysql://localhost/MyStore?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...

            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM apoint WHERE doctor=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, dep);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                doc = new Doctor();
                doc.name = resultSet.getString("user");
                doc.id = resultSet.getString("doctor");
            }

            stmt.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }


        return doc;
    }
}
