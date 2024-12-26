package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MediaStore extends JPanel {
	private Media media;
	private JButton addToCartButton;
    private JButton playButton;
    
	public MediaStore (Media media) {
		this.media = media;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel (media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font. PLAIN, 20));
		title.setAlignmentX (CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel(""+media.getPrice()+" $");
		cost.setAlignmentX (CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout (FlowLayout.CENTER));
		
		addToCartButton = new JButton("Add to cart");
        container.add(addToCartButton);
		if(media instanceof Playable) {
			playButton = new JButton("Play");
            container.add(playButton);
		}
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		this.setBorder (BorderFactory.createLineBorder(Color.BLACK));
		
		// Add ActionListener for "Add to cart" button
        addToCartButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(media.getTitle() + " has been added to the cart.");
			}
        });

        // Add ActionListener for "Play" button
        if (media instanceof Playable) {
            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Create a dialog to simulate media playing
                    JDialog playDialog = new JDialog();
                    playDialog.setTitle("Playing: " + media.getTitle());
                    playDialog.setSize(300, 200);
                    playDialog.setLocationRelativeTo(null); // Center the dialog
                    playDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

                    JLabel playMessage = new JLabel("Playing: " + media.getTitle(), JLabel.CENTER);
                    playDialog.add(playMessage);

                    // Show the dialog
                    playDialog.setVisible(true);
                }
            });
        }
	}
	
}
