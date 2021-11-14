package Tweetproject2;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import sentimentanalysis.Tweet;
import sentimentanalysis.TweetCollection;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class mainPanel extends JPanel {
	
	private TweetCollection tc;
	private JTextField userName;
	private JComboBox comboBox;
	private JLabel tweetData;
	private JTextField predictionText;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JLabel test;
	private JCheckBoxMenuItem chckbxmntmSave;
	private JTextArea userTweet;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	public mainPanel() 
	{
		// Back ground
		setBackground(Color.BLACK);
		tc = new TweetCollection("./sentimentanalysis/testProcessed.txt", 1600000);
		//setting dimesions
		setPreferredSize (new Dimension(856, 630));
		setLayout(null);
		
		//creating a menu
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 856, 22);
		add(menuBar);
		
		//adding the file option to the menu
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		//Adding apperance to the menu
		JMenu mnBackGround = new JMenu("Apperance");
		menuBar.add(mnBackGround);
		
		//adding the button to enable the spooky background
		JRadioButtonMenuItem rdbtnmntmEnableBackground = new JRadioButtonMenuItem("Enable Spooky Background");
		rdbtnmntmEnableBackground.addActionListener(new ActionListener() {
			//when pressed
			public void actionPerformed(ActionEvent e) {
				//if the button is selected make background transparent and the color to null
				if (rdbtnmntmEnableBackground.isSelected()==true)
				{
					setOpaque(false);
					setBackground(null);
				}
				//if the button is not pressed set background to black
				else if (rdbtnmntmEnableBackground.isSelected()==false)
				{
					setOpaque(true);
					setBackground(Color.BLACK);
				}
			}
		});
		mnBackGround.add(rdbtnmntmEnableBackground);
		//add save to menu
		chckbxmntmSave = new JCheckBoxMenuItem("Save");
		chckbxmntmSave.addActionListener(new ActionListener() {
			//when pressed
			public void actionPerformed(ActionEvent e) {
				//rewrite file
				tc.rewriteFile();
			}
		});
		mnFile.add(chckbxmntmSave);
		//Choose file option
		JMenuItem mntmSelectFiles = new JMenuItem("Choose File");
		mntmSelectFiles.addActionListener(new ActionListener() {
			//when pressed
			public void actionPerformed(ActionEvent e) {
				int fileSelect=0;
				do
				{
					//display option pane
					fileSelect = Integer.parseInt(JOptionPane.showInputDialog("Type 1 for training data or 2 for test data"));
					//1 selects testProcessed
					if(fileSelect== 1)
						tc = new TweetCollection("./sentimentanalysis/testProcessed.txt", 1600000);
					//2 selects trainingProcessed
					else if (fileSelect== 2)
						tc = new TweetCollection("./sentimentanalysis/trainingProcessed.txt", 1600000);

				}
				while(fileSelect!=1&&fileSelect!=2);
					//update text area and redisplay text
					textArea = new JTextArea();
					textArea.setText(tc.toString());
					scrollPane.setViewportView(textArea);
					
			    
			}
		});
		//separates choose file and save
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		mnFile.add(mntmSelectFiles);
		
		//Scroll pane for TweetCollection list
		scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 103, 296, 333);
		add(scrollPane);
		
		//tweet colletion list
		textArea = new JTextArea();
		textArea.setText(tc.toString());
		scrollPane.setViewportView(textArea);
 	
		//label saying tweets
		JLabel lblTweets = new JLabel("Tweets");
		lblTweets.setForeground(Color.ORANGE);
		lblTweets.setFont(new Font("Chiller", Font.BOLD | Font.ITALIC, 36));
		lblTweets.setBounds(56, 61, 196, 31);
		add(lblTweets);
		
		//label saying username
		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setForeground(Color.ORANGE);
		lblUsername.setFont(new Font("Chiller", Font.BOLD, 22));
		lblUsername.setBounds(362, 99, 101, 31);
		add(lblUsername);
		textArea.setText(tc.toString());
		
		//Scroll pane for individual tweets
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(438, 250, 395, 117);
		add(scrollPane_1);
		
		//view of scroll pane 
		userTweet = new JTextArea();
		userTweet.setLineWrap(true);
		scrollPane_1.setViewportView(userTweet);
		
		//text box bounds
		userName = new JTextField();
		userName.setBounds(438, 106, 207, 20);
		add(userName);
		userName.setColumns(10);
		
		//get ids button that that updates option panel and userTweet textBox
		JButton getTweetsButton = new JButton("Get Tweet Ids");
		getTweetsButton.addActionListener(new ActionListener() {
			//if pressed
			public void actionPerformed(ActionEvent e) {
				Set<Long> ids = tc.getTweetIdsByUser(userName.getText());
				String[] idsStr = new String[ids.size()];
				int index = 0;
				for (Long long1 : ids) {
					idsStr[index] = long1.toString();
					index++;
				}
				comboBox.setModel(new DefaultComboBoxModel(idsStr));
				//populates box if there are values inside
				if (idsStr.length>0) {
					Tweet t= tc.getTweetById(Long.parseLong(idsStr[0]));
					userTweet.setText(t.getText());
				}
			}
		});
		getTweetsButton.setBounds(438, 137, 135, 23);
		add(getTweetsButton);
		
		//adding text to the combo box
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			//if pressed
			public void actionPerformed(ActionEvent e) {
				String id = (String)comboBox.getSelectedItem();
				Tweet t= tc.getTweetById(Long.parseLong(id));
				userTweet.setText(t.getText());
			}
		});
		comboBox.setBounds(438, 171, 207, 22);
		add(comboBox);
		
		//creating a label that says 
		predictionText = new JTextField("Enter tweet here");
		predictionText.setBounds(56, 513, 296, 20);
		add(predictionText);
		predictionText.setColumns(10);
		
		//creating nameless label
		test = new JLabel();
		test.setFont(new Font("Chiller", Font.PLAIN, 18));
		test.setForeground(Color.ORANGE);
		test.setBounds(344, 553, 46, 14);
		add(test);
		test.setVisible(false);
		test.setText(null);
		
		//do predictions
		JButton btnDoPrediction = new JButton("Do prediction");
		btnDoPrediction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				{ //PredictionText.getText()
					if(predictionText.getText()!=null)
					{
					Tweet t = new Tweet(0, 10000, "ASdsad", predictionText.getText());
					tc.addTweet(t);
					test.setText(Integer.toString(tc.predict(t)));
					test.setVisible(true);
					tc.removeTweet(t.getId());
					
					}
					else if(predictionText.getText().isBlank())
					{
						test.setText(" ");
					}
				}
			}
		});
		btnDoPrediction.setBounds(56, 544, 175, 23);
		add(btnDoPrediction);
		
		
		//creating label that says Your Prediction is: 
		JLabel lblYourPredictionIs = new JLabel("Your Prediction is: ");
		lblYourPredictionIs.setFont(new Font("Chiller", Font.PLAIN, 18));
		lblYourPredictionIs.setForeground(Color.ORANGE);
		lblYourPredictionIs.setBounds(241, 552, 125, 14);
		add(lblYourPredictionIs);
		
		//creating label named tweet
		tweetData = new JLabel("Tweet: ");
		tweetData.setForeground(Color.ORANGE);
		tweetData.setFont(new Font("Chiller", Font.BOLD, 32));
		tweetData.setBounds(362, 250, 101, 36);
		add(tweetData);
		
		//Deleting Tweets
		JButton btnDeleteTweets = new JButton("Delete Selected Tweet");
		btnDeleteTweets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = (String)comboBox.getSelectedItem();
				Tweet t= tc.getTweetById(Long.parseLong(id));
				//delete tweet command
				tc.removeTweet(Long.parseLong(id));
				//if checkbox is checked rewrite to the file
				if(chckbxmntmSave.isSelected()==true)
					tc.rewriteFile();
				//update the list
				textArea.setText(tc.toString());
				userTweet.setText(" ");
				scrollPane.setViewportView(textArea);
				
			}
		});
		btnDeleteTweets.setBounds(626, 378, 207, 23);
		add(btnDeleteTweets);
		
		
		//label saying Enter Text to be predicted
		JLabel predictionText1 = new JLabel("Enter Text to be predicted");
		//setting the font
		predictionText1.setFont(new Font("Chiller", Font.BOLD, 21));
		//setting the color
		predictionText1.setForeground(Color.ORANGE);
		predictionText1.setBounds(56, 488, 352, 14);
		add(predictionText1);
		
		
		//creating buttom that Save Tweet Edit
		JButton btnNewButton = new JButton("Save Tweet Edit");
		btnNewButton.addActionListener(new ActionListener() {
			//if pressed
			public void actionPerformed(ActionEvent e) {
					//getting text from from textarea
					String text = userTweet.getText();
					//taking the selected id from the combobox and using it to get the tweet
					Tweet t= tc.getTweetById(Long.parseLong((String)comboBox.getSelectedItem()));
					tc.editTweetText(t, text);
					
					//if checkbox is checked rewrite to the file
					if(chckbxmntmSave.isSelected()==true)
						tc.rewriteFile();
					
					//retyping the textArea
					textArea = new JTextArea();
					textArea.setText(tc.toString());
					scrollPane.setViewportView(textArea);
			}
		});
		btnNewButton.setBounds(438, 378, 178, 23);
		add(btnNewButton);
		
		//textField
		textField = new JTextField();
		textField.setBounds(438, 446, 123, 20);
		add(textField);
		textField.setColumns(10);
		
		//textField
		textField_1 = new JTextField();
		textField_1.setBounds(438, 495, 123, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		//textField
		textField_2 = new JTextField();
		textField_2.setBounds(438, 546, 123, 20);
		add(textField_2);
		textField_2.setColumns(40);
		
		//label saying Enter the Polarity
		JLabel lblNewLabel = new JLabel("Enter the Polarity");
		//setting the font
		lblNewLabel.setFont(new Font("Chiller", Font.PLAIN, 21));
		//setting the color
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBounds(438, 416, 123, 20);
		add(lblNewLabel);
		
		//label saying 
		JLabel lblNewLabel_1 = new JLabel("Enter ID Number");
		//setting the font
		lblNewLabel_1.setFont(new Font("Chiller", Font.PLAIN, 21));
		//setting the color
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setBounds(438, 464, 125, 31);
		add(lblNewLabel_1);
		
		//label saying 
		JLabel lblNewLabel_2 = new JLabel("Enter Username");
		//setting the font
		lblNewLabel_2.setFont(new Font("Chiller", Font.PLAIN, 21));
		//setting the color
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setBounds(438, 523, 115, 22);
		add(lblNewLabel_2);
		
		//label saying 
		JLabel lblNewLabel_3 = new JLabel("Enter Tweet Text");
		//setting the font
		lblNewLabel_3.setFont(new Font("Chiller", Font.PLAIN, 21));
		//setting the color
		lblNewLabel_3.setForeground(Color.ORANGE);
		lblNewLabel_3.setBounds(636, 416, 125, 24);
		add(lblNewLabel_3);
		
		//textField
		textField_3 = new JTextField();
		textField_3.setBounds(571, 446, 262, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		//add tweet button
		JButton btnNewButton_1 = new JButton("Add Tweet");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if pressed
				
				//grabbing the text from all the texts fields and creating a tweet
				Tweet t = new Tweet(Integer.parseInt(textField.getText()), Long.parseLong(textField_1.getText()), 
						textField_2.getText(), textField_3.getText() );
				tc.addTweet(t);
				
				//rewrites text area
				textArea = new JTextArea();
				textArea.setText(tc.toString());
				scrollPane.setViewportView(textArea);
				
				//empties all fields
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				
				//if checkbox is checked rewrite to the file
				if(chckbxmntmSave.isSelected()==true)
					tc.rewriteFile();
			}
		});
		btnNewButton_1.setBounds(571, 494, 262, 23);
		add(btnNewButton_1);
	}
}