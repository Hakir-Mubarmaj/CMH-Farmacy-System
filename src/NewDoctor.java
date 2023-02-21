import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

class Doctor{
    public String name;
    public String dept;
    public String id;
}
public class NewDoctor extends JDialog{
    private JPanel newDoc;
    private JButton getApointmentButton;
    private JLabel doc1;
    private JLabel dept;

    public NewDoctor(JFrame parent, String d,String PID) {
        super(parent);
        setTitle("Confirmation");
        setContentPane(newDoc);
        setMinimumSize(new Dimension(540, 960));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        doc = getAuthenticatedUser(d);
        doc1.setText(doc.name);
        dept.setText(d);
        getApointmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final String DB_URL = "jdbc:mysql://localhost/MyStore?serverTimezone=UTC";
                final String USERNAME = "root";
                final String PASSWORD = "";
                try {
                    Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                    String sql = "INSERT INTO apoint(id,doctor,user)\n" +
                            "VALUES (NULL,'"+doc.id+"','"+PID+"')";
                    Statement stmt = conn.createStatement();
                    int i = stmt.executeUpdate(sql);
                    if (i > 0) {
                        System.out.println("ROW INSERTED");
                    } else {
                        System.out.println("ROW NOT INSERTED");
                    }
                } catch (Exception a) {
                    System.out.println(a);
                }
                ConfirmDoctor c = new ConfirmDoctor(null);
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
            String sql = "SELECT * FROM doctor WHERE dept=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, dep);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                doc = new Doctor();
                doc.name = resultSet.getString("name");
                doc.dept = resultSet.getString("dept");
                doc.id = resultSet.getString("docID");
            }

            stmt.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }


        return doc;
    }
}
