package hangmanGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

class HangmanGame extends JPanel implements MouseListener, KeyListener {

    private static final long serialVersionUID = 1L;
    public Image img,img3;
    public ImageIcon icon,icon3;

    public Image img2;
    public ImageIcon icon2;
    public int wrong;

    WordMatch wordMatch;
    public JFrame jf;

    public HangmanGame() {

        wordMatch = new WordMatch();
        wordMatch.chooseWord();
        this.setSize(100, 500);
        this.setVisible(true);
        this.setFocusable(true);
        icon = new ImageIcon("image/abs.png");
        img = icon.getImage();
          
        icon2 = new ImageIcon("image/Alphabet12.png");
        img2 = icon2.getImage();
        icon3 = new ImageIcon("image/h1.png");
        img3 = icon3.getImage();
        addMouseListener(this);
        addKeyListener(this);
        wrong = 0;
        jf = new JFrame();
        jf.setTitle("Hangman");
        jf.setSize(715, 530);
        jf.add(this);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    public boolean imageUpdate(Image arg0, int agr1, int arg2, int arg3, int arg4, int arg5) {
        return false;
    }

    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, 700, 500, null);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(375, 95, 308, 308);
        g.drawImage(img3,40, 100, 203, 280, null);
        g.setColor(Color.black);
        g.drawImage(img2, 380, 100, 300, 300, null);
        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.BOLD, 68));
        g.drawChars(wordMatch.hangmanLetters, 0, wordMatch.charArray.length, 180, 460);

        if (wordMatch.wrongGuess == 1) {
            g.setColor(Color.BLACK);
            g.drawLine(188, 150, 188, 120);
            g.drawOval(162, 150, 50, 50);  
        }
        if (wordMatch.wrongGuess == 2) {
            g.setColor(Color.BLACK);
            g.drawLine(188, 150, 188, 120);		
            g.drawOval(162, 150, 50, 50);
            g.drawLine(188, 200, 188, 275);
        }
        if (wordMatch.wrongGuess == 3) {
            g.setColor(Color.BLACK);
            g.drawLine(188, 150, 188, 120);		
            g.drawOval(162, 150, 50, 50);
            g.drawLine(188, 200, 188, 275);
            g.drawLine(148, 235, 188, 215);
        }
        if (wordMatch.wrongGuess == 4) {
            g.setColor(Color.BLACK);
            g.drawLine(188, 150, 188, 120);		
            g.drawOval(162, 150, 50, 50);
            g.drawLine(188, 200, 188, 275);
            g.drawLine(148, 235, 188, 215);
            g.drawLine(188, 215, 228, 235);
        }
        if (wordMatch.wrongGuess == 5) {
            g.setColor(Color.black);
            g.drawLine(188, 150, 188, 120);	
            g.drawOval(162, 150, 50, 50);
            g.drawLine(188, 200, 188, 275);
            g.drawLine(148, 235, 188, 215);
            g.drawLine(188, 215, 228, 235);
            g.drawLine(188, 275, 228, 335);
        }
        if (wordMatch.wrongGuess == 6) {
            g.setColor(Color.black);
            g.drawLine(188, 150, 188, 120);	
            g.drawOval(162, 150, 50, 50);
            g.drawLine(188, 200, 188, 275);
            g.drawLine(148, 235, 188, 215);
            g.drawLine(188, 215, 228, 235);
            g.drawLine(188, 275, 228, 335);
            g.drawLine(148, 335, 188, 275);
        }
        if (wordMatch.winOrLoose == true) {
            g.setColor(Color.green);
            g.drawString("you win", 80, 250);
            g.setColor(Color.gray);
            g.fillRect(40, 418, 100, 50);
            g.setColor(Color.green);
            g.setFont(new Font("Arial", Font.BOLD, 18));
            g.drawString("New Game", 45, 450);

        }
        if (wordMatch.wrongGuess == 6) {
            g.setColor(Color.yellow);
            g.drawString("You lost", 80, 250);
            g.setColor(Color.gray);
            g.fillRect(40, 418, 100, 50);
            g.setColor(Color.yellow);
            g.setFont(new Font("Arial", Font.BOLD, 18));
            g.drawString("New Game", 45, 450);
        }

        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        int mX = e.getX();
        int mY = e.getY();
       if (mX > 40 && mX < 140 && mY > 418 && mY < 468 && (wordMatch.wrongGuess == 6 || wordMatch.winOrLoose == true)) {
            wordMatch.wrongGuess = 0;
            wordMatch.chooseWord();
            wordMatch.winOrLoose = false;
            for (int i = 0; i < 26; i++) {
                wordMatch.usedLetterList[i] = '-';
            } 
        }
       if(wordMatch.wrongGuess < 6 ){
        if (mX > 386 && mX < 430 && mY > 95 && mY < 170) {
            char ch = 'a';
            wordMatch.checkWord(ch);
        }
        if (mX > 432 && mX < 468 && mY > 95 && mY < 170) {
            char ch = 'b';
            wordMatch.checkWord(ch);
        }
        if (mX > 470 && mX < 515 && mY > 95 && mY < 170) {
            char ch = 'c';
            wordMatch.checkWord(ch);
        }
        if (mX > 517 && mX < 556 && mY > 95 && mY < 170) {
            char ch = 'd';
            wordMatch.checkWord(ch);
        }
        if (mX > 558 && mX < 593 && mY > 95 && mY < 170) {
            char ch = 'e';
            wordMatch.checkWord(ch);
        }
        if (mX > 595 && mX < 624 && mY > 95 && mY < 170) {
            char ch = 'f';  // f being click
            wordMatch.checkWord(ch);
        }
        if (mX > 626 && mX < 670 && mY > 95 && mY < 170) {
            char ch = 'g';
            wordMatch.checkWord(ch);
        }

       if (mX > 385 && mX < 409 && mY > 172 && mY < 245) {
            char ch = 'j';
            wordMatch.checkWord(ch);
        }
        if (mX > 422 && mX < 460 && mY > 172 && mY < 245) {
            char ch = 'h';
            wordMatch.checkWord(ch);
        }
        if (mX > 463 && mX < 490 && mY > 172 && mY < 245) {
            char ch = 'i';
            wordMatch.checkWord(ch);
        }
        if (mX > 492 && mX < 531 && mY > 172 && mY < 245) {
            char ch = 'k';
            wordMatch.checkWord(ch);
        }
        if (mX > 533 && mX < 570 && mY > 172 && mY < 245) {
            char ch = 'l';
            wordMatch.checkWord(ch);
        }
        if (mX > 573 && mX < 626 && mY > 172 && mY < 245) {
            char ch = 'm';
            wordMatch.checkWord(ch);
        }
        if (mX > 628 && mX < 673 && mY > 172 && mY < 245) {
            char ch = 'n';
            wordMatch.checkWord(ch);
        }
     if (mX > 380 && mX < 425 && mY > 250 && mY < 325) {
            char ch = 'o';
            wordMatch.checkWord(ch);
        }
        if (mX > 427 && mX < 458 && mY > 250 && mY < 325) {
            char ch = 'p';
            wordMatch.checkWord(ch);
        }
        if (mX > 460 && mX < 510 && mY > 250 && mY < 325) {
            char ch = 'q';
            wordMatch.checkWord(ch);
        }
        if (mX > 513 && mX < 552 && mY > 250 && mY < 325) {
            char ch = 'r';
            wordMatch.checkWord(ch);
        }
        if (mX > 555 && mX < 592 && mY > 250 && mY < 325) {
            char ch = 's';
            wordMatch.checkWord(ch);
        }
        if (mX > 594 && mX < 634 && mY > 250 && mY < 325) {
            char ch = 't';
            wordMatch.checkWord(ch);
        }
        if (mX > 637 && mX < 682 && mY > 250 && mY < 325) {
            char ch = 'u';
            wordMatch.checkWord(ch);
        }
     if (mX > 401 && mX < 446 && mY > 330 && mY < 403) {
            char ch = 'v';
            wordMatch.checkWord(ch);
        }
        if (mX > 448 && mX < 512 && mY > 330 && mY < 403) {
            char ch = 'w';
            wordMatch.checkWord(ch);
        }
        if (mX > 515 && mX < 556 && mY > 330 && mY < 403) {
            char ch = 'x';
            wordMatch.checkWord(ch);
        }
        if (mX > 559 && mX < 602 && mY > 330 && mY < 403) {
            char ch = 'y';
            wordMatch.checkWord(ch);
        }
        if (mX > 605 && mX < 650 && mY > 330 && mY < 403) {
            char ch = 'z';
            wordMatch.checkWord(ch);

        }
    }
    }
    

    public void keyPressed(KeyEvent e) {
        if (wordMatch.wrongGuess == 6 || wordMatch.winOrLoose == true) {
            wordMatch.wrongGuess = 0;
            wordMatch.chooseWord();
            wordMatch.winOrLoose = false;
            for (int i = 0; i < 26; i++) {
                wordMatch.usedLetterList[i] = '-';
            }
        }
        char ch = e.getKeyChar();
        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
            wordMatch.checkWord(ch);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
   }

    @Override
    public void keyReleased(KeyEvent e) {
  }

    public static void main(String[] args) {      
       new HangmanGame();
    }
}
