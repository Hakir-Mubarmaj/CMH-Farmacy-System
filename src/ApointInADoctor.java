import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApointInADoctor extends JDialog{
    private JPanel Apoint;
    private JButton ApointPrev;
    private JButton Oncology;
    private JButton Cardiology;
    private JButton Urology;
    private JButton Neurology;
    private JButton Gastroenteriology;
    private JButton Orthopedic;
    private JLabel Dname;
    private JLabel Ddept;

    public ApointInADoctor(JFrame parent,String dname, String ddept,String PID) {
        super(parent);
        setTitle("Get Apointment");
        setContentPane(Apoint);
        setMinimumSize(new Dimension(540, 960));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Dname.setText(dname);
        Ddept.setText(ddept);
        ApointPrev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConfirmDoctor c = new ConfirmDoctor(null);
                dispose();
            }
        });
        Oncology.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewDoctor n = new NewDoctor(null,"Oncology",PID);
                dispose();
            }
        });
        Cardiology.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewDoctor n = new NewDoctor(null,"Cardiology",PID);
                dispose();
            }
        });
        Urology.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewDoctor n = new NewDoctor(null,"Urology",PID);
                dispose();
            }
        });
        Neurology.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewDoctor n = new NewDoctor(null,"Neurology",PID);
                dispose();
            }
        });
        Gastroenteriology.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewDoctor n = new NewDoctor(null,"Gastroenteriology",PID);
                dispose();
            }
        });
        Orthopedic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewDoctor n = new NewDoctor(null,"Orthopedic",PID);
                dispose();
            }
        });
        setVisible(true);
    }
}
