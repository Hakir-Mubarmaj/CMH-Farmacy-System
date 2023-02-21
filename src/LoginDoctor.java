import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginDoctor extends JDialog{
    private JPanel logdoc;
    private JTextField textField1;
    private JButton nextButton;
    private JButton cancelButton;

    public LoginDoctor(JFrame parent) {
        super(parent);
        setTitle("Login");
        setContentPane(logdoc);
        setMinimumSize(new Dimension(540, 960));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = textField1.getText();

                doc = getAuthenticatedUser(ID);

                if (doc!= null) {
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(LoginDoctor.this,
                            "Doctor's ID Invalid",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);
                }
                dispose();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }
    public Doctor doc;
    private Doctor getAuthenticatedUser(String ID) {
        Doctor doc = null;

        final String DB_URL = "jdbc:mysql://localhost/MyStore?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...

            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM doctor WHERE docID=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, ID);

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
