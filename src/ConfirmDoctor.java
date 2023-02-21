import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmDoctor extends JDialog{
    private JPanel Cd;
    private JButton closeButton;

    public ConfirmDoctor(JFrame parent) {
        super(parent);
        setTitle("Confirmation");
        setContentPane(Cd);
        setMinimumSize(new Dimension(540, 960));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }
}
