import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

class Consume{
    public String med1;
    public String med2;
    public String med3;
    public String med4;
    public String med5;
}
public class Prescription extends JDialog{
    private JPanel PrescriptionPanel;
    private JLabel Pass;
    private JLabel m1;
    private JLabel m2;
    private JLabel m3;
    private JLabel m4;
    private JLabel m5;
    private JLabel a1;
    private JLabel a2;
    private JLabel a3;
    private JLabel a4;
    private JLabel a5;
    private JButton nextButton;

    public Prescription(JFrame parent,String p,String k) {
        super(parent);
        setTitle("Information");
        setContentPane(PrescriptionPanel);
        setMinimumSize(new Dimension(540, 960));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Pass.setText(p);
        consume = getAuthenticatedConsume(k);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EndScreen end = new EndScreen(null);
                dispose();
            }
        });
        setVisible(true);
    }
    public Consume consume;
    private Consume getAuthenticatedConsume(String person_id) {
        Consume consume= null;

        final String DB_URL = "jdbc:mysql://localhost/MyStore?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...

            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM consume WHERE person_id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, person_id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                consume = new Consume();
                consume.med1= resultSet.getString("medicine");
                m1.setText(consume.med1);
                if (consume.med1!=null){
                    a1.setText("Available");
                }
            }
            if (resultSet.next()) {
                consume = new Consume();
                consume.med2= resultSet.getString("medicine");
                m2.setText(consume.med2);
                if (consume.med2!=null){
                    a2.setText("Available");
                }
            }
            if (resultSet.next()) {
                consume = new Consume();
                consume.med3= resultSet.getString("medicine");
                m3.setText(consume.med3);
                if (consume.med3!=null){
                    a3.setText("Available");
                }
            }
            if (resultSet.next()) {
                consume = new Consume();
                consume.med4= resultSet.getString("medicine");
                m4.setText(consume.med4);
                if (consume.med4!=null){
                    a4.setText("Available");
                }
            }
            if (resultSet.next()) {
                consume = new Consume();
                consume.med5= resultSet.getString("medicine");
                m5.setText(consume.med5);
                if (consume.med5!=null){
                    a5.setText("Available");
                }
            }
            stmt.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }


        return consume;
    }
}
