import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckApointment extends JDialog{
    private JPanel CA;
    private JLabel ID;
    private JButton seeFullInfoButton;

    public CheckApointment(JFrame parent,String Id) {
        super(parent);
        setTitle("Appointment");
        setContentPane(CA);
        setMinimumSize(new Dimension(540, 960));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        ID.setText(Id);
        seeFullInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PatientInfoD PD = new PatientInfoD(null,Id);
            }
        });
        setVisible(true);
    }
}
